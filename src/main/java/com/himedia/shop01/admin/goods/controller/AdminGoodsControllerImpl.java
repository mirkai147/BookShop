package com.himedia.shop01.admin.goods.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.himedia.shop01.goods.vo.GoodsVO;
import com.himedia.shop01.admin.goods.service.AdminGoodsService;
import com.himedia.shop01.common.base.BaseController;
import com.himedia.shop01.goods.vo.ImageFileVO;
import com.himedia.shop01.member.vo.MemberVO;

@Controller("adminGoodsController")
@RequestMapping(value = "/admin/goods")
public class AdminGoodsControllerImpl extends BaseController implements AdminGoodsController {
	
	private static final String CURR_IMAGE_REPO_PATH = "C:\\shopping\\file_repo";
	
	@Autowired
	private AdminGoodsService adminGoodsService;
	
	@Override
	@RequestMapping(value = "/adminGoodsMain.do", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView adminGoodsMain(@RequestParam Map<String, String> dataMap,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		HttpSession session = request.getSession();
		session.setAttribute("side_menu", "admin_mode");
		
		String fixedSearchPeriod = dataMap.get("fixedSearchPeriod");
		String section = dataMap.get("section");
		String pageNum = dataMap.get("pageNum");
		String beginDate=null, endDate=null;
		
		String [] tempDate=calcSearchPeriod(fixedSearchPeriod).split(",");
		beginDate=tempDate[0];
		endDate=tempDate[1];
		dataMap.put("beginDate", beginDate);
		dataMap.put("endDate", endDate);
		
		Map<String,Object> condMap=new HashMap<String,Object>();
		if(section== null) {
			section = "1";
		}
		condMap.put("section",section);
		if(pageNum== null) {
			pageNum = "1";
		}
		condMap.put("pageNum",pageNum);
		condMap.put("beginDate",beginDate);
		condMap.put("endDate", endDate);
		List<GoodsVO> newGoodsList = adminGoodsService.listNewGoods(condMap);
		mav.addObject("newGoodsList", newGoodsList);
		
		String beginDate1[]=beginDate.split("-");
		String endDate2[]=endDate.split("-");
		mav.addObject("beginYear",beginDate1[0]);
		mav.addObject("beginMonth",beginDate1[1]);
		mav.addObject("beginDay",beginDate1[2]);
		mav.addObject("endYear",endDate2[0]);
		mav.addObject("endMonth",endDate2[1]);
		mav.addObject("endDay",endDate2[2]);
		
		mav.addObject("section", section);
		mav.addObject("pageNum", pageNum);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/addNewGoods.do", method = {RequestMethod.POST})
	public ResponseEntity addNewGoods(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String imageFileName = null;
		
		Map newGoodsMap = new HashMap();
		Enumeration enu = multipartRequest.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			newGoodsMap.put(name, value);
		}
		
		HttpSession session = multipartRequest.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("memberInfo");
		String reg_id = memberVO.getMember_id();
		List<ImageFileVO> imageFileList = upload(multipartRequest);
		if(imageFileList!=null && imageFileList.size()!=0) {
			for(ImageFileVO imageFileVO : imageFileList) {
				imageFileVO.setReg_id(reg_id);
			}
			newGoodsMap.put("imageFileList", imageFileList);
		}
		
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		try {
			int goods_id = adminGoodsService.addNewGoods(newGoodsMap);
			
			if(imageFileList!=null && imageFileList.size()!=0) {
				for(ImageFileVO imageFileVO : imageFileList) {
					imageFileName = imageFileVO.getFileName();
					File srcFile = new File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName);
					File destDir = new File(CURR_IMAGE_REPO_PATH+"\\"+goods_id);
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
			}
			message = "<script>";
			message+= " alert('새 상품을 추가했습니다.');";
			message+= " location.href='"+multipartRequest.getContextPath()+"/admin/goods/addNewGoodsForm.do';";
			message +=("</script>");
		} catch (Exception e) {
			if(imageFileList!=null && imageFileList.size()!=0) {
				for(ImageFileVO imageFileVO : imageFileList) {
					imageFileName = imageFileVO.getFileName();
					File srcFile = new File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName);
					srcFile.delete();
				}
			}
			
			message = "<script>";
			message+= " alert('오류가 발생했습니다. 다시 시도해 주세요.');";
			message+= " location.href='"+multipartRequest.getContextPath()+"/admin/goods/addNewGoodsForm.do';";
			message +=("</script>");
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
	@Override
	@RequestMapping(value = "/modifyGoodsForm.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView modifyGoodsForm(@RequestParam("goods_id") int goods_id,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		Map goodsMap = adminGoodsService.goodsDetail(goods_id);
		mav.addObject("goodsMap", goodsMap);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/modifyGoodsInfo.do", method = RequestMethod.POST)
	public ResponseEntity modifyGoodsInfo(
			@RequestParam("goods_id") String goods_id,
			@RequestParam("attribute") String attribute,
			@RequestParam("value") String value,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		message = "mod_success";
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
}
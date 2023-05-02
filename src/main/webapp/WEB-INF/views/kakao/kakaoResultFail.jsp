<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
</head>
<BODY>

			
	<H1>주문 상품 정보</H1>
	<TABLE class="list_view">
		<TBODY align=center>
			<tr style="background: #33ff00">
				<td>주문번호</td>
				<td colspan=2 class="fixed">주문상품명</td>
				<td>수량</td>
				<td>주문금액</td>
				<td>배송비</td>
				<td>예상적립금</td>
				<td>주문금액합계</td>
			</tr>
			<TR>
				<c:forEach var="item" items="${myOrderList }">
					<td>${item.order_id }</td>
					<TD class="goods_image"><a
						href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
							<IMG width="75" alt=""
							src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">
					</a></TD>
					<TD>
						<h2>
							<A
								href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">${item.goods_title }</A>
						</h2>
					</TD>
					<td>
						<h2>${item.order_goods_qty }개</h2>
					</td>
					<td><h2>${item.order_goods_qty *item.goods_sales_price}원
							(10% 할인)</h2></td>
					<td><h2>0원</h2></td>
					<td><h2>${1500 *item.order_goods_qty }원</h2></td>
					<td>
						<h2>${item.order_goods_qty *item.goods_sales_price}원</h2>
					</td>
				</c:forEach>
			</TR>
		</TBODY>
	</TABLE>

	<DIV class="clear"></DIV>
			<br><br><br>
				<h1>카카오 페이 결제 실패!</h1>
				<DIV class="detail_table">
					<table>
						<TBODY>
							<TR class="dot_line">
								<TD class="fixed_join">결제코드</TD>
								<TD>${responseCode }</TD>
							</TR>
							<TR class="dot_line">
								<TD class="fixed_join">결제메시지</TD>
								<TD>${responseMsg }</TD>
							</TR>
						</TBODY>
					</table>
				</DIV>
	
	<DIV class="clear"></DIV>
	<br>
	<br>
	<br>
	<br>
	<br>
	<a href="${contextPath}/main/main.do"> <IMG width="75" alt=""
		src="${contextPath}/resources/image/btn_shoping_continue.jpg">
	</a>
	<DIV class="clear"></DIV>

</BODY>


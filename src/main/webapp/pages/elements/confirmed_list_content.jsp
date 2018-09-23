<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ctg" uri="customtags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="title">
		<fmt:message key="title.doctor.confirm" />
	</div>

	<div style="width: 100%; padding-left: 10%; padding-top: 30px">
		<table id="orderTable">

			<tr>
				<th><fmt:message key="list.id" /></th>
				<th><fmt:message key="list.login" /></th>
				<th><fmt:message key="list.product" /></th>
				<th><fmt:message key="list.status" /></th>
				<th><fmt:message key="list.action" /></th>
			</tr>
			<c:forEach items="${recipes}" var="recipe">
				<tr>
					<td>${recipe.id}</td>
					<td>${recipe.user.login}</td>
					<td>${recipe.product.name}</td>
					<td>${recipe.statusRecipe}</td>
					<c:if test="${recipe.statusRecipe == 'Waiting' }">
						<td><div style="width: 140px center">
								<form method="POST" action="Controller">
									<input name="action" type="hidden" value="confirm_recipe" /> <input
										name="recipe_id" type="hidden" value="${recipe.id }" /> <input
										class="buyButton" type="submit"
										value="<fmt:message key="orders.confirm" />" />
								</form>
							</div></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
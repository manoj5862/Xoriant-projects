<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Product Form</h2>
	<hr />

	<jsp:include page="/menu.jsp" />
	<hr />
	<form action="./saveProductV1" autocomplete="off">
		Select Category: <select name="categoryId">
			<option value="2">Ladies Wearss</option>
			<option value="3">Mens Wear</option>
			<option value="4">Kids Wear</option>
			<option value="5">Furnitures</option>
			<option value="6">Home Appliances</option>
			<option value="12">Mobiles</option>
		</select> <br /> Select Brand: <select name="brandId">
			<option value="1">HP</option>
			<option value="2">Samsung</option>
			<option value="3">Apple</option>
			<option value="4">Sony</option>

		</select> <br /> ID: <input type="text" name="productId"> <br />
		Name: <input type="text" name="productName"> <br /> Price: <input
			type="text" name="price"> <br /> Description: <input
			type="text" name="description"> <br /> Image Path: <input
			type="text" name="imagePath"> <br /> Quantity: <input
			type="text" name="quantity"> <br /> keywords: <input
			type="text" name="keywords"> <br />

		<button>Save</button>
	</form>

</body>
</html>
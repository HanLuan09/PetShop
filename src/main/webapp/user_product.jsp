<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PetShop</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/cart.css">
    <link rel="stylesheet" href="./css/gird.css">
    <link rel="stylesheet" href="./css/user_product.css">
    <link rel="stylesheet" href="./css/order.css">
    <link rel="stylesheet" href="./css/responsive.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style type="text/css">
    	.order-text-name {
		    /* display: flex; */
		    /* white-space: nowrap; */
		    /* overflow: hidden; */
		    text-overflow: ellipsis;
		    overflow: hidden;
		    display: block;
		    /*display: -webkit-box;*/
		    -webkit-box-orient: vertical;
		    -webkit-line-clamp: 2;
		}
		.none{
			display: none;
		}
    </style>
</head>
<body style="background: #f5f5f5">
    <div class="main">
        <jsp:include page="navi_cart.jsp"/>
        <div class="container">
            <div class="grid wide">
                <div class="container__navi-cart">
                    <div class="l-2 m-0 c-0">
                    <!-- account -->
                    	<div class="petshop__account">
                            <div class="petShop-avatar">
                                <div class="petShop-avatar__placeholder">
                                    <img class="shopee-avatar__img " src="upload/${account.imageA}" alt="">
                                </div>
                            </div>
                            <div class="petShop-text">
                                <div class="petShop-text-name">${sessionScope.account.username}</div>
                                <div class="petShop-text-welcome">Welcome PetShop</div>
                            </div>
                        </div>
                       	<div class="stardust-dropdown">
                            <div id="container__menu-product" class="l1U02e active--right">
                                <div class="bfikuD"><i class="fa-regular fa-clipboard"></i></div>
                                <div class="DlL0zX"><spam class="adF7Xs">Sản phẩm của tôi</spam></div>
                            </div>
                        </div>
                        <div class="stardust-dropdown">
                            <div id="container__menu-account" class="l1U02e">
                                <div class="bfikuD"><i class="fa-regular fa-user"></i></div>
                                <div class="DlL0zX"><spam class="adF7Xs">Tài khoản của tôi</spam></div>
                            </div>
                        </div>
                        <div class="stardust-dropdown">
                            <div>
                                <a id="container__menu-bell" class="l1U02e" href="">
                                    <div class="bfikuD"><i class="fa-regular fa-bell"></i></div>
                                    <div class="DlL0zX"><spam class="adF7Xs">Thông báo</spam></div>
                                </a>
                            </div>
                        </div>
                    </div>
                    
                    <div class="l-10 m-12 c-12">
                        <div class="content-account" style="display: none;">
                            <div class="container_cart BjIo5w">
                                <div class="container_cart-wrap">
                                    <div class="row sm-gutter">
                                       <span>Hồ sơ của tôi</span>
                                    </div>
                                </div>
                            </div>
                            <div class="container_cart BjIo5w">
                                <div class="row sm-gutter" style="width: 100%;">
                                    <div class="col l-9">
                                        <table style="width: 90%;">
                                            <tr>
                                                <td class="espR83">
                                                    <div style="padding-left: 20px; padding-bottom: 5px;"><label for="">Tên đăng nhập</label></div>
                                                    <div class="Tmj5Z6">
                                                        <div class="W50dp5">
                                                            <inpput class="CMyrTJ" type="text">${account.username}</inpput>
                                                        </div>
                                                    </div>
                                                   
                                                </td>
                                                <td class="espR83">
                                                    <div style="padding-left: 20px; padding-bottom: 5px;"><label for="">Tên</label></div>
                                                    <div class="Tmj5Z6">
                                                        <div class="W50dp5">
                                                            <inpput class="CMyrTJ" type="text">${address.name}</inpput>
                                                        </div>
                                                    </div>
                                                   
                                                </td>
                                                <td class="espR83" >
                                                    <div style="padding-left: 20px; padding-bottom: 10px;"><label for="">Địa chỉ</label></div>
                                                    <div class="Tmj5Z6">
                                                        <div class="W50dp5">
                                                            <inpput class="CMyrTJ" type="text">${address.address}</inpput>
                                                        </div>
                                                    </div>
                                                   
                                                </td>
                                                <td class="espR83" >
                                                    <div style="padding-left: 20px; padding-bottom: 10px;"><label for="">Số điện thoại</label></div>
                                                    <div class="Tmj5Z6">
                                                        <div class="W50dp5">
                                                            <inpput class="CMyrTJ" type="text">${address.phone}</inpput>
                                                        </div>
                                                    </div>
                                                   
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="col l-3" style="border-left: 0.0625rem solid #efefef;">
                                    	<form action="image-account" method="post" enctype="multipart/form-data">
                                        <div class="IQPHvE">
                                            <div class="scvgOW">
                                                <div class="XWsmVn">
                                                    <!--<div id="preview-image" class="LoNm4g" style="background-image: url(upload/${account.imageA});"></div>-->
                                                    <img id="preview-image" class="LoNm4g" alt="" src="upload/${account.imageA}">
                                                </div>
                                                <input name="imageAccount" value="${account.imageA}" type="file" class="bMWDYw" id="file-input" accept=".jpg,.jpeg,.png">
                                                <button class="btn btn-light btn--m btn--inline" id="choose-image-btn" type="button">Chọn Ảnh</button>
                                                <div class="L4SAGB">Dung lượng tối đa 1MB</div>
                                                <div class="L4SAGB">Định dạng:.JPEG, .JPG, .PNG</div>
                                                <div style="margin: 20px 0;">
                                                    <button class="btn btn--m btn-solid-primary btn--inline" type="submit">Lưu</button>
                                                </div>  
                                            </div>
                                        </div>
                                        </form>
                                        <script>
	                                        const chooseImageBtn = document.getElementById('choose-image-btn');
	                                        const fileInput = document.getElementById('file-input');
	                                        const previewImage = document.getElementById('preview-image');
	
	                                        chooseImageBtn.addEventListener('click', function() {
	                                          fileInput.click();
	                                        });
	
	                                        fileInput.addEventListener('change', function() {
	                                          const file = fileInput.files[0];
	                                          const reader = new FileReader();
	                                          
	                                          reader.addEventListener("load", () => {
	                                              previewImage.src = reader.result;
	                                          });
	                                    
	                                          reader.readAsDataURL(file);
	                                        });
				                       </script>
                                    </div>
                                </div>
                            </div>
                        </div>
						<!-- petshop -->
                        <div class="content-phetshop">
                        	<div class="container_cart BjIo5w">
                                <div class="container_cart-wrap">
                                    <div class="row sm-gutter">
                                        <div style="display: flex; justify-content: center;"><span>Sản phẩm của tôi</span></div>
                                        <!--  <div class="col l-2 m-3 c-3" style="display: flex; justify-content: center;"><span class="active">Đang Chờ</span></div>
                                        <div class="col l-2 m-3 c-3" style="display: flex; justify-content: center;"><span class="active">Hoàn Thành</span></div>
                                        <div class="col l-2 m-3 c-3" style="display: flex; justify-content: center;"><span class="active">Đã Hủy</span></div>-->
                                    </div>
                                </div>
                            </div>
                        	<div class="">
			                    <div class="">
			                        <div class="l-12 m-12 c-12">
			                        	
			                            <div class="cPNXP" style="border-bottom: 1px solid rgba(0,0,0,.09);">
			                                <div class="sVj2 row sm-gutter">
			                                    <div class="col l-4">Sản phẩm</div>
			                                    <div class="col l-1 content__order">Số lượng</div>
			                                    <div class="col l-2 content__order">Đơn giá</div>
			                                    <div class="col l-1 content__order">Ngày mua</div>
			                                    <div class="col l-2 content__order">Trạng thái</div>
			                                    <div class="col l-2 content__order">Chi tiết</div>    
			                                </div>
			                            </div>
			                            <c:forEach items="${mapProducts}" var="entry">
			                            <div class="sqxwIi">
			                            
			                                <div class="cPNXP" style="padding-bottom: 15px;">
			                                    <div class="sVj2 row sm-gutter">
			                                        <div class="col l-12 m-12 c-12">Mã đơn đặt hàng: PETSHOP0${entry.key}</div>			                                       
			                                    </div>
			                                </div>
			                                <c:forEach items="${entry.value}" var="o">
			                                <div class="container_cart BjIo5w" style="border: 0; border-top: 1px dashed rgba(0,0,0,.09); background: #fffefb; margin-bottom: 0;">
			                                    <div class="container_cart-wrap">
			                                        <div class="row sm-gutter">
			                                            <div class="col l-4 m-4 c-4" style="display: flex;">
			                                                <img style="height: 50px; width: 45px;" src="upload/${o.imageP}" alt="">
			                                                <span class="oEI3Ln">
			                                                    <span class="order-text-name" >${o.nameP}</span>
			                                                </span>
			                                            </div>
			                                            <div class="col l-1 m-2 c-2">
			                                                <div class="container_cart-list">
			                                                    <span class="order_text-sum">${o.amount}</span>
			                                                </div>
			                                            </div>
			                                            <div class="col l-2 m-2 c-2">
			                                                <div class="container_cart-list">
			                                                    <span class="order_text-sum">${o.price} đ</span>
			                                                </div>
			                                            </div>
			                                             <div class="col l-1 m-2 c-2">
			                                                <div class="container_cart-list">
			                                                    <span class="order_text-sum">${o.date}</span>
			                                                </div>
			                                            </div>
			                                            <div class="col l-2 m-2 c-2">
			                                                <div class="container_cart-list">
			                                                	<c:if test="${o.status == 0}"><span class="order_text">Đặt hàng</span></c:if>
			                                                    <c:if test="${o.status == 1}"><span class="order_text">Hoàn thành</span></c:if>
			                                                    <c:if test="${o.status == 2}"><span class="order_text">Đã hủy</span></c:if>
			                                                </div>
			                                            </div>
			                                            <div class="col l-2 m-2 c-2">
			                                                <div class="container_cart-list">
			                                                    <button class="btn btn--primary" onclick="location.href='order-detail?idp=${o.idP}&ido=${o.idO}';">Chi tiết</button>
			                                                </div>
			                                            </div>
			                                        
			                                        </div>
			                                    </div>
			                                </div>
			                                </c:forEach>
			                            </div>
			                            <div style="margin-top: 15px"></div>
				                        </c:forEach>
				                            
			                            </div>
			                        </div>
			                    </div>
			                </div> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
       <script type="text/javascript" src="./javascript/user_product.js"></script>
    </div>
</body>
</html>
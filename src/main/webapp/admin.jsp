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
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/cart.css">
    <link rel="stylesheet" href="./css/gird.css">
    <link rel="stylesheet" href="./css/user_product.css">
    <link rel="stylesheet" href="./css/order.css">
    <link rel="stylesheet" href="./css/responsive.css">
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
		.order_text-sum {
			color: #333;
		}
    </style>
</head>
<body style="background: #f5f5f5">
    <div class="main">
        <div class="YqIqug">
            <div class="contai" style="display: flex; justify-content: space-between; align-items: center;">
                <div class="jb8bh0">
                    <a href="/petshop/home" class="lJqn"> <spam class="logo">PetShop</spam> 
                        <span class="eSRYBr">Admin</span>
                    </a>
                </div>
                <div class="jb8bh0">
                    <a class="card-fs-content-button" style="margin-top: 0" href="/petshop/manager">Trang quản lý sản phẩm</a>
                </div>
            </div>
        </div>
        <div class="container" style="top: calc(var(--height-header) + 20px);">
            <div class="grid wide">
                <div class="container__navi-cart">
                    <div class="l-2 m-0 c-0">
                    <!-- account -->
                    	<div class="petshop__account">
                            <div class="petShop-avatar">
                                <div class="petShop-avatar__placeholder">
                                    <img class="shopee-avatar__img" src="upload/${sessionScope.account.imageA}" alt="">
                                </div>
                            </div>
                            <div class="petShop-text">
                                <div class="petShop-text-name">${sessionScope.account.username}</div>
                                <div class="petShop-text-welcome">Quản lý PetShop</div>
                            </div>
                        </div>
                      
                    </div>
                    
                    <div class="l-10 m-12 c-12">
                        <!--<div class="content-account">
                            <div class="container_cart BjIo5w">
                                <div class="row sm-gutter" style="width: 100%;">
                                    <div class="col l-6">    
                                        <table style="width: 90%;">
                                            <tr>
                                                <td class="espR83">
                                                    <div class="Tmj5Z6">
                                                        <div>Tổng doanh thu</div>
                                                        <div>Trong 30 ngày ngần nhất</div>
                                                        <div>VND</div>
                                                        <div>Số lượng sản phẩm bán ra</div>
                                                        <div>Số lượng đơn hàng</div>
                                                        <div>danh sách sản phẩm bán chạy nhất</div>
                                                    </div>  
                                                </td>    
                                            </tr>

                                        </table>
                                    </div>
                                    <div class="col l-6" style="border-left: 0.0625rem solid #efefef;">
                                        <table style="width: 90%;">
                                            <tr>
                                                <td class="espR83">
                                                    <div class="Tmj5Z6">
                                                        <div>Tổng doanh thu</div>
                                                        <div>Doanh thu trong 30 ngày ngần nhất</div>
                                                        <div>VND</div>
                                                    </div>  
                                                </td>    
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </div>
                       
                        </div>-->
						<!-- petshop -->
                        <div class="content-phetshop">
                        	<div class="container_cart BjIo5w">
                                <div class="container_cart-wrap">
                                    <div class="row sm-gutter">
                                        <div style="display: flex; justify-content: center; color: #FF0000; text-transform: uppercase;"><span>Đơn hàng chờ duyệt</span></div>
                                        
                                    </div>
                                </div>
                            </div>
                        	<div class="">
			                    <div class="">
			                        <div class="l-12 m-12 c-12">
			                        	
			                            <div class="cPNXP" style="border-bottom: 1px solid rgba(0,0,0,.09);">
			                                <div class="sVj2 row sm-gutter">
			                                    <div class="col l-4 m-5 c-5">Sản phẩm</div>
			                                    <div class="col l-1 m-1 c-1 content__order">Số lượng</div>
			                                    <div class="col l-2 m-3 c-3 content__order">Đơn giá</div>
			                                    <div class="col l-1 m-3 c-3 content__order">Ngày mua</div>
			                                    <div class="col l-2 m-0 c-0 content__order hide-on-mobile-tablet">Trạng thái</div>
			                                    <div class="col l-2 m-0 c-0 content__order hide-on-mobile-tablet">Chi tiết</div>    
			                                </div>
			                            </div>
			                            <c:forEach items="${map}" var="entry">
			                            <div class="sqxwIi">
			                            	<!--  <div class="cPNXP" style="padding-bottom: 15px; background-color: #fffefb; border: 1px solid rgba(224,168,0,.4); display: none">
			                                    <div class="sVj2 row sm-gutter">
			                                        <div class="col l-12 m-12 c-12" style="color: #ff5a00d6;">Mã tài khoản: TKPS${entry.key}</div>			                                       
			                                    </div>
			                                </div>-->
			                                <c:forEach items="${entry.value}" var="pair">
			                                <div class="cPNXP" style="padding-bottom: 15px; padding: 15px 30px 15px;">
			                                    <div class="sVj2 row sm-gutter">
			                                        <div class="col l-12 m-12 c-12">Mã đơn đặt hàng: PETSHOP0${pair.first}</div>			                                       
			                                    </div>
			                                    <div class="jb8bh0">
								                    <a class="card-fs-content-button" href="/petshop/order-confirm?dio=${pair.first}" style="margin-top: 0;">Xác nhận giao hàng</a>
								                </div>
			                                </div>
			                                <c:forEach items="${pair.second}" var="o">
			                                <div class="container_cart BjIo5w" style="border: 0; border-top: 1px dashed rgba(0,0,0,.09); background: #fffefb; margin-bottom: 0;">
			                                    <div class="container_cart-wrap">
			                                        <div class="row sm-gutter">
			                                            <div class="col l-4 m-5 c-5" style="display: flex;">
			                                                <img style="height: 50px; width: 45px;" src="upload/${o.imageP}" alt="" class="hide-on-mobile-tablet">
			                                                <span class="oEI3Ln">
			                                                    <span class="order-text-name" >${o.nameP}</span>
			                                                </span>
			                                            </div>
			                                            <div class="col l-1 m-1 c-1">
			                                                <div class="container_cart-list">
			                                                    <span class="order_text-sum">${o.amount}</span>
			                                                </div>
			                                            </div>
			                                            <div class="col l-2 m-3 c-3">
			                                                <div class="container_cart-list">
			                                                    <span class="order_text-sum">${o.price} đ</span>
			                                                </div>
			                                            </div>
			                                             <div class="col l-1 m-3 c-3">
			                                                <div class="container_cart-list">
			                                                    <span class="order_text-sum">${o.date}</span>
			                                                </div>
			                                            </div>
			                                            <div class="col l-2 m-0 c-0">
			                                                <div class="container_cart-list">
			                                                	<c:if test="${o.status == 0}"><span class="order_text-sum">Đang chờ</span></c:if>
			                                                    <c:if test="${o.status == 1}"><span class="order_text-sum">Hoàn thành</span></c:if>
			                                                    <c:if test="${o.status == 2}"><span class="order_text-sum">Đã hủy</span></c:if>
			                                                </div>
			                                            </div>
			                                            <div class="col l-2 m-0 c-0"></div>
			                                        
			                                        </div>
			                                    </div>
			                                </div>
			                                </c:forEach>
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
</body>
</html>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/cart.css">
    <link rel="stylesheet" href="./css/product_details.css">
    <link rel="stylesheet" href="./css/gird.css">
    <link rel="stylesheet" href="./css/responsive.css">
</head>
<body style="background-color: #f5f5f5;">
    <div class="main" style="background-color: #F5F5F5">
        <jsp:include page="navi_cart.jsp"></jsp:include>

        <div class="container">
            <div class="grid wide">
                <div class="container__navi-cart hide-on-mobile-tablet">
                    <div class="l-12 m-12 c-12">
                        <div class="container_cart BjIo5w">
                            <div class="container_cart-wrap">
                                <div class="row sm-gutter" style="line-height: 40px;">
                                    <div class="col l-1 m-1 c-1" style="display: flex; margin: auto;">
                                        <label for="" class="stardust-checkbox">
                                            <input type="checkbox" class="stardust-checkbox__input">
                                            <div class="stardust-checkbox__box"></div>
                                        </label>  
                                    </div>
                                    <div class="container__navi-cart-item col l-2 m-3 c-3"> <span>Sản phẩm</span></div>
                                    <div class="col l-4 m-9 c-9"></div>
                                    <div class="container_cart-list col l-2">
                                        <div class="container__navi-cart-item">Số lượng</div>
                                    </div>
                                    <div class="container_cart-list col l-2">
                                        <div class="container__navi-cart-item">Đơn giá</div>
                                       
                                    </div>
                                    <div class="container_cart-list col l-1">
                                        <div class="container__navi-cart-item">Trạng thái</div>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="">
                    <div class="">
                    	<c:forEach items="${listCart}" var="o">
                        <div class="l-12 m-12 c-12">
                            <div class="container_cart BjIo5w">
                                <div class="container_cart-wrap">
                                    <div class="row sm-gutter">
                                        <div class="col l-1 m-1 c-1" style="display: flex;">
                                            <label for="" class="stardust-checkbox">
                                                <input type="checkbox" class="stardust-checkbox__input">
                                                <div class="stardust-checkbox__box"></div>
                                            </label> 
                                        </div>
                                        <div class="col l-2 m-3 c-3">
                                      
                                            <img class="container_cart-img" src="upload/${o.product.imageP}" alt="">
                                        </div>
                                        <div class="col l-4 m-8 c-8">
                                            <div class="container_cart-text">
                                                <h4 class="container_cart-text-name">${o.product.nameP}</h4>
                                                <div style="margin-top: 8px;">
                                                    <div class="container_cart-text-item">Kích Thước: <span>M</span></div>
                                                    <div class="container_cart-text-item">Màu Sắc: <span>M</span></div>
                                                    <div class="container_cart-text-item">Đơn Giá: <span>M</span></div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col l-0 m-5 c-0">
                                                    <div class="" style="padding-top: 10px;">
                                                        <div class="container_cart-item">
                                                            <button class="container_cart-item-btn">
                                                                <i class="fa-solid fa-minus"></i>
                                                            </button>
                                                            
                                                            <input type="text" class="container_cart-item-input" value="${o.quantity}" role="spinbutton" aria-valuenow="1">
                                                            <button class="container_cart-item-btn">
                                                                <i class="fa-solid fa-plus"></i>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col l-0 m-6 c-0">
                                                    <div class="container_cart-list">
                                                        <span class="container_cart-list-pay">${o.product.priceNew} đ</span>
                                                    </div>
                                                </div>
                                                <div class="col l-0 m-1 c-0">
                                                    <div class="container_cart-list">
                                                        <a class="container_cart-list-delete" href="/petshop/cart-delete?idp=${o.product.idP}&ida=${o.idA}&idcheck=1"><i class="fas fa-trash fa-lg"></i></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col l-2 m-0 c-5">
                                            <div class="container_cart-list">
                                                <div style="display: flex; flex-direction: row; align-items: center;">
                                                    <div style="margin-right: 15px;">
                                                        <div class="container__right-purchase-input" style="display: flex; flex-direction: row;">
                                                            <button class="container__right-purchase-input-btn" id="container__left" onclick="location.href ='cart-save?idp='+${o.product.idP}+'&quantity='+${o.quantity-1};">
                                                                <i class="fa-solid fa-minus"></i>
                                                            </button>                                                         
                                                            <input type="text" id="quantity-input" class="container__right-purchase-input-text" value="${o.quantity}" role="spinbutton" aria-valuenow="1" readonly>
                                                            <button class="container__right-purchase-input-btn" id="container__right" onclick="location.href ='cart-save?idp='+${o.product.idP}+'&quantity='+${o.quantity+1};">
                                                                <i class="fa-solid fa-plus"></i>
                                                            </button>
                                                        </div>
                                                    </div>
                                                    
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col l-2 m-0 c-5">
                                            <div class="container_cart-list">
                                                <span class="container_cart-list-pay">${o.product.priceNew} đ</span>
                                            </div>
                                        </div>
                                        <div class="col l-1 m-0 c-1">
                                            <div class="container_cart-list">
                                                <a class="container_cart-list-delete" href="/petshop/cart-delete?idp=${o.product.idP}&ida=${o.idA}&idcheck=1"><i class="fas fa-trash fa-lg"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>

                </div>
                <!--  -->
                <div style="margin: 20px 0;"></div>
                
                <div class="container__navi-cart">
                    <div class="l-12 m-12 c-12">
                        <div class="container_cart BjIo5w">
                            <div class="container_cart-wrap">
                                <div class="row sm-gutter" style="line-height: 40px;">
                                    <div class="col l-1 m-1 c-1" style="display: flex; margin: auto;">
                                        <label for="" class="stardust-checkbox">
                                            <input type="checkbox" class="stardust-checkbox__input">
                                            <div class="stardust-checkbox__box"></div>
                                        </label>  
                                    </div>
                                    <div class="col l-4 m-0 c-0">
                                        <div class="container__header-total">Chọn tất cả (<span>${countP}</span>)</div>
                                    </div>
                                    <div class="col l-5 m-8 c-7">
                                        <div class="container__header-total">Thanh toán: <span style="color: #FF0000">${sumPrice} đ</span></div>
                                    </div>
                                    <div class="col l-2 m-3 c-4">
                                        <button class="btn btn--primary" onclick="location.href='address';">Mua hàng</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
            <jsp:include page="product.jsp"/>
         	<jsp:include page="footer.jsp"/>
         	
        </div>
    </div>
</body>
</html>
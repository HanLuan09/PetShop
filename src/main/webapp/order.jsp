<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/cart.css">
    <link rel="stylesheet" href="./css/gird.css">
    <link rel="stylesheet" href="./css/product_details.css">
    <link rel="stylesheet" href="./css/register_login.css">
    <link rel="stylesheet" href="./css/order.css">
    <link rel="stylesheet" href="./css/responsive.css">
</head>
<body>
    <div class="main" style="background: #f5f5f5;">
        <div class="YqIqug">
            <div class="contai">
                <div class="jb8bh0">
                    <a href="/petshop/home" class="lJqn"> <spam class="logo">PetShop</spam> 
                        <span class="eSRYBr">Thanh toán</span>
                    </a>
                </div>
            </div>
        </div>
        <div >
            <div class="grid wide">
                <div class="">
                    
                    <div class="">
                        <div class="l-12 m-12 c-12">
                            <div class="p7ULT">
                                <div class="vtrWey"></div>
                                <div class="jJlG8">
                                    <div class="nU2ylc">
                                        <div class="MqmqK4">
                                            <div class="Iafoll">
                                                <i class="fa-solid fa-location-dot"></i>
                                            </div>
                                            <div>Địa chỉ nhận hàng</div>
                                        </div>
                                    </div>
                                    <div class="Jw2Sc">
                                    <c:if test="${addressCheck == 1}">
                                        <div>
                                            <div class="NYnMjH">
                                                <div class="FVWWQy">${address.name} (+84) ${address.phone}</div>
                                                <div class="QsWYfx">${address.address}</div>
                                                <div class="uk7Wpm">Mặc định</div>
                                            </div>
                                                                                   
                                        </div>
                                        <a href="/petshop/address"><div class="WkjWD">Thay đổi</div></a>
                                    </c:if>
                                    <c:if test="${addressCheck == 0}">
                                        <a href="/petshop/address"><div class="WkjWD">Thêm địa chỉ giao hàng</div></a>
                                    </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <!--  -->
                <div style="margin: 10px 0;"></div>
                <div class="">
                    <div class="">
                        <div class="l-12 m-12 c-12">
                            <div class="sqxwIi">
                                <div class="cPNXP ">
                                    <div class="sVj2 row sm-gutter">
                                        <div class="col l-6 m-4 c-4">Sản phẩm</div>
                                        <div class="col l-2 m-3 c-3 content__order">Đơn giá</div>
                                        <div class="col l-1 m-2 c-2 content__order">Số lượng</div>
                                        <div class="col l-3 m-3 c-3 content__order">Thành tiền</div>    
                                    </div>
                                </div>
								<c:forEach items="${listCItem}" var="o">
	                                <div class="container_cart BjIo5w">
	                                    <div class="container_cart-wrap">
	                                        <div class="row sm-gutter">
	                                            <div class="col l-6 m-4 c-4" style="display: flex;">
	                                                <img style="height: 50px; width: 45px;" src="upload/${o.product.imageP}" alt="">
	                                                <span class="oEI3Ln">
	                                                    <span class="order-text-name">${o.product.nameP}</span>
	                                                </span>
	                                            </div>
	                                            <div class="col l-2 m-3 c-3">
	                                                <div class="container_cart-list">
	                                                    <span class="order_text">${o.product.priceNew} đ</span>
	                                                </div>
	                                            </div>
	                                            <div class="col l-1 m-2 c-2">
	                                                <div class="container_cart-list">
	                                                    <span class="order_text">${o.quantity}</span>
	                                                </div>
	                                            </div>
	                                            <div class="col l-3 m-3 c-3">
	                                                <div class="container_cart-list">
	                                                    <span class="order_text-sum">${o.sumPrice} đ</span>
	                                                </div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
								</c:forEach>
                                
                            </div>
                        </div>
                    </div>
                </div>
                <!--  -->
                <div class="container__navi-cart ">
                    <div class="l-12 m-12 c-12">
                        <div class="DQ7t9K">
                            <div class="qsKTk">
                                <div>
                                    <div>
                                        <span class="zDPGhr SzEjHI">Tổng giá tiền:</span>
                                        <span class="KoRB7y">${sumPrice} đ</span>
                                    </div>
                                    
                                    <div>
                                        <span class="zDPGhr SzEjHI">Phương thức thanh toán:</span>
                                        
                                    </div>
                                    
                                    <div class="auth-form__aside" style="margin-bottom: 10px">			                            
			                            <div style="display: flex;">
			                                <div class="auth-form__aside-address auth-form__aside-address-2 auth-form__aside-address--click">
			                                    <spam class="auth-form__aside-home">Thanh toán khi nhận hàng</spam>
			                                </div>
			                                <c:if test="${addressCheck == 1}">
				                                <a href="vnpayajax?amount=${sumPrice}">
				                                    <div class="auth-form__aside-address auth-form__aside-address-2">
				                                        <spam class="auth-form__aside-home">VN Pay</spam>
				                                    </div>
				                                </a>
			                                </c:if>	   
			                                <c:if test="${addressCheck == 0}">	                                
				                                 <div id="checkAddress" class="auth-form__aside-address auth-form__aside-address-2">
				                                      <spam class="auth-form__aside-home">VN Pay</spam>
				                                 </div>			                                
			                                </c:if>	                                
			                            </div>
			                        </div>
			                        
                                </div>
                            </div>
                        </div>
                        <div class="container_cart BjIo5w" style="border: 0; border-top: 1px dashed rgba(0,0,0,.09); background: #fffefb;">
                            <div class="container_cart-wrap">
                                <div class="row sm-gutter" style="display: flex; justify-content: space-between;">
                                    <div class="container__header-total" style="margin: auto 0;">Nhấn "Đặt hàng" đồng nghĩa với việc bạn đồng ý tuân theo điều khoản của PetShop</div>
                                    <c:if test="${addressCheck == 1}"><button class="btn btn--primary" onclick="confirmOrder()">Đặt hàng</button></c:if>
                                    <c:if test="${addressCheck == 0}"><button class="btn btn--primary" onclick="location.href='/petshop/address';">Đặt hàng</button></c:if>
                                </div>
                                <script>
									function confirmOrder() {
									  if (confirm("Bạn có chắc chắn muốn đặt hàng?")) {
									    // Người dùng đã xác nhận đặt hàng, chuyển đến trang /petshop/order-pay
									    location.href = '/petshop/order-pay';
									  }
									  // Nếu người dùng không xác nhận, không làm gì cả
									}
								</script>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
            <jsp:include page="footer.jsp"/>
        </div>
        <div id="add-to-cart-popup" class="hidden">
            <div class="add-to-cart-icon">
                <i class="fa-regular fa-circle-check"></i>
            </div>
            <div class="add-to-cart-text">
                <p>Bạn chư thêm địa chỉ gia hàng.</p>
            </div>
        </div>
        <script>
            // Lấy phần tử thông báo pop-up
			var popup = document.getElementById("add-to-cart-popup");
			
			// Hàm hiển thị thông báo pop-up
			function showPopup() {
			  // Hiển thị thông báo
			  popup.classList.add("show");
			
			  // Sau 3 giây, ẩn thông báo
			  setTimeout(function() {
			    popup.classList.remove("show");
			  }, 900);
			}
			
			// Xử lý sự kiện thêm sản phẩm vào giỏ hàng
			var addToCartButton = document.getElementById("checkAddress");
			if(addToCartButton!=undefined){
				addToCartButton.addEventListener("click", function() {
				  showPopup();
				});
			}
        </script>  
    </div>
</body>
</html>
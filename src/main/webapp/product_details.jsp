<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Details</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/product_details.css">
    <link rel="stylesheet" href="./css/gird.css">
    <link rel="stylesheet" href="./css/responsive.css">
</head>
<body>
    <div class="main">
        <jsp:include page="navi.jsp"/>
        <div class="container">
            <div class="container__details-sp">
                <div class="grid wide">
                    <div class="container-details">
                        <div class="row c-gutter">
                                <!-- left -->
                            <div class="col l-4 m-4 c-12">
                                <div class="flex flex-column">
                                    <div class="U4yQzj">
                                        <div class="UuFd15">
                                        </div>
                                        <div class="container__left-img">
                                            <div class="VWiifV qO2bZw" style="background-image: url(upload/${detail.imageP}); background-size: contain; background-repeat: no-repeat;"></div>
                                        </div>
                                    </div>
                                        <!--  -->
                                        <!-- hình ảnh -->
                                    <div>
                
                                    </div>
                                </div>
                            </div>
                                <!-- right -->
                            <div class="col l-8 m-8 c-12">
                                    <div class="flex-auto flex-column container__right-wrap">
                                        <!-- xếp hạng -->
                                        <div class="container__right-name">
                                            <span>${detail.nameP}</span>
                                        </div>
                                        <div class="container__home">
                                            <div class="flex X5u-5c">
                                                <div class="home-right-rating">
                                                    <div class="home-right-rating-gpa">4.8</div>
                                                    <div class="home-right__rating-star">
                                                        <i class="home-right__rating--gold fa-solid fa-star"></i>
                                                        <i class="home-right__rating--gold fa-solid fa-star"></i>
                                                        <i class="home-right__rating--gold fa-solid fa-star"></i>
                                                        <i class="home-right__rating--gold fa-solid fa-star"></i>
                                                        <i class="home-right__rating--gold fa-solid fa-star"></i>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="home-right-quantity">
                                                <div class="home-right-number">1.4k</div>
                                                <div>Đánh giá</div>
                                            </div>
                                            <div class="home-right-quantity">
                                                <div class="home-right-number">${sumP}</div>
                                                <div>Đã bán</div>
                                            </div>
                                        </div>
                                        <!-- end rating -->
                                        <div class="container__origin">Xuất xứ: <span>${detail.origin}</span></div>
                                        <!-- price -->
                                        <div class="container__price">
                                            <div class="container__price-old">
                                                <span id= "price-old">${detail.price}</span> đ
                                            </div>
                                            <div class="container__price-new">
                                                <span id= "price-new">${detail.priceNew}</span> đ
                                            </div>
                                            <div class="container__price-discount">
                                                Giảm: <span>${detail.discount}</span>%
                                            </div>
                                        </div>
                                        <!-- end price -->
        
                                        <!-- phân loại kích thước màu sắc 
                                        <div class="container__header">
                                        	<c:if test="${not empty listSize}">
                                        	
                                            <div class="container__header-wrap">
                                                <Label class="container__header-name">Kích thước</Label>
                                                <div class="container__header-list">
                                                	<c:forEach items="${listSize}" var="o">
                                                    <button class="container__header-btn container__header-btn-1">${o.size}</button>
                                                    <div class="container__header-size" style="display: none">${o.ratio}</div>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        	
                                        	</c:if>
                                        	<c:if test="${not empty listColor}">
                                        	<div class="container__header-wrap">
                                                <Label class="container__header-name">Màu sắc</Label>
                                                <div class="container__header-list">
                                                	<c:forEach items="${listColor}" var="o">
                                                    <button class="container__header-btn container__header-btn-2">${o.color}</button>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                            </c:if>
                                        </div>-->
                                        
                                        <!-- end phân loại kích thước màu sắc  -->
                                        <!-- số lương và đặt hàng -->
                                        <form action="cart-add" method="post">
                                        <input name="idp" type="hidden" value="${detail.idP}">
                                        <div class="container__right-purchase" style="display: block;">
                                            <div class="container__right-purchase-list">
                                                <div class="flex flex-column">
                                                    <div class="flex container__right-purchase-item-center">
                                                        <div class="container__right-purchase-item-text">Số lượng</div>
                                                        <div style="display: flex; flex-direction: row; align-items: center;">
                                                            <div style="margin-right: 15px;">
                                                                <div class="container__right-purchase-input" style="display: flex; flex-direction: row;">
                                                                    <button type="button" class="container__right-purchase-input-btn" id="container__left">
                                                                        <i class="fa-solid fa-minus"></i>
                                                                    </button>
                                                                    <input name="quantity" type="text" class="container__right-purchase-input-text" value="1" role="spinbutton" aria-valuenow="1" readonly>
                                                                    <button type="button" class="container__right-purchase-input-btn" id="container__right">
                                                                        <i class="fa-solid fa-plus"></i>
                                                                    </button>
                                                                </div>
                                                            </div>
                                                            
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- dtn -->
                                            <div style="margin-top: 40px;">
                                                <div class="container__right-purchase-wrap">
                                                    <div class="container__right-purchase-btn" style="display: flex; flex-direction: row;">
                                                     <!-- đã có tài khoản -->
                                                    	<c:if test="${sessionScope.account != null}"> 
	                                                        <button type="submit" id="add-to-cart-button" class="btn btn-tinted btn--l container__right-purchase-btn__cart iFo-rx" type="button"aria-disabled="false">
	                                                            <span>Thêm vào giỏ hàng</span>
	                                                        </button>
	                                                        
	                                                        <button type="button" id="btn-purchase--buy" class="btn btn-solid-primary btn--l container__right-purchase-btn__buy iFo-rx" type="button" onclick="location.href='cart.jsp';" aria-disabled="false">Mua ngay</button>
	                                                        
                                                        </c:if>
                                                        <!-- chưa có tài khoản -->
                                                        <c:if test="${sessionScope.account == null}">
	                                                        <button id="btn-add--login" class="btn btn-tinted btn--l container__right-purchase-btn__cart iFo-rx" type="button"aria-disabled="false" onclick="location.href='login_register.jsp';">
	                                                            <span>Thêm vào giỏ hàng</span>
	                                                        </button>
	                                                        <button id="btn-buynow--login" class="btn btn-solid-primary btn--l container__right-purchase-btn__buy iFo-rx" type="button" aria-disabled="false" onclick="location.href='login_register.jsp';">Mua ngay</button>
                                                        </c:if>
                                                    </div>
                                                    
                                                </div>
                                            </div>
                                            <script>
				                				// xét xem người đăng nhập khi nhấn mua hàng mà chưa có tài khoản
				                                const btnAT = document.querySelector('#btn-add--login');
				                                const btnBT = document.querySelector('#btn-buynow--login');
				                                if(btnAT != undefined) {
					                                btnAT.addEventListener('click', function() {
					                                  localStorage.setItem('buttonClicked', 'login');
					                                });	
					                                <!--window.location.href = "login_register.jsp";-->
					                     
				                                }
				                                
				                                if(btnBT != undefined) {
					                                btnBT.addEventListener('click', function() {
					                                  localStorage.setItem('buttonClicked', 'login');
					                                });
					                                <!--window.location.href = "login_register.jsp";-->
				                                }
                        					</script>
                                        </div>
                                        </form>
                                        <!-- end số lượng và đặt hàng -->
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
                <script type="text/javascript" src="./javascript/base.js"></script>
                <script src="./javascript/main.js"></script>
                
                <!-- button mua hàng -->
                <script type="text/javascript">
	                var quantity = document.querySelector('input[name="quantity"]').value;
	                var button = document.querySelector('#btn-purchase--buy');
	                if(button!=undefined){
		                button.addEventListener('click', function() {
		                	location.href = 'cart?idp='+${detail.idP}+'&quantity='+quantity;
						});
	                }
		             
	            </script>
	            <!-- xử lý chọn 1 -->
                <script src="./javascript/validate.js"></script>
                <script>
                	
                    Validator2({
                        id: ".container__header-btn-1",
                        action: "container__header-btn--selecter"   
                    });
                    Validator2({
                        id: ".container__header-btn-2",
                        action: "container__header-btn--selecter"   
                    });
                    
                </script>

                <!-- end -->
                <!-- chi tiết sản phẩm -->
                <div class="container-wrap"></div>
                <div class="grid wide">
                    <div class="container-details-conten">
                        <div class="row c-gutter">
                            <div style="width: 95%;">
                                <div class="container-details-frame">Mô tả sản phẩm</div>
                                <div class="container-details-list">
                                    <div class="container-details-item">
                                        <div>${detail.describe}</div>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
               <!-- sản phẩm -->
            <!-- đồ thú cưng -->
            
                <jsp:include page="product.jsp"/>
                <jsp:include page="footer.jsp"/>
		</div>
        <div id="add-to-cart-popup" class="hidden">
            <div class="add-to-cart-icon">
                <i class="fa-regular fa-circle-check"></i>
            </div>
            <div class="add-to-cart-text">
                <p>Sản phẩm đã được thêm vào giỏ hàng thành công.</p>
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
			  }, 6000);
			}
			
			// Xử lý sự kiện thêm sản phẩm vào giỏ hàng
			var addToCartButton = document.getElementById("add-to-cart-button");
			if(addToCartButton!=undefined){
				addToCartButton.addEventListener("click", function() {
				  showPopup();
				});
			}
        </script>  
    </div>
</body>
</html>
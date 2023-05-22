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
    <!-- javascript -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
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
                                        	<div class="flex home-right-quantity">
                                        		<div class="home-right-rating-gpa home-right-number" style="color: #ee4d2d;">${detail.rating}</div>
                                                <div class="home-right__rating-star">
		                                        	<div class="card-jfy-rating-layer top-layer checked home-right__rating--gold" style="width: 100%;">
		                                            	<i class="fa-solid fa-star"></i>
		                                            	<i class="fa-solid fa-star"></i>
		                                                <i class="fa-solid fa-star"></i>
		                                                <i class="fa-solid fa-star"></i>
		                                                <i class="fa-solid fa-star"></i>      
		                                            </div>
		                                            <div class="card-jfy-rating-layer">
		                                            	<i class="fa-solid fa-star"></i>
		                                            	<i class="fa-solid fa-star"></i>
		                                            	<i class="fa-solid fa-star"></i>
		                                            	<i class="fa-solid fa-star"></i>
		                                            	<i class="fa-solid fa-star"></i>          
		                                        	</div>
		                                    	</div>
                                                
                                            </div>
                                           
                                            <div class="home-right-quantity">
                                                <div class="home-right-number">${detail.countRating}</div>
                                                <div>Đánh giá</div>
                                            </div>
                                            <div class="home-right-quantity">
                                                <div class="home-right-number">${detail.sumPrice}</div>
                                                <div>Đã bán</div>
                                            </div>
                                        </div>
                                        <script type="text/javascript">
	                                        var ratingValue = parseFloat(document.querySelector('.home-right-rating-gpa').textContent);
	                                        var ratingWidth = ratingValue * 20; // Chuyển đổi từ điểm đánh giá (0-5) sang phần trăm (0-100)
	                                        var cardRatingLayer = document.querySelector('.top-layer');
	                                        cardRatingLayer.style.width = ratingWidth + '%';
                                        </script>
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
                                                                    <input name="quantity" id="quantity-input" type="text" class="container__right-purchase-input-text" value="1" role="spinbutton" aria-valuenow="1" max ="${remaining}">
                                                                    <input id="input-max" type="hidden" value="${remaining}">
                                                                    <button type="button" class="container__right-purchase-input-btn" id="container__right">
                                                                        <i class="fa-solid fa-plus"></i>
                                                                    </button>
                                                                  	<span id="text--quatity" class ="container__right-purchase-item-text"></span>
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
	                                                        
	                                                        <button type="button" id="btn-purchase--buy" class="btn btn-solid-primary btn--l container__right-purchase-btn__buy iFo-rx" type="button" aria-disabled="false">Mua ngay</button>
	                                                        
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
                                            	var quantity = document.querySelector('#input-max').value;
                                            	var textQuantity = document.querySelector('#text--quatity');                                
				                                var inputs = document.querySelectorAll('.iFo-rx');
				                                if (quantity <=0) {
				                                	inputs.forEach(function(input) {
								            		    input.setAttribute('readonly', 'readonly');
								            		    input.setAttribute('disabled', 'disabled');
								            		});
				                                	 textQuantity.innerText = 'Đã hết hàng';
				                                }else{
				                                	  inputs.forEach(function(input) {
								                  		  if (input.hasAttribute('readonly') || input.hasAttribute('disabled')) {
								                  		    input.removeAttribute('readonly');
								                  		    input.removeAttribute('disabled');
								                  		  }
								                  	  });
				                                	  textQuantity.innerText = '';
				                                }
				                                const btnAT = document.querySelector('#btn-add--login');
				                                const btnBT = document.querySelector('#btn-buynow--login');
				                             // xét xem người đăng nhập khi nhấn mua hàng mà chưa có tài khoản
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
                <script src="./javascript/validate.js"></script>
                <script src="./javascript/main.js"></script>
                <script>
                	
                    Validator2({
                        id: ".container__header-btn-1",
                        action: "container__header-btn--selecter"   
                    });
                    Validator2({
                        id: ".container__header-btn-2",
                        action: "container__header-btn--selecter"   
                    });
                    const inputMax = document.querySelector('#input-max').value;
                    productNumber({
                    	minus: "#container__left",
                    	plus: "#container__right",
                    	quantity: ".container__right-purchase-input-text",
                    	quamax: inputMax
                    });
                    
                    productSalary({
                    	quainput: "#quantity-input", 
                    	quantity: "1",
                    	quamax: inputMax
                    });
                    <!-- button mua hàng -->
                    var button = document.querySelector('#btn-purchase--buy');
                    if(button != undefined){
                        button.addEventListener('click', function() {
                            // Lấy giá trị mới nhất của input
                            var quantity = document.querySelector('#quantity-input').value;
                            //console.log(quantity);
                            // Chuyển hướng đến trang giỏ hàng với các tham số cần thiết
                            location.href = 'petshop-orders?idp='+${detail.idP}+'&quantity='+quantity;
                        });
                    }
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
                <!-- nhận xét -->
                <div class="container-wrap"></div>
                <div class="grid wide">
                    <div class="container-details">
                        <div class="row c-gutter">
                            <div style="width: 95%; background-color: #fffbf8; border: 1px solid #f9ede5; border-radius: 2px; padding: 1.875rem; margin: 1.875rem;">
                                <div class="container-details-frame">Đánh giá sản phẩm</div>
                                <div class="container-details-list">
                                    <div class="content">
                                        <div class="col l-2 m-2 c-1">
                                            <div class="content__left-summary">
                                                <div class="content__left-score">
                                                    <span class="content__left-score-average">${detail.rating}</span>
                                                    <span class="content__left-score-max">/5</span>
                                                    <i class="home-product-item__rating--gold fa-solid fa-star"></i>
                                                </div>
                                                
                                            </div>
                                        </div>
                                        <div class="col l-10 c-10 m-11">
                                            <div>
                                                <button class="container__header-btn container__header-btn-1 container__header-btn--selecter container__header-btn--all">Tất cả</button>
                                                <c:forEach items="${listRCount}" var="o">
	                                                <button class="container__header-btn container__header-btn-1">${o.rating} Sao (${o.count})</button>
                                                </c:forEach>
                                              
                                            </div>
                                            <div class="content__left-count">${detail.countRating} Đánh giá</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="shopee-product-rating-list">
                            <div class="shopee-product-rating-comment-list">
                            	<c:forEach items="${listRA}" var="o">                           	
                                <div class="shopee-product-rating">
                                	<input class ="rating-input" type="hidden" value="${o.rating}">
                                    <div class="shopee-product-rating__avatar">
                                        <div class="shopee-avatar">
                                            <div class="shopee-avatar__placeholder">
                                                <img src="upload/${o.imageA}" alt="" class="shopee-avatar__img">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="shopee-product-rating__main">
                                        <div class="shopee-product-rating__author-name">${o.username}</div>
                                        <div class="repeat-purchase-con">
                                            <div class="home-product-item__rating">
                                            	<c:forEach begin="1" end="${o.rating}" var="rating">
	                                                <i class="home-product-item__rating--gold fa-solid fa-star"></i>
                                            	</c:forEach>
                                            	<c:if test="${o.rating<5}">
	                                            	<c:forEach begin="${o.rating+1}" end="5" var="rating">
		                                                <i class="fa-solid fa-star"></i>
	                                            	</c:forEach>
                                            	</c:if>
                                                
                                            </div>
                                        </div>
                                        <div class="petShop-product-rating__time">${o.dateRating}</div>
                                        
                                        <div class="shopee-product-rating__name">${o.comment}</div>

                                    </div>
                                </div>
                            	</c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
            <script type="text/javascript">
            $(document).ready(function() {
            	  $('.container__header-btn').click(function() {
            	    var selectedRating = $(this).text().charAt(0); // Lấy số sao từ nút được click           	    
            	    if ($(this).hasClass('container__header-btn--all')) {
            	      // Nếu nút được click là nút "Tất cả", hiển thị tất cả đánh giá
            	      $('.shopee-product-rating').show();           	              	   
            	      $('.container__header-btn').not(this).removeClass('container__header-btn--selecter'); // Loại bỏ class "container__header-btn-1" khỏi tất cả các nút khác
            	    } else {
            	      
            	      $('.container__header-btn').not(this).removeClass('container__header-btn--selecter');// loại bỏ
            	      
            	      $(this).addClass('container__header-btn--selecter');// thêm class            	              
            	      $('.container__header-btn--all').removeClass('container__header-btn--selecter');// loại bỏ nút tất cả nếu có 
            	      $('.shopee-product-rating').hide(); // Ẩn tất cả các đánh giá
            	      
            	      // Hiển thị các đánh giá có số sao phù hợp
            	      $('.shopee-product-rating input.rating-input').each(function() {
            	        if ($(this).val() == selectedRating) {
            	          $(this).closest('.shopee-product-rating').show();// hiên tất cả các đánh giá phù hợp
            	        }
            	      });
            	    }
            	  });
            	});

            </script>
          
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
			  }, 12000);
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
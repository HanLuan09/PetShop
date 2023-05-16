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
    <link rel="stylesheet" href="./css/product_details.css">
    <link rel="stylesheet" href="./css/gird.css">
    <link rel="stylesheet" href="./css/responsive.css">
    <style>
        .home-product-item__rating-text{
            font-size: 1.3rem;
            margin-bottom: -1.4px;
            margin-right: 5px;
        }
        .container__header-text {
            width: 100%;
            height: 200px;
            border: 1px solid #f5f5f5;
        }
        .fixed-size-text {
            padding: 4px 8px;
            width: 100%;
            height: 100%;
            resize: none;
            outline: none;
            border: 1px solid #817f7f;
            
        }

    </style>
</head>
<body>
    <div class="main">
        <jsp:include page="navi_cart.jsp"/>
        <div class="container">
            <div class="container__details-sp" style="padding-bottom: 15px">
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
                                            <div class="VWiifV qO2bZw" style="background-image: url(upload/${uDetail.imageP}); background-size: contain; background-repeat: no-repeat;"></div>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                                <!-- right -->
                            <div class="col l-8 m-8 c-12">
                                    <div class="flex-auto flex-column container__right-wrap">
                                        <!-- xếp hạng -->
                                        <div class="container__right-name">
                                            <span>${uDetail.nameP}</span>
                                        </div>
                                        
                                        <div class="container__origin">Xuất xứ: <span>${uDetail.origin}</span></div>
                                        <!-- price -->
                                        <div class="container__price">
                                            <div style="color: #757575; font-size: 1.4rem"><span>Đơn giá</span></div>
                                            <div class="container__price-new"><span>${uDetail.price} đ</span></div>
                                        </div>
                                        <div class="container__price">
                                            <div style="color: #757575; font-size: 1.4rem"><span>Tổng giá</span></div>
                                            <div class="container__price-new"><span>${uDetail.sumPrice} đ</span></div>
                                        </div>
                                        <!-- end price -->
                                        <div class="container__right-purchase" style="display: block;">
                                            <div class="container__right-purchase-list">
                                                <div class="flex flex-column">
                                                    <div class="flex container__right-purchase-item-center">
                                                        <div class="container__right-purchase-item-text">Số lượng</div>
                                                        <div class="container__right-purchase-item-yes" style="font-size: 1.5rem; color: #ee4d2d">${uDetail.amount}</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        <!-- phân loại kích thước màu sắc -->
                                        <c:if test="${uDetail.status==0}">
	                                        <form id="removeform" action="remove-order" method="post" onsubmit="confirmCancelOrder(event)">                	
	                                    </c:if>
	                                    <c:if test="${uDetail.status==1}">
	                                        <form action="${rProduct.rating>0 ? "rating-save" : "rating-add"}" method="post">                	
	                                    </c:if>
                                        <!-- <form action="${rProduct.rating>0 ? "rating-save" : "rating-add"}" method="post">-->
                                        	<input type="hidden" name="idp" value="${uDetail.idP}">
                                        	<input type="hidden" name="ido" value="${uDetail.idO}">
                                        	<input style="border: 2px solid #000" type="hidden" name ="rating" id="rating" value="${rProduct.rating}">
	                                        <div class="container__header">
	                                            <div class="container__header-wrap">
	                                                <Label class="container__header-name">Đánh giá</Label>
	                                                <div class="container__header-list">
	                                                    <button type="button" class="container__header-btn ${rProduct.rating ==1 ? "container__header-btn--selecter" : ""}">
	                                                    	<span class="home-product-item__rating-text">1</span> <i class="home-product-item__rating--gold fa-solid fa-star"></i>
	                                                    </button>
	                                                    <button type="button" class="container__header-btn ${rProduct.rating ==2 ? "container__header-btn--selecter" : ""}">
	                                                    	<span class="home-product-item__rating-text">2</span> <i class="home-product-item__rating--gold fa-solid fa-star"></i>
	                                                    </button>
	                                                    <button type="button" class="container__header-btn ${rProduct.rating ==3 ? "container__header-btn--selecter" : ""}">
	                                                    	<span class="home-product-item__rating-text">3</span> <i class="home-product-item__rating--gold fa-solid fa-star"></i>
	                                                    </button>
	                                                    <button type="button" class="container__header-btn ${rProduct.rating ==4 ? "container__header-btn--selecter" : ""}">
	                                                    	<span class="home-product-item__rating-text">4</span> <i class="home-product-item__rating--gold fa-solid fa-star"></i>
	                                                    </button>
	                                                    <button type="button" class="container__header-btn ${rProduct.rating ==5 ? "container__header-btn--selecter" : ""}">
	                                                    	<span class="home-product-item__rating-text">5</span> <i class="home-product-item__rating--gold fa-solid fa-star"></i>
	                                                    </button>
	                                                    
	                                                </div>
	                                            </div>
	                                            
	                                            <div class="container__header-wrap" style="display: block;">
	                                                <div><Label class="container__header-name">Nhận xét</Label></div>
	                                                <div class="container__header-list">
	                                                    <div class="container__header-text">
	                                                        <textarea class="fixed-size-text" name="comment" id="" cols="30" rows="10" placeholder="Nhận xét/Bình luận về sản phẩm" value="${rProduct.comment}">${rProduct.comment}</textarea>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                        </div>
	                                        
	                                            <!-- dtn -->
	                                            <div style="margin-top: 40px; margin-bottom: 20px">
	                                                <dib class="container__right-purchase-wrap">
	                                                    <div class="container__right-purchase-btn" style="display: flex; flex-direction: row;">
	                                                        <button class="btn btn-tinted btn--l container__right-purchase-btn__cart iFo-rx" type="button"aria-disabled="false" onclick="location.href='/petshop/order';"><span>Trở về</span></button>
	                                                        <c:if test="${uDetail.status==0}">
	                                                        	<button class="btn btn-solid-primary btn--l container__right-purchase-btn__buy iFo-rx" aria-disabled="false" type="submit" onclick="confirmCancelOrder()">Hủy đặt hàng</button>
	                                                        	<script>
	                                                        		function confirmCancelOrder(event) {
	                                                        		  event.preventDefault(); 

	                                                        		  if (confirm("Bạn có chắc chắn muốn hủy đặt hàng?")) {
	                                                        		    	document.getElementById("removeform").submit();
	                                                        		  } else {
	                                                        		    
	                                                        		  }
	                                                        		}
																</script>
	                                                        </c:if>
	                                                        <c:if test="${uDetail.status == 1}">
		                                                        <c:if test="${rProduct.rating==0}">
		                                                        	<button id="btn_rating--add" class="btn btn-solid-primary btn--l container__right-purchase-btn__buy iFo-rx" aria-disabled="false">Đánh giá</button>
		                                                        </c:if>
		                                                        <c:if test="${rProduct.rating>0}">
		                                                        	<button id="btn_rating--edit" class="btn btn-solid-primary btn--l container__right-purchase-btn__buy iFo-rx" type="button" aria-disabled="false">Đổi đánh giá</button>
		                                                        	<button id="btn_rating--save" class="btn btn-solid-primary btn--l container__right-purchase-btn__buy iFo-rx" aria-disabled="false">Lưu đánh giá</button>
		                                                        </c:if>
	                                                        </c:if>
	                                                    </div>
	                                                    
	                                                </dib>
	                                            </div>
                                            </form>
                                        </div>
                                       
                                    </div>
                                    <script src="./javascript/user_product.js"></script>
					                <script>
					                	SelectOne({
					                        id: ".container__header-btn",
					                        action: "container__header-btn--selecter",
					                        rating: "#rating"
					                    });
					                
						            	const save = document.getElementById("btn_rating--save");
						            	const edit = document.getElementById("btn_rating--edit");
						            	if(edit != undefined){
						            		save.style.display ="none";
						            		edit.style.display ="inherit";
						            		var inputs = document.querySelectorAll('input, textarea,.container__header-btn');
												
						            		// Lặp qua danh sách các phần tử input và textarea và thêm/xoá thuộc tính readonly và disabled
						            		//document.querySelector('.custom-file-upload').style.cu
						            		inputs.forEach(function(input) {
						            		    input.setAttribute('readonly', 'readonly');
						            		    input.setAttribute('disabled', 'disabled');
						            		  
						            		});
						
						            		edit.addEventListener('click', function(e){
						            			e.preventDefault();
						            			save.style.display='inherit';
						            			edit.style.display ="none";
						            			inputs.forEach(function(input) {
						                  		  if (input.hasAttribute('readonly') || input.hasAttribute('disabled')) {
						                  		    input.removeAttribute('readonly');
						                  		    input.removeAttribute('disabled');
						                  		  } else {
						                  		    input.setAttribute('readonly', 'readonly');
						                  		    input.setAttribute('disabled', 'disabled');
						                  		  }
						                  		});
						            		});
						            	}
					            	</script>
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
                <p>Bạn đã đánh giá sản phẩm thành công</p>
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
			var addToCartButton = document.getElementById("btn_rating--save");
			if(addToCartButton!=undefined){
				addToCartButton.addEventListener("click", function() {
				  showPopup();
				});
			}
			var addToCartButton = document.getElementById("btn_rating--add");
			if(addToCartButton!=undefined){
				addToCartButton.addEventListener("click", function() {
				  showPopup();
				});
			}
        </script> 
	</div>
	
</body>
</html>
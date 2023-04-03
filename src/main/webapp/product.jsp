<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<div class="container__details-product">
					<div class="grid wide">
	                    <div class="row sm-gutter">
	                    <div class="container__details-product-text">Các sản phẩm khác của shop</div>
	                        <div class="col l-12 m-12">
	                            <div class="home-product">
	                                <div class="row sm-gutter home-product-add">
	                                	<c:forEach items="${listP}" var="o">
	                                    <div class="col l-2 m-4 c-6 home-product-list">
	                                        <a class="home-product-item" href="detail?pid=${o.idP}&cid=${o.cateId}">
	                                            <div class="home-product-item__img" style="background-image: url(${o.imageP});"></div>
	                                            <h5 class="home-product-item__name">${o.nameP}</h5>
	                                            <div class="home-product-item__price">
	                                                <span class="home-product-item__price-old">${o.price} đ</span>
	                                                <span class="home-product-item__price-curent">${o.priceNew} đ</span>
	                                            </div>
	                                            
	                                            <div class="home-product-item__origin">
	                                                <span class="home-product-item__origin-title">${o.origin}</span>
	                                            </div>
	                                            <div class="home-product-item__sale">
	                                                <span class="home-product-item__sale-percent">${o.discount}%</span>
	                                                <span class="home-product-item__sale-lable">Giảm</span>
	                                            </div>
	                                        </a>
	                                    </div>
	                                	</c:forEach>
	                                    
	                                </div>
	                            </div>
	                            <div class="pagination__add">
	                                <!-- <a class="pagination__add-list" href="">Tải thêm</a> -->
	                                <button class="pagination__add-list" onclick="loadMore()">Tải thêm</button>
	                            </div>
	                            <script>
	                                var displayedProducts = 18;
	                                var productList = document.querySelector(".home-product-add");
	                                var products = productList.querySelectorAll(".home-product-list");
	                                if (displayedProducts >= products.length) {
	                                    document.querySelector(".pagination__add").style.display = "none";
	                                }
	                                else {
	                                	document.querySelector(".pagination__add").style.display = "block";
	                                }
	                                
	                                //console.log(productList)
	                                function loadMore() {
	                                // Tăng số lượng sản phẩm đã hiển thị lên 3
	                                    displayedProducts += 18;
	                                    
	                                    // Lấy danh sách các sản phẩm
	                                    
	                                   
	                                    // Hiển thị các sản phẩm mới
	                                    for (var i = 0; i < products.length; i++) {
	                                        if (i < displayedProducts) {
	                                            products[i].style.display = "block";
	                                        }
	                                    }
	                                    
	                                    // Ẩn nút "Tải thêm" nếu đã hết sản phẩm
	                                    if (displayedProducts >= products.length) {
	                                        document.querySelector(".pagination__add").style.display = "none";
	                                    }
	                                }
	
	                            </script>
	                        </div>                      
	                    </div>
	                </div>
	                <script type="text/javascript" src="./javascript/base.js"></script>
                <!-- end đồ thú cưng -->
                </div>                
                        
                   
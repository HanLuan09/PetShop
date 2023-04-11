<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ShopPet</title>
    <!-- icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- css -->
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/gird.css">
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/slider.css">
    <link rel="stylesheet" href="./css/register_login.css">
    <!-- javascript -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        .category-sort{
            height: 60px; 
            background-color: #fff; 
            border: 1px solid #f5f5f5; 
            display: flex; 
            align-items: center;
        }
        .m-left{
            margin-left: 15px;
        }
        .category-sort-span {
            margin-left: 10px; 
            font-size: 1.4rem; 
            color: #333;
            font-weight: 300;
        }
        .select-input {
            min-width: 200px;
            height: 34px;
            border: 1px solid #f0f5f5;
            background-color: #fff;
            border-radius: 2px;
            padding: 0 12px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            cursor: pointer;
            position: relative;
        }
        
        .select-input_lable{
            font-size: 1.4rem;
        }
        
        .select-input_lable-list {
            position: absolute;
            left: 0;
            right: 0;
            top: 33px;
            border: 1px solid #f0f5f5;
            border-radius: 2px;
            background-color: #fff;
            padding: 12px 16px;
            display: none;
        }
        .select-input_lable-item {
            display: block;
            color: #333;
            font-size: 1.4rem;  
        }
        .select-input:hover .select-input_lable-list{
        	z-index: 1;
            display: block;
        }
        .select-input_lable-item:hover a {
            color: #f30c0c;
        }
        .select-input_lable-item + .select-input_lable-item{
            margin-top: 12px;
        }
        .home-product-add .home-product-list:nth-child(n+16) {
		    display: none;
		}
    </style>
    <link rel="stylesheet" href="./css/responsive.css">
</head>
<body>
    <div class="main">
		<jsp:include page="navi.jsp"/>
        <div class="container">
            <!-- container -->
            
            <div class="app__container">
                <div class="grid wide">
                    <div class="row sm-gutter">
                        <!-- Danh mục -->
                        <div class="col l-2 m-0 c-0">
                            <nav class="category">
                                <h3 class="category__heading">Danh mục</h3>
                                <ul class="category-list--product">
                                	<c:forEach items="${listCC}" var="o">
						                <li class="category-item">
                                        	<a href="category?cid=${o.cid}" class="category-item__link ${active == o.cid ? "category-item--active" : ""}">${o.cname}</a>
                                    	</li>
						            </c:forEach>                                                                     
                                </ul>
                            </nav>  
                        </div>
                        <div class="col l-10 m-12 c-12">
                        	<div class="category-sort hide-on-mobile-tablet">
                                <span class="category-sort-span">Sắp xếp theo</span>
                                <button class="btn m-left" onclick="location.href='sort-popular';">Phổ biến</button>
                                <button class="btn m-left" style="background-color:  #ea7221;" onclick="location.href='sort-latest';">Mới nhất</button>
                                <button class="btn btn--primary m-left" onclick="location.href='sort-sell';">Bán chạy</button>
                                <div class="select-input m-left">
                                    <span class="select-input_lable">Giá</span>
                                    <i class="fas fa-angle-down"></i>
                                    <ul class="select-input_lable-list">
                                        <li class="select-input_lable-item">
                                            <a href="sort-low">Giá: Từ thấp đến cao</a>    
                                        </li>
                                        <li class="select-input_lable-item">    
                                            <a href="sort-high">Giá: Từ cao đến thấp</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <!-- sản phảm -->
                            <div class="home-product home-product--position">
                                <div class="home-product-pet">
                                    <div class="home-product-dog">
                                        <div class="row sm-gutter home-product-add">
                                            <!-- lisi -->
                                            <c:forEach items="${listP}" var="o">
		                                    <div class="col l-2-4 m-4 c-6 home-product-list">
		                                        <a class="home-product-item" href="detail?pid=${o.idP}&cid=${o.cateId}">
		                                            <div class="home-product-item__img" style="background-image: url(upload/${o.imageP});"></div>
		                                            <h5 class="home-product-item__name">${o.nameP}</h5>
		                                            <div class="home-product-item__price">
		                                                <span class="home-product-item__price-old">${o.price} đ</span>
		                                                <span class="home-product-item__price-curent">${o.priceNew} đ</span>
		                                            </div>
		                                            <div class="home-product-item__action">
		                                                
		                                                <div class="home-product-item__rating">
		                                                    <i class="home-product-item__rating--gold fa-solid fa-star"></i>
		                                                    <i class="home-product-item__rating--gold fa-solid fa-star"></i>
		                                                    <i class="home-product-item__rating--gold fa-solid fa-star"></i>
		                                                    <i class="home-product-item__rating--gold fa-solid fa-star"></i>
		                                                    <i class="home-product-item__rating--gold fa-solid fa-star"></i>
		                                                </div>
		                                                <span class="home-product-item__rating-separate"></span>
		                                                <span class="home-product-item__action-sold">Đã bán ${o.sumPrice}</span>
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
                                </div>
                                
                            </div>
        
                        </div>
                    </div>
                </div>
                <script type="text/javascript" src="./javascript/base.js"></script>
                <script>
                                var displayedProducts = 15;
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
                                    displayedProducts += 15;
                                    
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
            
			<jsp:include page="footer.jsp"/>
        </div>
        
    </div>

</body>
</html>
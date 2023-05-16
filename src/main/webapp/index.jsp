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
    <!-- icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- css -->
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/gird.css">
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/slider.css">
    <link rel="stylesheet" href="./css/register_login.css">
    <link rel="stylesheet" href="./css/responsive.css">
    <!-- javascript 
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div class="main">
		<jsp:include page="navi.jsp"/>
        <div class="container">
            <!-- container -->
            
            <div class="app__container">
                <!-- slide -->
                <div class="grid wide hide-on-mobile-tablet">
                    <div class="row sm-gutter">
                        <!-- Danh mục -->
                        <div class="col l-2 m-0 c-0">
                            
                            <nav class="category">
                                <h3 class="category__heading">Danh mục</h3>
    
                                <ul class="category-list">
                                	<c:forEach items="${listCC}" var="o">
						                <li class="category-item">
                                        	<a href="category?cid=${o.cid}" class="category-item__link">${o.cname}</a>
                                    	</li>
						            </c:forEach>                                                                     
                                </ul>
                            </nav>
                            
                        </div>
                        <div class="home-slider">
                            <div class="home-slider-left">
                                <div class="home-slider-left-container">
                                    <a href=""><img src="./img/slider_shoppet_1.jpg" alt="" class="home-slider-left-img__left"></a>
                                    <a href=""><img src="./img/slider_shoppet_2.jpg" alt="" class="home-slider-left-img__left"></a>
                                    <a href=""><img src="./img/slider_shoppet_1.jpg" alt="" class="home-slider-left-img__left"></a>
                                    <a href=""><img src="./img/slider_shoppet_2.jpg" alt="" class="home-slider-left-img__left"></a>
                                    <a href=""><img src="./img/slider_shoppet_1.jpg" alt="" class="home-slider-left-img__left"></a>
                                </div>
                                <!--  -->
                                <div class="home-slider-left-btn">
                                    <i id="home-slider-left-btn-icon-left" class="fa-solid fa-chevron-left"></i>
                                    <i id="home-slider-left-btn-icon-right" class="fa-solid fa-chevron-right"></i>
                                </div>
                            </div>
                            <!--  -->
                            <div class="home-slider-right">
                                <li class="home-slider-right-item home-slider-right-item--first"><a href=""><img src="./img/slider_shoppet_r3.jpg" alt="" class="home-slider-left-img__right"></a></li>
                                <li class="home-slider-right-item"><a href=""><img src="./img/slider_shoppet_r1.jpg" alt="" class="home-slider-left-img__right"></a></li>
                                <li class="home-slider-right-item home-slider-right-item--second"><a href=""><img src="./img/slider_shoppet_r1.jpg" alt="" class="home-slider-left-img__right"></a></li>
                                <li class="home-slider-right-item home-slider-right-item--second"><a href=""><img src="./img/slider_shoppet_r1.jpg" alt="" class="home-slider-left-img__right"></a></li>
                                
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end slide  -->
                <!-- chó   -->
                <div class="grid wide">
                    <div class="row sm-gutter">
                        <!-- Danh mục -->
                        <div class="col l-2 m-0 c-0">
                            <div class="home-product-new">
                                <img class="home-product-new__img" src="https://freenice.net/wp-content/uploads/2021/04/hinh-nen-con-cho-bong-long-trang-de-thuong.jpg" alt=""> 
                            </div>
                            
                        </div>
                        <div class="col l-10 m-12 c-12">
                            <!-- sản phảm -->
                            <div class="card-fs-content-header" style="background-color: #fff;">
                                <div>
                                    <span class="stardust-tabs-header__text" style="color: #ee4d2d; font-size: 1.5rem; font-weight: 500; margin-left: 10px;">Góc dành cho thú cưng</span>
                                    <a href="category?cid=0" class="card-fs-content-button">Xem toàn bộ sản phẩm</a>
                                </div>
                            </div>
                            <div class="home-product home-product--position" style="background-color: #fff;">
                                <div class="home-product-pet">
                                    <div class="home-product-dog">
                                        <div class="row-nowrap sm-gutter">
                                           <!-- lisi -->
                                            <c:forEach items="${listDogCat}" var="o">
	                                            <div class="col l-2-4 m-4 c-6 list__product-next">
	                                                <a class="home-product-item" href="detail?pid=${o.idP}&cid=${o.cateId}">
	                                                    <div class="home-product-item__img" style="background-image: url(upload/${o.imageP});"></div>
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
                                    <div class="home-product-dog-btn" >
                                        <div class="home-product-dog-item">
                                            <i class="fa-solid fa-chevron-left" id="btnLeft-dog" style="color: #ff0000"></i>
                                        </div>   
                                        <div class="home-product-dog-item">
                                            <i class="fa-solid fa-chevron-right" id="btnRight-dog" style="color: #ff0000"></i>
                                        </div>
                                    </div>
                                </div>
                                <script>
								  // Lấy danh sách các khung danh mục sản phẩm
								  const productContainer1 = document.querySelector('.home-product-dog');
								  const productContainer2 = productContainer1.querySelector('.row-nowrap');
								  const productContainers = productContainer2.querySelectorAll('.col');
								  let currentPosition = 0; // Xác định vị trí của khung danh mục sản phẩm hiện tại
								  console.log(productContainers.length)
								  // Lấy các nút chuyển đổi
								  const leftButton = document.getElementById('btnLeft-dog');
								  const rightButton = document.getElementById('btnRight-dog');
								
								  // Thêm transition CSS cho các container
								  productContainers.forEach(container => {
								    container.style.transition = 'transform 0.3s ease';
								  });
								  
								  // Xử lý sự kiện click của nút chuyển đến trái
								  leftButton.addEventListener('click', () => {
								    if (currentPosition > 3) {
								      currentPosition = currentPosition - 4;
								      updateContainerTransform();
								      rightButton.style.display = 'flex';
								      if (currentPosition === 0) {
								    	  
								        	leftButton.style.display = 'none';
								      }
								    }
								    //console.log(currentPosition)
								  });
									
								  // Xử lý sự kiện click của nút chuyển đến phải
								  rightButton.addEventListener('click', () => {
									var test = productContainers.length % 4;
									if (currentPosition < productContainers.length - 4) {
									      currentPosition = currentPosition + 4;
									      updateContainerTransform();
									      leftButton.style.display = 'flex';
									      if (currentPosition >= productContainers.length - 4) {
									        	rightButton.style.display = 'none';
									      }
									      
									    }
								    
								    
								  });
								 
								  // Ẩn nút chuyển đến trái khi hiển thị khung đầu tiên
								  if (currentPosition === 0) {
								    leftButton.style.display = 'none';
								  }
								
								  // Cập nhật giá trị transform của container
								  function updateContainerTransform() {
								    productContainers.forEach(container => {
								      container.style.transform = 'translateX(-'+currentPosition * container.offsetWidth+ 'px)';
								    });
								  }
								
								  // Hàm thực hiện animation mượt mà
								  function animate() {
								    requestAnimationFrame(animate);
								    updateContainerTransform();
								  }
								
								  // Bắt đầu animation
								  animate();
								</script>
                                
                                
                                <!--  -->
                            </div>
        
                        </div>
                    </div>
                </div>
                <!-- test danh mục-->
                <div class="grid wide">
                    <div class="row sm-gutter">
                        <div class="col l-12 m-12" style="margin-bottom: 10px;">
                            <div class="card-fs-content-header stardust-tabs-header" style="border-bottom: #d5d5d5 1px solid;">
                                <div class="stardust-tabs-header__text">
                                    <span style="font-size: 1.5rem">Sản phẩm hàng đầu</span>
                                </div>
                                
                            </div>
                            <div>
                                <div class ="card-categories-ul">
                                	<c:forEach items="${listBest}" var ="o">
                                    <div class="card-categories-li align-left">
                                        <a href="detail?pid=${o.idP}&cid=${o.cateId}" class="card-categories-li-content">
                                            <div class="card-categories-image-container">
                                                <img src="upload/${o.imageP}" alt="" class="image">
                                            </div>
                                            <div class="card-categories-name">
                                                <spam class="card-categories-name__text">${o.nameP}</spam>
                                            </div>
                                        </a>
                                    </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- đồ thú cưng -->
                <div class="grid wide">
                    <div class="row sm-gutter">
                        <div class="col l-12 m-12">
                        	<div class="card-fs-content-header stardust-tabs-header">
                                <div class="stardust-tabs-header__text">
                                    <span style="font-size: 1.5rem">Gợi ý hôm nay</span>
                                </div>
                            </div>
                            <div class="home-product">
                                <div class="row sm-gutter home-product-add">
                                	<c:forEach items="${listP}" var="o">
                                    <div class="col l-2 m-4 c-6 home-product-list">
                                        <a class="home-product-item" href="detail?pid=${o.idP}&cid=${o.cateId}">
                                            <div class="home-product-item__img" style="background-image: url(upload/${o.imageP});"></div>
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
                <!-- end đồ thú cưng -->
            </div>
            
			<jsp:include page="footer.jsp"/>
        </div>
        
    </div>
    <script type="text/javascript" src="./javascript/base.js"></script>
</body>
</html>
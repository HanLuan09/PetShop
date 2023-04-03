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
    <!-- javascript -->
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
                                <li class="home-slider-right-item home-slider-right-item--first"><a href=""><img src="img/slider/slider_shoppet_r3.jpg" alt="" class="home-slider-left-img__right"></a></li>
                                <li class="home-slider-right-item"><a href=""><img src="img/slider/slider_shoppet_r1.jpg" alt="" class="home-slider-left-img__right"></a></li>
                                <li class="home-slider-right-item home-slider-right-item--second"><a href=""><img src="img/slider/slider_shoppet_r1.jpg" alt="" class="home-slider-left-img__right"></a></li>
                                <li class="home-slider-right-item home-slider-right-item--second"><a href=""><img src="img/slider/slider_shoppet_r1.jpg" alt="" class="home-slider-left-img__right"></a></li>
                                
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
                            <div class="home-product home-product--position">
                                <div class="home-product-pet">
                                    <div class="home-product-dog">
                                        <div class="row-nowrap sm-gutter">
                                            <!-- lisi -->
                                            <c:forEach items="${listDog}" var="o">
	                                            <div class="col l-2-4 m-4 c-6">
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
                                    <div class="home-product-dog-btn" >
                                        <div class="home-product-dog-item">
                                            <i class="fa-solid fa-chevron-left" id="btnLeft-dog"></i>
                                        </div>   
                                        <div class="home-product-dog-item">
                                            <i class="fa-solid fa-chevron-right" id="btnRight-dog"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
        
                        </div>
                    </div>
                </div>
                <!-- mèo   -->
                <div class="grid wide">
                    <div class="row sm-gutter">
                        <!-- Danh mục -->
                        <div class="col l-2 m-0 c-0">
                            <div class="home-product-new">
                                <img class="home-product-new__img" src="https://vn-live-01.slatic.net/p/c32cec582e41689b3f5cea05de12201b.jpg" alt=""> 
                            </div>
                            
                        </div>
                        <div class="col l-10 m-12 c-12">
                            <!-- sản phảm -->
                            <div class="home-product home-product--position">
                                <div class="home-product-pet">
                                    <div class="home-product-dog">
                                        <div class="row-nowrap sm-gutter">
                                            <!-- lisi -->
                                            <c:forEach items="${listDog}" var="o">
	                                            <div class="col l-2-4 m-4 c-6">
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
                                    <div class="home-product-dog-btn" >
                                        <div class="home-product-dog-item">
                                            <i class="fa-solid fa-chevron-left" id="btnLeft-dog"></i>
                                        </div>   
                                        <div class="home-product-dog-item">
                                            <i class="fa-solid fa-chevron-right" id="btnRight-dog"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
        
                        </div>
                    </div>
                </div>
                                <script>
                                    // Lấy danh sách các khung danh mục sản phẩm
                                    const productContainer1 = document.querySelector('.home-product-dog');
                                    const productContainer2 = productContainer1.querySelector('.row-nowrap');
                                    const productContainers = productContainer2.querySelectorAll('.col');
                                    // const productContainers = productContainer3.querySelectorAll('.home-product-item');
                                    // console.log(productContainers.length)
                                    // Xác định vị trí của khung danh mục sản phẩm hiện tại
                                    let currentPosition = 0;
                                
                                    // Lấy các nút chuyển đổi
                                    const leftButton = document.getElementById('btnLeft-dog');
                                    const rightButton = document.getElementById('btnRight-dog');
                                
                                    // Xử lý sự kiện click của nút chuyển đến trái
                                    leftButton.addEventListener('click', () => {
                                        if (currentPosition > 0) {
                                            currentPosition--;
                                            productContainers.forEach(container => {
                                                container.style.transform = `translateX(-${currentPosition * container.offsetWidth}px)`;
                                            });
                                            rightButton.style.display = 'flex';
                                            if (currentPosition === 0) {
                                                leftButton.style.display = 'none';
                                            }
                                        }
                                    });
                                
                                    // Xử lý sự kiện click của nút chuyển đến phải
                                    rightButton.addEventListener('click', () => {
                                        if (currentPosition < productContainers.length - 1) {
                                            currentPosition++;
                                            productContainers.forEach(container => {
                                                container.style.transform = `translateX(-${currentPosition * container.offsetWidth}px)`;
                                            });
                                            leftButton.style.display = 'flex';
                                            if (currentPosition === productContainers.length - 5) {
                                                rightButton.style.display = 'none';
                                            }

                                        }
                                        // console.log(currentPosition)
                                    });
                                    // console.log(currentPosition)
                                    // Ẩn nút chuyển đến trái khi hiển thị khung đầu tiên
                                    if (currentPosition === 0) {
                                        leftButton.style.display = 'none';
                                    }
                                    
                                </script>
                                
                                <!--  -->
                <!-- đồ thú cưng -->
                <div class="grid wide">
                    <div class="row sm-gutter">
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
                <!-- end đồ thú cưng -->
            </div>
            
			<jsp:include page="footer.jsp"/>
        </div>
        
    </div>
    <!-- Modal layout -->
    <div class="modal" id="modal" style="display: none;">
        <div class="modal__overlay">

        </div>
        <div class="modal__body">
                <!-- Register form -->
            <form action="" class="form-regster" id="form-regster">
                <div class="auth-form" id="auth-form-register">
                    <div class="auth-form__container">
                        <div class="auth-form__header">
                            <h3 class="auth-form__heading">Đăng ký</h3>
                        </div>
                        <div class="auth-form__form auth-form__form--register">
                            <div class="auth-form__group">
                                <input name="fullname" type="text" id="fullname" class="auth-form__input" placeholder="Nhập tên đăng nhập"> 
                                <span class="form-message"></span> 
                            </div>
                            <div class="auth-form__group">
                                <input name="password" type="password" id="password" class="auth-form__input" placeholder="Nhập mật khẩu"> 
                                <span class="form-message"></span>
                            </div>
                            <div class="auth-form__group">
                                <input name="password_comfirmation" type="password" id="password_comfirmation" class="auth-form__input" placeholder="Nhập lại mật khẩu">
                                <span class="form-message"></span>  
                            </div>
                        </div>
    
                        <div class="auth-form__aside">
                            <p class="auth-form__text" >Bằng việc đăng ký, bạn đã đồng ý vơi ShopPet về
                                <a href="" class="auth-form__text-link">Điều khoản dịch vụ</a> &
                                <a href="" class="auth-form__text-link">Chính sách bảo mật</a>
                            </p>
                        </div>
    
                        <div class="auth-form__controls">
                            <button class="btn auth-form__controls-back btn--normal">Trở lại</button>
                            <button class="btn btn--primary" type="submit">Đăng ký</button>
                        </div>
    
                    </div>
                    <div class="auth-form__social">
                        <div class="login-foot" style="padding-top: 10px;">
                                <div class="login-foot-inner">
                                    <div class="login-foot-inner-line">
                                        <span>Hoặc là</span>
                                    </div>
                                    <div class="mod-third-party-login">
                                        <div class="mod-button mod-third-party-login-btn mod-third-party-login-fb" style="margin: 0 10px;">
                                            <img src="//lzd-img-global.slatic.net/g/tps/tfs/TB1wGErw7T2gK0jSZPcXXcKkpXa-96-96.png" alt="" class="mod-third-party-login-fbimg">
                                            <span class="mod-third-party-login-text">Facebook</span>
                                        </div>
                                        <div class="mod-button mod-third-party-login-btn mod-third-party-login-google" style="margin: 0 10px;">
                                            <img src="//lzd-img-global.slatic.net/g/tps/tfs/TB1_TgtwVP7gK0jSZFjXXc5aXXa-92-92.png" alt="" class="mod-third-party-login-fbimg">
                                            <span class="mod-third-party-login-text">Google</span>
                                        </div>
                                    </div>
                                </div>
                        </div>
                        <div class="auth-form__social-text">
                            <p class="auth-form__social-text__text" >Bạn đã có tài khoản?
                                <a href="" class="auth-form__social-text__text-link"> Đăng nhập</a>
                            </p>
                        </div>
                    </div>
                </div>
            </form>
             <!-- Login form -->
            <form action="login" method="POST" class="form-login" id="form-login">
                <div class="auth-form" id="auth-form-login">
                    <div class="auth-form__container">
                        <div class="auth-form__header">
                            <h3 class="auth-form__heading">Đăng nhập</h3>
                        </div>

                        <div class="auth-form__form">
                            <div class="auth-form__group">
                                <input name="name" type="text" id="name" class="auth-form__input" placeholder="Email/Nhập tên đăng nhập"> 
                                <span class="form-message"></span> 
                            </div>
                            
                            <div class="auth-form__group">
                                <input name="password" id="login_password" type="password" class="auth-form__input" placeholder="Nhập mật khẩu">
                                <span class="form-message"></span>  
                            </div>
                        </div>
    
                        <div class="auth-form__aside">
                            <div class="auth-form__help">
                                <a href="" class="auth-form__help-link auth-form__help--forgot">Quên mật khẩu</a>
                                <span class="auth-form__help-separate"></span>
                                <a href="" class="auth-form__help-link">Cần trợ giúp?</a>
                            </div>
    
                            </table>
                        </div>
    
                        <div class="auth-form__controls">
                            <button class="btn auth-form__controls-back btn--normal">Trở lại</button>
                            <button class="btn btn--primary" type="submit">Đăng nhập</button>
                        </div>
    
                    </div>
                    <div class="auth-form__social">
                        <div class="auth-form__social-nav">
                            <a href="" class="btn btn--size-s btn--with-icon auth-form__social--facebook">
                                <i class="auth-form__social-icon fa-brands fa-facebook"></i>
                                <span class="auth-form__social-title">
                                    Kết nối với Facebook
                                </span>
                            </a>
                            <a href="" class="btn btn--size-s btn btn--with-icon auth-form__social--google">
                                <i class="fa-brands fa-google"></i>
                                <span class="auth-form__social-title">
                                    Kết nối với Google
                                </span>
                            </a>
                        </div>
                        <div class="auth-form__social-text">
                            <p class="auth-form__social-text__text" >Bạn mới biết đến ShopPet?
                                <a href="" class="auth-form__social-text__text-link"> Đăng ký</a>
                            </p>
                        </div>
                    </div>
                </div>
            </form>
            <!-- Pay form -->
            <form action="" method="POST" class="form-pay" id="form-pay">
                <div class="auth-form" id="auth-form-pay">
                    <div class="auth-form__container">
                        <div class="auth-form__header">
                            <h3 class="auth-form__heading">Địa chỉ và Phương thức thanh toán</h3>
                        </div>

                        <div class="auth-form__form">
                            <div class="auth-form__group auth-form__group--name">
                                <div>
                                    <input name="name" type="text" id="name" class="auth-form__input" placeholder="Họ và tên"> 
                                    <span class="form-message"></span> 
                                </div>
                                <div>
                                    <input name="phone" type="text" id="phone" class="auth-form__input" placeholder="Số điện thoại"> 
                                    <span class="form-message"></span> 
                                </div>
                            </div>
                        
                            <div class="auth-form__group">
                                <input name="address" id="address" type="text" class="auth-form__input" placeholder="Địa chỉ giao hàng">
                                <span class="form-message"></span>  
                            </div>
                        </div>
    
                        <div class="auth-form__aside">
                            <p style="font-size: 1.4rem; font-weight: 400; color: #333;">Loại địa chỉ:</p>
                            <div style="display: flex;">
                                <div class="auth-form__aside-address auth-form__aside-address-1 auth-form__aside-address--click">
                                    <spam class="auth-form__aside-home">Nhà riêng</spam>
                                </div>
                                <div class="auth-form__aside-address auth-form__aside-address-1">
                                    <spam class="auth-form__aside-home">Văn phòng</spam>
                                </div>
                            </div>
                        </div>
                        <div class="auth-form__aside">
                            <p style="font-size: 1.4rem; font-weight: 400; color: #333;">Phương thức thanh toán:</p>
                            <div style="display: flex;">
                                <div class="auth-form__aside-address auth-form__aside-address-2 auth-form__aside-address--click">
                                    <spam class="auth-form__aside-home">Thanh toán khi nhận hàng</spam>
                                </div>
                                <a href="">
                                    <div class="auth-form__aside-address auth-form__aside-address-2">
                                        <spam class="auth-form__aside-home">Mobile Banking</spam>
                                    </div>
                                </a>
                                <a href="">
                                    <div class="auth-form__aside-address">
                                        <spam class="auth-form__aside-home">Ví điện tử</spam>
                                    </div>    
                                </a>
                            </div>
                            <div class="auth-form__aside-method">
                                Trạng thái: <span style="font-weight: 300;">Chưa thanh toán</span>
                            </div>
                            
                        </div>
    
                        <div class="auth-form__controls">
                            <button class="btn auth-form__controls-back btn--normal">Trở lại</button>
                            <button class="btn btn--primary">Hoàn thành</button>
                        </div>
    
                    </div>
                    <div style="margin-top: 20px;"> </div>
                </div>
            </form>
            <!--  -->
        </div>
    </div>
    <!-- login/ -->
    <script type="text/javascript" src="./javascript/base.js"></script>
 
    <script src="./javascript/validate.js"></script>
    <script>
        // mong muốn 
        // regster
        Validator({
            form: "#form-regster",
            formGroupSelector: ".auth-form__group",
            errorSelector: ".form-message",
            rules: [
                Validator.isRequired('#fullname'),
                //Validator.isRequired('#email'),
                Validator.isRequired('#password'),
                Validator.isRequired('#password_comfirmation'),
                //Validator.isEmail('#email'),
                Validator.minLength('#password', 6),
                Validator.isConfirmed('#password_comfirmation', function() {
                    return document.querySelector("#form-1 #password").value;
                }, 'Mật khẩu nhập lại không chính xác'),
            ],
            onSubmit: function(data) {
                // call API
                console.log(data);
            }
            
        });
        // login
        
        Validator({
            form: "#form-login",
            formGroupSelector: ".auth-form__group",
            errorSelector: ".form-message",
            rules: [
                Validator.isRequired('#name'),
                Validator.isRequired('#login_password'),
            ],
            onSubmit: function(data) {
                // call API
                console.log(data);
            }
            // login
        });
        
        // thanh toán
        Validator2({
            id: ".auth-form__aside-address-1",
            action: "auth-form__aside-address--click"   
        });
        Validator2({
            id: ".auth-form__aside-address-2",
            action: "auth-form__aside-address--click"   
        });
                    
    </script>
    
   
</body>
</html>
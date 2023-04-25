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
    <link rel="stylesheet" href="./css/register_login.css">
    <link rel="stylesheet" href="./css/responsive.css">
</head>
<body>
    <div >
    
        <div class="modal hide-on-mobile-tablet" id="modal">
            
            <div class="modal__body">
                
                <form action="${addressCheck == 0 ? "add-address" : "save-address"}" method="POST" class="form-pay" id="form-pay">
                <div class="auth-form" id="auth-form-pay">
                    <div class="auth-form__container">
                        <div class="auth-form__header">
                            <h3 class="auth-form__heading">Địa chỉ và Phương thức thanh toán</h3>
                        </div>

                        <div class="auth-form__form">
                            <div class="auth-form__group auth-form__group--name">
                                <div style="width: 26rem;">
                                    <input name="name" type="text" id="name" class="auth-form__input" placeholder="Họ và tên" value="${address.name}"> 
                                    <span class="form-message"></span> 
                                </div>
                                <div class="auth-form__group">
                                    <input name="phone" type="text" id="phone" class="auth-form__input" placeholder="Số điện thoại" value="${address.phone}"> 
                                    <span class="form-message"></span> 
                                </div>
                            </div>
                        
                            <div class="auth-form__group">
                                <input name="address" id="address" type="text" class="auth-form__input" placeholder="Địa chỉ giao hàng" value="${address.address}">
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
                            <button class="btn btn--primary" type="submit">Hoàn thành</button>
                        </div>
    
                    </div>
                    <div style="margin-top: 20px;"> </div>
                </div>
            	</form>   
                <!--  -->
            </div>
	        
        </div> 
         <!-- xử lý cho mobile -->
        <div class= "hide-on-pc">
            <!-- Đăng ký đăng nhập -->
            <div class="mod-tabs">
                <ul class="mod-tabs-header">
                    <!-- class active để chuyển layout -->
                    <li class="mod-tabs-item active">ĐỊA CHỈ</li>
                    <!--<li class="mod-tabs-item">THANH TOÁN</li>-->
                </ul>
                <form action="${addressCheck == 0 ? "add-address" : "save-address"}" method="POST" id="form-pay--mb">
                <div class="mod-tabs-content-list">
                    <div class="mod-tabs-content mod-tabs-content--block">
                        <div class="login">
                            <div class="login-main">
                                <div class="login-form">
                                    <div class="mod-input">
                                        <label for="username" class="mod-input-label">Họ và tên</label>
                                        <input type="text" name="name" id="name-mb" class="mod-input-text" value="${address.name}">
                                        <b></b>
                                        <span class="form-message"></span> 
                                    </div>
                                    <div class="mod-input">
                                        <label for="username" class="mod-input-label">Số điện thoại</label>
                                        <input type="text" name="phone" id="phone-mb" class="mod-input-text" value="${address.phone}">
                                        <b></b>
                                       <span class="form-message"></span> 
                                    </div>
                                    <div class="mod-input">
                                        <label for="username" class="mod-input-label">Địa chỉ</label>
                                        <input type="text" name="address" id="address-mb" class="mod-input-text" value="${address.address}">
                                        <b></b>
                                        <span class="form-message"></span> 
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
                                </div>
                            </div>
                            <div class="login-btn">
                                <button class="mod-button" type="submit">HOÀN THÀNH</button>
                            </div>     
                        </div>
                    </div>
                </div>
                </form>
            </div>
            <!-- end đăng ký đăng nhập -->
			<script>
			// sử lý sự kiện nhập input sẽ đẩy label lên
			var inputs = document.getElementsByClassName("mod-input-text");
			for (var i = 0; i < inputs.length; i++) {
		           
	            if(inputs[i].value != "") {
	                var label = inputs[i].previousElementSibling;
	                label.classList.add("mod-input-label-up");
	            }
	            inputs[i].addEventListener("focus", function() {
	                var label = this.previousElementSibling;
	                label.classList.add("mod-input-label-up");
	            });
	            inputs[i].addEventListener("blur", function() {
	                var label = this.previousElementSibling;
	                if (this.value === "") {
	                    label.classList.remove("mod-input-label-up");
	                }
	            });
	            
	        }

	        // end sự kiện nhập
	
	        // sử lý sự kiện chuyển farment đăng nhập và đăng ký
	        const tabs = document.querySelectorAll('.mod-tabs-item');
	        const tabContents = document.querySelectorAll('.mod-tabs-content');
	
	        function switchTab(index) {
	            // remove active class from all tabs and contents
	            tabs.forEach(tab => tab.classList.remove('active'));
	            tabContents.forEach(content => content.classList.remove('mod-tabs-content--block'));
	
	            // add active class to the selected tab and content
	            tabs[index].classList.add('active');
	            tabContents[index].classList.add('mod-tabs-content--block');
	        }
	
	        // add event listener to each tab
	        tabs.forEach((tab, index) => {
	            tab.addEventListener('click', () => {
	                switchTab(index);
	            });
	        });
	
	        // switch to the default active tab
	        switchTab(0);
	        // end sự kiện dk, dn
	        
	        
      
	    </script>
        </div>
    </div>
    <script src="./javascript/validate.js"></script>
    <script>
        // mong muốn 
        //pc
        // regster
        Validator({
            form: "#form-pay",
            formGroupSelector: ".auth-form__group",
            errorSelector: ".form-message",
            rules: [
                Validator.isRequired('#name'),
                Validator.isRequired('#phone'),
                Validator.isRequired('#address'),
               
            ]
            
        });
        
        Validator({
            form: "#form-pay--mb",
            formGroupSelector: ".mod-input",
            errorSelector: ".form-message",
            rules: [
                Validator.isRequired('#name-mb'),
                Validator.isRequired('#phone-mb'),
                Validator.isRequired('#address-mb'),
            ]
            
        });
         
    </script>
</body>
</html>
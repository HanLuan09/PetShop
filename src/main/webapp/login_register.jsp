<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăngký/Đăngnhập</title>
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
                    <!-- Register form -->
                <form action="register" method="post" class="form-regster" id="form-regster">
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
        					<div class="error-mess" style="margin: 5px 0; font-size: 1.3rem; color: #FF0000">${messregister}</div>
                            <div class="auth-form__aside">
                                <p class="auth-form__text" >Bằng việc đăng ký, bạn đã đồng ý vơi ShopPet về
                                    <a href="" class="auth-form__text-link">Điều khoản dịch vụ</a> &
                                    <a href="" class="auth-form__text-link">Chính sách bảo mật</a>
                                </p>
                            </div>
        
                            <div class="auth-form__controls">
                                <button onclick="location.href='${sessionScope.previousUrl}';" class="btn auth-form__controls-back btn--normal" type="button">Trở lại</button>
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
                                    <a href="login_register.jsp" class="auth-form__social-text__text-link" id="register_login"> Đăng nhập</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </form>
                 <!-- Login form -->
	            <c:set var="cookie" value="${request.cookies}"/>
	            <form action="login" method="POST" class="form-login" id="form-login">
	                <div class="auth-form" id="auth-form-login">
	                    <div class="auth-form__container">
	                        <div class="auth-form__header">
	                            <h3 class="auth-form__heading">Đăng nhập</h3>
	                        </div>
	
	                        <div class="auth-form__form">
	                            <div class="auth-form__group">
	                                <input name="name" value="${cookie.nameC.value}" type="text" id="name" class="auth-form__input" placeholder="Email/Nhập tên đăng nhập"> 
	                                <span class="form-message"></span> 
	                            </div>
	                            
	                            <div class="auth-form__group">
	                                <input name="password" value="${cookie.passC.value}" id="login_password" type="password" class="auth-form__input" placeholder="Nhập mật khẩu">
	                                <span class="form-message"></span>  
	                            </div>
	                        </div>
	    					<div class="error-mess" style="margin: 5px 0; font-size: 1.3rem; color: #FF0000">${messlogin}</div>
	                        <div class="auth-form__aside">
	                            <div class="auth-form__help">
	                                <a href="" class="auth-form__help-link auth-form__help--forgot">Quên mật khẩu</a>
	                                <span class="auth-form__help-separate"></span>
	                                <a href="" class="auth-form__help-link">Cần trợ giúp?</a>
	                            </div>
	                           
	                        </div>
	    					
	                        <div class="auth-form__controls">
	                            <button onclick="location.href='${sessionScope.previousUrl}';" class="btn auth-form__controls-back btn--normal" type="button">Trở lại</button>
	                            <button class="btn btn--primary" type="submit">Đăng nhập</button>
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
	                            <p class="auth-form__social-text__text" >Bạn mới biết đến ShopPet?
	                                <a href="login_register.jsp" class="auth-form__social-text__text-link" id="login_register"> Đăng ký</a>
	                            </p>
	                        </div>
	                    </div>
	                </div>
	            </form>                
                <!--  -->
            </div>
	        <script>
	            const buttonClicked = localStorage.getItem('buttonClicked');
	            
	            if (buttonClicked === 'login') {
	           		document.querySelector("#auth-form-register").style.display= "none";
	                document.querySelector("#auth-form-login").style.display= "block";
	                
	              // Do something if button A was clicked on page 1
	            } else if (buttonClicked === 'register') {
	              	
	            	document.querySelector("#auth-form-register").style.display= "block";
	            	document.querySelector("#auth-form-login").style.display= "none";
	              // Do something if button B was clicked on page 1
	            } 
	         // chưa có tài khoản
	            const loginR = document.querySelector("#login_register");
	            loginR.addEventListener("click", function(e) {
	            	e.preventDefault();
	                document.querySelector("#auth-form-register").style.display= "block";
	                document.querySelector("#auth-form-login").style.display= "none";
	                localStorage.setItem('buttonClicked', 'register');
	            });

	            // đã có tài khoản
	            const loginL = document.querySelector("#register_login");
	            loginL.addEventListener("click", function(e) {
	            	e.preventDefault();
	                document.querySelector("#auth-form-register").style.display= "none";
	                document.querySelector("#auth-form-login").style.display= "block";
	                localStorage.setItem('buttonClicked', 'login');
	            });
	           	
	    	</script>
        </div> 
         <!-- xử lý cho mobile -->
        <div class= "hide-on-pc">
            <!-- Đăng ký đăng nhập -->
            <div class="mod-tabs">
                <ul class="mod-tabs-header">
                    <!-- class active để chuyển layout -->
                    <li class="mod-tabs-item active">ĐĂNG NHẬP</li>
                    <li class="mod-tabs-item">ĐĂNG KÝ</li>
                </ul>
                <div class="mod-tabs-content-list">
                	<form action="login" method="post" id="form-login--mod-tabs">
                    <div class="mod-tabs-content mod-tabs-content--block">
                        <div class="login">
                            <div class="login-main">
                                <div class="login-form">
                                    <div class="mod-input">
                                        <label for="username" class="mod-input-label">Tên đăng nhập</label>
                                        <input type="text" name="name" value="${cookie.nameC.value}" class="mod-input-text" id ="login_name--mod-tabs">
                                        <b></b>
                                        <span class="form-message"></span> 
                                    </div>
                                    <div class="mod-input">
                                        <label for="password" class="mod-input-label">Nhập mật khẩu</label>
                                        <input type="password" name="password" value="${cookie.passC.value}" class="mod-input-text" id="login_password--mod-tabs">
                                        <b></b>
                                        <span class="form-message"></span> 
                                    </div>
                                    <div class="login-forgot">
                                        <a href="">Quên mật khẩu?</a>
                                    </div>
                                </div>
                            </div>
                            <div class="login-btn">
                                <button class="mod-button" type="submit">ĐĂNG NHẬP</button>
                            </div>
                            <div class="login-foot">
                                <div class="login-foot-inner">
                                    <div class="login-foot-inner-line">
                                        <span>Hoặc là</span>
                                    </div>
                                    <div class="mod-third-party-login">
                                        <div class="mod-button mod-third-party-login-btn mod-third-party-login-fb">
                                            <img src="//lzd-img-global.slatic.net/g/tps/tfs/TB1wGErw7T2gK0jSZPcXXcKkpXa-96-96.png" alt="" class="mod-third-party-login-fbimg">
                                            <span class="mod-third-party-login-text">Facebook</span>
                                        </div>
                                        <div class="mod-button mod-third-party-login-btn mod-third-party-login-google">
                                            <img src="//lzd-img-global.slatic.net/g/tps/tfs/TB1_TgtwVP7gK0jSZFjXXc5aXXa-92-92.png" alt="" class="mod-third-party-login-fbimg">
                                            <span class="mod-third-party-login-text">Google</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                	</form>
                	
                	<form action="register" method="post" id="form-register--mod-tabs">
                    <div class="mod-tabs-content">
                        <div class="login">
                            <div class="login-main">
                                <div class="login-form">
                                    <div class="mod-input">
                                        <label for="username" class="mod-input-label">Tên đăng nhập</label>
                                        <input type="text" name="fullname" class="mod-input-text" id ="name--mod-tabs">
                                        <b></b>
                                        <span class="form-message"></span> 
                                    </div>
                                    <div class="mod-input">
                                        <label class="mod-input-label">Nhập mật khẩu</label>
                                        <input type="password" name="password" class="mod-input-text" id="password--mod-tabs">
                                        <b></b>
                                        <span class="form-message"></span> 
                                    </div>
                                    <div class="mod-input">
                                        <label class="mod-input-label">Nhập lại mật khẩu</label>
                                        <input type="password" name="password_comfirmation" class="mod-input-text" id ="password_comfirmation--mod-tabs">
                                        <b></b>
                                        <span class="form-message"></span> 
                                    </div>
                                </div>
                            </div>
                            <div class="login-btn">
                                <button class="mod-button" type="submit">ĐĂNG KÝ</button>
                            </div>
                            <div class="login-foot">
                                <div class="login-foot-inner">
                                    <div class="login-foot-inner-line">
                                        <span>Hoặc là</span>
                                    </div>
                                    <div class="mod-third-party-login">
                                        <div class="mod-button mod-third-party-login-btn mod-third-party-login-fb">
                                            <img src="//lzd-img-global.slatic.net/g/tps/tfs/TB1wGErw7T2gK0jSZPcXXcKkpXa-96-96.png" alt="" class="mod-third-party-login-fbimg">
                                            <span class="mod-third-party-login-text">Facebook</span>
                                        </div>
                                        <div class="mod-button mod-third-party-login-btn mod-third-party-login-google">
                                            <img src="//lzd-img-global.slatic.net/g/tps/tfs/TB1_TgtwVP7gK0jSZFjXXc5aXXa-92-92.png" alt="" class="mod-third-party-login-fbimg">
                                            <span class="mod-third-party-login-text">Google</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                	</form>
                </div>
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
	        
	        //lỗi
	        // sử lý mess báo lỗi trên server trả về
	        //var div = document.querySelector(".he1");
	
	        // Lấy các thẻ input trong thẻ div
	        var inputsMess = document.querySelectorAll(".auth-form__input");
	        console.log(inputsMess)
	        // Lấy thẻ div có class là "mess"
	      
	        var mess = document.querySelector(".error-mess");
	        console.log(mess)
	        // Thêm sự kiện "input" cho các thẻ input
	        inputsMess.forEach(function(input) {
		        input.addEventListener("input", function() {
		            // Xóa nội dung của thẻ div "mess"
		            mess.innerHTML = "";
		            console.log(mess.value)
		        });
	        });
	        var inputs = document.getElementsByTagName("input");
	        var errorMessage = document.querySelector(".error-mess");
	        for (var i = 0; i < inputs.length; i++) {
	            inputs[i].onclick = function() {
	                errorMessage.innerText = "";
	            }
	        }
	        ///lỗi
      
	    </script>
        </div>
    </div>
    <script src="./javascript/validate.js"></script>
    <script>
        // mong muốn 
        //pc
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
                    return document.querySelector("#form-regster #password").value;
                }, 'Mật khẩu nhập lại không chính xác'),
            ]
            
        });
        // login
        
        Validator({
            form: "#form-login",
            formGroupSelector: ".auth-form__group",
            errorSelector: ".form-message",
            rules: [
                Validator.isRequired('#name'),
                Validator.isRequired('#login_password'),
            ]
            // login
        });
        //end pc
        // mt
        // regster
        Validator({
            form: "#form-register--mod-tabs",
            formGroupSelector: ".mod-input",
            errorSelector: ".form-message",
            rules: [
                Validator.isRequired('#name--mod-tabs'),
                Validator.isRequired('#password--mod-tabs'),
                Validator.isRequired('#password_comfirmation--mod-tabs'),
                Validator.minLength('#password--mod-tabs', 6),
                Validator.isConfirmed('#password_comfirmation--mod-tabs', function() {
                    return document.querySelector("#form-register--mod-tabs #password--mod-tabs").value;
                }, 'Mật khẩu nhập lại không chính xác'),
            ]
            
        });
        // login
        
        Validator({
            form: "#form-login--mod-tabs",
            formGroupSelector: ".mod-input",
            errorSelector: ".form-message",
            rules: [
                Validator.isRequired('#login_name--mod-tabs'),
                Validator.isRequired('#login_password--mod-tabs'),
            ]
            // login
        });
        //end
        
                    
    </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- css -->
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/gird.css">
    <link rel="stylesheet" href="./css/register_login.css">
    <link rel="stylesheet" href="./css/responsive.css">
    <style>
    	.payment {
    		display: flex; justify-content: center; margin-bottom: 20px; font-size: 1.4rem
    	}
    	.pay-text {
    		margin-left: 5px;
    		color: #ff0000;
    	}
        @media (max-width: 1023px) {
            #auth-form-register {
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <div >
        <div class="modal" id="modal">
            
            <div class="modal__body">
                    <!-- Register form -->
                <form action="" class="form-regster" id="form-regster">
                    <div class="auth-form" id="auth-form-register">
                        <div class="auth-form__container">
                            <div class="auth-form__header">
                                <i class="fa-solid fa-circle-check" style="font-size: 4rem; color: rgb(0, 247, 255);"></i>
                            </div>
                            <div class="auth-form__header">
                                <h5 class="auth-form__heading" style="text-transform: uppercase; color: #FF0000">Mua hàng thành công</h5>
                            </div>
                            <div class="auth-form__form ">
                                <div class="auth-form__group payment">
                                    <span>Mã đơn hàng của bạn là </span><span class="pay-text">PETSHOP000${idO}</span>
                                </div>
                                <div class="auth-form__group payment">
                                    <span>Ngày thanh toán </span><span class="pay-text"> ${vnp_PayDate}</span>
                                </div>
                                <div class="auth-form__group payment">
                                    <span>Tổng số tiền của đơn hàng</span> <span class="pay-text">${sumPrice}</span>
                                </div>
                                <div class="auth-form__group payment" >
                                    <span>Tổng số tiền đã thanh toán</span> <span class="pay-text">${vnp_amount}</span>
                                </div>
                                <div class="auth-form__group payment" >
                                    <span>Tổng số tiền còn lại phải trả </span> <span class="pay-text">${sum}</span>
                                </div>
                                <div class="auth-form__group payment" >
                                    <p>Bạn có thể xem chi tiết trong</p> <a href="/petshop/order" style="margin-left: 5px; color: #FF0000">đơn hàng của tôi</a>  
                                </div>
                            </div>
                            <div class="auth-form__controls payment">                               
                                <a href="petshop/home" class="btn btn--primary" style="padding: 10px 10px;">Tiếp tục mua sắm</a>
                            </div>
                        </div>              
                    </div>
                </form>                 
            </div>
        </div>          
    </div>
</body>
</html>
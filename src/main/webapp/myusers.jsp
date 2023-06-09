<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Tài khoản của tôi</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/gird.css">
    <link rel="stylesheet" href="./css/myusers.css">
    <link rel="stylesheet" href="./css/responsive.css">
</head>
<body>
    <div>
        <div id="header-wrapper">
            <div id="lzd-global-header">
                <a href="" class="back">
                    <i class="back-icon fa-solid fa-arrow-left-long"></i>
                </a>
                <div class="title-wrap title-display text-title space-set">
                    <div class="title-wrap-inner">
                        <h1 class="page-title">Tài khoản của tôi</h1>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="container">
        <div class="account vn">
            <div class="mod-minlogin guest">
                <div >
                	<c:if test="${sessionScope.account != null}">
                    	<p style="max-width: 40%;">Xin chào ${sessionScope.account.username}</p>
                    	<a href="logout">ĐĂNG XUẤT</a>
                    </c:if>
                    <c:if test="${sessionScope.account == null}">
                    	<p style="max-width: 40%;">Xin chào</p>
                    	<a href="login">ĐĂNG NHẬP / ĐĂNG KÝ</a>
                    </c:if>
                </div>
            </div>
            <ul>
                <li> 
                    <i class="fa-regular fa-pen-to-square"></i>
                    <a href="order">Đơn hàng của tôi</a>
                </li>
                <li>
                    <i class="fa-regular fa-heart"></i>
                    <a href="">Sản phẩm yêu thích</a>
                </li>
            </ul>
            <ul>
                <li>
                    <i class="fa-regular fa-clipboard"></i>
                    <a href="">Chính sách</a>
                </li>
                <li>
                    <i class="fa-regular fa-circle-question"></i>
                    <a href="">Trung tâm hỗ trợ</a>
                </li>
            </ul>
            <div class="content" style="width: 100px; height: 100px; display: block; right: 15px; bottom: 62px;">
                <img alt="" src="https://laz-img-cdn.alicdn.com/tfs/TB1uHklAaL7gK0jSZFBXXXZZpXa-200-189.png" class="img">
                <div class="close"></div>
            </div>
        </div>
    </div>
</body>
</html>
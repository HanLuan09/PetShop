<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!-- header -->
        <div class="hide-on-tablet hide-on-pc" data-fixed="fixed" style="padding: 4.2vw 4vw; background: linear-gradient(90deg,#ff933f,#f93782 69%,#f93782);">
            <header>
                <span style="font-size: 2rem; color: #183545">PetShop <span style="color: #1a9cb7">Giỏ Hàng</span></span>
            </header>
        </div>
        <nav class="h2-tabbar hide-on-pc" style="background-image:url('//lzd-img-global.slatic.net/g/tps/imgextra/i1/O1CN01Uz4Tvs1yUbd3VkjJs_!!6000000006582-2-tps-1125-147.png')">
            <a href="/petshop/home" class="tabbar-item selected home hp-exp-class">
                <i class="tabbar-item-icon fa-solid fa-house home-icon"></i>
                <span class="tabbar-text">Home</span>
            </a> 
            <a href="" class="tabbar-item selected home hp-exp-class">
                <img alt="categories" class="tabbar-item-icon" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFoAAABICAMAAABBaBKgAAAAhFBMVEUAAAARERESEhISEhISEhIVFRUUFBQ9PT0SEhIRERESEhITExMVFRUXFxcREREREREVFRUZGRkYGBgRERERERESEhISEhITExMSEhIeHh4RERESEhIRERESEhISEhISEhISEhITExMSEhIRERERERESEhISEhIRERESEhIRERETExMRERF4dZduAAAAK3RSTlMAz4HYfjAnBPbiel8kCvyoHxQPr6FjU08rCPDUxrttaEY8N+60nJB1V0pCX01AnQAAANxJREFUWMPt1smOwkAMBNAKw9BZOgtJgLAvs0/9//9BkNLilBhQX5DfrS4ly74YSqnn2CranuBDGZEMLTyYsxV30Szikcx4Voqqf7qYUy5K0SuNSK4KH9Uo6nXV4GYhY5k4KaGUUuo1lKcp/JiFzEbwYZLx4gAPErbc2E2+fhPaLtDvyFbSxYB3GLpRTXJj3OZXlMq+MOQv/jVwTDGRsSmUUkq9iOR7v4QXnyQDL93/bO1dTpt3oemdz8IupFiOfsW16/jIs5ANzT3/YLhzydabQKg6YIixSyillMgZs0c+z0Ij3wAAAAAASUVORK5CYII=">
                <span class="tabbar-text">Categories</span>
            </a> 
            <!-- ${sessionScope.account == null ? "login":"cart"} -->
            <a href="" class="tabbar-item selected home hp-exp-class">
                <img alt="cart" class="tabbar-item-icon" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFoAAABICAMAAABBaBKgAAAAmVBMVEUAAAASEhITExMWFhYUFBQSEhIdHR0RERESEhISEhITExMSEhIRERERERESEhIQEBARERETExMVFRUXFxczMzMREREeHh4RERESEhISEhITExMRERERERERERESEhISEhIRERERERESEhISEhIRERERERERERERERESEhITExMSEhIRERERERERERESEhISEhIUFBQSEhIRERGcDW4PAAAAMnRSTlMAoF8LMroRlNWAWoz3sHz7aEE9IAXjCMeYYhrow6WKb+2/VSzd0Zt1c0438bWSf0cmg1BFKdMAAAHfSURBVFjD7dfXcuJAEIXhxkoEIREkgUTGsATH/d//4bZcZe52J3StXFTZ322DwsyZ1oz8+HrBpvfhPC7kf/vFp8O4tUuTXtsZkMECjtKOZguP0o4VjKQdJ0ikHW+wlHY0KG2XI9uayFE7NmK0QG8mRjPYicI0y+FiW5elqLzAXExqSEVlD8+2iOSiUsNKjJ6gEY05ZNZ51DXWrvWPHWUXiSGvxCiDtShcrLmWPgxFYW1/pBC6ojCDi23MdMGucojFYgFT8TZ2edmlKn2ZbZnr0xdB3+X+A/FVPLkM416TvtDWMPXp28BKrAJN+oa2CdKnb2HZGunT9w5bMdGnr7ZNvT59HTiJiT59B7iKtJG+BtJCpI307Z03LyW8+35xfzvnv/ZqIFu4Oq/aZ/HwAAdxM829jh1BCZnHsWPpdUgpA3H0mMOrx/eFvojPz8/OmwTmPnMeAZ3AYVp2QFSIh2oHlKPKcuEkBYaVeAk6AOmwN3r4u/r0cgTIe4X46pc4mIWiUG26mKXDsWhN69d55x/W57dKvps4nISxqaQVJHxIAlNJJbgFpBuYShoJEA0iIDGVFOLPjtYHYlPJXwjRbescmkr+JredzgAmhtJ9PbXrWN9XQhxzfW+r0aWH/LgDfwCWrX+ukom9hgAAAABJRU5ErkJggg==">
                <span class="tabbar-text">Cart</span>
            </a> 
            <a href="myusers.jsp" class="tabbar-item selected home hp-exp-class">
                <img alt="account" class="tabbar-item-icon" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFoAAABICAMAAABBaBKgAAAApVBMVEUAAAAREREVFRU1NTURERESEhIZGRkREREgICARERESEhJ2dnYSEhIRERETExMTExMRERESEhIRERERERERERERERERERERERETExMWFhYVFRUTExMSEhIRERESEhISEhITExMYGBgRERESEhIRERESEhISEhISEhIRERESEhIREREWFhYRERESEhISEhISEhIRERESEhIRERESEhIRERERERERERGg6CSWAAAANnRSTlMA7jEE+/UPhwfhYwLLsE496qugkfjPtoQ1Ix0a5dRUOCcV2Y1nQyy9pVxIC8WbgXx3upVx269/hQZeAAACt0lEQVRYw+2Y2VLqQBCGCWQwm0AWgkRQFlkFxeV87/9oJ+jFyVCo3dGbU+V/Y1lMfdX9T3dPQ+NXteQtHteR77imN8vTYPhj3HawyrDkp1c/AZ6mhjPqd74Lvn98B4+eg27RbnnTZeewcjlqd/stcjCi1Hhg59/exIZScX3TvfVb6ttz/s+P9juLmuTrCPA34flPi8QF964W+epoRup9csAHnls1yAbc4PPi2R0N17sxgl73q8tIgAftDUYlWVAAc+BGh16D2xWcC3MwTVU9A4FsCozB9xQ9OIJUeHbowIsc/aiJ5A6ctngiGdiI42jN4EJ6OIV+KM/xBkwhnM8Gtg2FdjAQl8e4/KMK25edXMFAN9Qz6IoaMQPl+5QL231hpSe1cCcs6mft+wlZKBsfQUMpHyRdE1l3Ir75iSyCQoveg2T8OVZy4v6VrA4uqN+7gcxEUyPquSDqml4nMq/7x2NKXcoq5Ak6WnQfCplvA+377+J6shH5pETfCsdwAY6y+l4gkQ6ErZWuYDYIx84FrCv/dkx/ePrExX51/Z1AJmuFJZi2VbO9pb0PjiG2ezGWl9KDvbI6d2ElDR/cTiUHR16uGzDTCtsBos39+9bRyYHsxg56FgrR4RjmVYfGlDKr5GKfO5TqLar2GM2y2jnZU1sHwz+5afvkzY0acj2B37Zu7tDnXa+DiV3TgnXZIvUgPvGvWASHYDs5bcTM2vhklrCXFKoDUUs73CXRDEfQG9aY7iRf9Hi3B06zoVUYA9H1p0u7C6bON/XWHrsNT83IgZGKbEfF7IN2+ONaWWnVfaXU8txHk7fe8b7xc8iMDx5hz75Bvd2XH5dg0xGwBWQZW0+WsvVkKVtPVrD1ZD1bT9az9WQ9W0/Ws2OLLGFLl/2JRRaxt9KdduaqfgZr5klL/AxMG7/6n/QXkYFsym4cKFEAAAAASUVORK5CYII=">
                <span class="tabbar-text">Account</span>
            </a> 
        </nav>
        <header class="header hide-on-mobile">
            <div class="grid wide">
                <div  class="header-main">
                    <!-- nav 1 -->
                    <a href="/petshop/home" class="header__list1">
                        <img src="./img/shoppet.jpg" alt="" class="header-petshop">
                        <!-- <li class="header-shoppet">ShopPet</li>    -->
                    </a>
                    
                    <ul class="header__list2">
                        <div class="header__nav">
                            <div class="header_user  hide-on-mobile-tablet">
                                <div class="header__user-list">
                                    <span class="header__user-text-petshop">Welcome to ShopPet!</span>
                                    <div class="header__user-item"> 
                                        <!-- chưa có tài khoản -->
                                        <c:if test="${sessionScope.account == null}">
                                        <div class="header__user-nouser">
                                            <a href="#" class="header__user-item-icon"><i class="fa fa-user"></i></a>
                                            <a href="login_register.jsp" class="header__user-item-register">Đăng ký</a> | 
                                            <a href="login_register.jsp" class="header__user-item-login">Đăng nhập</a>
                                        </div>
                                        </c:if>
                                        <!-- có tài khoản -->
                                        <c:if test="${sessionScope.account != null}">
                                        <div class="header__user-yesuser">
                                            <img class="header__user-img" src="https://superbrain.edu.vn/wp-content/uploads/2020/05/icon-thuong-thuong-phong-cach-rieng-cua-Superbrain-7.jpg" alt="">
                                            <span class="header__user-name">Xin chào ${sessionScope.account.username}</span>    
                                            <ul class="header__user-item-users-menu">
                                                <li class="header__user-item-users-item">
                                                    <a href="">Tài khoản của tôi</a>
                                                </li>
                                                <c:if test="${sessionScope.account.isAdmin == 1}">
                                                <li class="header__user-item-users-item">
                                                    <a href="manager">Quản lý bán hàng</a>
                                                </li>
                                                </c:if>
                                                <li class="header__user-item-users-item">
                                                    <a href="logout">Đăng xuất</a>
                                                </li>
                                            </ul>
                                        </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                			<script>
                				// xét xem người dùng chọn đăng ký hay đăng nhập
                                const btnA = document.querySelector('.header__user-item-register');
                                const btnB = document.querySelector('.header__user-item-login');
                                if(btnA != undefined) {
	                                btnA.addEventListener('click', function() {
	                                  localStorage.setItem('buttonClicked', 'register');
	                                });	
                                }
                                
                                if(btnB != undefined) {
	                                btnB.addEventListener('click', function() {
	                                  localStorage.setItem('buttonClicked', 'login');
	                                });
                                }
                        	</script>
                        </div>
                        <!--  -->
                    </ul>
                </div>
            </div>
        </header>
        
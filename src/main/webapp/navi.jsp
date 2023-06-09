<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!-- header -->
        <div class="search-wrap hide-on-tablet hide-on-pc" data-fixed="fixed">
            <header class="search search-wrap-shadow">
                <div class="search-box">
                    <span class="search-icon"></span>
                    <div class="search-content">
                        <input type="search" class="search-input" value ="${search}">
                        <!-- <ul class="search-diwen-wrap">
                            <li class="search-text" style>chó cưng</li>
                            <li class="search-text" style>mèo cưng</li>
                            <li class="search-text">thức ăn cho chó</li>
                            <li class="search-text">thức ăn cho mèo</li>
                            <li class="search-text">phụ kiện thú cưng</li>
                        </ul> -->
                    </div>
                    <div class="search-btn">Tìm kiếm</div>
                </div>
            </header>
        </div>
        <nav class="h2-tabbar hide-on-pc" style="background-image:url('//lzd-img-global.slatic.net/g/tps/imgextra/i1/O1CN01Uz4Tvs1yUbd3VkjJs_!!6000000006582-2-tps-1125-147.png')">
            <a href="/petshop/home" class="tabbar-item selected home hp-exp-class">
                <i class="tabbar-item-icon fa-solid fa-house home-icon"></i>
                <!--<img alt="home" class="tabbar-item-icon" src="data:image/png;base64,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">  -->
                <span class="tabbar-text">Home</span>
            </a> 
            <a href="" class="tabbar-item selected home hp-exp-class">
                <img alt="categories" class="tabbar-item-icon" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFoAAABICAMAAABBaBKgAAAAhFBMVEUAAAARERESEhISEhISEhIVFRUUFBQ9PT0SEhIRERESEhITExMVFRUXFxcREREREREVFRUZGRkYGBgRERERERESEhISEhITExMSEhIeHh4RERESEhIRERESEhISEhISEhISEhITExMSEhIRERERERESEhISEhIRERESEhIRERETExMRERF4dZduAAAAK3RSTlMAz4HYfjAnBPbiel8kCvyoHxQPr6FjU08rCPDUxrttaEY8N+60nJB1V0pCX01AnQAAANxJREFUWMPt1smOwkAMBNAKw9BZOgtJgLAvs0/9//9BkNLilBhQX5DfrS4ly74YSqnn2CranuBDGZEMLTyYsxV30Szikcx4Voqqf7qYUy5K0SuNSK4KH9Uo6nXV4GYhY5k4KaGUUuo1lKcp/JiFzEbwYZLx4gAPErbc2E2+fhPaLtDvyFbSxYB3GLpRTXJj3OZXlMq+MOQv/jVwTDGRsSmUUkq9iOR7v4QXnyQDL93/bO1dTpt3oemdz8IupFiOfsW16/jIs5ANzT3/YLhzydabQKg6YIixSyillMgZs0c+z0Ij3wAAAAAASUVORK5CYII=">
                <span class="tabbar-text">Categories</span>
            </a> 
            <c:if test="${sessionScope.account == null}">
            <a href="/petshop/login_register.jsp" class="tabbar-item selected home hp-exp-class">
                <img alt="cart" class="tabbar-item-icon" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFoAAABICAMAAABBaBKgAAAAmVBMVEUAAAASEhITExMWFhYUFBQSEhIdHR0RERESEhISEhITExMSEhIRERERERESEhIQEBARERETExMVFRUXFxczMzMREREeHh4RERESEhISEhITExMRERERERERERESEhISEhIRERERERESEhISEhIRERERERERERERERESEhITExMSEhIRERERERERERESEhISEhIUFBQSEhIRERGcDW4PAAAAMnRSTlMAoF8LMroRlNWAWoz3sHz7aEE9IAXjCMeYYhrow6WKb+2/VSzd0Zt1c0438bWSf0cmg1BFKdMAAAHfSURBVFjD7dfXcuJAEIXhxkoEIREkgUTGsATH/d//4bZcZe52J3StXFTZ322DwsyZ1oz8+HrBpvfhPC7kf/vFp8O4tUuTXtsZkMECjtKOZguP0o4VjKQdJ0ikHW+wlHY0KG2XI9uayFE7NmK0QG8mRjPYicI0y+FiW5elqLzAXExqSEVlD8+2iOSiUsNKjJ6gEY05ZNZ51DXWrvWPHWUXiSGvxCiDtShcrLmWPgxFYW1/pBC6ojCDi23MdMGucojFYgFT8TZ2edmlKn2ZbZnr0xdB3+X+A/FVPLkM416TvtDWMPXp28BKrAJN+oa2CdKnb2HZGunT9w5bMdGnr7ZNvT59HTiJiT59B7iKtJG+BtJCpI307Z03LyW8+35xfzvnv/ZqIFu4Oq/aZ/HwAAdxM829jh1BCZnHsWPpdUgpA3H0mMOrx/eFvojPz8/OmwTmPnMeAZ3AYVp2QFSIh2oHlKPKcuEkBYaVeAk6AOmwN3r4u/r0cgTIe4X46pc4mIWiUG26mKXDsWhN69d55x/W57dKvps4nISxqaQVJHxIAlNJJbgFpBuYShoJEA0iIDGVFOLPjtYHYlPJXwjRbescmkr+JredzgAmhtJ9PbXrWN9XQhxzfW+r0aWH/LgDfwCWrX+ukom9hgAAAABJRU5ErkJggg==">
                <span class="tabbar-text">Cart</span>
            </a> 
            </c:if>
            <c:if test="${sessionScope.account != null}">
            <a href="cart-get" class="tabbar-item selected home hp-exp-class">
                <img alt="cart" class="tabbar-item-icon" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFoAAABICAMAAABBaBKgAAAAmVBMVEUAAAASEhITExMWFhYUFBQSEhIdHR0RERESEhISEhITExMSEhIRERERERESEhIQEBARERETExMVFRUXFxczMzMREREeHh4RERESEhISEhITExMRERERERERERESEhISEhIRERERERESEhISEhIRERERERERERERERESEhITExMSEhIRERERERERERESEhISEhIUFBQSEhIRERGcDW4PAAAAMnRSTlMAoF8LMroRlNWAWoz3sHz7aEE9IAXjCMeYYhrow6WKb+2/VSzd0Zt1c0438bWSf0cmg1BFKdMAAAHfSURBVFjD7dfXcuJAEIXhxkoEIREkgUTGsATH/d//4bZcZe52J3StXFTZ322DwsyZ1oz8+HrBpvfhPC7kf/vFp8O4tUuTXtsZkMECjtKOZguP0o4VjKQdJ0ikHW+wlHY0KG2XI9uayFE7NmK0QG8mRjPYicI0y+FiW5elqLzAXExqSEVlD8+2iOSiUsNKjJ6gEY05ZNZ51DXWrvWPHWUXiSGvxCiDtShcrLmWPgxFYW1/pBC6ojCDi23MdMGucojFYgFT8TZ2edmlKn2ZbZnr0xdB3+X+A/FVPLkM416TvtDWMPXp28BKrAJN+oa2CdKnb2HZGunT9w5bMdGnr7ZNvT59HTiJiT59B7iKtJG+BtJCpI307Z03LyW8+35xfzvnv/ZqIFu4Oq/aZ/HwAAdxM829jh1BCZnHsWPpdUgpA3H0mMOrx/eFvojPz8/OmwTmPnMeAZ3AYVp2QFSIh2oHlKPKcuEkBYaVeAk6AOmwN3r4u/r0cgTIe4X46pc4mIWiUG26mKXDsWhN69d55x/W57dKvps4nISxqaQVJHxIAlNJJbgFpBuYShoJEA0iIDGVFOLPjtYHYlPJXwjRbescmkr+JredzgAmhtJ9PbXrWN9XQhxzfW+r0aWH/LgDfwCWrX+ukom9hgAAAABJRU5ErkJggg==">
                <span class="tabbar-text">Cart</span>
            </a> 
            </c:if>
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
                        <img src="./img/petshop.png" alt="" class="header-petshop">
                        <!-- <li class="header-shoppet">ShopPet</li>    -->
                    </a>
                    <!-- search view -->
                    <div class="header__search hide-on-mobile">
                    	    
                        <div class="header__search-input__wrap">
                        	<form action="search" method="get">
                            <div class="header__search-box">
                                <span class="header__search-icon"></span>
                                <div class="header__search-content">
                                	<input oninput="searchName(this)" type="text" name="search" class="header__search-input" placeholder="Tìm kiếm tại đây" value="${search}">
                                    
                                    <!-- search lịch sử tìm kiếm-->
                                    <div class="header__search-history" id="search-history" style="display: none;">
                                        <h3 class="header__search-history-heading">Tìm kiếm</h3>
                                        <ul class="header__search-history-list" id="content-search">
                                            <li class="header__search-history-item"><a href="search?search=Thú cưng">Thú cưng</a></li>
                                            <li class="header__search-history-item"><a href="search?search=Mèo ba tư">Mèo ba tư</a></li>
                                            <li class="header__search-history-item"><a href="search?search=Chó Corgi">Chó Corgi</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <button class="header__search-button" type="submit" style="border: 0">Tìm kiếm</button>
                            </div>
	                        </form>
                        </div>
                    </div>
                    <!-- end search -->

                    <ul class="header__list2">
      
                        <div class="header__nav">
                            <div class="header__cart hide-on-mobile-tablet">
                                <a href="/petshop/cart-get" class="header__cart-icon header__nav-icon"><i class="fa fa-shopping-cart"></i></a>
                                <span class="header__cart-notice">${sumCart}</span>
                                 <!-- Chưa có san phẩm header__cart-list--no-cart -->
                                <div class="header__cart-list header__cart-list--no-cart">
                                	<c:if test="${sumCart==0}">
                                    	<img src="./img/no_cart.png" alt="" class="header__cart-no-cart-img">
                                    </c:if>
                                    <!-- Có giỏ hàng -->
                                    <c:if test="${sumCart !=0}">
                                    <h4 class="header__cart-heading">Sản phẩm đã thêm</h4>
                                    <ul class="header__cart-list-ul category-list">
                                        <!-- item -->
                                        <c:forEach items="${listCartNavi}" var="o">
                                        <li class="header__cart-item">
                                            <img src="upload/${o.product.imageP}" alt="" class="header__cart-img">
                                            <div class="header__cart-item-info">
                                                <div class="header__cart-item-head">
                                                    <h5 class="header__cart-item-name">${o.product.nameP}</h5>
                                                    <div class="header__cart-item-wrap">
                                                        <span class="header__cart-item-price">${o.product.priceNew} đ</span>
                                                        <span class="header__cart-item-multipl">x</span>
                                                        <span class="header__cart-item-qnt">${o.quantity}</span>
                                                    </div>
                                                </div>
                                                <div class="header__cart-item-body">
                                                    <span class="header__cart-item-description">
                                                        Phân loại Bạc
                                                    </span>
                                                    <a href="/petshop/cart-delete?idp=${o.product.idP}&ida=${o.idA}&idcheck=0"><span class="header__cart-item-remove">Xóa</span></a>
                                                </div>
                                            </div>
                                        </li>
                                        </c:forEach>
                                    </ul>
                                    <button class="header__cart-viewcart btn btn--primary" onclick="location.href='cart-get';">Xem giỏ hàng</button>
                                    </c:if>
                                </div>
                            </div>
                            <!-- end cart  -->
                            <span class="header_nav_line  hide-on-mobile-tablet"></span>
                            <div class="header_user  hide-on-mobile-tablet">
                                <div class="header__user-list">
                                    <span class="header__user-text-petshop">Welcome to PetShop!</span>
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
                                            <img class="header__user-img" src="upload/${sessionScope.account.imageA}" alt="">
                                            <span class="header__user-name">Xin chào ${sessionScope.account.username}</span>    
                                            <ul class="header__user-item-users-menu">
                                                <li class="header__user-item-users-item">
                                                    <a href="order">Đơn hàng của tôi</a>
                                                </li>
                                                <c:if test="${sessionScope.account.isAdmin == 1}">
                                                <li class="header__user-item-users-item">
                                                    <a href="admin">Quản lý bán hàng</a>
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
        <script type="text/javascript">
	        //search
	        function searchName(param){
			    var txtSearch =param.value;
			    $.ajax({
			        url: "/petshop/search-name",
			        type: "get",
			        data: {
			            search: txtSearch
			        },
			        success: function (data) {
			            var row = document.getElementById("content-search");
			            row.innerHTML = data;
			            
			            var searchHistory = document.querySelectorAll('#content-search li');
			            searchHistory.forEach((item) => {
			            	var aTag = item.querySelector('a');
			                var text = aTag.innerText.trim();
			                console.log(text)
			                aTag.href = "search?search="+text;
			                aTag.addEventListener('click', (event) => {
			                    // Ngăn chặn sự kiện lan truyền đến thẻ div cha
			                    event.stopPropagation();
			                   
			                    // Thực hiện hành động của thẻ a
			                    window.location.href = aTag.href;
			                  });
			                
			           }); 
			            
			        },
			        error: function(xhr){
			            
			        }
			    })
			}
	        const input = document.querySelector('input.header__search-input');
	        const div = document.querySelector('div.header__search-history');

	        // Hiển thị div khi người dùng nhập vào input
	        input.addEventListener('focus', () => {
	          div.style.display = 'block';
	        });

	        // Ẩn div khi người dùng click ra ngoài thẻ input và thẻ div
	        document.addEventListener('click', (event) => {
	          if (!input.contains(event.target) && !div.contains(event.target)) {
	            div.style.display = 'none';
	          }
	        });
		</script>
        
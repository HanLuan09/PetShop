<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>PetShop</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/manager_product.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="./css/order.css">
        <style>
            img{
                width: 200px;
                height: 120px;
            }
            a {
            	text-decoration: none;
            	color: #fff;
            	cursor: pointer;
            }
            a:hover {
				text-decoration: none;
				color: #FF0000;
			}
            .page-item {
            	display: inline;
            }
            .YqIqug {
            	position: fixed;
			    left: 0;
			    right: 0;
			    top: 0;
            }
            .card-fs-content-button {
			    font-weight: 500;
			    font-size: 14px;
			    float: right;
			    display: block;
			    border: 1px solid #f57224;
			    border-radius: 1px;
			    color: #f57224;
			    height: 40px;
			    text-transform: uppercase;
			    background-color: transparent;
			    line-height: 40px;
			    text-align: center;
			    padding-left: 10px;
			    padding-right: 10px;
			    
			}
            
        </style>
    <body>
   
    <div class="main">
    	<div class="YqIqug">
            <div class="contai">
                <div class="col-sm-4 jb8bh0">
                    <a href="/petshop/admin" class="lJqn"> <spam class="logo">PetShop</spam> 
                        <span class="eSRYBr">Sản phẩm</span>
                    </a>
                </div>
                <div class="col-sm-6" style="width: 65%">
					<form action="manager" method="get">
                            <div class="header__search">    
                                <div class="header__search-input__wrap">
                                    <div class="header__search-box">
                                        <span class="header__search-icon"></span>
                                        <div class="header__search-content">
                                            <input oninput="searchName(this)" name="search" type="search" value="${hsearch}" class="header__search-input" placeholder="Tìm kiếm tại đây"> 
                                            <!-- search lịch sử tìm kiếm
                                            <div class="header__search-history">
                                                <h3 class="header__search-history-heading">Lịch sử tìm kiếm</h3>
                                                <ul class="header__search-history-list">
                                                    <li class="header__search-history-item"><a href="">luan</a></li>
                                                    <li class="header__search-history-item"><a href="">hán</a></li>
                                                </ul>
                                            </div>-->
                                        </div>
                                        <button class="header__search-button" type="submit" style="border: 0">Tìm kiếm</button>
                                        
                                    </div>
                                </div>
                            </div>
					</form>
				</div>
            </div>
            <div class="col-sm-3 jb8bh0">
                <a href="edit?pid=-1" class="card-fs-content-button" style="font-size: 1.1rem">Thêm sản phẩm</a>
                <!--  <a href="/petshop/manager?pro=1" class="card-fs-content2-button" style="margin-left: 10px; font-size: 1.1rem">Sản phẩm đã xóa</a> -->
            </div>
            
        </div>
        <div style="margin-top: 10.2rem;">
        <div class="container">
        	<div class="vtrWey"></div>
            <div class="table-wrapper" style="margin: 0">
               <div class="row mt-4">            
               		<c:if test="${not empty succesMess}">
                	<div id="myAlert" class="col-12 alert alert-success alert-dismissible" role="alert">
                		<span>${succesMess}</span>
                		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
                			<span aria-hidden="true">&times;</span>
                		</button>
                	</div>
                	</c:if>                	
                </div>
                <script type="text/javascript">
	                window.onbeforeunload = function() {
	                    // Kiểm tra xem người dùng có nhấn nút trở về hay không
	                    if (performance && performance.navigation.type === 2) {
	                    	const div = document.querySelector('#myAlert');
					        if (div !== 'undefined') {
					            div.style.display = "none";
					        }
	                    }
	                };
	                $(document).ready(function() {
	                    // Mờ dần đối tượng
	                    $("#myAlert").fadeTo(2000, 500).slideUp(500, function(){
	                        $("#myAlert").slideUp(500);
	                    });
	                });
                </script>
                
                <table id="table-sp" class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Mã</th>
                            <th style="width: 330px">Tên sản phẩm</th>
                            <th>Danh mục</th>
                            <th>Số lượng</th>
                            <th>Giá</th>
                            <th>Giảm giá</th>
                            <th>Đã bán</th>
                            <th>Trạng thái</th>
                        </tr>
                    </thead>
                    <tbody id="content-tbody">
                        <c:forEach items="${listAminP}" var="o">
                            <tr>                             
                                <td>PET${o.idP}</td>
                                <td>${o.nameP}</td>
                                <td>${o.cate}</td>
                                <td>${o.amount}</td>
                                <td>${o.price} đ</td>
                                <td>${o.discount}%</td>
                                <td>${o.sumPrice}</td>
                                <td>                              	
                                    <a href="edit?pid=${o.idP}"  class="btn blue-gradient" data-toggle="modal">Xem</a>
                                    <a href="#deleteEmployeeModal" class="delete btn btn-dark" data-toggle="modal" data-p-id="${o.idP}">Xóa</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
          
                    <ul id ="paging" class="pagination" style="display: flex;">
                    	<li class="page-item page-item--left"><a href="#"><i class="fa-solid fa-chevron-left"></i></a></li>
                    	<div class="pagination" style ="display: flex; max-width: 270px; overflow: hidden; padding: 0 5px;">
                    		<li class="page-item pading-item--number active" id="page-item--1"><a class="page-link">1</a></li>
	                    	<c:forEach begin ="2" end = "${count}" var = "o">
	                        	<li class="page-item pading-item--number"><a class="page-link">${o}</a></li>
	                        </c:forEach>
                        </div>
                        <li class="page-item page-item--right"><a href="#" class="page-link"><i class="fa-solid fa-chevron-right"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <script src="./javascript/manager.js" type="text/javascript"></script>
        <!-- Delete Modal HTML -->
        <div id="deleteEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="delete" method="post">
                    	<input type="text" name="productId" value="${productId}"> 	
                        <div class="modal-header">						
                            <h4 class="modal-title">Xóa Sản Phẩm</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <p>Bạn có chắc chắn muốn xóa sản phẩm này không?</p>
                            <p class="text-warning"><small>Không thể hoàn tác hành động này!</small></p>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Hủy">
                            <input type="submit" class="btn btn-danger" value="Xóa">
                        </div>
                    </form>
                  
                    <script> 						 
						 $(document).on("click", ".delete", function () {
						     var pId = $(this).data('p-id');
						     
					         $("input[name='productId']").val(pId);
						 });
					</script>
                </div>
            </div>
        </div>
        
        </div>
    </div> 
    </body>
</html>
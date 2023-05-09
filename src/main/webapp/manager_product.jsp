<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>PetShop</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/manager_product.css" rel="stylesheet" type="text/css"/>
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
            
        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-2">
                            <h2><a href=""><b>PetShop</b></a></h2>
                        </div>
                        <div class="col-sm-6">
                        	<form action="manager-search" method="post">
                            <div class="header__search">    
                                <div class="header__search-input__wrap">
                                    <div class="header__search-box">
                                        <span class="header__search-icon"></span>
                                        <div class="header__search-content">
                                            <input name="search" type="search" value="${hsearch}" class="header__search-input" placeholder="Tìm kiếm tại đây"> 
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
                        <div class="col-sm-4">
                            <a href="edit?pid=-1" class="btn btn-success" style="background: linear-gradient(90deg,#1a9545,#ea7221);"><i class="material-icons">&#xE147;</i> <span>Thêm sản phẩm</span></a>
                            <a href="#deleteEmployeeModal" class="btn btn-danger" style="background: linear-gradient(90deg,#b92f22,#d96506);" data-toggle="modal" ><i class="material-icons">&#xE15C;</i> <span>Xóa sản phẩm</span></a>		
                            <!--<c:if test="${sessionScope.account == null}">				
                            	<a href="/petshop/login_register.jsp" class="btn btn-danger" id="btn-login" style="background: linear-gradient(90deg,#183545,#1a9cb7);" data-toggle="modal"><span>Đăng Nhập</span></a>                          				
                        	</c:if>
                        	<c:if test="${sessionScope.account != null}">				
                            	<a href="" class="btn btn-danger" id="btn-login" style="background: linear-gradient(90deg,#183545,#1a9cb7);" data-toggle="modal"><span>Đăng Xuất</span></a>                          				
                        	</c:if> -->
                        </div>
                    </div>
                </div>
                
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>
                                
                            </th>
                            <th>Mã</th>
                            <th style="width: 330px">Tên</th>
                            <th>Danh mục</th>
                            <th>Số lượng</th>
                            <th>Giá</th>
                            <th>Đã bán</th>
                            <th>Trạng thái</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listAminP}" var="o">
                            <tr>
                                <td>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                        <label for="checkbox1"></label>
                                    </span>
                                </td>
                                <td>${o.idP}</td>
                                <td>${o.nameP}</td>
                                <td>${o.cate}</td>
                                <td>${o.amount}</td>
                                <td>${o.price} đ</td>
                                <td>${o.sumPrice}</td>
                                <td>
                                    <a href="edit?pid=${o.idP}"  class="edit" data-toggle="modal"><i class="material-icons" title="Sửa">&#xE254;</i></a>
                                    <a href="#deleteEmployeeModal" class="delete" data-toggle="modal" data-p-id="${o.idP}"><i class="material-icons" data-toggle="tooltip" title="Xóa">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
          
                    <ul class="pagination" style="display: flex;">
                    	<li class="page-item disabled"><a href="#"><i class="fa-solid fa-chevron-left"></i></a></li>
                    	<div class="pagination" style ="display: flex; width: 270px; overflow: hidden; padding: 0 5px;">
	                    	<c:forEach begin ="1" end = "${count}" var = "o">
	                        	<li class="page-item active"><a href="#" class="page-link">${o}</a></li>
	                        </c:forEach>
                        </div>
                        <li class="page-item"><a href="#" class="page-link"><i class="fa-solid fa-chevron-right"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
        
        <!-- Edit Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="add" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Name</label>
                                <input name="name" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input name="image" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input name="price" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Title</label>
                                <textarea name="title" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <textarea name="description" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select name="category" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${listC}" var="o">
                                        <option value="${o.id}">${o.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="editEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Employee</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Address</label>
                                <textarea class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Phone</label>
                                <input type="text" class="form-control" required>
                            </div>					
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-info" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Delete Modal HTML -->
        <div id="deleteEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="delete" method="post">
                    	<input type="hidden" name="productId" value="${productId}"> 	
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
        <script src="javascrip/manager.js" type="text/javascript"></script>
        
    </body>
</html>
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
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/gird.css">
    <link rel="stylesheet" href="./css/order.css">
    <link rel="stylesheet" href="./css/manager_detail.css">
    <style>
        b{
        	font-size: 24px;
        	font-weight: 700;
        }
        .header_text {
        	padding-left: 30px;
		    text-decoration: none;
		    color: #fff;
		    cursor: pointer;
		}
        .footer_button {
        	float: right;
        	margin: 0 40px;
        	margin-bottom: 20px;
        }
        .auth-form__group.invalid .form-control {
		    border-color: #f33a58;
		}
		
		.auth-form__group.invalid .form-message {
			display: block;
		    color: #f33a58;
		}
    </style>
   
</head>
<body>
	
	<form id="form" action="${idProduct>0 ? "save" : "add"}" method="post" enctype="multipart/form-data">
	<input type="hidden" name="idP" id ="idBook" value = "${idProduct}">
    <div class="main">
    	<div class="YqIqug">
            <div class="contai">
                <div class="jb8bh0">
                    <a href="/petshop/manager" class="lJqn"> <spam class="logo">PetShop</spam> 
                        <span class="eSRYBr">Thêm sản phẩm</span>
                    </a>
                </div>
            </div>
        </div>
       <div class="container">
            <div class="grid wide"> 
                <div class="row container-wrap" style="width: 95%; margin: 15px auto;">
                	<div class="vtrWey"></div>
                    <div class="col l-6 content">
                        <div class="flex container-list">
                            <div class="auth-form__group">
                                <label class="container-label" for="">Tên sản phẩm</label>
                                <input name="nameP" id="nameP" class="container-text-top form-control" type="text" placeholder="Nhập tên sản phẩm" value="${productId.nameP}">
                                <span class="form-message"></span>
                                <span> ${errorMess}</span>
                            </div>
                        </div>
                        <div class="flex container-list">
                            <div class="auth-form__group">
                                <label class="container-label" for="">Nguồn gốc xuất xứ</label>
                                <input name="origin" id="origin" class="container-text-top form-control" type="text" placeholder="Nhập nguồn gốc xuất xứ" value="${productId.origin}">
                                <span class="form-message"></span>
                            </div>
                        </div>
                        <div class="auth-form__group">
                            <label class="container-label" for="" style="margin-left: 20px;">Mô tả sản phẩm</label>
                            <div class="container-description form-control">
                                <textarea name="describe" id="describe" class="fixed-size" placeholder="Nhập mô tả" value = "${productId.describe}">${productId.describe}</textarea>
                            </div>
                            <span style="margin-left: 19px" class="form-message"></span>
                        </div>
                        <div class="flex container-list">
                            <div class="auth-form__group">
                                <label class="container-label" for="">Giá</label>
                                <input name="price" id="price" class="container-text form-control" type="text" value="${productId.price}">
                                <span class="form-message"></span>
                            </div>
                            <div class="auth-form__group">
                                <label class="container-label" for="">Giảm giá</label>
                                <input id="discount" name="discount" class="container-text form-control" type="text" value="${productId.discount}">
                                <span class="form-message"></span>
                            </div>  
                        </div>
                        
                        <div class="flex container-list">
                            <div class="auth-form__group">
                                <label class="container-label" for="">Số lượng</label>
                                <input id ="amount" name="amount" class="container-text form-control" type="text" value="${productId.amount}">
                                <span class="form-message"></span>
                            </div>  
                            <div>
                                <label class="container-label" for="">Danh mục</label>
                                <select class="container-text" name="cateid" id="">
                                	<c:forEach items="${listCate}" var="o">
                                    	<option value="${o.cid}">${o.cname}</option>
                                	</c:forEach>
                                </select>
                            </div>
                            
                        </div>
                    </div>
                    <div class="col l-6" >
                        <div class="container-list">
                            <div class="auth-form__group" style="display: flex; justify-content: center;">
                                <label for="file-input" class="custom-file-upload">
                                    Chọn ảnh
                                  </label>
                                  <div style="position: relative;">
	                                  <input name="image" type="file" id="file-input" accept=".jpg,.jpeg,.png" style="display:none;" value="${productId.imageP}">
	                                  <input type="hidden" id="input-file" value="${productId.imageP}">
	                                  <span class="form-message" style="position: absolute; top: 30px; left: -9rem; width: 200px;"></span>
                                  </div>
                            </div>
                            <span style="display: flex; justify-content: center; margin-top: 5px; color: #EE4D20;" class ="form-message--file"></span>
                            <div class="container-img">
                                <img id="preview-image" src="upload/${productId.imageP}" alt="" style=" max-width: 100%; max-height: 100%; background-size: contain; background-repeat: no-repeat;">
                            </div>
                        </div>
                        <script>
                            const fileInput = document.getElementById("file-input");
                            const previewImage = document.getElementById("preview-image");
                      
                            fileInput.addEventListener("change", () => {
                              const file = fileInput.files[0];
                              const reader = new FileReader();
                      
                              reader.addEventListener("load", () => {
                                previewImage.src = reader.result;
                                document.getElementById("input-file").value = "input-file";
                                previewImage.style.display = "block";
                              });
                      
                              reader.readAsDataURL(file);
                            });
                          </script>
                    </div>
                </div>
            </div>
       </div>
       <footer class="footer">
            <div class="footer_button" style="display: flex;">
            	<button class="btn" type="button" onclick="location.href='/petshop/manager';" style="margin-right: 10px">Trở về</button>
            	<button class="btn btn--primary1" id="btn_add" type="submit">Add</button>
            	<button class="btn btn--primary" id="btn_save" type="submit">Save</button>
            	<button class="btn btn--primary2" id="btn_edit">Edit</button>
            </div>
            <script type="text/javascript">
            
            	const idCheck = document.getElementById("idBook");
            	const add = document.getElementById("btn_add");
            	const save = document.getElementById("btn_save");
            	const edit = document.getElementById("btn_edit");
            	if(idCheck.value<=0){
            		add.style.display ="block";
            		save.style.display ="none";
            		edit.style.display ="none";
            	}
            	else{
            		add.style.display ="none";
            		save.style.display ="none";
            		edit.style.display ="block";
            		var inputs = document.querySelectorAll('input, textarea,.custom-file-upload, select');
						
            		// Lặp qua danh sách các phần tử input và textarea và thêm/xoá thuộc tính readonly và disabled
            		//document.querySelector('.custom-file-upload').style.cu
            		inputs.forEach(function(input) {
            		  
            		    input.setAttribute('readonly', 'readonly');
            		    input.setAttribute('disabled', 'disabled');
            		  
            		});

            		edit.addEventListener('click', function(e){
            			e.preventDefault();
            			save.style.display='block';
            			edit.style.display ="none";
            			inputs.forEach(function(input) {
                  		  if (input.hasAttribute('readonly') || input.hasAttribute('disabled')) {
                  		    input.removeAttribute('readonly');
                  		    input.removeAttribute('disabled');
                  		  } else {
                  		    input.setAttribute('readonly', 'readonly');
                  		    input.setAttribute('disabled', 'disabled');
                  		  }
                  		});
            		});
            	}
            	
                
            </script>
        </footer>
    </div>
	</form>
	<script src="./javascript/main.js"></script>
	<script src="./javascript/validate.js"></script>
	<script>
        // mong muốn 
        //pc
        // regster
        Validator({
            form: "#form",
            formGroupSelector: ".auth-form__group",
            errorSelector: ".form-message",
            rules: [
                Validator.isRequired('#describe'),
                Validator.isRequired('#nameP'),
                Validator.isRequired('#origin'),
                Validator.isRequired('#discount'),
                Validator.isNumber("#price", 0),
                Validator.isNumber("#amount", 0),
                Validator.isImage('#input-file'),
                //Validator.isRequired('#file-input'),
                //Validator.minLength('#password', 6),
                
            ]
            
        });
      	
        productSalary({
        	quainput: "#price", 
        	quantity: "0",
        	quamax: "100000000"
        });
        productSalary({
        	quainput: "#discount", 
        	quantity: "0",
        	quamax: "100"
        });
        productSalary({
        	quainput: "#amount", 
        	quantity: "0",
        	quamax: "1000000"
        });
        
    </script>
</body>
</html>
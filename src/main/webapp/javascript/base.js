
// giảm giá 
// Lấy danh sách tất cả các phần tử có class 'home-product-item__sale'
var sales = document.querySelectorAll('.home-product-item__sale');
// Duyệt qua từng phần tử và kiểm tra giảm giá
for (var i = 0; i < sales.length; i++) {
  var percent = parseFloat(sales[i].querySelector('.home-product-item__sale-percent').textContent);
  if (percent <= 0) {
    // Nếu giảm giá bằng 0 thì xóa phần tử
    sales[i].parentNode.removeChild(sales[i]);
  }
}

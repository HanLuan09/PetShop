
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
// màu sắc trong đánh giá:
// Giá trị trung bình của đánh giá
var productItems = document.querySelectorAll('.home-product-list--rating');
productItems.forEach(function(item) {
	var ratingValue = parseFloat(item.querySelector('.product-rating-value').textContent);
	var ratingWidth = ratingValue * 20; // Chuyển đổi từ điểm đánh giá (0-5) sang phần trăm (0-100)
	var cardRatingLayer = item.querySelector('.top-layer');
	cardRatingLayer.style.width = ratingWidth + '%';
});
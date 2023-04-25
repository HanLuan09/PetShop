//udate giá trong detail
/*
var sizes = document.querySelectorAll('.container__header-btn-1');
var ratioSize = document.querySelectorAll('.container__header-size');
const p = document.getElementById("price-old");
const pN = document.getElementById("price-new");
const priceSizeO = p.innerHTML;
const priceSizeN = pN.innerHTML;
function switchSize(index) {
	var tmp = ratioSize[index].innerHTML;
	//var price = p.innerHTML;
	//var priceNew = pN.innerHTML;
	p.innerHTML = priceSizeO * tmp;
	pN.innerHTML = priceSizeN * tmp;
}

// add event listener to each tab
sizes.forEach((tab, index) => {
	tab.addEventListener('click', () => {
		switchSize(index);
	});
});
*/
// tăng số lượng sản phẩm
function productNumber(options){
	//const minusBtn = document.querySelector('#container__left');
	//const plusBtn = document.querySelector('#container__right');
	//const quantityInput = document.querySelector('.container__right-purchase-input-text');
	const minusBtn = document.querySelector(options.minus);
	const plusBtn = document.querySelector(options.plus);
	const quantityInput = document.querySelector(options.quantity);
	function decreaseQuantity() {
	 	let quantity = parseInt(quantityInput.value);
	 	if (quantity > 1) {
	    	quantity--;
	  	}
	  	quantityInput.value = quantity;
	}
	
	function increaseQuantity() {
	  	let quantity = parseInt(quantityInput.value);
	  	quantity++;
	  	quantityInput.value = quantity;
	}
	minusBtn.addEventListener('click', () => {
	  	decreaseQuantity();
	});
	plusBtn.addEventListener('click', () => {
	  	increaseQuantity();
	});
	        
}

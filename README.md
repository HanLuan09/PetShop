# PetShop
Dự án full stack "Cửa hàng thú cưng" sử dụng java servlet-jdbc.

## Mô tả hệ thống
Website cho phép người dùng tìm kiếm và mua bán những sản phẩm liên
quan đến thú cưng.
Website có chức năng Đăng ký/ Đăng nhập. Thông tin tài khoản của người dùng
mà website lưu trữ sẽ bao gồm ít nhất: tên, mật khẩu.
• Nếu admin đăng nhập với tài khoản admin thì có thực hiện được những
chức năng của admin để quản sản phẩm.
• Người dùng phải đăng ký tài khoản mới có thể đăng nhập và sử dụng tài
khoản của họ để thực hiện những việc như: mua bán và đưa ra nhận xét
đánh giá về sản phẩm.
###### 1. Chức năng quản lý (Admin)
Đầu tiên sẽ có 1 trang hiện danh sách các đơn đặt hàng đang chờ được duyệt, và
có một nút button để admin chuyển sang trang quản lý. Mỗi đơn đặt hàng sẽ có 1
button để admin chuyển sang trang chi tiết đơn hàng. Ở đây admin sẽ có thể duyệt
đơn hàng cho khách hàng.
Chức năng của quản lý sẽ có 1 bảng hiển thị những sản phẩm đang có trong cơ sở
dữ liệu. Admin có thể: thêm, sửa, xóa thông tin sản phẩm. Ở trang này admin có
thể tìm kiếm và lọc sản phẩm.
Trang chi tiết thông tin sản phẩm giúp admin có thể xem chi tiết sản phẩm, thêm
sản phẩm và sửa sản phẩm.
###### 2. Chức năng của người dùng (user).
Người dùng có thể sử dụng trang web thư viện bán sách thông qua các chức năng
chính:
➢ Đầu tiên người dùng sẽ thấy 1 trang chủ có danh sách tất cả các sản phẩm
đã có trong cơ sở dữ liệu.
➢ Người dùng có thể tìm kiếm sản phẩm mình đang quan tâm.
➢ Người dùng có thể bấm vào từng sản phẩm và xem thông tin chi tiết của
sản phẩm đó, ở đây người dùng có thể đặt mua sản phẩm với số lượng cụ
10
thể. Ngoài ra, ở trang này người dùng có thể để lại nhận xét cho sản phẩm,
và đánh giá sách theo thang điểm 5 sao.
➢ Để có thể đặt mua được sản phẩm người dùng cần phải đăng nhập trước.
➢ Người dùng có thể xem danh sách những sản phẩm mình đã đặt mua, xem
thông tin từng sản phẩm mình đã đặt mua.
Khi đặt mua sách người dùng phải điền đầy đủ thông tin về tên, số điện thoại, địa
chỉ,… Và người dùng có thể chọn thanh toán khi giao hàng hoặc là qua vnpay.
Để phục vụ nhu cầu tìm kiếm của người dùng, trang web có sử dụng 1 số thuật
toán sắp xếp và tìm kiếm dựa trên từ khóa và đánh điểm tương đồng.


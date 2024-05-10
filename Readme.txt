Sau khi giải nén:
Mở xampp và import midterm.sql vào CSDL
Sau đó chạy ứng dụng
Mô hình sử dụng: Spring boot, các tác vụ được xử lý ở các Controller, sử dụng JpaRepository để tương tác với cơ sở dữ liệu.
Cấu trúc mã: Các hoạt động đăng nhập được xử lý ở LoginController, Còn liên quan đến các sản phẩm được xử lý ở HomeController với:
Các CURL:
- Đăng nhập:
http://localhost:8080/login
- Trang chủ:
http://localhost:8080/home
- Chi tiết sản phẩm:
http://localhost:8080/detailphone/{code}
- Thêm sản phẩm mới vào giỏ hàng
http://localhost:8080/cart/{code}
- Xóa sản phẩm ra giỏ hàng
http://localhost:8080/cart/delete/{code}
- Đặt các sản phẩm có trong giỏ hàng
http://localhost:8080/dathang/{code}
- Tìm kiếm các sản phẩm:
http://localhost:8080/find
- Xem các đơn hàng:
http://localhost:8080/detail

Link video demo: https://www.youtube.com/watch?v=Sk9cZ3swO1s&feature=youtu.be


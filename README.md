### week07_lab_NguyenDinhHoangAnh_20068861

### sơ đồ cơ sở dữ liệu
![img](/img/diagram.png)

### danh sách product
![img](/img/products.png)

### nhấn button "Add new product" để thêm product mới
![img](/img/insertProduct.png)
### sau khi thêm thành công
![img](/img/inserted.png)

### nhấn vào update để hiển thị giao diện cập nhật
![img](/img/update.png)

### sau khi cập nhật
![img](/img/updated.png)

### nhấn vào delete để xóa sản phẩm, sản phẩm sau khi bị xóa sẽ không bị mất trong csdl mà chỉ thay đổi trạng thái thành INACTIVE
![img](/img/delete.png)
sản phẩm có id 204 đã bị xóa có status là 2 (INACTIVE) và không được hiển thị lên giao diện

### nhấn vào detail để xem chi tiết về 1 sản phẩm
![img](/img/detail.png)

### có thể nhấn vào Insert Price để thêm giá cho sản phẩm đó
![img](/img/insertPrice.png)

### sau khi sản phẩm có giá thì sẽ hiển thị ô nhập số lượng và nút add vào giỏ hàng
![img](/img/insertedPrice.png)

### khi nhấn nút Add to cart, sản phẩm sẽ được thêm vào session với giá được tính tại thời điểm gần nhất
### nhấn nút Add to cart sẽ quay về giao diện danh sách sản phẩm, ở đây có thể nhấn Checkout để xem giỏ hàng
![img](/img/cart.png)

### Ở giỏ hàng có thể nhấn Pay cart để thực hiện thanh toán, sau khi thanh toán thì sẽ quay lại trang danh sách sản phẩm, giỏ hàng được xóa khỏi session, hóa đơn được lưu trong cơ sở dữ liệu

Giỏ hàng được xóa sau khi nhấn thanh toán
![img](/img/cartEmpty.png)

Hóa đơn được tạo và lưu vào cơ sở dữ liệu
![img](/img/orderdb.png)
![img](/img/orderDetail.png)

### Giao diện thống kê hóa đơn
![img](/img/thongke.png)
có 2 loại thống kê là thống kê theo khoảng thời gian và thống kê theo ngày,
thống kê theo khoảng thời gian: chọn to date và from date -> nhấn nút thống kê theo khoảng thời gian

ở bên dưới sẽ hiển thị danh sách các hóa đơn được lập trong khoảng thời gian đó
![img](/img/thongketime.png)

thống kê theo ngày: chọn date -> nhấn nút thống kê theo ngày

ở bên dưới sẽ hiển thị danh sách các hóa đơn được lập trong ngày hôm đó
![img](/img/thongkengay.png)

### có thể xem được danh sách nhân viên và khách hàng

danh sách khách hàng
![img](/img/cust.png)

danh sách nhân viên
![img](/img/employees.png)

ở danh sách nhân viên, có thể nhấn vào List order để xem được danh sách hóa đơn do nhân viên đó lập
![img](/img/orderEmp.png)
danh sách order của nhân viên đầu tiên
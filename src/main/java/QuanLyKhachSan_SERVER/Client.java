/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachSan_SERVER;

import java.rmi.Naming;
import java.util.List;

/**
 *
 * @author LE CANH HUNG
 */
public class Client {
    public static void main(String[] args) {
        try {
            IHotelManager manager = (IHotelManager) Naming.lookup("rmi://localhost:1111/HotelManager");
            System.out.println("Lookup successfully");
//             Thêm phong vao co so du lieu
            manager.addPhongThue(new PhongThue(101, "Trống", "", "", null, null));
            manager.addPhongThue(new PhongThue(102, "Trống", "", "", null, null));
            manager.addPhongThue(new PhongThue(201, "Trống", "", "", null, null));
            manager.addPhongThue(new PhongThue(202, "Trống", "", "", null, null));
            manager.addPhongThue(new PhongThue(301, "Trống", "", "", null, null));
            manager.addPhongThue(new PhongThue(302, "Trống", "", "", null, null));
            manager.addPhongThue(new PhongThue(401, "Trống", "", "", null, null));
            System.out.println("Add phong thue thanh cong");
            

            // Lấy thông tin một phòng
//            PhongThue phong = manager.getPhongBySoPhong(101);
//            if (phong != null) {
//                System.out.println("Thông tin phòng 101: " + phong);
//            }

            // Cập nhật trạng thái phòng
//            phong.setTrangThai("Có khách");
//            phong.setTenKhachHang("Le Van B");
//            manager.updatePhong(phong);

            // Xóa một phòng
//            manager.deletePhong(102);

            // Xem lại danh sách phòng
//            System.out.println("Danh sách phòng sau cập nhật:");
//            for (PhongThue p : manager.getAllPhongThue()) {
//                System.out.println(p);
//            }
            // test ghi va doc du lieu
            manager.write();
            manager.read();
            // Lấy danh sách phòng
            List<PhongThue> danhSachPhong = manager.getAllPhongThue();
            System.out.println("Danh sách phòng:");
            for (PhongThue phong : danhSachPhong) {
                if(phong.getTrangThai().equalsIgnoreCase("Trống")){
                    System.out.println(phong.getSoPhong());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

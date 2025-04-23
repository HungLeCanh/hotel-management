/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QuanLyKhachSan_SERVER;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author LE CANH HUNG
 */
public interface IHotelManager extends Remote{
    // Thêm phòng thuê mới
    void addPhongThue(PhongThue phong) throws RemoteException;

    // Lấy danh sách tất cả các phòng thuê
    List<PhongThue> getAllPhongThue() throws RemoteException;

    // Tìm phòng theo số phòng
    PhongThue getPhongBySoPhong(int soPhong) throws RemoteException;

    // Cập nhật trạng thái của phòng
    void updatePhong(PhongThue phong) throws RemoteException;

    // Xóa phòng khỏi danh sách
    void deletePhong(int soPhong) throws RemoteException;
    
    // Tính tiền
    long tinhTienThue(PhongThue phong) throws RemoteException;
    
    // Thống kê theo tháng
    long thongKe(int nam, int thang) throws RemoteException;
    
    // Lưu dữ liệu phòng thuê xuống file dulieu.txt
    void write() throws RemoteException;
    
    // Lấy dữ liệu từ file
    void read() throws RemoteException;
    
    // Ghi lại lịch sử thuê phòng
    void addLichSuThue(PhongThue phong) throws RemoteException;
    
    // Lấy danh sách lịch sử
    List<PhongThue> getLichSuThue() throws RemoteException;
    
    // Lưu dữ liệu lịch sử thuê phòng xuống file thongke.txt
    void writeHistory() throws RemoteException;
    
    // Lấy dữ liệu lịch sử thuê phòng
    void readHistory() throws RemoteException;
}

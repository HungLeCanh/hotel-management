/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachSan_SERVER;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author LE CANH HUNG
 */
public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1111); // Khởi tạo RMI registry trên cổng 1099
            HotelManagerServer manager = new HotelManagerServer();
            Naming.rebind("rmi://localhost:1111/HotelManager", manager); // Đăng ký tên dịch vụ
            System.out.println("Hotel Manager Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

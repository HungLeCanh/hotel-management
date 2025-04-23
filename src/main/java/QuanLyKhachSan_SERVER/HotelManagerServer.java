/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachSan_SERVER;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LE CANH HUNG
 */
public class HotelManagerServer extends UnicastRemoteObject implements IHotelManager{
    private List<PhongThue> danhSachPhong = new ArrayList<>();
    private List<PhongThue> lichSuThuePhong = new ArrayList<>();
    
    public HotelManagerServer() throws RemoteException{
        super();
        this.danhSachPhong = new ArrayList<>();
        this.lichSuThuePhong = new ArrayList<>();
    }

    public HotelManagerServer(List<PhongThue> danhSachPhong, List<PhongThue> lichSuThuePhong) throws RemoteException {
        this.danhSachPhong = danhSachPhong;
        this.lichSuThuePhong = lichSuThuePhong;
    }
    @Override
    public void addPhongThue(PhongThue phong) throws RemoteException {
        danhSachPhong.add(phong);
    }

    @Override
    public List<PhongThue> getAllPhongThue() throws RemoteException {
        return danhSachPhong;
    }
    
    @Override
    public List<PhongThue> getLichSuThue() throws RemoteException {
        return lichSuThuePhong;
    }

    @Override
    public PhongThue getPhongBySoPhong(int soPhong) throws RemoteException {
        for (PhongThue phong : danhSachPhong) {
            if (phong.getSoPhong() == soPhong) {
                return phong;
            }
        }
        return null;
    }

    @Override
    public void updatePhong(PhongThue phong) throws RemoteException {
        for (int i = 0; i < danhSachPhong.size(); i++) {
            if (danhSachPhong.get(i).getSoPhong() == phong.getSoPhong()) {
                danhSachPhong.set(i, phong);
                break;
            }
        }
    }

    @Override
    public void deletePhong(int soPhong) throws RemoteException {
        danhSachPhong.removeIf(phong -> phong.getSoPhong() == soPhong);
    }
    
    @Override
    public long tinhTienThue(PhongThue phong) {
        long soNgay = ChronoUnit.DAYS.between(phong.getThoiGianCheckIn(), phong.getThoiGianCheckOut());
            if (soNgay <= 0) {
                throw new IllegalArgumentException("Thời gian Check-Out phải sau Check-In.");
            }
            return soNgay * 400_000; // Giá mỗi ngày là 400,000 VND 
    }
    
    @Override
    public long thongKe(int nam, int thang) throws RemoteException {
    long doanhThu = 0;

    for (PhongThue phong : lichSuThuePhong) {
        LocalDate checkIn = phong.getThoiGianCheckIn();
        LocalDate checkOut = phong.getThoiGianCheckOut();

        if (checkIn != null && checkOut != null) {
            if (checkIn.getYear() == nam && checkIn.getMonthValue() == thang) {
                long soNgayThue = ChronoUnit.DAYS.between(checkIn, checkOut);
                doanhThu += soNgayThue * 400_000;
            }
        }
    }

    return doanhThu;
}
    
    // Luu danh sach phong 
    @Override
    public void write(){
        try {
            FileOutputStream fos = new FileOutputStream("dulieu.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(danhSachPhong);
            System.out.println("GHI THANH CONG");
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("LOI GHI FILE");
        }
    }
    
    // Lay  du lieu danh sach phong
    @Override
    public void read(){
        try {
            FileInputStream fis = new FileInputStream("dulieu.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.danhSachPhong = (ArrayList<PhongThue>)ois.readObject();
            System.out.println("DOC VA LAY DU LIEU FILE THANH CONG");
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("LOI DOC FILE");
        }
    }
    
    // Ghi lại lịch sử thuê phòng
    @Override
    public void addLichSuThue(PhongThue phong) throws RemoteException {
        lichSuThuePhong.add(phong);
    }
    
    // Lưu dữ lịch sử thuê phòng
    @Override
    public void writeHistory(){
        try {
            FileOutputStream fos = new FileOutputStream("lichsuthuephong.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lichSuThuePhong);
            System.out.println("GHI THANH CONG");
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("LOI GHI FILE");
        }
    }
    
    // Lay  du lieu lich su thue phong
    @Override
    public void readHistory(){
        try {
            FileInputStream fis = new FileInputStream("lichsuthuephong.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.lichSuThuePhong = (ArrayList<PhongThue>)ois.readObject();
            System.out.println("DOC VA LAY DU LIEU FILE THANH CONG");
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("LOI DOC FILE");
        }
    }
}

package quanly;

import java.util.ArrayList;

import quanlifile.QuanLyFile;

public class QuanLyKho {
    private ArrayList<Kho> dsKho;
    private QuanLyFile quanLyFile;
    public QuanLyKho() {
        dsKho = new ArrayList<Kho>();
        quanLyFile =  new QuanLyFile();
    }

    public void themKho(Kho kho) {
        dsKho.add(kho);
    }

    //nhan vien nhap kho
    public void nhapKho() {
        Kho kho = new Kho();
        kho.themKho();
        dsKho.add(kho);
    }
    // hien thi danh sach kho
    public void hienThiDanhSachKho() {
        String format = "%-15s %-15s %-15s %-20s";
        String tieuDe = String.format(format, "Mã kho", "Tên khu vực", "Ghi chú", "Nhân viên quản lý");
        System.out.println(tieuDe);
        for (Kho kho : dsKho) {
            System.out.println(kho);
        }
    }
    // hien thi chi tiet tung kho
    public void hienThiChiTietKho(String maKho, QuanLySanPham qlsp) {
        for (Kho kho : dsKho) {
            if (kho.getMaKho().equals(maKho)) {
                kho.khoiTaokho(qlsp);
                kho.thongTinChiTietKho();
            }
        }
    }
    public void ghiFile(){
        quanLyFile.outputKho(dsKho);
    }
    public void docFile(){
        quanLyFile.inputKho(dsKho);
    }

    public void capNhatKho(String maKho){
        for (Kho kho : dsKho) {
            if (kho.getMaKho().equals(maKho)) {
                kho.themKho();
                break;
            }
        }
        System.out.println("không tìm thấy mã kho cần cập nhật!");
    }


}

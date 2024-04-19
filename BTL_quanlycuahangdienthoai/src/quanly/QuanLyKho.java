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

    //kiem tra maKho da ton tai chua
    public boolean kiemTraMaKho(String maKho) {
        for (Kho kho : dsKho) {
            if (kho.getMaKho().equals(maKho)) {
                return true;
            }
        }
        return false;
    }
    //nhan vien nhap kho
    public void nhapKho(QuanLyNhanVien qlnv) {
        Kho kho = new Kho();
        kho.themKho(qlnv);
        if (!kiemTraMaKho(kho.getMaKho())) {
            dsKho.add(kho);
            System.out.println("Thêm kho thành công!");
        } else {
            System.out.println("Mã kho đã tồn tại!");
        }
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

    public void capNhatKho(QuanLyNhanVien qlnv, String maKho){
        for (Kho kho : dsKho) {
            if (kho.getMaKho().equals(maKho)) {
                kho.themKho(qlnv);
                System.out.println("Cập nhật thành công!");
                break;
            }
            else{
                System.out.println("Không tìm thấy mã kho cần cập nhật!");
                break;
            }
        }
    }

}

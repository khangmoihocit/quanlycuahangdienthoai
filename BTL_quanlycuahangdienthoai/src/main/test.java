package main;

import quanly.Kho;
import quanly.NhanVien;
import quanly.QuanLyKho;
import quanly.QuanLyNhanVien;

public class test {
    public static void main(String[] args) {
        QuanLyNhanVien qlnv = new QuanLyNhanVien();
        qlnv.docFileNhanVien();
       
        QuanLyKho qlk = new QuanLyKho();
        NhanVien nv1 = qlnv.getDsNhanVien().get(0);
        NhanVien nv2 = qlnv.getDsNhanVien().get(1);
        Kho kho1 = new Kho("001", "khu vuc A", "realme", nv1);
        Kho kho2 = new Kho("002", "khu vuc B", "samsung", nv2);
        // qlk.themKho(kho1);
        // qlk.themKho(kho2);
        // qlk.ghiFile();
        qlk.docFile(qlnv);
        qlk.hienThiDanhSachKho();
        // System.out.println(kho1.getNhanVien());

    }
}

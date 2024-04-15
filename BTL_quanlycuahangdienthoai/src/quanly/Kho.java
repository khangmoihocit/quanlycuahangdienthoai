package quanly;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Kho {
    private String maKho, tenKhuVuc, ghiChu;
    private String tenNV;
    // private ArrayList<SanPham> dsSanPham;
    private Set<SanPham> dsSanPham;
    public Kho(String maKho, String tenKhuVuc, String ghiChu, String tenNV) {
        this.maKho = maKho;
        this.tenKhuVuc = tenKhuVuc;
        this.ghiChu = ghiChu;
        this.tenNV = tenNV;
        // dsSanPham = new ArrayList<SanPham>();
        dsSanPham = new LinkedHashSet<SanPham>();
    }
    public Kho() {
        // dsSanPham = new ArrayList<SanPham>();
        dsSanPham = new LinkedHashSet<SanPham>();
    }
    //nhan vien tao them kho
    public void themKho(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã kho: ");
        setMaKho(sc.nextLine());
        System.out.print("Nhập tên khu vực: ");
        setTenKhuVuc(sc.nextLine());
        System.out.print("Nhập ghi chú: ");
        setGhiChu(sc.nextLine());
        System.out.print("Nhập nhân viên quản lý: ");
        setTenNV(sc.nextLine());
    }
    //khoi tao kho
    public void khoiTaokho(QuanLySanPham qlsp) {
        for (SanPham sanPham : qlsp.getDsSanPham()){
            if (sanPham.getThuongHieu().equalsIgnoreCase(ghiChu)){
                dsSanPham.add(sanPham);
            }
        }
    }
    //thong tin chi tiet kho
    public void thongTinChiTietKho() {
        System.out.println("Mã kho: " + maKho);
        System.out.println("Tên khu vực: " + tenKhuVuc);
        System.out.println("Ghi chú: " + ghiChu);
        System.out.println("Nhân viên quản lý: " + getTenNV());
        System.out.println("Danh sách sản phẩm: ");
        String format = "%-5s %-25s %-5s %-15s %-15s %-15s %-28s %-10s %-15s %-15s";
		String tieuDe = String.format(format, "Mã SP", "Tên SP", "SL", "thương hiệu", "hệ điều hành", 
		"kích thước màn", "chip xử lý", "pin", "Xuất xứ", "giá(VND)");
		System.out.println(tieuDe);
        for (SanPham sanPham : dsSanPham){
            System.out.println(sanPham);
        }
    }
    

    @Override
    public String toString() {
        String fomat = "%-15s %-15s %-15s %-20s";
        return String.format(fomat, maKho, tenKhuVuc, ghiChu, getTenNV());
    }

    public String getMaKho() {
        return maKho;
    }
    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }
    public String getTenKhuVuc() {
        return tenKhuVuc;
    }
    public void setTenKhuVuc(String tenKhuVuc) {
        this.tenKhuVuc = tenKhuVuc;
    }
    public String getGhiChu() {
        return ghiChu;
    }
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    public String getTenNV() {
        return tenNV;
    }
    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    public Set<SanPham> getDsSanPham() {
        return dsSanPham;
    }
    public void setDsSanPham(Set<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }
}

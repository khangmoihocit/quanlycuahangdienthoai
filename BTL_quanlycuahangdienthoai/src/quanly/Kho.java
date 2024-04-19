package quanly;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Kho {
    private String maKho, tenKhuVuc, ghiChu;
    private NhanVien nhanVien;
    private Set<SanPham> dsSanPham; //sử dụng set để tránh lưu trùng sản phẩm có trong danh sách
    public Kho(String maKho, String tenKhuVuc, String ghiChu, String tenNV) {
        this.maKho = maKho;
        this.tenKhuVuc = tenKhuVuc;
        this.ghiChu = ghiChu;
        dsSanPham = new LinkedHashSet<SanPham>();
        this.nhanVien.setTen(tenNV);
    }
    public Kho() {
        // dsSanPham = new ArrayList<SanPham>();
        dsSanPham = new LinkedHashSet<SanPham>();
    }
    //nhan vien tao them kho
    public void themKho(QuanLyNhanVien qlnv){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã kho: ");
        setMaKho(sc.nextLine());
        System.out.print("Nhập tên khu vực: ");
        setTenKhuVuc(sc.nextLine());
        System.out.print("Nhập ghi chú: ");
        setGhiChu(sc.nextLine());
        int n = 0;
        while(true) {
            n++;
            System.out.print("Nhập nhân viên quản lý: ");
            String tenNV = sc.nextLine();
            NhanVien nv = qlnv.timNhanVien(tenNV);
            if (nv != null) {
                setNhanVien(nv);
                break;
            }
            else if(n == 3){
                System.out.println("Nhập sai quá 3 lần! Hủy thêm kho!");
            }
            else {
                System.err.println("Nhân viên không tồn tại! Vui lòng nhập lại.");
            }
        }
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
        System.out.println("            THÔNG TIN KHO");
        System.out.println("Mã kho: " + maKho);
        System.out.println("Tên khu vực: " + tenKhuVuc);
        System.out.println("Ghi chú: " + ghiChu);
        System.out.println("Nhân viên quản lý: " + nhanVien.getTen());
        System.out.println("Danh sách sản phẩm: ");
        String format = "%-5s %-20s %-5s %-15s %-15s %-15s %-28s %-10s %-15s %-15s";
		String tieuDe = String.format(format, "Mã SP", "Tên SP", "SL", "thương hiệu", "hệ điều hành", 
		"kích thước màn", "chip xử lý", "pin", "Xuất xứ", "giá(VND)");
        if (dsSanPham.isEmpty()){
            System.out.println("Không có sản phẩm nào trong kho!");
        }
        else {
		    System.out.println(tieuDe);
            for (SanPham sanPham : dsSanPham){
                System.out.println(sanPham);
            }
        }
    }

    @Override
    public String toString() {
        String fomat = "%-15s %-15s %-15s %-20s";
        return String.format(fomat, maKho, tenKhuVuc, ghiChu, nhanVien.getTen());
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
    public Set<SanPham> getDsSanPham() {
        return dsSanPham;
    }
    public void setDsSanPham(Set<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }
    public NhanVien getNhanVien() {
        return nhanVien;
    }
    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

}

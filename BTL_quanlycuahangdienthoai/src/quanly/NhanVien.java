package quanly;

import java.util.Scanner;

public class NhanVien extends ConNguoi {
	private double luong;

	public NhanVien(String id, String ten, String tuoi, String diaChi, double luong) {
		super(id, ten, tuoi, diaChi);
		this.luong = luong;
	}
	public NhanVien() {
		super();
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập id nhân viên: ");
		setId(sc.nextLine());
		System.out.println("Nhập họ tên nhân viên: ");
		setTen(sc.nextLine());
		System.out.println("Nhập tuổi nhân viên: ");
		setTuoi(sc.nextLine());
		System.out.println("Nhập địa chỉ nhân viên: ");
		setDiaChi(sc.nextLine());
		System.out.println("Nhập lương nhân viên: ");
		setLuong(sc.nextDouble());
	}
	@Override
	public String toString() {
		String fomatString = "%-15s";
		return super.toString() + String.format(fomatString, luong);
	}
}

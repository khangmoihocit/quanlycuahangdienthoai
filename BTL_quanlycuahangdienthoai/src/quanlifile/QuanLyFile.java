package quanlifile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import quanly.KhachHang;
import quanly.Kho;
import quanly.NhanVien;
import quanly.QuanLyNhanVien;
import quanly.SanPham;

public class QuanLyFile {
	private File fileKH;
	private File fileNV;
	private File fileSP;
	private File fileHD;
	private File fileKho;

	public QuanLyFile() {
		this.fileKH = new File("thongtinkhachhang.txt");
		this.fileNV = new File("thongtinnhanvien.txt");
		this.fileSP = new File("thongtinsanpham.txt");
		this.fileHD = new File("thongtinhoadon.txt");
		this.fileKho = new File("quanlykho.txt");
	}
	// khách hàng
	public void inputKH(ArrayList<KhachHang> arr) {
		try {
			Scanner sc = new Scanner(fileKH);
			while(sc.hasNext()) {
				KhachHang x = new KhachHang(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
				arr.add(x);
			}
			sc.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	public void outputKH(ArrayList<KhachHang> arr) {
		try {
			FileWriter writer = new FileWriter(fileKH);
			for (int i=0; i<arr.size(); ++i) {
				writer.write(arr.get(i).getId() + "\n");
				writer.write(arr.get(i).getTen()+ "\n");
				writer.write(arr.get(i).getTuoi()+ "\n");
				writer.write(arr.get(i).getDiaChi()+ "\n");
				writer.write(arr.get(i).getSdt()+ "\n");
				writer.write(arr.get(i).getEmail()+ "\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	//file nhân viên
	public void inputNV(List<NhanVien> arr){
		try {
			Scanner sc = new Scanner(fileNV);
			while(sc.hasNext()){
				NhanVien nv = new NhanVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
				arr.add(nv);
			}
			sc.close();
		} catch (Exception e) {
		}
	}
	public void outputNV(List<NhanVien> arr){
		try {
			FileWriter writer = new FileWriter(fileNV);
			for (int i=0; i < arr.size(); ++i){
				writer.write(arr.get(i).getId() + "\n");
				writer.write(arr.get(i).getTen() + "\n");
				writer.write(arr.get(i).getTuoi() + "\n");
				writer.write(arr.get(i).getDiaChi() + "\n");
				writer.write(arr.get(i).getLuong() + "\n");
			}
			writer.close();
		} catch (Exception e) {
		}
	}
	
	//file sản phẩm
	public void inputSP(ArrayList<SanPham> arr) {
		try {
			FileReader fr = new FileReader(fileSP);
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String line1 = br.readLine();if (line1 == null) break;
				String line2 = br.readLine();
				String line3 = br.readLine();
				String line4 = br.readLine();
				String line5 = br.readLine();
				String line6 = br.readLine();
				String line7 = br.readLine();
				String line8 = br.readLine();
				String line9 = br.readLine();
				SanPham x = new SanPham(line1, line2, line3, line4, line5, line6, line7, line8, line9);
				arr.add(x);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
		}
	}
	public void outputSP(ArrayList<SanPham> arr) {
		try {
			FileWriter writer = new FileWriter(fileSP);
			for (int i=0; i<arr.size(); ++i) {
				writer.write(arr.get(i).getTenSP() + "\n");
				writer.write(arr.get(i).getSoLuong()+ "\n");
				writer.write(arr.get(i).getThuongHieu()+ "\n");
				writer.write(arr.get(i).getHeDieuHanh()+ "\n");
				writer.write(arr.get(i).getKichThuocMan()+ "\n");
				writer.write(arr.get(i).getChip()+ "\n");
				writer.write(arr.get(i).getPin()+ "\n");
				writer.write(arr.get(i).getXuatXu()+ "\n");
				writer.write(arr.get(i).getGiaString()+ "\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	//xuat Hoa don
	public void xuatHD(String s) {
		try {
			FileWriter writer = new FileWriter(fileHD);
			writer.write("\n------------------THÔNG TIN HÓA ĐƠN-----------------\n");
			writer.write(s);
			writer.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	//kho
	public void inputKho(ArrayList<Kho> arr, QuanLyNhanVien qlnv){
		try {
			FileReader fr = new FileReader(fileKho);
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String line1 = br.readLine();if (line1 == null) break;
				String line2 = br.readLine();
				String line3 = br.readLine();
				String line4 = br.readLine();
				NhanVien nv = qlnv.timNhanVien(line4);
				Kho kho = new Kho(line1, line2, line3, nv);
				arr.add(kho);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
		}
	}
	public void outputKho(ArrayList<Kho> arr){
		try {
			FileWriter writer = new FileWriter(fileKho);
			for (int i=0; i < arr.size(); ++i){
				writer.write(arr.get(i).getMaKho() + "\n");
				writer.write(arr.get(i).getTenKhuVuc() + "\n");
				writer.write(arr.get(i).getGhiChu() + "\n");
				writer.write(arr.get(i).getNhanVien().getId() + "\n");
			}
			writer.close();
		} catch (Exception e) {
		}
	}
}

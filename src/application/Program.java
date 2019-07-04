package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("--- TEST 1: seller findById ---");
		Seller seller2 = sellerDao.findById(3);
		System.out.println(seller2);
		
		System.out.println("\n--- TEST 2: seller findByDepartment ---");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		System.out.println(list.size());
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n--- TEST 3: seller findAll ---");
		//Department department = new Department(2, null);
		List<Seller> list2 = sellerDao.findAll();
		System.out.println(list.size());
		for(Seller obj : list2) {
			System.out.println(obj);
		}
		
		System.out.println("\n--- TEST 4: seller insert ---");
		Seller seller3 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		//sellerDao.insert(seller3);
		System.out.println("Inserted! New id = "+seller3.getId());
		
		System.out.println("\n--- TEST 5: seller update ---");
		seller3 = sellerDao.findById(1);
		seller3.setName("Martha Wayne");
		sellerDao.update(seller3);
		System.out.println("Update completed!");
		
		System.out.println("\n--- TEST 6: seller delete ---");
		System.out.print("Enter id to delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
		
	}

}

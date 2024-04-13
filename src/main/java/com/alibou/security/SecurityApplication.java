package com.alibou.security;

import com.alibou.security.project.entity.Accounts;
import com.alibou.security.project.entity.Cate;
import com.alibou.security.project.entity.Unit;
import com.alibou.security.project.entity.Vendor;
import com.alibou.security.project.repos.AccountRepo;
import com.alibou.security.project.repos.CateRepo;
import com.alibou.security.project.repos.UnitRepo;
import com.alibou.security.project.repos.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);

//		long randomLong = getRandomLongInRange(100000L, 999999L);
//		System.out.println("Random long: " + randomLong);

	}
	@Autowired
	VendorRepo vendorRepo;
	@Autowired
	UnitRepo unitRepo;
	@Autowired
	CateRepo cateRepo;
	@Autowired
	AccountRepo accountRepo;
	@Override
	public void run(String... args) throws Exception {

		if(vendorRepo.count() == 0){
			vendorRepo.save(new Vendor(null,"داخلي","---","000000000",1,LocalDateTime.now(),LocalDateTime.now()));
		}
		if(unitRepo.count() == 0){
			unitRepo.save(new Unit(null,"حبة",1));
			unitRepo.save(new Unit(null,"زوج",1));
			unitRepo.save(new Unit(null,"بالتر",1));
			unitRepo.save(new Unit(null,"بالكيلو",1));
			unitRepo.save(new Unit(null,"درزن",1));
		}
		if(cateRepo.count() == 0){
			cateRepo.save(new Cate(null,"عام",1));
		}if(accountRepo.count() == 0){

			accountRepo.saveAll(Arrays.asList(
					new Accounts(1001L,"نقدية",1, LocalDateTime.now(),LocalDateTime.now()),
					new Accounts(1002L,"مشتريات",1, LocalDateTime.now(),LocalDateTime.now()),
					new Accounts(3001L,"راس المال",2, LocalDateTime.now(),LocalDateTime.now()),
					new Accounts(5001L,"مصاريف",1, LocalDateTime.now(),LocalDateTime.now()),
					new Accounts(4001L,"مبيعات",2, LocalDateTime.now(),LocalDateTime.now()),
					new Accounts(4005L,"خصومات بيع",1, LocalDateTime.now(),LocalDateTime.now()),
					new Accounts(1005L,"خصومات شراء",2, LocalDateTime.now(),LocalDateTime.now())
			));
		}

		System.out.println("----------All Data saved into Database----------------------");
	}

}

package com.application.library;

import com.application.library.exchange.api.ExchangeService;
import com.application.library.mapperDTO.autormapper.AutorCreateDTO;
import com.application.library.mapperDTO.bookmapper.BookCreateDTO;
import com.application.library.mapperDTO.borrowmapper.BorrowCreateDTO;
import com.application.library.mapperDTO.personmapper.PersonCreateDTO;
import com.application.library.model.Borrow;
import com.application.library.model.Role;
import com.application.library.services.*;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.time.temporal.ChronoUnit.DAYS;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	private final BookService bookService;
	private final PersonService personService;
	private final BorrowService borrowService;
	private final AutorService autorService;
	private final RoleService roleService;
	private final UserService userService;
	private final ExchangeService exchangeService;


	@Autowired
	public LibraryApplication( ExchangeService exchangeService, BookService bookService, PersonService personService, BorrowService borrowService, AutorService autorService, RoleService roleService, UserService userService) {
		this.bookService = bookService;
		this.personService = personService;
		this.borrowService = borrowService;
		this.autorService = autorService;
		this.roleService = roleService;
		this.userService = userService;
		this.exchangeService = exchangeService;

	}







	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);



	}



	@Override
	@Transactional
	public void run(String... args) throws Exception {


		AutorCreateDTO autorOne = new AutorCreateDTO("Adams", "Mickiewicz");
		AutorCreateDTO autorTwo = new AutorCreateDTO("Juliusz", "Słowacki");
		AutorCreateDTO autorThree = new AutorCreateDTO("Sigmunt", "Froud");

		autorService.addAutor(autorOne);
		autorService.addAutor(autorTwo);
		autorService.addAutor(autorThree);

		Set<Integer> autorsFirst = new HashSet<Integer>();
		Set<Integer> autorsSecond = new HashSet<Integer>();

		autorsFirst.add(1);
		autorsFirst.add(3);
		autorsSecond.add(2);


		BookCreateDTO one =  new BookCreateDTO("Zbrodnia i Kara", autorsFirst);
		BookCreateDTO two =  new BookCreateDTO("Dziady", autorsFirst);
		BookCreateDTO three =  new BookCreateDTO("Historia Rzymu", autorsSecond);
		BookCreateDTO four =  new BookCreateDTO("Harry Potter", autorsSecond);
		BookCreateDTO five =  new BookCreateDTO("O jeden most za daleko", autorsFirst);

		bookService.addBook(one);
		bookService.addBook(two);
		bookService.addBook(three);
		bookService.addBook(four);
		bookService.addBook(five);

		PersonCreateDTO oneP = new PersonCreateDTO("Alicja" , "Kowalska");
		PersonCreateDTO twoP = new PersonCreateDTO("Pawel", "Demendyn");
		PersonCreateDTO threeP = new PersonCreateDTO("Adam", "Maklowicz");
		PersonCreateDTO fourP = new PersonCreateDTO("Maciek", "Kur");
		PersonCreateDTO fiveP = new PersonCreateDTO("Asia", "Trzebiatowska");

		personService.addPerson(oneP);
		personService.addPerson(twoP);
		personService.addPerson(threeP);
		personService.addPerson(fourP);
		personService.addPerson(fiveP);

		BorrowCreateDTO rentFirst = new BorrowCreateDTO(1,2);
		BorrowCreateDTO rentSecond = new BorrowCreateDTO(2,2);
		BorrowCreateDTO rentThird = new BorrowCreateDTO(4,3);
		BorrowCreateDTO rentFive = new BorrowCreateDTO(5,2);

		borrowService.addRent(rentFirst);
		borrowService.addRent(rentSecond);
		borrowService.addRent(rentThird);
		borrowService.addRent(rentFive);


		Role admin = new Role("ADMIN");
		Role user = new Role("USER");

		roleService.addRole(admin);
		roleService.addRole(user);

		userService.addUser("admin", "root", admin);

		LocalDate time =  LocalDate.now().minusDays(8);
		borrowService.getBorrowById(2).setReturnAt(time);


		borrowService.getBorrowById(1).setReturnAt(time.minusDays(9));


		Period init = new Period(borrowService,exchangeService);
		init.oneDayCheck();








		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------STARTED----------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
	}









}



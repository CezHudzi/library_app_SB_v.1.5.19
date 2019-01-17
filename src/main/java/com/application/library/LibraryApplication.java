package com.application.library;

import com.application.library.mapperDTO.autormapper.AutorCreateDTO;
import com.application.library.mapperDTO.bookmapper.BookCreateDTO;
import com.application.library.mapperDTO.personmapper.PersonCreateDTO;
import com.application.library.model.Role;
import com.application.library.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	private final BookService bookService;
	private final PersonService personService;
	private final BorrowService borrowService;
	private final AutorService autorService;
	private final RoleService roleService;
	private final UserService userService;
	@Autowired
	public LibraryApplication(BookService bookService, PersonService personService, BorrowService borrowService, AutorService autorService, RoleService roleService, UserService userService) {
		this.bookService = bookService;
		this.personService = personService;
		this.borrowService = borrowService;
		this.autorService = autorService;
		this.roleService = roleService;
		this.userService = userService;
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


		BookCreateDTO one =  new BookCreateDTO("DZIADY", autorsFirst);
		BookCreateDTO two =  new BookCreateDTO("Dziady", autorsFirst);
		BookCreateDTO three =  new BookCreateDTO("Historia Rzymu", autorsSecond);
		BookCreateDTO four =  new BookCreateDTO("Harry Potter", autorsSecond);
		BookCreateDTO five =  new BookCreateDTO("Pachnidlo", autorsFirst);

		bookService.addBook(one);
		bookService.addBook(two);
		bookService.addBook(three);
		bookService.addBook(four);
		bookService.addBook(five);

		PersonCreateDTO oneP = new PersonCreateDTO("IZ" , "Vo");
		PersonCreateDTO twoP = new PersonCreateDTO("Pawel", "Dem");
		PersonCreateDTO threeP = new PersonCreateDTO("Adam", "Maklowicz");
		PersonCreateDTO fourP = new PersonCreateDTO("Maciek", "Kur");
		PersonCreateDTO fiveP = new PersonCreateDTO("Asia", "Zag");

		personService.addPerson(oneP);
		personService.addPerson(twoP);
		personService.addPerson(threeP);
		personService.addPerson(fourP);
		personService.addPerson(fiveP);

		//borrowService.rentBook(1L,2L);
		//borrowService.rentBook(3L,2L);
		//borrowService.rentBook(3L,2L);

		Role admin = new Role("ADMIN");
		Role user = new Role("USER");

		roleService.addRole(admin);
		roleService.addRole(user);

		userService.addUser("admin", "root", admin);


		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------STARTED----------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
	}
}



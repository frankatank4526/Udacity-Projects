package com.udacity.jdnd.course1;

import com.udacity.jdnd.course1.service.FizzBuzzService;
import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzServiceTest {
	static FizzBuzzService bfs;
	@BeforeAll
	static void initializeBuzzFizz(){
		bfs = new FizzBuzzService();
	}

	@Test
	void testFizzBuzz(){
		FizzBuzzService fbs = new FizzBuzzService();

		// check non-divisible numbers return themselves
		assertEquals("1", fbs.fizzBuzz(1));
		assertEquals("47", fbs.fizzBuzz(47));
		assertEquals("121", fbs.fizzBuzz(121));

		// check numbers divisible by 3
		assertEquals("Fizz", fbs.fizzBuzz(3));
		assertEquals("Fizz", fbs.fizzBuzz(333));

		//check numbers divisible by 5
		assertEquals("Buzz", fbs.fizzBuzz(5));
		assertEquals("Buzz", fbs.fizzBuzz(85));

		//check numbers divisible by 3 and 5
		assertEquals("FizzBuzz", fbs.fizzBuzz(15));
		assertEquals("FizzBuzz", fbs.fizzBuzz(75));

		//check invalid inputs
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(0));
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(-1));
	}

	@Test
	void testFizzValid(){
		// check "Fizz" input
		assertEquals(9 , bfs.buzzFizz("Fizz", 3));
		assertEquals( 30, bfs.buzzFizz("Fizz", 10));
		assertEquals( 33, bfs.buzzFizz("Fizz", 11));

	}
	@Test
	void testBuzzValid(){
		assertEquals(10, bfs.buzzFizz("Buzz", 2));
		assertEquals(50, bfs.buzzFizz("Buzz", 10));
		assertEquals(55,bfs.buzzFizz("Buzz", 11));
		assertEquals(10,  bfs.buzzFizz("10", 10));

	}
	@Test
	void testBuzzFizzInvalid(){
		assertThrows(IllegalArgumentException.class , () -> bfs.buzzFizz("fibuz", 1));

		assertThrows(IllegalArgumentException.class, () -> bfs.buzzFizz("FizzBuzz" , -1));


	}
}

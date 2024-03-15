package com.example.JunitTest.Junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import com.example.JunitTest.Model.Calculator;

public class AnnotationsTest {

	Calculator calculator = new Calculator();

	@BeforeAll
	public static void message() {
		System.out.println("Calculation Started...");
		
	}

	@BeforeEach
	public  void methodStart() {
		System.out.println("Calculating................");
	}
	
	@AfterEach
	public  void methodEnd() {
		System.out.println("Finished................");
	}
	
	@Test
	public void assertEqual() {
		String actualvalue = calculator.message("Calculator");
		assertEquals("Calculator", actualvalue);

	}

	@Test
	public void addTest() {
		int a=calculator.add(34, 45);
		System.out.println("Addition : "+a);
		assertEquals(79, a);
	}

	@Test
	public void NegativeSubtractTest() {
		int d = calculator.subtraction(3, 5);
		System.out.println("Subtraction : "+d);
		assertEquals(-2, d);
	}

	@Test
	public void PositiveSubtractTest() {
		int d = calculator.subtraction(39, 5);
		System.out.println("Subtraction : "+d);
		assertEquals(34, d);
	}

	@Test
	public void multiplyTest() {
		int f = calculator.multiply(34, 2);
		System.out.println("Multiplication : "+f);
		assertEquals(68, f);
	}

	@Test
	public void divideTest() {
		int g = calculator.division(44, 2);
		System.out.println("Division : "+g);
		assertEquals(22, g);
	}

	@Test
	public void dividebyZero() {
		Assertions.assertThrows(ArithmeticException.class, () -> calculator.division(5, 0));
	}
	
	@AfterAll
	public static void end() {
		System.out.println("Calculation Ended..");
	}

}

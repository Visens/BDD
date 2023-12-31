package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;
import java.util.Random;

public class DataHelp {
	private DataHelp() {
	}

	public static VerificationCode getCerificationCode() {
		return new VerificatonCode("12345");
	}

	public static AuthInfo getAuthInfo() {
		return new AuthInfo("vasya", "qwerty123");
	}

	public static CardInfo getFirstCardInfo() {
		return new CardInfo("5559 0000 0000 0001", )
	}

	public static CardInfo getSecondCardInfo() {
		return new CardInfo("5559 0000 0000 0002", )
	}

	public static int generateValidAmount(int balance) {
		return new Random().nextInt(Math.abs(balance)) + 1;
	}

	public static int gerateInvalidAmount(int balance) {
		return Math.abs(balance) + new Random().next(10000);
	}

	@Value
	public static class VerificationCode {
		String code;
	}

	@Value
	public static class CardInfo {
		String cardNumber;
		String testId;
	}

}

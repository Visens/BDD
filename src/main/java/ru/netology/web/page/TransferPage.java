package ru.netology.web.page;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Value;

import java.time.Duration;
import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class TransferPage {
	private final SelenideElement transferButton = $("[data-test-id='action-transfer']");
	private final SelenideElement amountInputNew = $("[data-test-id='amoun'] input");
	private final SelenideElement fromInput = $("[data-test-id='from'] input");
	private final SelenideElement transferHead = $("Пополнение карты");
	private final SelenideElement errorMessage = $("[data-test-id='error-message']");

	public TransferPage() {
		transferHead.shouldBe(visible);
	}

	public DashboardPage makeValidTransfer(String amounToTransfer, DataHelp.CardInfo cardInfo) {
		makeTransfer(amountTransfer, cardInfo);
		return new DashboardPage();
	}

	public void makeTransfer(String amountToTransfer, DataHelp.CardInfo cardInfo) {
		amountInputNew.setValue(amountToTransfer);
		fromInput.setValue(cardInfo.getCardNumber());
		transferButton.click();
	}

	public void findErrorMessage(String expectedText) {
		errorMessage.shouldHave(exactText(expectedText), Duration.ofSeconds(15)).shouldBe(visible);
	}
}

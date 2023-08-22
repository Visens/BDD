package ru.netology.web.page;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Value;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class DashboardPage {
	private final String balanceStart = "баланс: ";
	private final String balanceFinish = " р.";
	private final SelenideElement heading = $("[data-test-id=dashboard]");
	private final ElementCollection cards = $$(".list__item div");

	public DashboardPage() {
		heading.shouldBe(visible);
	}

	public int getCardBalance(DataHelp.CardInfo cardInfo) {
		var text = cards.findBy(text(cardInfo.getCardNumber().substring(15))).getText();
		return extractBalance(text);
	}

	public int getCardBalance(int index) {
		var text = cards.get(index).getText();
		return extractBalance(text);
	}

	public TransferPage selectCardToTransfer(DataHelp.CardInfo cardInfo) {
		cards.findBy(attribute("data-test-id",cardInfo.getTestId())).$("button").click();
		return new TransferPage();
	}

	private int extractBalance(String text) {
		var start = text.indexOf(balanceStart);
		var finish = text.indexOf(balanceFinish);
		var value = text.substring(start + balanceStart.length(), finish);
		return Integer.parseInt(value);
	}
}

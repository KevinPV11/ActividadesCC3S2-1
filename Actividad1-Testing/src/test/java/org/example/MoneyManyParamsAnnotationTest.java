package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyManyParamsAnnotationTest {
    @ParameterizedTest
    @CsvSource({//Permite especificar muchos valores por cada caso de prueba
        "10, USD",
        "15, EUR",
        "50, CHF"
    })
    void constructorShouldSetAmountAndCurrency(int amount, String currency){
        Money money = new Money(amount, currency);
        //Complete
        assertThat(money.getAmount()).isEqualTo(amount);
        assertThat(money.getCurrency()).isEqualTo(currency);
    }
}

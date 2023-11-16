package christmas.domain.Discount;

import christmas.fixture.DiscountFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountTest {

    @DisplayName("getMessage 테스트")
    @Nested
    class getMessage {

        @DisplayName("출력이 원하는대로 되는지 확인한다.")
        @Test
        void checkGetMessage() {
            Discount discount = DiscountFixture.BASE.getDiscount();
            assertEquals(discount.getMessage(), DiscountFixture.BASE.getDiscountMessage());
        }

    }

    @DisplayName("getDiscountedPrice 테스트")
    @Nested
    class getDiscountedPrice {

        @DisplayName("반환값이 올바른지 확인한다.")
        @Test
        void checkGetDiscountedPrice() {
            Discount discount = DiscountFixture.BASE.getDiscount();
            assertEquals(discount.getDiscountedPrice(), DiscountFixture.BASE.getDiscountPrice());
        }

    }

}
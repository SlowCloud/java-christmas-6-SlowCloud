package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends NsTest {

    @Test
    void 할인값_확인() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "티본스테이크 1개",
                    "바비큐립 1개",
                    "초코케이크 2개",
                    "제로콜라 1개",
                    "<할인 전 총주문 금액>",
                    "142,000원",
                    "<증정 메뉴>",
                    "샴페인 1개",
                    "<혜택 내역>",
                    "크리스마스 디데이 할인: -1,200원",
                    "평일 할인: -4,046원",
                    "특별 할인: -1,000원",
                    "증정 이벤트: -25,000원",
                    "<총혜택 금액>",
                    "-31,246원",
                    "<할인 후 예상 결제 금액>",
                    "135,754원",
                    "<12월 이벤트 배지>",
                    "산타"
            );
        });
    }

    @Test
    void 할인_없는_경우_확인() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1 ");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "타파스 1개",
                    "제로콜라 1개",
                    "<할인 전 총주문 금액>",
                    "8,500원",
                    "<증정 메뉴>",
                    "없음",
                    "<혜택 내역>",
                    "없음",
                    "<총혜택 금액>",
                    "0원",
                    "<할인 후 예상 결제 금액>",
                    "8,500원",
                    "<12월 이벤트 배지>",
                    "없음"
            ).doesNotContain(
                    "평일 할인",
                    "주말 할인",
                    "크리스마스 디데이 할인",
                    "특별 할인",
                    "증정 이벤트"
            );
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @DisplayName("자동차 이름은 1자 이상이어야 한다.")
    @Test
    void validate_minimum_name_length() {
        // given
        String emptyName = "";
        String spaceName = " ";

        // when
        assertThatThrownBy(() -> new CarName(null))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");

        // when
        assertThatThrownBy(() -> new CarName(emptyName))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");

        // when
        assertThatThrownBy(() -> new CarName(spaceName))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");
    }

    @DisplayName("자동차 이름이 생성된다.")
    @Test
    void create_car_name() {
        // when
        CarName carName = new CarName("dugi");

        // then
        String expectedName = "dugi";
        assertThat(carName.getName()).isEqualTo(expectedName);
    }
}
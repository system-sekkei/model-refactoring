package rental;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatementOutput {

    Rental newRelease;
    Rental children;
    Rental regular;

    @BeforeEach
    @DisplayName("テストデータ準備")
    void setupData() {
        Movie newReleaseMovie = new Movie("新作", Movie.NEW_RELEASE);
        Movie childrenMovie  = new Movie("子供", Movie.CHILDREN);
        Movie regularMovie  = new Movie("一般", Movie.REGULAR);

        newRelease = new Rental(newReleaseMovie, 3);
        children = new Rental(childrenMovie, 2);
        regular = new Rental(regularMovie, 1);
    }

    String output;
    @BeforeEach
    @DisplayName("結果データの準備")
    void setupResult() {
        output = "山田様のレンタル明細\n" +
                "\t新作\t900円\n" +
                "\t子供\t150円\n" +
                "\t一般\t200円\n" +
                "合計金額 1250円\n" +
                "獲得ポイント 4p";
    }

    @Test
    @Disabled("ステートメント出力")
    void output() {
        Customer customer = new Customer("山田") ;
        customer.addRental(newRelease);
        customer.addRental(children);
        customer.addRental(regular);

        assertEquals(output, customer.statement());
    }

}
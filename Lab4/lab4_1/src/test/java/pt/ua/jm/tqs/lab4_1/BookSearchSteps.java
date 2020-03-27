
package pt.ua.jm.tqs.lab4_1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class BookSearchSteps {

	Library library = new Library();
	List<Book> result = new ArrayList<>();

    @Given("a book with the title {string}, written by {string}, published in {int} March {int}")
    public void a_book_with_the_title_written_by_published_in_March(String string, String string2, Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        library.addBook(new Book(string, string2, new Date(int2, 03, int1)));
    }

    @Given("another book with the title {string}, written by {string}, published in {int} August {int}")
    public void another_book_with_the_title_written_by_published_in_August(String string, String string2, Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        library.addBook(new Book(string, string2, new Date(int2, 8, int1)));
    }

    @Given("another book with the title {string}, written by {string}, published in {int} January {int}")
    public void another_book_with_the_title_written_by_published_in_January(String string, String string2, Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        library.addBook(new Book(string, string2, new Date(int2, 01, int1)));
    }

    @When("the customer searches for books published between {int} and {int}")
    public void the_customer_searches_for_books_published_between_and(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        result = library.findBooks(new Date(int1, 1, 1), new Date(int2, 12, 31));
    }

    @Then("{int} books should have been found")
    public void books_should_have_been_found(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(result.size(), (int) int1);
    }

    @Then("Book {int} should have the title {string}")
    public void book_should_have_the_title(Integer int1, String string) {
        // Write code here that turns the phrase above into concrete actions
        int n = 0;
        for (Book book: result) {
            if (book.getTitle().equals(string))
                n++;
        }
        assertEquals(1, n);
    }

    @When("the customer searches for books written by {string}")
    public void the_customer_searches_for_books_written_by(String string) {
        // Write code here that turns the phrase above into concrete actions
        result = library.findBooks(string);
    }

}

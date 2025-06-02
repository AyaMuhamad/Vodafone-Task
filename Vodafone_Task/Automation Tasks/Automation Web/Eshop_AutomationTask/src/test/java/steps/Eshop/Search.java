package steps.Eshop;

import Eshop.com.pages.Eshop.SearchPage;
import io.cucumber.java.en.And;


public class Search {
    SearchPage searchPage = new SearchPage();

    @And("User searches for {string} and selects product number {int}")
    public void userAddsProductBySearch(String searchTerm, int productNum) {
        searchPage.AddProductBySearch(searchTerm, productNum);
    }
}

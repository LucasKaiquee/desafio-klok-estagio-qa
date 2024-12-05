package DesafioKlok;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.SearchPage;
import utils.BaseTest;

public class SearchTest extends BaseTest {
    private SearchPage searchPage;
    private String productName = "Notebook";

    @BeforeEach
    public void setUpTest() {
        String target = "https://www.magazineluiza.com.br";
        super.setUp(target);
        searchPage = new SearchPage(driver); 
    }

    @Test
    public void searchProduct_validName_relevantResults() {
        searchPage.searchProduct(this.productName); 
        assertTrue(searchPage.isProductDisplayed(), "Produtos não foram exibidos!");
        assertTrue(searchPage.areProductsRelevant(this.productName), "A maioria dos produtos na página não corresponde a busca!");
    }

    @Test
    public void searchProduct_partialName_relevantResults() {
        searchPage.searchProduct("Noteb"); 
        assertTrue(searchPage.isProductDisplayed(), "Produtos não foram exibidos!");
        assertTrue(searchPage.areProductsRelevant(this.productName), "A maioria dos produtos na página não corresponde a busca!");
    }

    @Test
    public void searchProduct_incorrectName_relevantResults() {
        searchPage.searchProduct("Notebiok"); 
        assertTrue(searchPage.isProductDisplayed(), "Produtos não foram exibidos!");
        assertTrue(searchPage.areProductsRelevant(this.productName), "A maioria dos produtos na página não corresponde a busca!");
    }

    @Test
    public void searchProduct_invalidName_displaysNoResults() {
        searchPage.searchProduct("testeDesafioKlokProdutoInválido");
        assertTrue(searchPage.isNoProductMessage("testeDesafioKlokProdutoInvalido"), "Produtos foram exibidos!");
    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }
}

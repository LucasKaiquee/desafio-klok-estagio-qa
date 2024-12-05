package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;
    
    private By searchBox = By.id("input-search");
    private By productCards = By.cssSelector("[data-testid='product-card-container']");
    private By messageNoProduct = By.cssSelector("[data-testid='text-list-title']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Realiza a busca de um produto na página.
     * 
     * @param productName O nome do produto a ser buscado.
     */
    public void searchProduct(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

        searchField.clear();
        searchField.sendKeys(productName);
        searchField.submit();

        wait.until(ExpectedConditions.urlContains("/busca/"));
    }

    /**
     * Verifica se produtos são exibidos após a busca.
     * 
     * @return true se houver produtos exibidos, false caso contrário.
     */
    public boolean isProductDisplayed() {
        List<WebElement> products = driver.findElements(productCards);
        return !products.isEmpty();
    }

    /**
     * Verifica se mais da metade dos produtos exibidos são relevantes para o termo de busca.
     * 
     * @param searchTerm O termo de busca utilizado.
     * @return true se mais da metade dos produtos forem relevantes, false caso contrário.
     */
    public boolean areProductsRelevant(String searchTerm) {
        List<WebElement> products = driver.findElements(productCards);
        
        int relevantCount = 0;
        for (WebElement product : products) {
            String productTitle = product.findElement(By.cssSelector("[data-testid='product-title']")).getText().toLowerCase();
            if (productTitle.contains(searchTerm.toLowerCase()))
                relevantCount++;
        }

        return relevantCount > products.size() / 2;
    }

    /**
     * Verifica se a mensagem de "nenhum produto encontrado" é exibida corretamente.
     * 
     * @param productName O nome do produto buscado.
     * @return true se a mensagem de erro estiver correta, false caso contrário.
     */
    public boolean isNoProductMessage(String productName) {
        List<WebElement> noProductMessage = driver.findElements(messageNoProduct);
    
        String expectedMessage = "sua busca por \"" + productName.toLowerCase() + "\" não encontrou resultado algum :(";
        String actualMessage = noProductMessage.get(0).getText().toLowerCase();

        return expectedMessage.equals(actualMessage);
    }
}

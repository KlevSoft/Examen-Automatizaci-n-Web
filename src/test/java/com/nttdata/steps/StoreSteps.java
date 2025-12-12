package com.nttdata.steps;

import com.nttdata.page.MyStorePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoreSteps {
    private WebDriver driver;
    public StoreSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void typeUser(String user) {

        WebElement userInputElement = driver.findElement(MyStorePage.usuario);
        userInputElement.sendKeys(user);
        //espera implicita
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        // espera explicita
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.BtnIniciar));
    }

    public void typePassword(String password) {
        this.driver.findElement(MyStorePage.clave).sendKeys(password);
    }

    public void login() {
        this.driver.findElement(MyStorePage.BtnIniciar).click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement userLoggedIn = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.userLoggedIn));
            if (userLoggedIn.isDisplayed()) {
                System.out.println("Inicio de sesión exitoso: " + userLoggedIn.getText());
            } else {
                throw new AssertionError("No se pudo verificar el inicio de sesión exitoso.");
            }
        } catch (TimeoutException e) {
            throw new AssertionError("Inicio de sesión fallido");
        }

    }

    public void navegoCategoria(String categoria, String subcategoria) {
        driver.findElement(MyStorePage.getCategoryLocator(categoria)).click();
        driver.findElement(MyStorePage.getSubCategoryLocator(subcategoria)).click();

    }

    public void agregarProductoCarrito(int cantidad) {
        WebElement firstProduct = driver.findElement(MyStorePage.Producto);
        firstProduct.click();
        WebElement quantityInput = driver.findElement(MyStorePage.CantidadInput);
        quantityInput.click();
        quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        quantityInput.sendKeys(Keys.DELETE);
        quantityInput.sendKeys(String.valueOf(cantidad));
        driver.findElement(MyStorePage.BtnAgregar).click();
    }

    public void validarProductoAgregado() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement confirmationPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.ValidarLoAgregado));
        if (!confirmationPopup.isDisplayed()) {
            throw new AssertionError("El popup de confirmación no se muestra.");
        }
    }

    public void validoMontoTotal() {
        String totalPopup = driver.findElement(MyStorePage.montoTotal).getText();
    }

    public void finalizaCompra() {
        driver.findElement(MyStorePage.BtnComprar).click();
    }

    public void validoTituloCarrito() {
        WebElement carritoTituloElement = driver.findElement(MyStorePage.validoTituloCarrito);
        String titleFromPage = carritoTituloElement.getText();
        if (!titleFromPage.equals("CARRITO")) {
            throw new AssertionError("El título de la página no es el esperado. Título encontrado: " + titleFromPage);
        }
        System.out.println("El título de la página del carrito es correcto: " + titleFromPage);
    }

    public void validoPrecioCarrito() {

    }

    public void navigateToLogin() {
        WebElement loginLink = driver.findElement(MyStorePage.loginLink);
        if (loginLink.isDisplayed()) {
            loginLink.click();
        }
    }
}
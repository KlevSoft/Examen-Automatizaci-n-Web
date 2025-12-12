package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.StoreSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class ProductStoreDef {
    StoreSteps storeSteps;
    private WebDriver driver;
    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }
    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es");
        screenShot();
        storeSteps = new StoreSteps(driver);
        storeSteps.navigateToLogin(); // Navega al inicio de sesión si es necesario
        screenShot();

    }
    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        storeSteps = new StoreSteps(driver);
        storeSteps.typeUser(user);
        storeSteps.typePassword(password);
        storeSteps.login();
        screenShot();

    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        storeSteps.navegoCategoria(categoria, subcategoria);
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        storeSteps.agregarProductoCarrito(cantidad);
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        storeSteps.validarProductoAgregado();
        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        storeSteps.validoMontoTotal();
        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        storeSteps.finalizaCompra();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        storeSteps.validoTituloCarrito();
        screenShot();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        storeSteps.validoPrecioCarrito();
        screenShot();
    }
}
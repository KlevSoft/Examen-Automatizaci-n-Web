package com.nttdata.page;

import org.openqa.selenium.By;

public class MyStorePage {

    public static By loginLink = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a");
    public static By userLoggedIn = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span");

    public static By usuario = By.xpath("//*[@id=\"field-email\"]");
    public static By clave = By.xpath("//*[@id=\"field-password\"]");;
    public static By BtnIniciar = By.xpath("//*[@id=\"submit-login\"]");;

    public static By getCategoryLocator(String categoria) {
        return By.xpath("//*[@id=\"category-3\"]/a");
    }
    public static By getSubCategoryLocator(String subcategoria) {
        return By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a");
    }

    public static By Producto = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a");

    public static By CantidadInput = By.xpath("//*[@id=\"quantity_wanted\"]");
    public static By BtnAgregar = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    public static By ValidarLoAgregado = By.xpath("//*[@id=\"myModalLabel\"]");
    public static By montoTotal = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By BtnComprar = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");

    public static By validoTituloCarrito = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1");

}
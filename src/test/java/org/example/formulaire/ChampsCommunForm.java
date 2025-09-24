package org.example.formulaire;

import org.example.models.Adresse;
import org.example.models.User;
import org.openqa.selenium.*;

public class ChampsCommunForm {
    WebElement dropdownInput;
    User user;

    //Methode pour remplire tous les champs en commun
    public void remplirChampsCommuns(WebDriver driver,String AdresseMail, String MotDePasse, String Nom, String Prenom, String PaysResidence, String PaysNationalite, Adresse adresse, String Telephone) {

        //Renseigner les champs de saisie du formulaire
        //Informations de connexion
        driver.findElement(By.xpath("//input[@placeholder='monadresse@domaine.com']")).sendKeys(AdresseMail);
        driver.findElement(By.cssSelector("#edit-pass-pass1")).sendKeys(MotDePasse);
        driver.findElement(By.cssSelector("#edit-pass-pass2")).sendKeys(MotDePasse);

        //Informations personnelles
        // Accepter cookies
        List<WebElement> elems = driver.findElements(By.id("tarteaucitronPersonalize2"));
            if (!elems.isEmpty()) {
            elems.get(0).click(); // clique sur le premier élément si présent
           }
       // driver.findElement(By.id("tarteaucitronPersonalize2")).click(); 

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();",
                driver.findElement(By.id("edit-field-civilite-mr")));

        driver.findElement(By.id("edit-field-nom-0-value")).sendKeys(Nom);
        driver.findElement(By.id("edit-field-prenom-0-value")).sendKeys(Prenom);

        //Selectionner le pays de résidence
        // C'est un Input et pas un Select = récupere l'element, vider le champ, taper le pays, et entrer
        dropdownInput = driver.findElement(By.id("edit-field-pays-concernes-selectized"));
        dropdownInput.sendKeys(Keys.BACK_SPACE);
        dropdownInput.sendKeys(PaysResidence);
        dropdownInput.sendKeys(Keys.ENTER);

         driver.findElement(By.id("edit-field-nationalite-0-target-id")).sendKeys(PaysNationalite);
        driver.findElement(By.id("edit-field-code-postal-0-value")).sendKeys(adresse.getCodePostale());
        driver.findElement(By.id("edit-field-ville-0-value")).sendKeys(adresse.getVille());
        driver.findElement(By.id("edit-field-telephone-0-value")).sendKeys(Telephone);

    }
}

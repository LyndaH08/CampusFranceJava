package org.example.Test.CreateAccountTest;
import org.example.Utils.ReadDataFromJson;
import org.example.formulaire.ChampsCommunForm;
import org.example.models.User;
import org.junit.jupiter.api.*; //Importer les annotation
//Les methodes d'assertions sont declaré static (sinon il faut les appeler avec le nom de la classe Assertion
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import java.io.IOException;
import java.util.List;

//Junit devrais cree une seule instance de la classe de test pour toutes les methodes
//Sinon je devrai declarer Static le BeforeALL et AfterALL car elle devrai s'executer une seule fois avant et apres tous les tests
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreateAccountStudent
{
    WebDriver driver;
    WebElement dropdownInput;
    ChampsCommunForm fillFields;
    List <User> users;

    //La methode  @BeforeAll void beforeAll()  {} s'exécute une seule fois avant l'exécution de toutes les methodes de tests


    @BeforeEach
    void beforeEach() throws IOException {
    // Création des options pour configurer chrome le navigateur Chrome
    ChromeOptions options = new ChromeOptions();
        
    // Vérifie si le test s'exécute sur GitHub Actions
    // GitHub définit automatiquement la variable d'environnement GITHUB_ACTIONS à "true"
    String githubActions = System.getenv("GITHUB_ACTIONS");
    if ("true".equals(githubActions)) {
        // Exécution en mode headless (pas d'affichage graphique) pour le runner Linux
        options.addArguments("--headless=new"); 

        // Désactive le sandboxing (nécessaire pour certains environnements CI)
        options.addArguments("--no-sandbox");

        // Permet à Chrome de fonctionner correctement sur des runners avec peu de mémoire
        options.addArguments("--disable-dev-shm-usage");
    }

    // Création du driver Chrome avec les options définies ci-dessus
    driver = new ChromeDriver(options); 

    // Lecture des etudiants depuis le fichier JSON
    users = ReadDataFromJson.fromJsonFileToObject();

    // Initialisation du formulaire commun
    fillFields = new ChampsCommunForm();

    // Lancer la page du formulaire
    driver.get("https://www.campusfrance.org/fr/user/register");
    }

    @Test
    public  void AccountStudentLicence1Sport()
    {
        //Renseigner tous les champs du formulaires en commun
        fillFields.remplirChampsCommuns(driver,users.get(0).getAdresseMail(),users.get(0).getMotDePasse(), users.get(0).getNom(),
            users.get(0).getPrenom(),users.get(0).getPaysResidence(),users.get(0).getPaysNationalite(),
                                         users.get(0).getAdresse(),users.get(0).getTelephone());


        //Informations complémentaire
        //Scroller  avant de cocher le bouton radio  Etudiant
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();",
                driver.findElement(By.id("edit-field-publics-cibles-2")));

       //C'est un Input et pas un Select = récupere l'element, vider le champ, taper le pays, et entrer
        dropdownInput = driver.findElement(By.id("edit-field-domaine-etudes-selectized"));
        dropdownInput.sendKeys(Keys.BACK_SPACE);
        dropdownInput.sendKeys(users.get(0).getDomaine());
        dropdownInput.sendKeys(Keys.ENTER);

        dropdownInput = driver.findElement(By.id("edit-field-niveaux-etude-selectized"));
        dropdownInput.sendKeys(Keys.BACK_SPACE);
        dropdownInput.sendKeys(users.get(0).getNiveau());
        dropdownInput.sendKeys(Keys.ENTER);

       //Vérifier l'intituler du label du bouton de validation du formulaire
        assertEquals("Créer un compte", driver.findElement(By.id("edit-submit")).getAttribute("value"));

        // Vérifier que le statut sélectionné est "Etudiant"
        assertTrue(driver.findElement(By.id("edit-field-publics-cibles-2")).isSelected(),"Le bouton 'Étudiant' n'est pas sélectionné.");


        // Vérifier que le niveau est bien selectionnet et c'est bien "Licence 1".
        // Recupere le text de l'item qui est le text selectionner
        WebElement champ = driver.findElement(By.cssSelector("#edit-field-niveaux-etude-wrapper > div > div > div.selectize-input.items.has-options.full.has-items > div"));

        //Vérifie que le champ n'est pas vide
        assertFalse(champ.getText().isEmpty(), "Le champ ne doit pas être vide");

        //Vérifie le texte attendu
        assertEquals("Licence 1", champ.getText(), "Le texte du champ est incorrect");

    }


    @Test
    public void AccountStudentDoctoratBiology()
    {
        fillFields.remplirChampsCommuns(driver,users.get(1).getAdresseMail(),users.get(1).getMotDePasse(), users.get(1).getNom(),
                users.get(1).getPrenom(),users.get(1).getPaysResidence(),users.get(1).getPaysNationalite(),
                users.get(1).getAdresse(),users.get(1).getTelephone());

        //Informations complémentaire
        //Scroller  avant de cocher le bouton radio  Etudiant
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();",
                driver.findElement(By.id("edit-field-publics-cibles-2")));

        //C'est un Input et pas un Select = récupere l'element, vider le champ, taper le pays, et entrer
        dropdownInput = driver.findElement(By.id("edit-field-domaine-etudes-selectized"));
        dropdownInput.sendKeys(Keys.BACK_SPACE);
        dropdownInput.sendKeys(users.get(1).getDomaine());
        dropdownInput.sendKeys(Keys.ENTER);

        dropdownInput = driver.findElement(By.id("edit-field-niveaux-etude-selectized"));
        dropdownInput.sendKeys(Keys.BACK_SPACE);
        dropdownInput.sendKeys(users.get(1).getNiveau());
        dropdownInput.sendKeys(Keys.ENTER);

        //Vérifier l'intituler du label du bouton de validation du formulaire
        assertEquals("Créer un compte", driver.findElement(By.id("edit-submit")).getAttribute("value"));

        // Vérifier que le statut sélectionné est "Etudiant"
        assertTrue(driver.findElement(By.id("edit-field-publics-cibles-2")).isSelected(),"Le bouton 'Étudiant' n'est pas sélectionné.");


        // Vérifier que le niveau est bien selectionnet et c'est bien "Licence 1".
        // Recupere le text de l'item qui est le text selectionner
        WebElement champ = driver.findElement(By.cssSelector("#edit-field-niveaux-etude-wrapper > div > div > div.selectize-input.items.has-options.full.has-items > div"));

        //Vérifie que le champ n'est pas vide
        assertFalse(champ.getText().isEmpty(), "Le champ ne doit pas être vide");

        //Vérifie le texte attendu
        assertEquals("Doctorat / PhD", champ.getText(), "Le texte du champ est incorrect");
    }



    @AfterEach
    void AfterEach(){driver.quit();}



  //La methode @AfterAll void AfterAll() s'exécute une seule fois apres l'exécution de toutes les methodes de tests

}

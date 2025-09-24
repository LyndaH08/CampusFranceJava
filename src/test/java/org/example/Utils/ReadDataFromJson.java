package org.example.Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.User;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ReadDataFromJson {

    /**
     * Méthode qui lit un fichier JSON et retourne une liste d'objets User
     * @return List<User> - la liste des utilisateurs
     * @throws IOException si le fichier n'est pas trouvé ou lecture impossible
     */
    public static List<User> fromJsonFileToObject() throws IOException {

        // Créer un ObjectMapper, l'équivalent de JsonSerializer en C#
        ObjectMapper mapper = new ObjectMapper();

        // Lire le fichier JSON depuis le dossier resources
          File file = new File("src/test/resources/StudentCampusFrance.json");

        // Désérialiser le contenu JSON en liste d'objets User
        // TypeReference est nécessaire pour indiquer le type générique List<User>
        //TypeReference<List<User>> dit à Jackson Je veux une liste d’objets User
        //C’est la seule façon en Java de désérialiser directement une liste d’objets avec Jackson.
        List<User> users = mapper.readValue(file, new TypeReference<List<User>>() {});


        return users;
    }
}


package entity;

import main.GamePanel;

import java.io.*;
import java.util.Scanner;

public class Monde {
    GamePanel gp;// on initialise le game panel



    public Monde(GamePanel gp){
        this.gp =gp;
    }// on crée le constructeur


    public void setMedecin() {// on crée la fonction setMedecin qui crée les médecins


        try
        {
            // Le fichier d'entrée
            FileInputStream file = new FileInputStream("res/player/medecin/medecin.txt");
            Scanner scanner = new Scanner(file);

            int i = 0;
            String text;
            while(i<gp.nbMedecin && scanner.hasNextLine())
                // on teste que le fichier text est des données a la ligne suivante est que le nombre attendu ne soit pas dépassé
            {

                text = scanner.nextLine();// on instancie le texte avec les valeurs d'une ligne du fichier
                String [] med = text.split(",");// on ajoute à la liste le texte et on les sépare par une virgule
                Entity.toto.add(new Medecin(this.gp,Integer.parseInt(med[0]),Integer.parseInt(med[1]),Integer.parseInt(med[2])));
                // on donne à chaque attribut d'un médecin les données de la ligne
                i++;
            }
            scanner.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public void setPatient() {// meme chose que la fonction setMedecin mais pour les patients


        try
        {
            // Le fichier d'entrée
            FileInputStream file = new FileInputStream("res/player/patient/lieuPatientChambre.txt");
            Scanner scanner = new Scanner(file);

            int i = 0;
            String text;
            while(i<gp.nbPatient && scanner.hasNextLine())
            {

                text = scanner.nextLine();
                String [] med = text.split(",");
                Entity.toto.add(new Patient(this.gp,Integer.parseInt(med[0]),Integer.parseInt(med[1]),Integer.parseInt(med[2])));

                i++;
            }
            scanner.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public void setVisiteur() {// meme chose que la fonction setMedecin mais pour les visiteurs


        try
        {
            // Le fichier d'entrée
            FileInputStream file = new FileInputStream("res/player/visiteur/lieuVisiteur.txt");
            Scanner scanner = new Scanner(file);

            int i = 0;
            String text;
            while(i<gp.nbVisiteur && scanner.hasNextLine())
            {

                text = scanner.nextLine();
                String [] med = text.split(",");
                Entity.toto.add(new Visiteur(this.gp,Integer.parseInt(med[0]),Integer.parseInt(med[1]),Integer.parseInt(med[2])));

                i++;

            }
            scanner.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}


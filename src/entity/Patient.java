package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Patient extends Entity{

    Lieu lieu = new Lieu();
    int[] choix = new int[8];
    public Patient(GamePanel gp, int positionX, int positionY, int covid){
        super(gp,positionX,positionY,covid);
        getPlayerImage();

    }
    // Ici on va chercher les images du Patient dans le dossier player/patient (4 images pour le covid, 4 images sans covid)

    public void getPlayerImage() {
        try {
            up1= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/patient/boy_up_1.png")));
            up2= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/covid/Covid_patient_boy_up_1.png")));
            down1= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/patient/boy_down_1.png")));
            down2= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/covid/Covid_patient_boy_down_1.png")));
            left1= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/patient/boy_left_1.png")));
            left2= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/covid/Covid_patient_boy_left_1.png")));
            right1= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/patient/boy_right_1.png")));
            right2= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/covid/Covid_patient_boy_right_1.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int[] choixLieu() {

        // statut 1 : Pris en charge --> direction la chambre
        // statut 2 : Dans la chambre --> Soit guéri, soit réa
        // statut 3 : Si Réa, direction la chambre
        // statut 5 : Part dans l'hopital
        // statut 7 : Reviens comme un nouveau patient





        if (statut == 3){
            choix [0] = lieu.chambreRea(i)[0];  // REA
            choix [1] = lieu.chambreRea(i)[1];  // REA

            return choix;

        }
        if (statut == 1) { // Direction chambre
            boolean trouve = false;

            int j = 0;
            while (!trouve && j<gp.nbChambrePatient.length){
                if (gp.nbChambrePatient[j][0] == 0){

                    trouve = true;
                    gp.nbChambrePatient[j][0] = 1; // Direction chambre
                    i = j;
                    statut =2;
                    choix [0] = lieu.chambrePatient(i)[0];
                    choix [1] = lieu.chambrePatient(i)[1];
                    return choix;
                }
                j++;

            }


        }
        if (statut == 5){
            choix [0] = lieu.sorti()[0];  // SORTI
            choix [1] = lieu.sorti()[1];  // SORTI
            statut =8;
            return choix;
        }

        if (statut == 7){
            gp.nbChambreRea[i] = 0;
            choix [0] = lieu.sorti()[0];  // SORTI
            choix [1] = lieu.sorti()[1];
            statut =8; // Reviens comme un nouveau patient
            return choix;
        }
        if (statut == 8){
            statut =1;
            setPositionX(110);
            setPositionY(10);

            double k=Math.random()*10 ; // Le nouveau patient à 7/10 chance de revenir sans le covid
            if (k>=3)
                setCovid(0);

            choix[0] = lieu.accueil()[0];
            choix[1] = lieu.accueil()[1];
            return choix;
        }



        return choix;
    }

}


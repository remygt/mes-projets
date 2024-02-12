package entity;


import main.GamePanel;

import javax.imageio.ImageIO;

import java.io.IOException;
import java.util.Objects;


public class Visiteur extends Entity{

    Lieu lieu = new Lieu();
    int [] choix = new int[2];
    public Visiteur(GamePanel gp, int positionX, int positionY, int covid){
        super(gp,positionX,positionY,covid);
        getPlayerImage();

    }
            // Ici on va chercher les images du Visiteur dans le dossier player/visiteur (4 images pour le covid, 4 images sans covid)
    public void getPlayerImage() {
        try {
            up1= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/visiteur/boy_up_1.png")));
            up2= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/covid/Covid_visiteur_boy_up_1.png")));
            down1= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/visiteur/boy_down_1.png")));
            down2= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/covid/Covid_visiteur_boy_down_1.png")));
            left1= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/visiteur/boy_left_1.png")));
            left2= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/covid/Covid_visiteur_boy_left_1.png")));
            right1= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/visiteur/boy_right_1.png")));
            right2= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/covid/Covid_visiteur_boy_right_1.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int[] choixLieu() {
        // statut 1 : Va à l'accueil et demande la chambre du patient, s'assoit à l'accueil si indisponible
        // statut 2 : Si le médecin arrive, va au siège visiteur de la chambre
        // statut 5 : Patiente
        // statut 3 : Part de l'hopital
        // statut 4 : Reviens comme un nouveau visiteur
        if (statut == 1) {

            int j = 0;
            while (j<gp.nbChambrePatient.length){
                if (gp.nbChambrePatient[j][0] == 1){

                    if (gp.nbSiegeVisiteur[j] == 0){
                        if (assis){
                            assis = false;

                            gp.nbSiegeVisiteur[i] = 0;

                        }
                        gp.nbSiegeVisiteur[j] = 1;
                        i = j;
                        statut =2;
                        choix [0] = lieu.chambrePatient(i)[4];
                        choix [1] = lieu.chambrePatient(i)[5];
                        return choix;

                    }
                }
                j++;

            }
            j = 33;
            while (j<gp.nbSiegeVisiteur.length){
                if (gp.nbSiegeVisiteur[j] == 0 && !assis){


                    gp.nbSiegeVisiteur[j] = 1;
                    i = j-33;
                    choix [0] = lieu.siegeVisiteur(i)[0];
                    choix [1] = lieu.siegeVisiteur(i)[1];

                    assis = true;
                    return choix;
                }
                j++;

            }


        }
        if (statut == 2){
            if (gp.nbChambrePatient[i][1] == 1){
                choix [0] = lieu.chambrePatient(i)[6];
                choix [1] = lieu.chambrePatient(i)[7];
                statut =5;
                return choix;
            }

        }
        if (statut == 3){
            gp.nbSiegeVisiteur[i] = 0;
            choix [0] = lieu.sorti()[0];  // SORTI
            choix [1] = lieu.sorti()[1];
            statut =4;
            return choix;
        }
        if (statut == 4){
            statut =1;
            setPositionX(5);
            setPositionY(68);

            double k=Math.random()*10 ;
            if (k>=3)
                setCovid(0);

            choix[0] = lieu.accueil()[2];
            choix[1] = lieu.accueil()[3];
            return choix;
        }
        if (statut == 5){
            if (compteur_stop == 10){
                statut =3;
                compteur_stop =0;
            }
            else compteur_stop += 1;
        }
        return choix;

    }
}


package entity;


import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

import static tiles.TileManager.mapTileNum;

public class Medecin extends Entity{
    Lieu lieu = new Lieu();
    int compteur_guerri =0;
    int[] choix = new int[2];
    int siege =-1;

    public Medecin(GamePanel gp,int positionX, int positionY, int covid){
        super(gp,positionX,positionY,covid);
        getPlayerImage();


    }
    // Ici on va chercher les images du Médecin dans le dossier player/médecin (4 images pour le covid, 4 images sans covid)

    public void getPlayerImage() {
        try {
            up1= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/medecin/boy_up_1.png")));
            up2= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/covid/Covid_medecin_boy_up_1.png")));
            down1= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/medecin/boy_down_1.png")));
            down2= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/covid/Covid_medecin_boy_down_1.png")));
            left1= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/medecin/boy_left_1.png")));
            left2= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/covid/Covid_medecin_boy_left_1.png")));
            right1= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/medecin/boy_right_1.png")));
            right2= ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/covid/Covid_medecin_boy_right_1.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int[] choixLieu() {

        // statut 1 : Cherche un patient ou va en salle de repos le cas contraire
        // statut 2 : Opère
        // statut 3 : Va en réa si le patient n'est pas guéri


        int n =0;
        boolean trouve = false;
        if (compteur_guerri == 3 && statut == 1){
            while (!trouve && n<gp.nbLitMedecin.length){
                if (gp.nbLitMedecin[n] == 0){
                    trouve = true;
                    assis = true;
                    i=n;
                    gp.nbLitMedecin[n] = 1;
                    choix [0] = lieu.siegeMedecin(i)[0];
                    choix [1] = lieu.siegeMedecin(i)[1];

                }
                n++;
            }
            compteur_guerri =0;
        }
        if(statut == 1){
            while (!trouve && n<gp.nbChambrePatient.length){
                if (gp.nbChambrePatient[n][0] == 1 && gp.nbChambrePatient[n][1] == 0){
                    trouve = true;
                    if (siege !=-1 && assis) {
                        gp.nbLitMedecin[siege] = 0;
                        assis = false;
                    }

                    i =n;

                    gp.nbChambrePatient[i][1] = 1;
                    statut = 2;
                    choix [0] = lieu.chambrePatient(i)[2];
                    choix [1] = lieu.chambrePatient(i)[3];
                    compteur_guerri +=1;
                }

                n++;
            }
            if (!trouve && !assis){
                n =0;
                while (!trouve && n<gp.nbLitMedecin.length){

                    if (gp.nbLitMedecin[n] == 0){
                        trouve = true;
                        i=n;
                        siege = i;
                        assis = true;

                        gp.nbLitMedecin[i] = 1;
                        choix [0] = lieu.siegeMedecin(i)[0];
                        choix [1] = lieu.siegeMedecin(i)[1];

                    }
                    n++;
                }
            }

        }
        if (statut == 3){
            choix [0] = lieu.chambreRea(i)[2];  // REA
            choix [1] = lieu.chambreRea(i)[3];  // REA

        }



        return choix;
    }


}


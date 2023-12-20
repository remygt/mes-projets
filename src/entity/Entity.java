package entity;

import main.Deplacement;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// CODE COULEUR PERSO : Bleu --> Medecin; Blanc --> Visiteur ; Noir --> Patient  ; SI COVID : Fond vert



public class Entity extends Thread{
    public static ArrayList<Entity> toto = new ArrayList<Entity>();
    public int statut;
    private int worldX,worldY;
    private double positionX, positionY;
    private double speed = 0.1;
    private int covid;

    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    private String direction;
    GamePanel gp;
    Deplacement depla;
    public int i;
    double j = 0;
    public int finishX;
    public int finishY;
    public int interX = 0;
    public int interY = 0;
    public boolean arrive;
    public int[][][] liste_depla;
    public boolean pause = false;
    public int compteur_stop =0;
    double age = 10 + Math.random()*80;
    public double tauxContamination = Math.random()*100 ;
    public double defenseImun = defenseImun();
    public boolean assis =false;
    int spawn = (int)Math.random()*10;
    public int x; public int y; int stockX; int stockY;
    public static int dodo = 0;
    public final int temps_dodo;
    public int compteur_dodo=0;
    public int compteur_erreur =0;
    public int x_erreur =0;
    public int y_erreur=0;
    public Entity(GamePanel gp, int positionX, int positionY, int covid) {
        temps_dodo=dodo;
        dodo +=30;

        this.gp = gp;
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        this.setCovid(covid);
        this.setSpeed(speed);
        direction = "start";
        this.start();
        i =0;
        statut = 1;
        arrive = true;
        depla = new Deplacement(gp);
        // COORDONNEES DE DEPART

        if(this.getClass().getSimpleName().equalsIgnoreCase("Medecin")){
            finishX = 66; finishY = 49;
        }
        else if (this.getClass().getSimpleName().equalsIgnoreCase("Visiteur")){
            finishX = 4; finishY = 50;
        }
        else {
            if (spawn % 2 == 0){
                finishX = 4; finishY = 25;
            }
            else {
                finishX = 4; finishY = 36;
            }
        }

    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getWorldX() {
        return (int)(gp.tileSize * getPositionX());
    }

    public int getWorldY() {
        return (int)(gp.tileSize * getPositionY());
    }


    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getCovid() {
        return covid;
    }

    public void setCovid(int covid) {
        this.covid = covid;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
    public int[] choixLieu() {
        int[] choix = new int[2];
        return choix;
    }
    public void getChoixdepla() { // DONNE LA DIRECTION QUE DOIT PRENDRE LE PERSONNAGE
        x = (int)getPositionX();
        y = (int)getPositionY();


        if (arrive && finishX != 0 && finishY!=0 ){ // CALCUL UN NOUVEL ITINERAIRE SI IL CHANGE DE STATUT


            liste_depla = new int[120][81][2];

            liste_depla = depla.Chemin(this,finishX, finishY,x,y);

            arrive = false;

        }


        if (x==finishX && y==finishY){ // ARRIVE DONC NOUVEAU LIEU


            int[] choix = choixLieu();
            finishX = choix[0];
            finishY = choix[1];
            arrive =true;
            setDirection("start");

        }





        if (!arrive) { // CHOIX DE LA DIRECTION

            int d = liste_depla[x][y][0];

            if (liste_depla[x][y+1][0] == d-1 && liste_depla[x][y+1][1] ==1 ){
                setDirection("down");
            }
            else if(liste_depla[x][y-1][0] == d-1 && liste_depla[x][y-1][1] ==1){
                setDirection("up");

            }
            else if(liste_depla[x-1][y][0] == d-1 && liste_depla[x-1][y][1] ==1){
                setDirection("left");

            }
            else if(liste_depla[x+1][y][0] == d-1 && liste_depla[x+1][y][1] ==1) {
                setDirection("right");

            }
            else if(!depla.isValid(this,(int)positionX,(int)positionY)){
                int [] liste = {liste_depla[x][y+1][0],liste_depla[x][y-1][0],liste_depla[x-1][y][0],liste_depla[x+1][y][0]};
                int m = liste[0];
                for (int n =1; n<3; n++){
                    if (m == 0){
                        m = liste[n];
                    }
                    else {
                        if (m>liste[n] && liste[n]!=0){
                            m = liste[n];
                        }
                    }
                }

                if (m ==liste_depla[x][y+1][0] ){
                    setDirection("down");
                }
                else if (m== liste_depla[x][y-1][0]){
                    setDirection("up");
                }
                else if (m == liste_depla[x-1][y][0]){
                    setDirection("left");
                }
                else if (m == liste_depla[x+1][y][0]){
                    setDirection("right");

                }
            }
            depla.checkDeplacement(this);
        }


    }

    public void run() {
        try {

            // modification position player
            if (j == 0 && !pause) {
                this.getChoixdepla();
            }



            // MODIFIE LA POSITION DU JOUEUR


            if (!pause) {
                switch (direction){
                    case "start":

                        break;
                    case "up":
                        positionY -= speed;


                        break;
                    case "down":
                        positionY += speed;



                        break;
                    case "left":
                        positionX -= speed;


                        break;
                    case "right":

                        positionX += speed;

                        break;
                }

                if (j==0){
                    gp.mapCoverage[(int)positionX][(int)positionY] = 1;
                    gp.mapCoverage[stockX][stockY] = 0;
                    stockX = (int)positionX;
                    stockY = (int)positionY;


                }
                j += speed;

                if ((int) j==1){  // PERMET DE DEPLACER LE JOUEUR SUIVANT LES PIXELS
                    positionX = Math.round(positionX);
                    positionY = Math.round(positionY);
                    j = 0;
                }
            }
            if (pause){
                direction ="start";
                pause = false;
            }




        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    public void draw (Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "start":
                image = down1;
                if (this.getCovid()==1|| this.getCovid()==2){
                    image =down2;
                }
            case "up":
                image = up1;
                if (this.getCovid()==1 || this.getCovid()== 2){
                    image =up2;
                }
                break;
            case "down":
                image = down1;
                if (this.getCovid()==1|| this.getCovid()== 2){
                    image =down2;
                }
                break;
            case "left":

                image = left1;
                if (this.getCovid()==1|| this.getCovid()==2){
                    image =left2;
                }
                break;
            case "right":
                image = right1;
                if (this.getCovid()==1|| this.getCovid()==2){
                    image =right2;
                }
                break;
        }
        g2.drawImage(image,getWorldX(),getWorldY(), gp.tileSize, gp.tileSize, null);


    }

    // Ici est mis en place la defence immunitaire fonctionnant de la façon suivante :
    // Un âge est attribué à chaque personnage (entre 10 et 90 ans)
    // On donne une défense immunitaire pour chaque tranche d'âge, elle-même divisée par 2 si le patient est malade
    // Or s'il est à l'hôpital, c'est qu'il est malade.

    public double defenseImun (){

        if(10<= age && age<30) {
            if (getClass().getSimpleName().equalsIgnoreCase("Patient"))
                return (70 + Math.random() * 30) / 2;
            else
                return 70 + Math.random() * 30;
        }
        if(30<= age && age<50){
            if (getClass().getSimpleName().equalsIgnoreCase("Patient"))
                return (50 + Math.random() * 30) / 2;
            else
                return 50 + Math.random()*30;
        }
        if(50<= age && age<70){
            if (getClass().getSimpleName().equalsIgnoreCase("Patient"))
                return (30 + Math.random() * 30) / 2;
            else
                return 30 + Math.random()*30;
        }
        else{
            if (getClass().getSimpleName().equalsIgnoreCase("Patient"))
                return (10 + Math.random()*30)/2;
            else
                return 10 + Math.random()*30;
        }
    }
}

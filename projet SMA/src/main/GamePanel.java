package main;

import entity.*;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class GamePanel extends JPanel implements Runnable{ //Ecran de jeu
    public JLabel label = new JLabel();// on initialise les labels et les sliders
    public JLabel label3 = new JLabel();
    public JLabel label4 = new JLabel();
    public JLabel label5 = new JLabel();
    public JLabel label6 = new JLabel();
    public JLabel labelSetFPS = new JLabel();

    public JSlider slider = new JSlider(0,45,15);
    public JSlider slider2 = new JSlider(0,100,15);
    public JSlider slider3 = new JSlider(0,100,15);

    public JSlider sliderSetFPS = new JSlider(1,300,60);



    // Parametre d'affichage
    public final int tileSize = 10;

    public final int screenWidth = 1210;
    public final int screenHeight = 820;
    // WORLD SETTINGS
    public final int maxWorldCol = 121;
    public final int maxWorldRow = 81;
    public int nbMedecin ;
    public int nbPatient;
    public int nbVisiteur; // MAX 100
    public boolean pause= false;


    public int[][] nbChambrePatient = new int[25][2];
    public int[] nbChambreRea = new int[15];
    public int[] nbLitMedecin = new int[55];
    public int[] nbSiegeVisiteur = new int[60];
    public int[][] mapCoverage = new int[120][81];

    //FPS
    int FPS;
    TileManager tileM = new TileManager(this);
    public StatutChecker cChecker = new StatutChecker(this);
    Thread gameThread; //Il gère le temps dans le jeu, et donc fait tourner le programme

    Monde monde = new Monde(this);

    public GamePanel(){// on crée le gamepanel
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

    }
    public void startGameThread() {// cette methode permet de lancer le Thread

        gameThread = new Thread(this);
        gameThread.start();

    }
    public void setupGame(){// permet de sauvegarder les valeurs selectionné dans la fenêtre de paramétrage
        nbMedecin = slider.getValue(); // MAX 100
        nbPatient = slider2.getValue(); //MAX 100
        nbVisiteur = slider3.getValue(); //MAX 100
        FPS=sliderSetFPS.getValue();
        monde.setMedecin();
        monde.setPatient();
        monde.setVisiteur();

    }

    public void setupFPS(){// permet de modifier la vitesse en temps réel
        FPS = sliderSetFPS.getValue();
    }
    @Override
    public void run() {


        double drawInterval = 1000000000/FPS; //0.01666 sec
        double nextDrawTime = System.nanoTime() + drawInterval;


        while(gameThread !=null){ //Boucle qui tourne sans cesse

            // 1 Update : Mets à jour les informations
            // 2 Repaint : Dessine l'écran avec les mises à jour

            try {
                update();
                setupFPS();// actualise la vitesse à chaque update
                drawInterval = 1000000000/FPS; //0.01666 sec
                nextDrawTime = System.nanoTime() + drawInterval;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            repaint();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if (remainingTime<0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }





    }

    public void update() throws IOException {

        if (!pause) {
            int nbCovid=0;
            int nbVariant=0;
            // fichier de base
            File outFile=new File("res/save/donnee");
            outFile.getParentFile().mkdirs();
            Writer writer = new FileWriter(outFile, StandardCharsets.UTF_8);// on initialise la fileWriter
            BufferedWriter br =new BufferedWriter(writer);// on crée un Writer
            for (int i = 0;i<Entity.toto.size(); i++){
                if (Entity.toto.get(i).temps_dodo == Entity.toto.get(i).compteur_dodo) { // on teste pour chaque agent
                    Entity.toto.get(i).run();//on lance la methode run de chaque agent
                    if ( Entity.toto.get(i).getCovid() == 1 || Entity.toto.get(i).getCovid()==2){// on vérifie si le personnage a le COVID
                        nbCovid ++;
                    }
                    if (Entity.toto.get(i).getCovid()==2) {
                        nbVariant++;
                    }
                }
                else{
                    Entity.toto.get(i).compteur_dodo+=1;
                }
                label.setText("Nombre covid total : "+ nbCovid);// on actualise les labels de la fenêtre de jeu
                label3.setText("  Nombre Non Covid :  "+ (Entity.toto.size()- nbCovid));
                br.write(nbCovid+" "+(Entity.toto.size()- nbCovid));// on écrit dans le fichier les données relatives au covid
                br.newLine();// on passe à la ligne suivante
                br.flush();


            }

            cChecker.checkStatut();// on lance la methode check statut
        }

    }
    public void paintComponent(Graphics g){ //C'est un peu comme ton stylo ou ton feutre

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);
        for (int i = 0;i<Entity.toto.size(); i++){
            if(Entity.toto.get(i) != null){
                Entity.toto.get(i).draw(g2);
            }
        }

        g2.dispose();

    }
}

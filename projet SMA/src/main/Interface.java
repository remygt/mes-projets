package main;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class Interface {

    public static void start(){
        JFrame window = new JFrame();//on crée plusieur fenêtre et plusieur panel
        JFrame windowSlider = new JFrame();
        JFrame windowSliderFPS = new JFrame();
        JPanel pSetup = new JPanel();
        JPanel pGame = new JPanel();
        JPanel pSetFPS = new JPanel();


        JButton btn=new JButton("Lancer la simulation");//on crée des boutons
        JButton btnpause=new JButton("pause");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Facon de fermer les fenetre
        windowSlider.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowSliderFPS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setResizable(false); //On bloque la redimension
        window.setTitle("Projet SMA");

        GamePanel gamePanel = new GamePanel();//on initialise le gamepanel


        pSetup.add(gamePanel.slider);//on ajoute les Sliders et les labels a la fenêtre
        pSetup.add(gamePanel.label4);
        gamePanel.slider.setPaintTrack(true);// on initialise les attributs du slider
        gamePanel.slider.setPaintTicks(true);
        gamePanel.slider.setPaintLabels(true);
        gamePanel.slider.setMajorTickSpacing(25);
        gamePanel.slider.setMinorTickSpacing(10);

        pSetup.add(gamePanel.slider2);
        pSetup.add(gamePanel.label5);
        gamePanel.slider2.setPaintTrack(true);
        gamePanel.slider2.setPaintTicks(true);
        gamePanel.slider2.setPaintLabels(true);
        gamePanel.slider2.setMajorTickSpacing(25);
        gamePanel.slider2.setMinorTickSpacing(10);

        pSetup.add(gamePanel.slider3);
        pSetup.add(gamePanel.label6);
        gamePanel.slider3.setPaintTrack(true);
        gamePanel.slider3.setPaintTicks(true);
        gamePanel.slider3.setPaintLabels(true);
        gamePanel.slider3.setMajorTickSpacing(25);
        gamePanel.slider3.setMinorTickSpacing(10);

        pSetup.add(btn);

        pSetFPS.add(gamePanel.sliderSetFPS);
        pSetFPS.add(gamePanel.labelSetFPS);
        gamePanel.sliderSetFPS.setPaintTrack(true);
        gamePanel.sliderSetFPS.setPaintTicks(true);
        gamePanel.sliderSetFPS.setPaintLabels(true);
        gamePanel.sliderSetFPS.setMajorTickSpacing(50);
        gamePanel.sliderSetFPS.setMinorTickSpacing(25);

        gamePanel.label4.setText("nombre de medecin (bleu) : " + gamePanel.slider.getValue());// on initialise le texte de chaque label
        gamePanel.label5.setText("nombre patient (noir) : " + gamePanel.slider2.getValue());
        gamePanel.label6.setText("nombre visiteur (gris) :  " + gamePanel.slider3.getValue());
        gamePanel.labelSetFPS.setText("nombre de FPS (vitesse) :  " + gamePanel.sliderSetFPS.getValue());

        windowSlider.add(pSetup);//on ajoute les panels aux fenêtres de paramétrage
        windowSliderFPS.add(pSetFPS);

        pGame.add(gamePanel.label);// on ajoute les labels au panel de jeux
        pGame.add(gamePanel.label3);
        gamePanel.label.setForeground(Color.RED);//on colore les labels
        gamePanel.label3.setForeground(Color.RED);
        pGame.add(btnpause);// on ajoute le bouton pause au panel de jeu
        pGame.add(gamePanel);// on ajoute le jeu au panel de jeu
        window.add(pGame);//on ajoute le panel de jeu a la fenêtre de jeu
        window.pack();

        windowSliderFPS.setSize(210,100);// on définit la taille de chaque fenêtre
        windowSlider.setSize(250, 250);
        window.setSize(1210,1000);

        windowSlider.setUndecorated(true);// on supprime les bordures des fenêtres de paramétrage
        windowSliderFPS.setUndecorated(true);

        windowSlider.setLocationRelativeTo(null);// affiche la fenetre au milieu
        window.setLocation(200,0); // on définit la position des fenêtres
        windowSliderFPS.setLocation(0,400);

        windowSlider.setVisible(true);//on rend la fenêtre visible de paramétrage


        btnpause.addActionListener(new ActionListener() {//on crée l'action qu'exécute le bouton quand on appuie
            @Override
            public void actionPerformed(ActionEvent e) {//le bouton passe de pause a play quand on appuie dessus
                if (gamePanel.pause) {
                    gamePanel.pause = false;
                    btnpause.setText("pause");
                }
                else {
                    gamePanel.pause = true;
                    btnpause.setText("play");
                }
            }
        });
        btn.addActionListener(new ActionListener() {//on crée l'action qu'exécute le bouton quand on appuie
            @Override
            public void actionPerformed(ActionEvent e) {// lance le jeu
                window.setVisible(true);
                windowSliderFPS.setVisible(true);
                windowSlider.setVisible(false);
                gamePanel.setupGame();// actualise les parametres de départ
                gamePanel.startGameThread();// lance le Thread
            }
        });
        gamePanel.slider.addChangeListener(new ChangeListener() {//on crée l'action qu'exécute le slider quand on le bouge
            @Override
            public void stateChanged(ChangeEvent e) {
                gamePanel.label4.setText("nombre de medecin (bleu) : " + gamePanel.slider.getValue());
                //le texte du label s'actualise
            }
        });
        gamePanel.slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gamePanel.label5.setText("nombre patient (noir) : " + gamePanel.slider2.getValue());

            }
        });
        gamePanel.slider3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gamePanel.label6.setText("nombre visiteur (gris) : " + gamePanel.slider3.getValue());

            }
        });

        gamePanel.sliderSetFPS.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gamePanel.labelSetFPS.setText("nombre de FPS (vitesse) :  " + gamePanel.sliderSetFPS.getValue());

            }
        });
    }
}

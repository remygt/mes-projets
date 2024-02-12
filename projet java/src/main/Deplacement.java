package main;

import entity.Entity;
import entity.Medecin;

import java.util.ArrayDeque;
import java.util.Queue;

import static tiles.TileManager.mapTileNum;

public class Deplacement {
    GamePanel gp;
    private static final int[] row = { -1, 0, 0, 1 };
    private static final int[] col = { 0, -1, 1, 0 };

    public Deplacement(GamePanel gp) {
        this.gp = gp;
    }
    class Node
    {    int x, y, dist;

        Node(int x, int y, int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    // PERMET DE REGARDER SI IL PEUT OU PAS ALLER SUR TEL CASE
    private static boolean isValid(Entity entity, boolean[][] visited, int i, int j)
    {
        if (i>119 || j>79){
            return false;
        }
        if (i== entity.interX && j== entity.interY){
            return false;
        }
        if(entity.getClass().getSimpleName().equalsIgnoreCase("Medecin"))
            return ((mapTileNum[i][j] != 9) && (mapTileNum[i][j] != 4) && (mapTileNum[i][j] != 22) && (mapTileNum[i][j] != 33 ) && (mapTileNum[i][j] != 8 ) && (mapTileNum[i][j] != 10 )&& (mapTileNum[i][j] != 19 ) && (mapTileNum[i][j] != 20 ) && (mapTileNum[i][j] != 21 )  && ! visited[i][j]);
        else
            return ((mapTileNum[i][j] != 9) && (mapTileNum[i][j] != 4)  && (mapTileNum[i][j] != 22) && (mapTileNum[i][j] != 33 ) && (mapTileNum[i][j] != 8 ) && (mapTileNum[i][j] != 34 ) && (mapTileNum[i][j] != 35 ) && (mapTileNum[i][j] != 36 )  && (mapTileNum[i][j] != 37 )&& (mapTileNum[i][j] != 19 ) && (mapTileNum[i][j] != 20 ) && (mapTileNum[i][j] != 21 )&& ! visited[i][j]);

    }
    private boolean isValid2(Entity entity, boolean[][] visited, int i, int j)
    {
        if (i>119 || j>79){
            return false;
        }
        if (i== entity.interX && j== entity.interY){
            return false;
        }
        if (gp.mapCoverage[i][j]==1){return false;}
        if(entity.getClass().getSimpleName().equalsIgnoreCase("Medecin"))
            return ((mapTileNum[i][j] != 9) && (mapTileNum[i][j] != 4) && (mapTileNum[i][j] != 22) && (mapTileNum[i][j] != 33 ) && (mapTileNum[i][j] != 8 ) && (mapTileNum[i][j] != 10 )&& (mapTileNum[i][j] != 19 ) && (mapTileNum[i][j] != 20 ) && (mapTileNum[i][j] != 21 )  && ! visited[i][j]);
        else
            return ((mapTileNum[i][j] != 9) && (mapTileNum[i][j] != 4)  && (mapTileNum[i][j] != 22) && (mapTileNum[i][j] != 33 ) && (mapTileNum[i][j] != 8 ) && (mapTileNum[i][j] != 34 ) && (mapTileNum[i][j] != 35 ) && (mapTileNum[i][j] != 36 )  && (mapTileNum[i][j] != 37 )&& (mapTileNum[i][j] != 19 ) && (mapTileNum[i][j] != 20 ) && (mapTileNum[i][j] != 21 )&& ! visited[i][j]);

    }
    public static boolean isValid(Entity entity, int i, int j)
    {
        if(entity.getClass().getSimpleName().equalsIgnoreCase("Medecin"))
            return ((mapTileNum[i][j] != 9) && (mapTileNum[i][j] != 4) && (mapTileNum[i][j] != 22) && (mapTileNum[i][j] != 33 ) && (mapTileNum[i][j] != 8 )&& (mapTileNum[i][j] != 10 )&& (mapTileNum[i][j] != 19 ) && (mapTileNum[i][j] != 20 ) && (mapTileNum[i][j] != 21 ) );
        else
            return ((mapTileNum[i][j] != 9) && (mapTileNum[i][j] != 4) && (mapTileNum[i][j] != 22) && (mapTileNum[i][j] != 33 ) && (mapTileNum[i][j] != 8 ) && (mapTileNum[i][j] != 34 ) && (mapTileNum[i][j] != 35 ) && (mapTileNum[i][j] != 36 )  && (mapTileNum[i][j] != 37 )&& (mapTileNum[i][j] != 19 ) && (mapTileNum[i][j] != 20 ) && (mapTileNum[i][j] != 21 ));

    }

    // ALGORITHME DE LEE REVISITE AFIN DE GARDER LE PARCOURS EN MEMOIRE

    public int[][][] Chemin(Entity entity,int startX, int startY,int finishX, int finishY){


        boolean[][] deja_visite = new boolean[120][81];
        Queue<Node> q = new ArrayDeque<>();
        deja_visite[startX][startY] = true;
        q.add(new Node(startX, startY, 0));
        int [][][] pred = new int[120][81][2];

        while (!q.isEmpty()) {

            Node node = q.poll();
            startX = node.x;
            startY = node.y;
            int dist = node.dist;
            if (startX == finishX && startY == finishY) {
                pred[startX][startY][0] = dist;
                pred[startX][startY][1] = 1;





                break;
            }
            for (int k = 0; k < 4; k++) {
                if (isValid(entity,deja_visite, startX + row[k], startY + col[k])) {
                    deja_visite[startX + row[k]][startY + col[k]] = true;
                    pred[startX][startY][0] = dist;
                    pred[startX][startY][1] = 1;
                    q.add(new Node(startX + row[k], startY + col[k], dist + 1));

                }
            }


        }

        return pred;


    }
    public int[][][] cheminInterdit(Entity entity,int startX, int startY,int finishX, int finishY, int interX, int interY){
        boolean[][] deja_visite = new boolean[120][81];
        Queue<Node> q = new ArrayDeque<>();
        deja_visite[startX][startY] = true;
        q.add(new Node(startX, startY, 0));
        int [][][] pred = new int[120][81][2];

        while (!q.isEmpty()) {

            Node node = q.poll();
            startX = node.x;
            startY = node.y;
            int dist = node.dist;

            if (startX == finishX && startY == finishY) {


                pred[startX][startY][0] = dist;
                pred[startX][startY][1] = 1;


                break;
            }
            for (int k = 0; k < 4; k++) {

                if ((isValid2(entity,deja_visite, startX + row[k], startY + col[k]))) {
                    deja_visite[startX + row[k]][startY + col[k]] = true;
                    pred[startX][startY][0] = dist;
                    pred[startX][startY][1] = 1;
                    q.add(new Node(startX + row[k], startY + col[k], dist + 1));

                }
            }



        }



        return pred;
    }
    public void checkDeplacement(Entity entity){
        int[][][] liste = new int[0][0][0];
        boolean interdit = false;

        if (entity.getDirection().equalsIgnoreCase("down")){
            if (gp.mapCoverage[entity.x][entity.y+1]==1){
                interdit = true;
                entity.interX = entity.x;
                entity.interY = entity.y+1;
                liste = cheminInterdit(entity, entity.finishX, entity.finishY, entity.x, entity.y, entity.x,entity.y+1) ;
            }

        }
        else if (entity.getDirection().equalsIgnoreCase("up")){
            if (gp.mapCoverage[entity.x][entity.y-1]==1){
                interdit = true;
                entity.interX = entity.x;
                entity.interY = entity.y-1;
                liste = cheminInterdit(entity, entity.finishX, entity.finishY, entity.x, entity.y, entity.x,entity.y-1);

            }
        }
        else if (entity.getDirection().equalsIgnoreCase("left")){
            if (gp.mapCoverage[entity.x-1][entity.y]==1){
                entity.interX = entity.x-1;
                entity.interY = entity.y;
                interdit = true;
                liste = cheminInterdit(entity, entity.finishX, entity.finishY, entity.x, entity.y, entity.x-1,entity.y);

            }

        }
        else if (entity.getDirection().equalsIgnoreCase("right")){
            if (gp.mapCoverage[entity.x+1][entity.y]==1){
                entity.interX = entity.x+1;
                entity.interY = entity.y;

                interdit = true;
                liste = cheminInterdit(entity, entity.finishX, entity.finishY, entity.x, entity.y, entity.x+1,entity.y);

            }

        }
        if (interdit){



            if (liste[entity.x][entity.y-1][0]!=0){
                entity.liste_depla = liste;
                entity.setDirection("up");
            }
            else if (liste[entity.x][entity.y+1][0]!=0){
                entity.liste_depla = liste;
                entity.setDirection("down");
            }
            else if (liste[entity.x+1][entity.y][0]!=0){
                entity.liste_depla = liste;
                entity.setDirection("right");
            }
            else if (liste[entity.x-1][entity.y][0]!=0){
                entity.liste_depla = liste;
                entity.setDirection("left");
            }
            else{
                entity.pause = true;
            }
        }
    }

}


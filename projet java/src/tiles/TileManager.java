package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
// le TileManager va servir à associer chaque numéro de la map au format txt,
// en image (chaise, bureau, sol, tout ce qui est visible en temps qu'image sur la map),
// toutes présentes dans le dossier map.
public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public static int[][] mapTileNum;

    public TileManager(GamePanel gp){

        this.gp = gp;
        tile = new Tile[150];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("maps/mapfinal.txt"); // On appelle ici la map à lire
    }

    private void getTileImage() { // Et l'associatino se fait ici :
        try{
            tile[0] =new Tile();
            tile[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/herbe.png"));

            tile[1] =new Tile();
            tile[1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/road1.png"));

            tile[2] =new Tile();
            tile[2].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/allee.png"));

            tile[3] =new Tile();
            tile[3].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/tiroirs_haut.png"));

            tile[4] =new Tile();
            tile[4].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/bordure.png"));

            tile[5] =new Tile();
            tile[5].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/carre_sol.png"));

            tile[6] =new Tile();
            tile[6].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/tiroirs_droit.png"));

            tile[7] =new Tile();
            tile[7].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/tiroirs_gauche.png"));

            tile[8] =new Tile();
            tile[8].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/tiroirs_bas.png"));

            tile[9] =new Tile();
            tile[9].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/jaune.png"));

            tile[10] =new Tile();
            tile[10].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/lit_bas.png"));

            tile[11] =new Tile();
            tile[11].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/lit_haut_2.png"));

            tile[12] =new Tile();
            tile[12].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/lit_haut.png"));

            tile[13] =new Tile();
            tile[13].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/lit_haut_1.png"));

            tile[14] =new Tile();
            tile[14].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/lit_haut_(2).png"));

            tile[15] =new Tile();
            tile[15].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/armoire_2.png"));

            tile[16] =new Tile();
            tile[16].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/armoire_3.png"));

            tile[17] =new Tile();
            tile[17].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/armoire_4.png"));

            tile[18] =new Tile();
            tile[18].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/armoire.png"));

            tile[20] =new Tile();
            tile[20].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/chaise_pixels_droit.png"));

            tile[19] =new Tile();
            tile[19].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/chaise_pixels_gauche.png"));

            tile[21] =new Tile();
            tile[21].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/chaise_pixels_gauche.png"));

            tile[22] =new Tile();
            tile[22].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/image_table.png"));

            tile[23] =new Tile();
            tile[23].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/table_bas_gauche.png"));

            tile[24] =new Tile();
            tile[24].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/table_bas_droit.png"));

            tile[25] =new Tile();
            tile[25].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/porte_bas.png"));

            tile[26] =new Tile();
            tile[26].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/porte_droit_(2).png"));

            tile[27] =new Tile();
            tile[27].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/porte_droit.png"));

            tile[28] =new Tile();
            tile[28].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/porte_gauche_(2).png"));

            tile[29] =new Tile();
            tile[29].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/porte_gauche.png"));

            tile[30] =new Tile();
            tile[30].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/porte_haut_(2).png"));

            tile[31] =new Tile();
            tile[31].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/porte_haut.png"));

            tile[32] =new Tile();
            tile[32].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/porte.png"));

            tile[34] =new Tile();
            tile[34].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/porte_bas_Médecin.png"));

            tile[35] =new Tile();
            tile[35].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/porte_droit_Médecin.png"));

            tile[36] =new Tile();
            tile[36].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/porte_gauche_Médecin.png"));

            tile[37] =new Tile();
            tile[37].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/porte_haut_Médecin.png"));

            tile[38] =new Tile();
            tile[38].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/boy_blanc_left_1.png"));
            tile[44] =new Tile();
            tile[44].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/sol_devant.png"));

            // LOGO HOPITAL
            tile[51] =new Tile();
            tile[51].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-1-column-1.png"));
            tile[52] =new Tile();
            tile[52].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-1-column-2.png"));
            tile[53] =new Tile();
            tile[53].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-1-column-3.png"));
            tile[54] =new Tile();
            tile[54].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-1-column-4.png"));
            tile[55] =new Tile();
            tile[55].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-1-column-5.png"));
            tile[56] =new Tile();
            tile[56].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-1-column-6.png"));
            tile[57] =new Tile();
            tile[57].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-1-column-7.png"));
            tile[58] =new Tile();
            tile[58].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-2-column-1.png"));
            tile[59] =new Tile();
            tile[59].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-2-column-2.png"));
            tile[60] =new Tile();
            tile[60].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-2-column-3.png"));
            tile[61] =new Tile();
            tile[61].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-2-column-4.png"));
            tile[62] =new Tile();
            tile[62].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-2-column-5.png"));
            tile[63] =new Tile();
            tile[63].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-2-column-6.png"));
            tile[64] =new Tile();
            tile[64].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-2-column-7.png"));
            tile[65] =new Tile();
            tile[65].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-3-column-1.png"));
            tile[66] =new Tile();
            tile[66].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-3-column-2.png"));
            tile[67] =new Tile();
            tile[67].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-3-column-3.png"));
            tile[68] =new Tile();
            tile[68].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-3-column-4.png"));
            tile[69] =new Tile();
            tile[69].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-3-column-5.png"));
            tile[70] =new Tile();
            tile[70].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-3-column-6.png"));
            tile[71] =new Tile();
            tile[71].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-3-column-7.png"));
            tile[72] =new Tile();
            tile[72].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-4-column-1.png"));
            tile[73] =new Tile();
            tile[73].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-4-column-2.png"));
            tile[74] =new Tile();
            tile[74].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-4-column-3.png"));
            tile[75] =new Tile();
            tile[75].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-4-column-4.png"));
            tile[76] =new Tile();
            tile[76].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-4-column-5.png"));
            tile[77] =new Tile();
            tile[77].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-4-column-6.png"));
            tile[78] =new Tile();
            tile[78].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-4-column-7.png"));
            tile[79] =new Tile();
            tile[79].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-5-column-1.png"));
            tile[80] =new Tile();
            tile[80].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-5-column-2.png"));
            tile[81] =new Tile();
            tile[81].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-5-column-3.png"));
            tile[82] =new Tile();
            tile[82].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-5-column-4.png"));
            tile[83] =new Tile();
            tile[83].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-5-column-5.png"));
            tile[84] =new Tile();
            tile[84].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-5-column-6.png"));
            tile[85] =new Tile();
            tile[85].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-5-column-7.png"));
            tile[86] =new Tile();
            tile[86].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-6-column-1.png"));
            tile[87] =new Tile();
            tile[87].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-6-column-2.png"));
            tile[88] =new Tile();
            tile[88].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-6-column-3.png"));
            tile[89] =new Tile();
            tile[89].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-6-column-4.png"));
            tile[90] =new Tile();
            tile[90].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-6-column-5.png"));
            tile[91] =new Tile();
            tile[91].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-6-column-6.png"));
            tile[92] =new Tile();
            tile[92].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-6-column-7.png"));
            tile[93] =new Tile();
            tile[93].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-7-column-1.png"));
            tile[94] =new Tile();
            tile[94].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-7-column-2.png"));
            tile[95] =new Tile();
            tile[95].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-7-column-3.png"));
            tile[96] =new Tile();
            tile[96].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-7-column-4.png"));
            tile[97] =new Tile();
            tile[97].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-7-column-5.png"));
            tile[98] =new Tile();
            tile[98].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-7-column-6.png"));
            tile[99] =new Tile();
            tile[99].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/row-7-column-7.png"));

            //VOITURES

            tile[101] =new Tile();
            tile[101].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_jaune_row-1-column-1.png"));
            tile[102] =new Tile();
            tile[102].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_jaune_row-1-column-2.png"));
            tile[103] =new Tile();
            tile[103].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_jaune_row-2-column-1.png"));
            tile[104] =new Tile();
            tile[104].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_jaune_row-2-column-2.png"));

            tile[105] =new Tile();
            tile[105].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_rouge_row-1-column-1.png"));
            tile[106] =new Tile();
            tile[106].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_rouge_row-1-column-2.png"));
            tile[107] =new Tile();
            tile[107].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_rouge_row-2-column-1.png"));
            tile[108] =new Tile();
            tile[108].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_rouge_row-2-column-2.png"));

            tile[109] =new Tile();
            tile[109].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_rose_row-1-column-1.png"));
            tile[110] =new Tile();
            tile[110].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_rose_row-1-column-2.png"));
            tile[111] =new Tile();
            tile[111].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_rose_row-2-column-1.png"));
            tile[112] =new Tile();
            tile[112].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_rose_row-2-column-2.png"));

            tile[113] =new Tile();
            tile[113].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_orange_row-1-column-1.png"));
            tile[114] =new Tile();
            tile[114].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_orange_row-1-column-2.png"));
            tile[115] =new Tile();
            tile[115].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_orange_row-2-column-1.png"));
            tile[116] =new Tile();
            tile[116].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/voiture_orange_row-2-column-2.png"));
            tile[140] =new Tile();
            tile[140].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("map/passage_pieton.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath){
        try{
            InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);


            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row =0;
            while (col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();

                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(";");// Ici on précise à l'algorithme que chaque nombre
                    int num = Integer.parseInt(numbers[col]);// est séparé d'un ;
                    mapTileNum[col][row] = num;
                    col++;

                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
    }catch (Exception e){
        }

    }
    public void draw (Graphics2D g2){ // La fonction draw va, comme son nom l'indique, servir à dessiner la map.txt
        // en prenant en compte le nombres de lignes et le nombres de colonnes


        int worldCol = 0;
        int worldRow =0;
        while(worldCol<gp.maxWorldCol && worldRow<gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;


            g2.drawImage(tile[tileNum].image, worldX, worldY, gp.tileSize, gp.tileSize, null);
            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;

            }


        }
    }

}

package entity;



public class Lieu {
    int[] lieu = new int[8];

    public int[] sorti() {
        lieu[0]=5;
        lieu[1]=3;
        return lieu;
    }
    public int[] accueil() {
        lieu[0]=4;
        lieu[1]=36;
        lieu[2]=4;
        lieu[3]=50;
        return lieu;
    }

    public int[] chambrePatient(int i) {


        switch (i) {
            case 0:
                lieu[0] = 16; // patient
                lieu[1] = 53;
                lieu[2] = 16; // medecin
                lieu[3] = 54;
                lieu[4] = 17; // visiteur chambre
                lieu[5] = 53;
                lieu[6] = 19; // siege visiteur
                lieu[7] = 52;
                break;
            case 1:
                lieu[0] = 15; // patient
                lieu[1] = 24;
                lieu[2] = 15; // medecin
                lieu[3] = 25;
                lieu[4] = 17; // visiteur chambre
                lieu[5] = 24;
                lieu[6] = 21; // siege visiteur
                lieu[7] = 29;
                break;



            case 2:
                lieu[0] = 15; // patient
                lieu[1] = 19;
                lieu[2] = 15; // medecin
                lieu[3] = 20;
                lieu[4] = 16; // visiteur chambre
                lieu[5] = 19;
                lieu[6] = 21; // siege visiteur
                lieu[7] = 22;
                break;


            case 27:
                lieu[0] = 15; // patient
                lieu[1] = 9;
                lieu[2] = 14; // medecin
                lieu[3] = 9;
                lieu[4] = 16; // visiteur chambre
                lieu[5] = 9;
                lieu[6] = 21; // siege visiteur
                lieu[7] = 17;
                break;

            case 4:
                lieu[0] = 20; // patient
                lieu[1] = 9;
                lieu[2] = 20; // medecin
                lieu[3] = 10;
                lieu[4] = 21; // visiteur chambre
                lieu[5] = 9;
                lieu[6] = 23; // siege visiteur
                lieu[7] = 15;
                break;

            case 28:
                lieu[0] = 25; // patient
                lieu[1] = 9;
                lieu[2] = 25; // medecin
                lieu[3] = 10;
                lieu[4] = 26; // visiteur chambre
                lieu[5] = 9;
                lieu[6] = 25; // siege visiteur
                lieu[7] = 15;
                break;

            case 6:
                lieu[0] = 30; // patient
                lieu[1] = 9;
                lieu[2] = 30; // medecin
                lieu[3] = 10;
                lieu[4] = 31; // visiteur chambre
                lieu[5] = 9;
                lieu[6] = 34; // siege visiteur
                lieu[7] = 15;
                break;

            case 15:
                lieu[0] = 35; // patient
                lieu[1] = 9;
                lieu[2] = 35; // medecin
                lieu[3] = 10;
                lieu[4] = 36; // visiteur chambre
                lieu[5] = 9;
                lieu[6] = 35; // siege visiteur
                lieu[7] = 15;
                break;
            case 8:
                lieu[0] = 40; // patient
                lieu[1] = 9;
                lieu[2] = 40; // medecin
                lieu[3] = 10;
                lieu[4] = 41; // visiteur chambre
                lieu[5] = 9;
                lieu[6] = 44; // siege visiteur
                lieu[7] = 15;
                break;
            case 11:
                lieu[0] = 45; // patient
                lieu[1] = 9;
                lieu[2] = 45; // medecin
                lieu[3] = 10;
                lieu[4] = 46; // visiteur chambre
                lieu[5] = 9;
                lieu[6] = 48; // siege visiteur
                lieu[7] = 15;
                break;
            case 10:
                lieu[0] = 50; // patient
                lieu[1] = 9;
                lieu[2] = 50; // medecin
                lieu[3] = 10;
                lieu[4] = 51; // visiteur chambre
                lieu[5] = 9;
                lieu[6] = 50; // siege visiteur
                lieu[7] = 15;
                break;
            case 26:
                lieu[0] = 55; // patient
                lieu[1] = 9;
                lieu[2] = 55; // medecin
                lieu[3] = 10;
                lieu[4] = 56; // visiteur chambre
                lieu[5] = 9;
                lieu[6] = 54; // siege visiteur
                lieu[7] = 15;
                break;
            case 12:
                lieu[0] = 60; // patient
                lieu[1] = 9;
                lieu[2] = 60; // medecin
                lieu[3] = 10;
                lieu[4] = 61; // visiteur chambre
                lieu[5] = 9;
                lieu[6] = 60; // siege visiteur
                lieu[7] = 15;
                break;
            case 21:
                lieu[0] = 65; // patient
                lieu[1] = 9;
                lieu[2] = 65; // medecin
                lieu[3] = 10;
                lieu[4] = 66; // visiteur chambre
                lieu[5] = 9;
                lieu[6] = 65; // siege visiteur
                lieu[7] = 15;
                break;
            case 14:
                lieu[0] = 70; // patient
                lieu[1] = 9;
                lieu[2] = 70; // medecin
                lieu[3] = 10;
                lieu[4] = 71; // visiteur chambre
                lieu[5] = 9;
                lieu[6] = 70; // siege visiteur
                lieu[7] = 15;
                break;
            case 7:
                lieu[0] = 75; // patient
                lieu[1] = 9;
                lieu[2] = 75; // medecin
                lieu[3] = 10;
                lieu[4] = 76; // visiteur chambre
                lieu[5] = 10;
                lieu[6] = 76; // siege visiteur
                lieu[7] = 15;
                break;
            case 16:
                lieu[0] = 80; // patient
                lieu[1] = 9;
                lieu[2] = 80; // medecin
                lieu[3] = 10;
                lieu[4] = 81; // visiteur chambre
                lieu[5] = 9;
                lieu[6] = 80; // siege visiteur
                lieu[7] = 15;
                break;
            case 24:
                lieu[0] = 89; // patient
                lieu[1] = 10;
                lieu[2] = 89; // medecin
                lieu[3] = 9;
                lieu[4] = 89; // visiteur chambre
                lieu[5] = 13;
                lieu[6] = 83; // siege visiteur
                lieu[7] = 15;
                break;
            case 18:
                lieu[0] = 89; // patient
                lieu[1] = 18;
                lieu[2] = 89; // medecin
                lieu[3] = 17;
                lieu[4] = 89; // visiteur chambre
                lieu[5] = 19;
                lieu[6] = 84; // siege visiteur
                lieu[7] = 17;
                break;
            case 30:
                lieu[0] = 89; // patient
                lieu[1] = 23;
                lieu[2] = 89; // medecin
                lieu[3] = 22;
                lieu[4] = 89; // visiteur chambre
                lieu[5] = 24;
                lieu[6] = 84; // siege visiteur
                lieu[7] = 24;
                break;
            case 20:
                lieu[0] = 89; // patient
                lieu[1] = 28;
                lieu[2] = 89; // medecin
                lieu[3] = 27;
                lieu[4] = 89; // visiteur chambre
                lieu[5] = 29;
                lieu[6] = 84; // siege visiteur
                lieu[7] = 26;
                break;


            case 13:
                lieu[0] = 89; // patient
                lieu[1] = 33;
                lieu[2] = 89; // medecin
                lieu[3] = 32;
                lieu[4] = 89; // visiteur chambre
                lieu[5] = 34;
                lieu[6] = 84; // siege visiteur
                lieu[7] = 30;
                break;


            case 22:
                lieu[0] = 89; // patient
                lieu[1] = 38;
                lieu[2] = 89; // medecin
                lieu[3] = 37;
                lieu[4] = 89; // visiteur chambre
                lieu[5] = 39;
                lieu[6] = 84; // siege visiteur
                lieu[7] = 37;
                break;
            case 23:
                lieu[0] = 89; // patient
                lieu[1] = 43;
                lieu[2] = 89; // medecin
                lieu[3] = 42;
                lieu[4] = 89; // visiteur chambre
                lieu[5] = 44;
                lieu[6] = 84; // siege visiteur
                lieu[7] = 41;
                break;
            case 17:
                lieu[0] = 89; // patient
                lieu[1] = 48;
                lieu[2] = 89; // medecin
                lieu[3] = 47;
                lieu[4] = 89; // visiteur chambre
                lieu[5] = 49;
                lieu[6] = 84; // siege visiteur
                lieu[7] = 50;
                break;
            case 25:
                lieu[0] = 89; // patient
                lieu[1] = 53;
                lieu[2] = 89; // medecin
                lieu[3] = 52;
                lieu[4] = 89; // visiteur chambre
                lieu[5] = 54;
                lieu[6] = 84; // siege visiteur
                lieu[7] = 52;
                break;
            case 9:
                lieu[0] = 89; // patient
                lieu[1] = 58;
                lieu[2] = 89; // medecin
                lieu[3] = 57;
                lieu[4] = 89; // visiteur chambre
                lieu[5] = 59;
                lieu[6] = 84; // siege visiteur
                lieu[7] = 58;
                break;
            case 3:
                lieu[0] = 89; // patient
                lieu[1] = 63;
                lieu[2] = 89; // medecin
                lieu[3] = 62;
                lieu[4] = 89; // visiteur chambre
                lieu[5] = 64;
                lieu[6] = 84; // siege visiteur
                lieu[7] = 62;
                break;
            case 5:
                lieu[0] = 89; // patient
                lieu[1] = 68;
                lieu[2] = 89; // medecin
                lieu[3] = 67;
                lieu[4] = 89; // visiteur chambre
                lieu[5] = 69;
                lieu[6] = 84;// siege visiteur
                lieu[7] = 69;
                break;
            case 29:
                lieu[0] = 15; // patient
                lieu[1] = 72;
                lieu[2] = 14; // medecin
                lieu[3] = 72;
                lieu[4] = 16; // visiteur chambre
                lieu[5] = 72;
                lieu[6] = 21; // siege visiteur
                lieu[7] = 70;
                break;
            case 19:
                lieu[0] = 15; // patient
                lieu[1] = 66;
                lieu[2] = 14; // medecin
                lieu[3] = 66;
                lieu[4] = 16; // visiteur chambre
                lieu[5] = 66;
                lieu[6] = 21; // siege visiteur
                lieu[7] = 64;
                break;
            case 31:
                lieu[0] = 17; // patient
                lieu[1] = 60;
                lieu[2] = 17; // medecin
                lieu[3] = 61;
                lieu[4] = 17; // visiteur chambre
                lieu[5] = 59;
                lieu[6] = 21; // siege visiteur
                lieu[7] = 58;
                break;



        }
        return lieu;
    }
    public int[] chambreRea(int i) {

        switch (i) {
            case 0:
                lieu[0] = 88;
                lieu[1] = 76;
                lieu[2] = 88;
                lieu[3] = 75;
                break;
            case 1:
                lieu[0] = 84;
                lieu[1] = 76;
                lieu[2] = 84;
                lieu[3] = 75;
                break;

            case 2:
                lieu[0] = 79;
                lieu[1] = 76;
                lieu[2] = 79;
                lieu[3] = 75;
                break;




            case 3:
                lieu[0] = 74;
                lieu[1] = 76;
                lieu[2] = 74;
                lieu[3] = 75;
                break;




            case 4:
                lieu[0] = 69;
                lieu[1] = 76;
                lieu[2] = 69;
                lieu[3] = 75;
                break;



            case 5:
                lieu[0] = 64;
                lieu[1] = 76;
                lieu[2] = 64;
                lieu[3] = 75;
                break;



            case 6:
                lieu[0] = 59;
                lieu[1] = 76;
                lieu[2] = 59;
                lieu[3] = 75;
                break;



            case 7:
                lieu[0] = 54;
                lieu[1] = 76;
                lieu[2] = 54;
                lieu[3] = 75;
                break;

            case 8:
                lieu[0] = 49;
                lieu[1] = 76;
                lieu[2] = 49;
                lieu[3] = 75;
                break;

            case 9:
                lieu[0] = 44;
                lieu[1] = 76;
                lieu[2] = 44;
                lieu[3] = 75;
                break;
            case 10:
                lieu[0] = 39;
                lieu[1] = 76;
                lieu[2] = 39;
                lieu[3] = 75;
                break;
            case 11:
                lieu[0] = 34;
                lieu[1] = 76;
                lieu[2] = 34;
                lieu[3] = 75;
                break;
            case 12:
                lieu[0] = 29;
                lieu[1] = 76;
                lieu[2] = 28;
                lieu[3] = 75;
                break;
            case 13:
                lieu[0] = 24;
                lieu[1] = 76;
                lieu[2] = 24;
                lieu[3] = 75;
                break;
            case 14:
                lieu[0] = 15;
                lieu[1] = 76;
                lieu[2] = 14;
                lieu[3] = 76;
                break;
        }
        return lieu;
    }

    public int[] siegeMedecin(int i) {
        switch(i){

            case 0:
                lieu[0] = 60;
                lieu[1] = 23;
                break;

            case 1:
                lieu[0] = 62;
                lieu[1] = 23;
                break;

            case 2:
                lieu[0] = 71;
                lieu[1] = 23;
                break;

            case 3:
                lieu[0] = 73;
                lieu[1] = 23;
                break;

            case 4:
                lieu[0] = 60;
                lieu[1] = 29;
                break;

            case 5:
                lieu[0] = 62;
                lieu[1] = 29;
                break;

            case 6:
                lieu[0] = 71;
                lieu[1] = 29;
                break;

            case 7:
                lieu[0] = 73;
                lieu[1] = 29;
                break;

            case 8:
                lieu[0] = 58;
                lieu[1] = 25;
                break;

            case 9:
                lieu[0] = 58;
                lieu[1] = 28;
                break;

            case 10:
                lieu[0] = 64;
                lieu[1] = 25;
                break;

            case 11:
                lieu[0] = 64;
                lieu[1] = 28;
                break;


            case 12:
                lieu[0] = 69;
                lieu[1] = 28;
                break;

            case 13:
                lieu[0] = 69;
                lieu[1] = 25;
                break;

            case 14:
                lieu[0] = 75;
                lieu[1] = 28;
                break;

            case 15:
                lieu[0] = 75;
                lieu[1] = 25;
                break;

            case 16:
                lieu[0] = 60;
                lieu[1] = 33;
                break;

            case 17:
                lieu[0] = 62;
                lieu[1] = 33;
                break;

            case 18:
                lieu[0] = 60;
                lieu[1] = 39;
                break;

            case 19:
                lieu[0] = 62;
                lieu[1] = 39;
                break;

            case 20:
                lieu[0] = 58;
                lieu[1] = 35;
                break;

            case 21:
                lieu[0] = 58;
                lieu[1] = 38;
                break;

            case 22:
                lieu[0] = 64;
                lieu[1] = 35;
                break;

            case 23:
                lieu[0] = 64;
                lieu[1] = 38;
                break;


            case 24:
                lieu[0] = 69;
                lieu[1] = 35;
                break;

            case 25:
                lieu[0] = 69;
                lieu[1] = 38;
                break;

            case 26:
                lieu[0] = 75;
                lieu[1] = 35;
                break;

            case 27:
                lieu[0] = 75;
                lieu[1] = 38;
                break;

            case 28:
                lieu[0] = 71;
                lieu[1] = 33;
                break;

            case 29:
                lieu[0] = 73;
                lieu[1] = 33;
                break;

            case 30:
                lieu[0] = 71;
                lieu[1] = 39;
                break;

            case 31:
                lieu[0] = 73;
                lieu[1] = 39;
                break;

            case 32:
                lieu[0] = 33;
                lieu[1] = 20;
                break;

            case 33:
                lieu[0] = 36;
                lieu[1] = 20;
                break;


            case 34:
                lieu[0] = 56;
                lieu[1] = 49;
                break;

            case 35:
                lieu[0] = 59;
                lieu[1] = 49;
                break;

            case 36:
                lieu[0] = 61;
                lieu[1] = 49;
                break;

            case 37:
                lieu[0] = 69;
                lieu[1] = 49;
                break;

            case 38:
                lieu[0] = 72;
                lieu[1] = 49;
                break;

            case 39:
                lieu[0] = 75;
                lieu[1] = 49;
                break;

            case 40:
                lieu[0] = 78;
                lieu[1] = 49;
                break;

            case 41:
                lieu[0] = 72;
                lieu[1] = 58;
                break;

            case 42:
                lieu[0] = 33;
                lieu[1] = 20;
                break;

            case 43:
                lieu[0] = 62;
                lieu[1] = 57;
                break;

            case 44:
                lieu[0] = 56;
                lieu[1] = 57;
                break;

            case 45:
                lieu[0] = 62;
                lieu[1] = 62;
                break;

            case 46:
                lieu[0] = 61;
                lieu[1] = 62;
                break;

            case 47:
                lieu[0] = 48;
                lieu[1] = 67;
                break;

            case 48:
                lieu[0] = 32;
                lieu[1] = 64;
                break;

            case 49:
                lieu[0] = 31;
                lieu[1] = 64;
                break;


            case 50:
                lieu[0] = 34;
                lieu[1] = 56;
                break;

            case 51:
                lieu[0] = 45;
                lieu[1] = 52;
                break;

            case 52:
                lieu[0] = 45;
                lieu[1] = 54;
                break;

            case 53:
                lieu[0] = 49;
                lieu[1] = 52;
                break;

            case 54:
                lieu[0] = 49;
                lieu[1] = 54;
                break;


            case 55:
                lieu[0] = 35;
                lieu[1] = 33;
                break;

            case 56:
                lieu[0] = 39;
                lieu[1] = 32;
                break;

            case 57:
                lieu[0] = 48;
                lieu[1] = 32;
                break;

            case 58:
                lieu[0] = 48;
                lieu[1] = 39;
                break;


        }

        return lieu;
    }

    public int[] siegeVisiteur(int i) {

        switch (i) {

            case 0:
                lieu[0]=21;
                lieu[1]=48; //Entrée (attente d'accueil)
                break;

            case 1:
                lieu[0]=22;
                lieu[1]=50; //Entrée (attente d'accueil)
                break;


            case 3:
                lieu[0]=25;
                lieu[1]=50; //Entrée (attente d'accueil)
                break;

            case 4:
                lieu[0]=26;
                lieu[1]=48; //Entrée (attente d'accueil)
                break;




            case 9:
                lieu[0]=24;
                lieu[1]=39; //Salle de repos
                break;

            case 10:
                lieu[0]=22;
                lieu[1]=36; //Salle de repos
                break;

            case 11:
                lieu[0]=25;
                lieu[1]=36; //Salle de repos
                break;




            case 13:
                lieu[0]=29;
                lieu[1]=26; //Attente Accueil
                break;

            case 14:
                lieu[0]=30;
                lieu[1]=26; //Attente Accueil
                break;

            case 15:
                lieu[0]=31;
                lieu[1]=26; //Attente Accueil
                break;

            case 16:
                lieu[0]=32;
                lieu[1]=26; //Attente Accueil
                break;


            case 17:
                lieu[0]=43;
                lieu[1]=26; //Attente Accueil
                break;

            case 18:
                lieu[0]=44;
                lieu[1]=26; //Attente Accueil
                break;

            case 19:
                lieu[0]=45;
                lieu[1]=26; //Attente Accueil
                break;

            case 20:
                lieu[0]=46;
                lieu[1]=26; //Attente Accueil
                break;

            case 21:
                lieu[0]=47;
                lieu[1]=26; //Attente Accueil
                break;


            case 22:
                lieu[0]=38;
                lieu[1]=48; //Attente Accueil
                break;

            case 23:
                lieu[0]=39;
                lieu[1]=48; //Attente Accueil
                break;


            case 24:
                lieu[0]=44;
                lieu[1]=48; //Attente Accueil
                break;

            case 25:
                lieu[0]=45;
                lieu[1]=48; //Attente Accueil
                break;

            case 26:
                lieu[0]=46;
                lieu[1]=48; //Attente Accueil
                break;

            case 27:
                lieu[0]=47;
                lieu[1]=48; //Attente Accueil
                break;

            case 28:
                lieu[0]=48;
                lieu[1]=48; //Attente Accueil
                break;

            case 29:
                lieu[0]=49;
                lieu[1]=48; //Attente Accueil
                break;

            case 30:
                lieu[0]=50;
                lieu[1]=48; //Attente Accueil
                break;


            case 31:
                lieu[0]=53;
                lieu[1]=40; //Attente Accueil
                break;

            case 32:
                lieu[0]=53;
                lieu[1]=39; //Attente Accueil
                break;

            case 33:
                lieu[0]=53;
                lieu[1]=38; //Attente Accueil
                break;

            case 12:
                lieu[0]=53;
                lieu[1]=37; //Attente Accueil
                break;

            case 5:
                lieu[0]=53;
                lieu[1]=34; //Attente Accueil
                break;

            case 7:
                lieu[0]=53;
                lieu[1]=33; //Attente Accueil
                break;

            case 8:
                lieu[0]=53;
                lieu[1]=32; //Attente Accueil
                break;

            case 2:
                lieu[0]=53;
                lieu[1]=31; //Attente Accueil
                break;

            case 6:
                lieu[0]=53;
                lieu[1]=30; //Attente Accueil
                break;
        }
        return lieu;
    }
}

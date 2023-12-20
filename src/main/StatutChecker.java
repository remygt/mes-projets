package main;

import entity.Entity;
import entity.Lieu;

public class StatutChecker {
    GamePanel gp;
    Lieu lieu = new Lieu();
    public StatutChecker(GamePanel gp){
        this.gp =gp;

    }
    Deplacement depla;
    public void checkStatut() {

        for (int i = 0; i< Entity.toto.size(); i++){

            for (int j = 0; j< Entity.toto.size(); j++){
                if (j==i){
                    continue;
                }

                if (Entity.toto.get(i)!=null && Entity.toto.get(j)!=null) {
                    int positionx1 = (int)Math.round(Entity.toto.get(j).getPositionX());
                    int positionx2 =(int)Math.round(Entity.toto.get(i).getPositionX());
                    int positiony1 = (int)Math.round(Entity.toto.get(j).getPositionY());
                    int positiony2 =(int)Math.round(Entity.toto.get(i).getPositionY());

                    boolean c1 = positionx1 == positionx2 && positiony1 == positiony2;
                    boolean c2 = positionx1 == positionx2  && positiony1 + 1 == positiony2;
                    boolean c3 = positionx1 == positionx2 && positiony1 - 1 == positiony2 ;
                    boolean c4 = positionx1 == positionx2 + 1 && positiony1 == positiony2;
                    boolean c5 =positionx1 == positionx2 - 1 && positiony1 == positiony2;
                    boolean c10 = positionx1 == positionx2+1 && positiony1 == positiony2+1;
                    boolean c11= positionx1 == positionx2 -1 && positiony1  == positiony2 -1;
                    boolean c12 = positionx1 == positionx2 +1 && positiony1 == positiony2 -1;
                    boolean c13 = positionx1 == positionx2 - 1 && positiony1 == positiony2 +1 ;

                    boolean c6 = Entity.toto.get(j).getClass().getSimpleName().equalsIgnoreCase("Medecin");
                    boolean c7 = Entity.toto.get(i).getClass().getSimpleName().equalsIgnoreCase("Patient");
                    boolean c72 = Entity.toto.get(j).getClass().getSimpleName().equalsIgnoreCase("Patient");
                    boolean c8 = Entity.toto.get(j).getClass().getSimpleName().equalsIgnoreCase("Visiteur");
                    boolean c9 = Entity.toto.get(i).getClass().getSimpleName().equalsIgnoreCase("Visiteur");
                    Entity patient = Entity.toto.get(i);
                    Entity medecin = Entity.toto.get(j);
                    Entity visiteur = Entity.toto.get(j);
                    Entity perso1 = Entity.toto.get(i);
                    Entity perso2 = Entity.toto.get(j);

                    if (c1 || c2 || c3 || c4 || c5 || c10 || c11 || c12 || c13){
                        if ((c7 && c8) || (c8 && c9) || (c7 && c72) ){
                            if (patient.getCovid() == 1 && patient.tauxContamination >= visiteur.defenseImun) {
                                visiteur.setCovid(1);
                            }

                        }
                        if (c6 &&(c7 || c9)){
                            if (patient.getCovid() == 1 && patient.tauxContamination >= medecin.defenseImun) {
                                medecin.setCovid(1);
                            }
                        }
                    }






                    if (c1 || c2 || c3 || c4 || c5 ) {



                        if (c7 && patient.statut == 2 ){




                        }

                        if (c6 && c7){
                            if (patient.statut == 2 && medecin.statut == 2){
                                if (patient.getPositionX() == lieu.chambrePatient(patient.i)[0]
                                        && medecin.getPositionX() == lieu.chambrePatient(patient.i)[2]){
                                    if (gp.nbChambrePatient[patient.i][1] == 1 && c6){
                                        if (patient.compteur_stop == 10){
                                            patient.compteur_stop =0;
                                            int n = (int)(Math.random()*10);
                                            if (n== 7){
                                                patient.statut = 4;
                                                medecin.statut = 4;
                                            }
                                            else{

                                                patient.statut = 5;
                                                medecin.statut = 1;
                                                gp.nbChambrePatient[patient.i][0] = 0;
                                                gp.nbChambrePatient[patient.i][1] = 0;
                                            }

                                        }
                                        patient.compteur_stop +=1;




                                    }
                                }
                            }

                            if (patient.statut ==3 && medecin.statut == 3 ){


                                if (patient.getPositionX() == lieu.chambreRea(patient.i)[0]
                                        && medecin.getPositionX() == lieu.chambreRea(patient.i)[2] ){

                                    if (patient.compteur_stop == 10){
                                        patient.compteur_stop =0;
                                        patient.statut = 7;
                                        medecin.statut =1;

                                    }
                                    patient.compteur_stop +=1;



                                }



                            }
                            if (patient.statut == 4 && medecin.statut == 4) {

                                int m = 0;
                                boolean trouve = false;
                                while (!trouve && m < gp.nbChambreRea.length) {
                                    if (gp.nbChambreRea[m] == 0) {
                                        trouve = true;
                                        gp.nbChambreRea[m] = 1;
                                        patient.i = m;
                                        medecin.i = m;
                                        medecin.statut = 3;
                                        patient.statut =3;
                                    }
                                    m++;
                                }

                            }


                        }

                    }




                }
            }
        }
    }
}

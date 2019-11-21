/* 
 * Copyright 2019 Elísabet Palomino .
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;

/**
 *
 * @author Elísabet Palomino
 */
public class Main {

    public static final Random RND = new Random();

    public static void main(String[] args) {

        //Constantes
        final int MAX_DIAS = 7;
        final int MAX_LLUVIA = 500;
        final int MIN_LLUVIA = 0;

        //Variables
        int lluvia;
        int dia = 1;

        int lluviaMax = 0;
        int lluviaMin = 0;

        int diaMas = 0;
        int diaMenos = 0;

        double lluviaTot = 0;
        double mediaLluvia;

        //Bucle
        do {

            //Valor aleatorio lluvia
            lluvia = RND.nextInt(MAX_LLUVIA - MIN_LLUVIA + 1) + MIN_LLUVIA;

            //Mensaje
            System.out.printf("Lluvia del dia día %d .....................: "
                    + "%04d l/m\u00b2%n", dia, lluvia);

            //Condicion
            if (dia == 1) {
                lluviaMax = lluvia;
                diaMas = dia;
            } else if (lluvia > lluviaMax) {
                lluviaMax = lluvia;
                diaMas = dia;
            }
            if (dia == 1) {
                lluviaMin = lluvia;
                diaMenos = dia;
            } else if (lluvia < lluviaMin) {
                lluviaMin = lluvia;
                diaMenos = dia;
            }

            //Cálculo lluvia total y media
            lluviaTot = lluviaTot + lluvia;
            mediaLluvia = lluviaTot / 7;

            dia++;

        } while (dia <= MAX_DIAS);

        //Separador
        System.out.println("---");

        //Sacar por pantalla los datos
        System.out.printf("El día mas lluvioso fue el dia %d con .....: %04d "
                + "l/m\u00b2%n",
                diaMas, lluviaMax);
        System.out.printf("El día menos lluvioso fue el dia %d con ...: %04d "
                + "l/m\u00b2%n", diaMenos, lluviaMin);

        //Separador
        System.out.println("---");

        System.out.printf(Locale.ENGLISH, "El total la lluvia es .............."
                + "......: %07.2f l/m\u00b2%n", lluviaTot);
        System.out.printf(Locale.ENGLISH, "La media de la lluvia es ............"
                + ".....: %07.2f l/m\u00b2%n", mediaLluvia);

    }//main

}//class

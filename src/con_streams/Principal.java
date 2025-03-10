package con_streams;

import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Pais suecia = new Pais("Suecia", "Marcus & Martinus", "Unforgettable");
        Pais ucrania = new Pais("Ucrania", "Alyona Alyona & Jerry Heil", "Teresa & Maria");
        Pais alemania = new Pais("Alemania", "Isaak", "Always on the Run");
        Pais luxemburgo = new Pais("Luxemburgo", "Tali", "Fighter");
        Pais paisesBajos = new Pais("Países Bajos", "Joost Klein", "Europapa");
        Pais israel = new Pais("Israel", "Edén Golán", "Hurricane");
        Pais lituania = new Pais("Lituania", "Silvester Belt", "Luktelk");
        Pais espanya = new Pais("España", "Nebulossa", "Zorra");
        Pais estonia = new Pais("Estonia", "5miinust & Puuluup", "(Nendest) Narkootikumidest ei tea me (küll) midagi");
        Pais irlanda = new Pais("Irlanda", "Bambie Thug", "Doomsday Blue");
        Pais letonia = new Pais("Letonia", "Dons", "Hollow");
        Pais grecia = new Pais("Grecia", "Marina Satti", "Zari");
        Pais reinoUnido = new Pais("Reino Unido", "Olly Alexander", "Dizzy");
        Pais noruega = new Pais("Noruega", "Gåte", "Ulveham");
        Pais italia = new Pais("Italia", "Angelina Mango", "La noia");
        Pais serbia = new Pais("Serbia", "Teya Dora", "Ramonda");
        Pais finlandia = new Pais("Finlandia", "Windows95man", "No Rules!");
        Pais portugal = new Pais("Portugal", "Iolanda", "Grito");
        Pais armenia = new Pais("Armenia", "Ladaniva", "Jako");
        Pais chipre = new Pais("Chipre", "Sília Kapsís", "Liar");
        Pais suiza = new Pais("Suiza", "Nemo", "The Code");
        Pais eslovenia = new Pais("Eslovenia", "Raiven", "Veronika");
        Pais croacia = new Pais("Croacia", "Baby Lasagna", "Rim tim tagi dim");
        Pais georgia = new Pais("Georgia", "Nutsa Buzaladze", "Firefighter");
        Pais francia = new Pais("Francia", "Slimane", "Mon Amour");
        Pais austria = new Pais("Austria", "Kaleen", "We Will Rave");

        Eurovision eurovision2024 = new Eurovision(new ArrayList<>(List.of(suecia, ucrania, alemania, luxemburgo, paisesBajos,
                israel, lituania, espanya, estonia, irlanda, letonia, grecia, reinoUnido, noruega, italia, serbia,
                finlandia, portugal, armenia, chipre, suiza, eslovenia, croacia, georgia, francia, austria)));


        //Listado de todos los países participantes
        System.out.println("Listado de todos los paises");
        System.out.println(eurovision2024.listaNombrePaises());
        System.out.println();

        //Listado de todos los países por orden alfabético, junto con las votaciones realizadas ordenadas de mayor a menor.
        System.out.println("Listado de todos los paises en orden alfabético junto a sus votaciones");
        System.out.println(eurovision2024);
        System.out.println();

        //Listado de los países ordenados por puntuaciones recibidas, junto con sus puntuaciones
        System.out.println("Listado de los paises ordenados por posición");
        eurovision2024.getPuntuacionTotal().forEach((key, value) -> System.out.println(key.getNombre() + "-" + value));
        System.out.println();

        //Nombre del país ganador, junto con la puntuación total obtenida y los países que le han votado, junto con los puntos asignados por cada uno de ellos.
        Pais pais = eurovision2024.getPuntuacionTotal().keySet().stream().limit(1).findFirst().orElse(null);
        System.out.println("PAIS GANADOR EUROVISIÓN 2024: " + pais.getNombre() + "-" + pais.getPuntuacionTotal());
        //Quien le ha votado
        System.out.println("Países que han votado a " + pais.getNombre() + ":");
        pais.getPuntuacionesRecibidas().forEach((key, value) ->
                System.out.println("\t" + key.getNombre() + " - Puntos: " + value));
        System.out.println();

        //Listado de canciones ordenadas por nombre.
        System.out.println("Listado de canciones ordenadas por nombre");
        eurovision2024.getEurovision().stream().map(Pais::getCancion).sorted().forEach(System.out::println);
        System.out.println();

        //Listado de cantantes ordenados por nombre
        System.out.println("Listado de participantes ordenadas por nombre");
        eurovision2024.getEurovision().stream().map(Pais::getParticipante).sorted().forEach(System.out::println);
        System.out.println();

        //Obtener el pais con mayor numero de maximas puntuaciones (12 puntos) y los países que le han otorgado esos 12 puntos
        eurovision2024.paisesConMaximasPuntuaciones().forEach(pais1 -> {
                System.out.print("País con más veces maxima puntuacion: " + pais1.getNombre() + " veces: " +
                        pais1.getPaisesVotosMaximo().size() + " votos de: ");
                pais1.getPaisesVotosMaximo().forEach(pais12 -> System.out.print(" -> "+pais12.getNombre()));
                System.out.println();
            });

    }
}

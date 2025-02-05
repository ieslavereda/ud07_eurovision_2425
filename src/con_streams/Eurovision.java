package con_streams;

import java.util.*;
import java.util.stream.Collectors;

public class Eurovision {

    public static final Comparator<Integer> BY_POINTS_RESVERSED = (o1, o2) -> o2 - o1;

    private final List<Pais> eurovision;
    private final Map<Pais, Integer> puntuacionTotal;

    public Eurovision(List<Pais> eurovision) {
        this.eurovision = eurovision;
        Collections.sort(eurovision);
        puntuacionTodosPaises();
        puntuacionTotal = new LinkedHashMap<>();
        listaPaisesPorPuntuacion();
    }

    public Map<Pais, Integer> getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public List<Pais> getEurovision() {
        return eurovision;
    }

    private void puntuacionTodosPaises() {
        for (Pais pais : eurovision) {
            List<Pais> paises = eurovision.stream().filter(pais1 -> !pais1.equals(pais)).collect(Collectors.toList());
            Collections.shuffle(paises);
            Map<Puntuacion, Pais> votos = new TreeMap<>();
            Arrays.stream(Puntuacion.values()).
                    forEach(puntuacion -> {
                        Pais pais1 = paises.remove(0);
                        votos.put(puntuacion, pais1);
                        pais1.setPuntuacionesRecibidas(pais, puntuacion);
                    });
            pais.setPuntuacionesDelPais(votos);
        }
    }

    public String listaNombrePaises() {
        return eurovision.stream().map(Pais::getNombre).collect(Collectors.joining("-"));
    }

    private void listaPaisesPorPuntuacion() {
        Map<Pais, Integer> aux = new HashMap<>();
        eurovision.forEach(pais -> aux.put(pais, pais.getPuntuacionTotal()));

        aux.values().stream().sorted(BY_POINTS_RESVERSED).
                forEach(puntuacion -> aux.keySet().stream().filter(pais -> pais.getPuntuacionTotal() == puntuacion).
                        forEach(pais -> puntuacionTotal.put(pais, puntuacion)));
    }

    @Override
    public String toString() {
        return "Eurovision --> \n" +
                eurovision;
    }
}

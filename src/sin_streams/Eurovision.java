package sin_streams;

import java.util.*;

public class Eurovision {

    public static final Comparator<Integer> BY_POINTS_RESVERSED = new Comparator<>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };

    private final List<Pais> eurovision;
    private final Map<Pais, Integer> puntuacionTotal;

    public Eurovision(List<Pais> eurovision) {
        this.eurovision = eurovision;
        Collections.sort(eurovision);
        puntuacionTodosPaises();
        puntuacionTotal = new LinkedHashMap<>();
        listaPaisesPorPuntuacion();
    }

    public Map<Pais,Integer> getPuntuacionTotal(){ return puntuacionTotal;}

    public List<Pais> getEurovision(){return eurovision;}

    private void puntuacionTodosPaises() {
        for (Pais pais : eurovision) {
            int i = 0;
            List<Pais> paises = new ArrayList<>(eurovision);
            Collections.shuffle(paises);
            Map<Puntuacion, Pais> votos = new TreeMap<>();
            for (Puntuacion puntuacion : Puntuacion.values()) {
                if (!pais.equals(paises.get(i))) {
                    votos.put(puntuacion, paises.get(i));
                    paises.get(i).setPuntuacionesRecibidas(pais, puntuacion);
                }
                i++;
            }
            pais.setPuntuacionesDelPais(votos);
        }
    }

    public String listaNombrePaises() {
        String res = "";
        for (Pais pais : eurovision)
            res += pais.getNombre() + "-";
        return res.substring(0, res.length() - 1);
    }

    private void listaPaisesPorPuntuacion() {
        Map<Pais,Integer> aux = new HashMap<>();

        for (Pais pais : eurovision) {
            aux.put(pais, pais.getPuntuacionTotal());
        }

        List<Integer> puntos = new ArrayList<>(aux.values());
        puntos.sort(BY_POINTS_RESVERSED);

        for(Integer puntacion:puntos){
            for(Pais pais:aux.keySet()){
                if(pais.getPuntuacionTotal()==puntacion)
                    puntuacionTotal.put(pais,puntacion);
            }
        }

    }

    public Map<Pais,Set<Pais>> paisesConMaximasPuntuaciones(){
        int maximasVeces=0;
        Map<Pais,Set<Pais>> paisesMaxPun = new HashMap<>();
        for (Pais pais:eurovision){
            if(pais.getVecesMaxPuntuacion()>maximasVeces)
                maximasVeces=pais.getVecesMaxPuntuacion();
        }
        for (Pais pais:eurovision){
            if(pais.getVecesMaxPuntuacion()==maximasVeces) {
                paisesMaxPun.put(pais,pais.getPaisesVotosMaximo());
            }
        }
        return paisesMaxPun;
    }

    @Override
    public String toString() {
        return "Eurovision --> \n" +
                eurovision;
    }
}

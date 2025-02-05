package con_streams;

import java.util.*;

public class Pais implements Comparable<Pais> {

    private final String nombre;
    private final String participante;
    private final String cancion;
    private Map<Puntuacion,Pais> puntuacionesDelPais;
    private final Map<Pais, Puntuacion> puntuacionesRecibidas;
    private final Set<Pais> paisesVotosMaximo;
    private int puntuacionTotal;
    private int vecesMaxPuntuacion;

    public Pais(String nombre, String participante, String cancion) {
        this.nombre = nombre;
        this.participante = participante;
        this.cancion = cancion;
        this.puntuacionesDelPais = new TreeMap<>();
        this.puntuacionesRecibidas = new HashMap<>();
        this.paisesVotosMaximo = new HashSet<>();
        puntuacionTotal=0;
        vecesMaxPuntuacion=0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getParticipante() {
        return participante;
    }

    public String getCancion() {
        return cancion;
    }

    public Map<Pais, Puntuacion> getPuntuacionesRecibidas() {
        return puntuacionesRecibidas;
    }

    public int getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public int getVecesMaxPuntuacion() {return vecesMaxPuntuacion;}

    public Set<Pais> getPaisesVotosMaximo() {
        return paisesVotosMaximo;
    }

    public void setPuntuacionesDelPais(Map<Puntuacion, Pais> puntuacionesDelPais) {
        this.puntuacionesDelPais = puntuacionesDelPais;
    }

    public void setPuntuacionesRecibidas(Pais pais, Puntuacion puntuacion){
        puntuacionesRecibidas.put(pais,puntuacion);
        puntuacionTotal += puntuacion.getValue();
        if(puntuacion== Puntuacion.TWELVE){
            vecesMaxPuntuacion++;
            paisesVotosMaximo.add(pais);
        }
    }

    private String puntuacionPaises(){
        List<String> resultado = new ArrayList<>();
        puntuacionesDelPais.keySet().forEach(puntuacion -> resultado.add("\t"+puntuacionesDelPais.get(puntuacion).getNombre()+"-"+puntuacion+"\n"));
        return String.join("", resultado);
    }

    @Override
    public String toString(){
        return "Pais: " + nombre + " Participante: " + participante +" Canción: "+cancion+"\n  Puntos que ha dado "+nombre+":\n"+
                puntuacionPaises();
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null || !(obj instanceof Pais pais))
            return false;
        return pais.getNombre().equals(nombre);
    }

    @Override
    public int hashCode(){
        return nombre.hashCode()+cancion.hashCode()+participante.hashCode();
    }

    @Override
    public int compareTo(Pais pais) {
        return nombre.compareTo(pais.getNombre());
    }
}

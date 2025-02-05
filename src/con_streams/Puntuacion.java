package con_streams;

public enum Puntuacion {

    TWELVE(12), TEN(10), EIGHT(8), SEVEN(7), SIX(6),
    FIVE(5), FOUR(4), THREE(3), TWO(2), ONE(1);

    private final int value;

    Puntuacion(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

}

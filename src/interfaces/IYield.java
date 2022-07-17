package interfaces;

public interface IYield {
    /**
     * Método que retorna o valor de rendimento a partir de uma quantidade de dias
     * 
     * @param days int - Dias
     * @return double - Valor de rendimento total
     */
    public double calculateYield(int days);
}

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.ifpr.SimuladorCashback;


public class AppTest {
    // FAIXA BRONZE
    @Test
    public void testCalculoBronzeAbaixoMinimo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double valorEsperado = 4.9995; // 5% de R$ 99,99
        double valorCalculado = simulador.calculaCashBack(99.99, "Bronze");
        assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testCalculoBronzeNoMinimo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double valorEsperado = 5.0; // 5% de R$ 100,00
        double valorCalculado = simulador.calculaCashBack(100.00, "Bronze");
        assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testCalculoBronzeAcimaMinimo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double valorEsperado = 10.001; // 10% de R$ 100,01
        double valorCalculado = simulador.calculaCashBack(100.01, "Bronze");
        assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testCalculoBronzePoucoAcimaMinimo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double valorEsperado = 10.002; // 10% de R$ 100,02
        double valorCalculado = simulador.calculaCashBack(100.02, "Bronze");
        assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testCalculoBronzeProximoLimiteMaximo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double valorEsperado = 49.999; // 10% de R$ 499,99
        double valorCalculado = simulador.calculaCashBack(499.99, "Bronze");
        assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testCalculoBronzeNoLimiteMaximo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double valorEsperado = 50.0; // 10% de R$ 500,00
        double valorCalculado = simulador.calculaCashBack(500.00, "Bronze");
        assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testCalculoBronzeAcimaLimiteMaximo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double valorEsperado = 75.0015; // 15% de R$ 500,01
        double valorCalculado = simulador.calculaCashBack(500.01, "Bronze");
        assertEquals(valorEsperado, valorCalculado, 0.01);
    }
    
    // FAIXA PRATA 
    @Test
    public void testCalculoPrataAbaixoMinimo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double valorEsperado = 9.999; // 10% de R$ 99,99
        double valorCalculado = simulador.calculaCashBack(99.99, "Prata");
        assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testCalculoPrataNoMinimo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double valorEsperado = 10.0; // 10% de R$ 100,00
        double valorCalculado = simulador.calculaCashBack(100.00, "Prata");
        assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testCalculoPrataAcimaMinimo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double valorEsperado = 15.0015; // 15% de R$ 100,01
        double valorCalculado = simulador.calculaCashBack(100.01, "Prata");
        assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testCalculoPrataPoucoAcimaMinimo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double valorEsperado = 15.003; // 15% de R$ 100,02
        double valorCalculado = simulador.calculaCashBack(100.02, "Prata");
        assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testCalculoPrataProximoLimiteMaximo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double valorEsperado = 74.9985; // 15% de R$ 499,99
        double valorCalculado = simulador.calculaCashBack(499.99, "Prata");
        assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testCalculoPrataNoLimiteMaximo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double valorEsperado = 75.0; // 15% de R$ 500,00
        double valorCalculado = simulador.calculaCashBack(500.00, "Prata");
        assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testCalculoPrataAcimaLimiteMaximo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double valorEsperado = 100.002; // 20% de R$ 500,01
        double valorCalculado = simulador.calculaCashBack(500.01, "Prata");
        assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    // FAIXA OURO
    @Test
    public void testCashbackOuroAbaixoLimiteMinimo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double esperado = 14.9985; // 15% de R$ 99,99
        double resultado = simulador.calculaCashBack(99.99, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackOuroNoLimiteMinimo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double esperado = 15.0; // 15% de R$ 100,00
        double resultado = simulador.calculaCashBack(100.00, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackOuroLogoAcimaLimiteMinimo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double esperado = 20.002; // 20% de R$ 100,01
        double resultado = simulador.calculaCashBack(100.01, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackOuroPoucoAcimaLimiteMinimo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double esperado = 20.004; // 20% de R$ 100,02
        double resultado = simulador.calculaCashBack(100.02, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackOuroProximoLimiteMaximo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double esperado = 99.998; // 20% de R$ 499,99
        double resultado = simulador.calculaCashBack(499.99, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackOuroNoLimiteMaximo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double esperado = 100.0; // 20% de R$ 500,00
        double resultado = simulador.calculaCashBack(500.00, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackOuroLimiteMaximoSuperior() {
        SimuladorCashback simulador = new SimuladorCashback();
        double esperado = 125.0; // 25% de R$ 500,00
        double resultado = simulador.calculaCashBack(500.00, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackOuroAcimaLimiteMaximo() {
        SimuladorCashback simulador = new SimuladorCashback();
        double esperado = 125.0025; // 25% de R$ 500,01
        double resultado = simulador.calculaCashBack(500.01, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

}
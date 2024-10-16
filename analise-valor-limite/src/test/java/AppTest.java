import static org.junit.Assert.assertEquals;
import org.junit.Test;

import paranavai.ifpr.edu.br.SimuladorCashBack;

public class AppTest {
    // FAIXA BRONZE
    @Test
    public void testCashbackBronzeAbaixoLimiteInferior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 4.9995; // 5% de R$ 99,99
        double resultado = simulador.calculaCashBack(99.99, "Bronze");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackBronzeNoLimiteInferior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 5.0; // 5% de R$ 100,00
        double resultado = simulador.calculaCashBack(100.00, "Bronze");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackBronzeLogoAcimaLimiteInferior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 10.001; // 10% de R$ 100,01
        double resultado = simulador.calculaCashBack(100.01, "Bronze");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackBronzePoucoAcimaLimiteInferior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 10.002; // 10% de R$ 100,02
        double resultado = simulador.calculaCashBack(100.02, "Bronze");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackBronzeProximoAoLimiteSuperior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 49.999; // 10% de R$ 499,99
        double resultado = simulador.calculaCashBack(499.99, "Bronze");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackBronzeNoLimiteSuperior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 50.0; // 10% de R$ 500,00
        double resultado = simulador.calculaCashBack(500.00, "Bronze");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackBronzeNoLimiteSuperior1() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 75.0; // 15% de R$ 500,00
        double resultado = simulador.calculaCashBack(500.00, "Bronze");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackBronzeAcimaLimiteSuperior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 75.0015; // 15% de R$ 500,01
        double resultado = simulador.calculaCashBack(500.01, "Bronze");
        assertEquals(esperado, resultado, 0.01);
    }

    // FAIXA PRATA
    @Test
    public void testCashbackPrataAbaixoLimiteInferior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 9.999; // 10% de R$ 99,99
        double resultado = simulador.calculaCashBack(99.99, "Prata");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackPrataNoLimiteInferior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 10.0; // 10% de R$ 100,00
        double resultado = simulador.calculaCashBack(100.00, "Prata");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackPrataLogoAcimaLimiteInferior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 15.0015; // 15% de R$ 100,01
        double resultado = simulador.calculaCashBack(100.01, "Prata");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackPrataPoucoAcimaLimiteInferior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 15.003; // 15% de R$ 100,02
        double resultado = simulador.calculaCashBack(100.02, "Prata");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackPrataProximoAoLimiteSuperior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 74.9985; // 15% de R$ 499,99
        double resultado = simulador.calculaCashBack(499.99, "Prata");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackPrataNoLimiteSuperior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 75.0; // 15% de R$ 500,00
        double resultado = simulador.calculaCashBack(500.00, "Prata");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackPrataNoLimiteSuperior1() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 100.0; // 20% de R$ 500,00
        double resultado = simulador.calculaCashBack(500.00, "Prata");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackPrataAcimaLimiteSuperior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 100.002; // 20% de R$ 500,01
        double resultado = simulador.calculaCashBack(500.01, "Prata");
        assertEquals(esperado, resultado, 0.01);
    }

    // FAIXA OURO
    @Test
    public void testCashbackOuroAbaixoLimiteInferior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 14.9985; // 15% de R$ 99,99
        double resultado = simulador.calculaCashBack(99.99, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackOuroNoLimiteInferior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 15.0; // 15% de R$ 100,00
        double resultado = simulador.calculaCashBack(100.00, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackOuroLogoAcimaLimiteInferior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 20.002; // 20% de R$ 100,01
        double resultado = simulador.calculaCashBack(100.01, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackOuroPoucoAcimaLimiteInferior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 20.004; // 20% de R$ 100,02
        double resultado = simulador.calculaCashBack(100.02, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackOuroProximoAoLimiteSuperior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 99.998; // 20% de R$ 499,99
        double resultado = simulador.calculaCashBack(499.99, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackOuroNoLimiteSuperior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 100.0; // 20% de R$ 500,00
        double resultado = simulador.calculaCashBack(500.00, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackOuroNoLimiteSuperior1() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 125.0; // 25% de R$ 500,00
        double resultado = simulador.calculaCashBack(500.00, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void testCashbackOuroAcimaLimiteSuperior() {
        SimuladorCashBack simulador = new SimuladorCashBack();
        double esperado = 125.0025; // 25% de R$ 500,01
        double resultado = simulador.calculaCashBack(500.01, "Ouro");
        assertEquals(esperado, resultado, 0.01);
    }

}

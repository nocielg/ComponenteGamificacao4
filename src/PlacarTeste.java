import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
//
public class PlacarTeste {
	Armazenamento _armazenamento;
	ArrayList <Usuario> usuario = new ArrayList<Usuario>();
	Placar placar;
	ArmazenamentoMock armazenamentoMock;
		
	@Before
	public void inicializanoTeste(){
		armazenamentoMock = new ArmazenamentoMock();
		armazenamentoMock.armazenandoUsuarios();
		placar = new Placar(armazenamentoMock);
	}
	
	@Test
	public void testaregistrarPlacar() {
		armazenamentoMock.adicionaUsuario(new Usuario("Vanessa"));
		placar.registraTipoDePonto("Vanessa", 100,"estrela");
		assertEquals(100,armazenamentoMock.retornaPontosDosTipos("Vanessa", "estrela"));
				
	}
		
	@Test
	public void testaRetornaTodosOsPontosDeUmUsuario() {
		assertEquals(Arrays.toString(placar.retornaTodosPontosDeUmUsuario("Maria")),"[Maria;Comentario20]");
		
	}
	
	@Test
	public void testaRetornaRankingPorTipoDePonto() {
		assertEquals(placar.retornaRankingPorTipoDePonto("Topico"),"{15=Carlos, 30=Joao}");
	}
	
}

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class PlacarTeste {
	Armazenamento _armazenamento;
	ArrayList <Usuario> usuario = new ArrayList<Usuario>();
	Placar placar;
	ArmazenamentoMock armazenamentoMock;
	
	/*public void carregandoUsuariosArmazenados(){
		usuario = (ArrayList) _armazenamento.usuario.clone();
	}*/
	
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
	
	/*
	public void testarRegistroDePontos(){
		Usuario usuario_vanessa = retornaUsuario("Vanessa");
		//Usuario usuario_maria = retornaUsuario("Maria");
		//Usuario usuario_carlos = retornaUsuario("Carlos");
		assertEquals(usuario_joao.getPontos("Estrela"),5);
		assertEquals(usuario_maria.getPontos("Comentario"),20);
		assertEquals(usuario_carlos.getPontos("Topico"),15);
	}
	
	@Test
	public void testaRetornaTodosPontosDeUmUsuario(){
		
		assertEquals(Arrays.toString(retornaTodosPontosDeUmUsuario("Maria")),"[Maria;Comentario20]");
		
	}
	
	
	@Test
	public void retornaRankingPorTipoDePonto(){
		
		assertEquals(Arrays.toString(retornaRankingPorTipoDePonto("Topico")),"Joao;Carlos;");
	}
	*/

}

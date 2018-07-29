import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//
public class IntegracaoTeste {
	private String _pathFile = "/home/gleisson/eclipse-workspace/ComponenteGamificacao4/arquivo.txt";
	private Placar _placar;
	private IFileHelper _fileHelper;
	Armazenamento _armazenamento;
	
	@Before
	public void setArquivo() throws IOException{
		_fileHelper = new IFileHelper(_pathFile);
		_armazenamento = new Armazenamento(_fileHelper);
		_placar = new Placar(_armazenamento);
		_armazenamento.adicionaUsuario(new Usuario("Usuario1"));
	}
	
	@After
	public void limparArquivo() throws IOException{
		File _file = new File(this._pathFile);
		//_file.delete();
	}
	
	@Test
	public void testaRegistrarPlacar() throws IOException  {
		_placar.registraTipoDePonto("Usuario1",10,"estrela");
		assertEquals(1, _fileHelper.lerArquivo(this._pathFile).length());
	//parei aqui
		
	}
	
	
	@Test
	public void testaLerArquivo() {
		//assertEquals("usuario1;tipoEstrela;10", _fileHelper.ler());
		try {
			assertEquals("1",_fileHelper.lerArquivo(_pathFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

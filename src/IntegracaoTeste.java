import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
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
	File _file;
	//FileWriter _fileWriter;
	
	@Before
	public void setArquivo() throws IOException{
		_fileHelper = new IFileHelper(_pathFile);
		//_armazenamento = new Armazenamento(_fileHelper);
		_armazenamento = new Armazenamento();
		_placar = new Placar(_armazenamento);
		_armazenamento.adicionaUsuario(new Usuario("Usuario1"));
	}
	
	@After
	public void limparArquivo() throws IOException{
		this._file = new File(this._pathFile);
		//this._fileWriter = new FileWriter(this._file,true);
		//_file.delete();
		//_file.createNewFile();
	}
	
	@Test
	public void testaRegistrarPlacar() throws IOException  {
		//Verificando o comprimento da string armazenada no arquivo.
		_placar.registraTipoDePonto("Usuario1",10,"estrela");
		this._fileHelper.escrevendoNoArquivo("Usuario1");
		assertEquals(20, _fileHelper.lerArquivo(this._pathFile).length());
		//assertEquals(19, _fileHelper.lerArquivo(this._pathFile).length());
			
	}
	
	
	@Test
	public void testaLerArquivo() {
		//assertEquals("usuario1;tipoEstrela;10", _fileHelper.ler());
		try {
			assertEquals("Usuario1,10,estrela",_fileHelper.lerArquivo(_pathFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

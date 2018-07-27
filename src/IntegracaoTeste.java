import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IntegracaoTeste {
	private String _pathFile = "/home/gleisson/eclipse-workspace/ComponenteGameficacao4/arquivo.txt";
	private Placar _placar;
	private IFileHelper _fileHelper;
	
	@Before
	public void setArquivo() throws IOException{
		_fileHelper = new IFileHelper(_pathFile);
		Armazenamento _armazenamento = new Armazenamento(_fileHelper);
		_placar = new Placar(_armazenamento);
	}
	
	@After
	public void limparArquivo() throws IOException{
		File _file = new File(this._pathFile);
		_file.delete();
	}
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class IFileHelper {
	private String _pathFile = "";
	Armazenamento _armazenamento;
	
	public IFileHelper(String pathFile){
		this._pathFile = pathFile;
	}

	private String lerArquivo(String arquivo) throws IOException{
		FileReader fileReader = new FileReader(this._pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String textoLido;
		textoLido = bufferedReader.readLine();
		bufferedReader.close();
		
		return textoLido;
		
	}
	
	public void escrevendoNoArquivo() throws IOException{
		PrintWriter printWriter = new PrintWriter(this._pathFile);
		for(Usuario u: this._armazenamento.usuario){
			_armazenamento.retornaUsuarioPorTipoDePontoRecebido(printWriter, u);
		}
		printWriter.close();
		
	}
}

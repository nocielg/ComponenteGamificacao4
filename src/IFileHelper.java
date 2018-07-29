import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;

public class IFileHelper {
	private String _pathFile = "";
	Armazenamento _armazenamento;
	Placar _placar;
	
	public IFileHelper(String pathFile){
		this._pathFile = pathFile;
	}

	protected String lerArquivo(String arquivo) throws IOException{
		FileReader fileReader = new FileReader(this._pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String textoLido;
		textoLido = bufferedReader.readLine();
		bufferedReader.close();
		
		return textoLido;
		
	}
	
	public void escrevendoNoArquivo(String usuario) throws IOException{
		String stringSalvaNoArquivo = _placar.retornaTodosPontosDeUmUsuario(usuario).toString();
			try {
				Formatter saida = new Formatter(this._pathFile);
				saida.format("\n", _armazenamento.usuario,stringSalvaNoArquivo);
				saida.close();
				System.out.println("Arquivo salvo com sucesso");
			}
		
			catch (Exception erro){
				System.out.println("O arquivo não pode ser gerado");
			} 
		
		/*try {
			FileWriter writer = new FileWriter(new File(this._pathFile));  
			PrintWriter saida = new PrintWriter(writer);
			saida.print(stringSalvaNoArquivo);
			saida.close();  
			writer.close();
			System.out.println("Arquivo criado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		
		/*PrintWriter printWriter = new PrintWriter(this._pathFile);
		for(Usuario u: this._armazenamento.usuario){
			_armazenamento.retornaUsuarioPorTipoDePontoRecebido(printWriter, u);
		}
		printWriter.close();*/
		
		/*
		  https://pt.stackoverflow.com/questions/134221/como-gravar-um-arquivo-txt-com-o-nome-de-cada-paciente
		*/
		
	}

}

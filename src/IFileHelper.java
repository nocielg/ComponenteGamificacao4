import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Formatter;
//
public class IFileHelper {
	private String _pathFile = "";
	private File _file;
	private FileWriter _fileWriter;
	Armazenamento _armazenamento;
	Placar _placar;
	
	public IFileHelper(String pathFile){
		this._pathFile = pathFile;
	}
	/*
	public IFileHelper(File file){
		this._file = file;
	}*/

	protected String lerArquivo(String arquivo) throws IOException{
		FileReader fileReader = new FileReader(this._pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String textoLido;
		textoLido = bufferedReader.readLine();
		bufferedReader.close();
		
		return textoLido;
		
	}
	
	public void escrevendoNoArquivo(String usuario) throws IOException{
		this._armazenamento = new Armazenamento();
		this._placar = new Placar(this._armazenamento);
		String[] stringSalvaNoArquivo = this._placar.retornaTodosPontosDeUmUsuario(usuario);
		 
		try {
			this._file = new File(this._pathFile);
			this._fileWriter = new FileWriter(this._file,true);
			BufferedWriter bwt = new BufferedWriter(this._fileWriter);
			//bwt.write(Arrays.toString(stringSalvaNoArquivo));
			bwt.write(stringSalvaNoArquivo.toString());
			bwt.newLine();
			bwt.flush();
			bwt.close();
			//bwt.write(stringSalvaNoArquivo.toString(), 0, stringSalvaNoArquivo.length);
			
			/*
			for(int i = 0; i<stringSalvaNoArquivo.length; i++) {
				bwt.write(stringSalvaNoArquivo[i]);
				bwt.newLine();
			}
			
			bwt.close();
			*/
			
			/*for (int i = 0; i < x.length; i++) {
			    // Maybe:
			    outputWriter.write(x[i]+"");
			    // Or:
			    outputWriter.write(Integer.toString(x[i]);
			    outputWriter.newLine();
			  }
			*/
			//this._fileWriter.write("ggg");
			this._fileWriter.write(stringSalvaNoArquivo.toString());
			this._fileWriter.close();
			//PrintWriter outputStream = new PrintWriter(this._file);
			//PrintWriter outputStream = new PrintWriter("arquivo.txt");
			//A informação é gravada na memória ram.
			//outputStream.println("Hello");
			//outputStream.println(stringSalvaNoArquivo);
			//outputStream.flush();
			//Quando o arquivo é fechado a informação ue estava na memóriam ram é gravada no arquivo.
			//outputStream.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			/*try {
				Formatter saida = new Formatter(this._pathFile);
				saida.format("\n", _armazenamento.usuario,stringSalvaNoArquivo);
				saida.close();
				System.out.println("Arquivo salvo com sucesso");
			}
		
			catch (Exception erro){
				System.out.println("O arquivo não pode ser gerado");
			}*/ 
		/*
		try {
			FileWriter writer = new FileWriter(new File(this._pathFile));  
			PrintWriter saida = new PrintWriter(writer);
			saida.println(stringSalvaNoArquivo);
			saida.close();  
			writer.close();
			System.out.println("Arquivo criado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} */
		/*
		boolean fileOpened = true;

		try {
		    toFile = new PrintWriter(this._pathFile);;
		} // end try

		catch (FileNotFoundException e) {
		       fileOpened = false;      
		    // Error Message saying file could not be opened        
		} // end catch

		if(fileOpened){
		    toFile.println(stringSalvaNoArquivo);
		    toFile.close();
		} // end if*/

		
		
		
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

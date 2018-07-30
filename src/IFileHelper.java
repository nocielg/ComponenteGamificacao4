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
	
	}

}

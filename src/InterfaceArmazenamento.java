import java.io.IOException;
import java.io.PrintWriter;

public interface InterfaceArmazenamento {
	public void adicionaUsuario(Usuario usuario);
	public void adicionandoPonto(String usuario, int ponto, String tipoDePonto);
	public int retornaPontosDosTipos(String usuario, String tipoDePonto);
	public String retornaUsuariosQueReceberamPontos();
	public String tiposDePontosRegistradosPorUsuario(String nomeUsuario);
	public void retornaUsuarioPorTipoDePontoRecebido(PrintWriter pw, Usuario usuario);
	public void escrevendoNoArquivo() throws IOException;
}

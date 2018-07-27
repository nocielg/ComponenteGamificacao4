import java.util.List;

public interface InterfacePlacar {
	public void registraTipoDePonto(String usuario, int ponto, String tipoDePonto);
	public String[] retornaTodosPontosDeUmUsuario(String usuario);
	public String retornaRankingPorTipoDePonto (String tipoDePonto);
}

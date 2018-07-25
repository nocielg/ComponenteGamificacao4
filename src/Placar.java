import java.util.Arrays;

public class Placar implements InterfacePlacar{
	private Armazenamento _armazenamento;
	
	public Placar (Armazenamento _armazenamento) {
		this._armazenamento = _armazenamento;
	}
	
	@Override
	public void registraTipoDePonto(String usuario, int ponto, String tipoDePonto) {
		//a quem delega a recuperação e o armazenamento das informações
		
		_armazenamento.adicionandoPonto(usuario, ponto, tipoDePonto);
	}
	
	@Override
	public String[] retornaTodosPontosDeUmUsuario(String usuario) {
		//mexer aqui
		String tiposDePontos;
		String[] tiposDePontosSplit;
		String[] tipoDePontosUsuarios = null;
		int contador = 0;
		
			for(Usuario u: this._armazenamento.usuario){
				if ((u.getNomeUsuario()) == usuario){
					tiposDePontos = u.getTipos();
					tiposDePontosSplit = tiposDePontos.split(";");
					tipoDePontosUsuarios = new String[tiposDePontosSplit.length];
					for(String string: tiposDePontosSplit){
						tipoDePontosUsuarios[contador] = u.getNomeUsuario()+";"+string+u.getPontos(string); 
						contador=contador+1;
					}
					//contador estava aqui, anteriormente
				}
				
			}
		
		return tipoDePontosUsuarios;
		
	}
	
	@Override
	public String[] retornaRankingPorTipoDePonto (String tipoDePonto) {
		String tiposDePontos;
		String[] tiposDePontosSplit;
		String[] rankingTipoDePontosUsuarios = null;
		int contador = 0;
				
			for(Usuario u: this._armazenamento.usuario) { //usuario){
				if ((u.getTipos()) == tipoDePonto){
					tiposDePontos = u.getTipos();
					tiposDePontosSplit = tiposDePontos.split(";");
					rankingTipoDePontosUsuarios = new String[tiposDePontosSplit.length];
					for(String string: tiposDePontosSplit){
						rankingTipoDePontosUsuarios[contador] = u.getNomeUsuario()+";"+u.getPontos(tipoDePonto); 
						contador=contador+1;
					}
					// contador estava aqui, anteriormente
				}
				
				
				
				
			}
		Arrays.sort(rankingTipoDePontosUsuarios); 
		
		return rankingTipoDePontosUsuarios;
		
	}
}

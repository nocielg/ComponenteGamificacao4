import java.util.Arrays;

public class Placar implements InterfacePlacar{
	private Armazenamento _armazenamento;
	//private ArmazenamentoMock _armazenamentoMock;
	
	public Placar (Armazenamento _armazenamento) {
		this._armazenamento = _armazenamento;
	}
	
	public Placar(ArmazenamentoMock armazenamentoMock) {
		this._armazenamento = armazenamentoMock;
	}

	@Override
	public void registraTipoDePonto(String usuario, int ponto, String tipoDePonto) {
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
						
					}
					contador=contador+1;
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
				
			for(Usuario u: this._armazenamento.usuario) { 
				if ((u.getTipos()) == tipoDePonto){
					tiposDePontos = u.getTipos();
					tiposDePontosSplit = tiposDePontos.split(";");
					rankingTipoDePontosUsuarios = new String[tiposDePontosSplit.length];
					for(String string: tiposDePontosSplit){
						rankingTipoDePontosUsuarios[contador] = u.getNomeUsuario()+";"+u.getPontos(tipoDePonto); 
						
					}
					contador=contador+1;
				}
				
				
				
				
			}
		Arrays.sort(rankingTipoDePontosUsuarios); 
		
		
		return rankingTipoDePontosUsuarios;
		
	}
}

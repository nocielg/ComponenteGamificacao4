import java.util.Arrays;
import java.util.TreeMap;

import com.sun.javafx.collections.MappingChange.Map;
//
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
	/*
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
			
				
	}*/
	
	@Override
	public String retornaRankingPorTipoDePonto (String tipoDePonto) {
		//A treeMap é como se fosse uma hash table no entanto os seus valores já vem ordenados
		TreeMap<Integer,String> tiposOrdenados = new TreeMap<Integer,String>();
		String rankingTipoDePontosUsuarios = null;
		
		for(Usuario u: this._armazenamento.usuario) { 
			
			if (u.getPontos(tipoDePonto)!=0) {
				tiposOrdenados.put(u.getPontos(tipoDePonto),u.getNomeUsuario());
			}
		}
		
		rankingTipoDePontosUsuarios = tiposOrdenados.toString();
		
		return rankingTipoDePontosUsuarios;
		
	}
}

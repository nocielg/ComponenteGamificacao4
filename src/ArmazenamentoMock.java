import java.util.ArrayList;
//
public class ArmazenamentoMock extends Armazenamento implements InterfaceArmazenamento{
	
	public void armazenandoUsuarios() {
		adicionaUsuario(new Usuario("Joao"));
		adicionaUsuario(new Usuario("Maria"));
		adicionaUsuario(new Usuario("Carlos"));
		adicionandoPonto("Joao", 5, "Estrela");
		adicionandoPonto("Joao", 10, "Curtida");
		adicionandoPonto("Joao", 30, "Topico");
		adicionandoPonto("Maria", 20, "Comentario");
		adicionandoPonto("Carlos", 15, "Topico");
		adicionandoPonto("Carlos", 5, "Estrela");
	}
}

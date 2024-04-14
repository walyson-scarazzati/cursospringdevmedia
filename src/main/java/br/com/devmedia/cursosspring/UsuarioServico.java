package br.com.devmedia.cursosspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {
	
	private Usuario usuario;

	@Autowired
	private Mailer mailer;

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void lembrarSenhaPorEmail() {
		// O banco de dados poderia ser acessado aqui
		// para recupera��o da senha do usu�rio.
		mailer.setDestinatario(usuario.getEmail());
		mailer.setMensagem("A senha do usu�rio " + usuario.getLogin() + " � xxx");
		mailer.enviarEmail();
	}

}

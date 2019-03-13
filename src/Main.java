import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.JOptionPane;
public class Main extends Application{
	
	public static void main(String[] args){	
			launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Alert  alert;
		String mensagem = "";
		String subTitulo ="";
		
		try {
			String comando = "C:/Program Files (x86)/Nox/bin/nox_adb.exe connect 127.0.0.1:62001";
			Process p = Runtime.getRuntime().exec(comando);
			BufferedReader ler = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linha = "";
			while((linha = ler.readLine()) != null){
				mensagem += linha;
			}
			alert = new Alert(AlertType.INFORMATION);
			subTitulo = "Conexão realizada com sucesso !";
			
		} catch (IOException e) {
			alert = new Alert(AlertType.ERROR);
			mensagem = e.getMessage();
			subTitulo = "Erro na conexão !";
		}
		
		alert.setTitle("Connect Nox");
		Stage s =(Stage) alert.getDialogPane().getScene().getWindow();

		s.getIcons().add(new Image("imagens/icone.png"));
		s.getScene().getStylesheets().add("style.css");
		alert.setHeaderText(subTitulo);
		alert.setContentText(mensagem);
		stage.setTitle("Connect Nox");
		alert.show();
	}
}

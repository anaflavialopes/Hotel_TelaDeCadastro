package apresentacao;

import javax.swing.JOptionPane;
import controle_Hotel.Controle_Hospede;
import hotel.Novo_Hospede;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Principal extends Application {

	@Override
	public void start(Stage palco) throws Exception {
		Controle_Hospede ch = new Controle_Hospede();

		VBox layoutPrincipal = new VBox(40);
		layoutPrincipal.setPadding(new Insets(10, 10, 10, 10));

		String quartos[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		BorderPane layoutNome = new BorderPane();
		Label labelNome = new Label("Nome:");
		TextField textNome = new TextField();
		layoutNome.setLeft(labelNome);
		layoutNome.setRight(textNome);

		BorderPane layoutEndereco = new BorderPane();
		Label labelEndereco = new Label("Endereço:");
		TextField textEndereco = new TextField();
		layoutEndereco.setLeft(labelEndereco);
		layoutEndereco.setRight(textEndereco);

		BorderPane layoutCPF = new BorderPane();
		Label labelCPF = new Label("CPF:");
		TextField textCPF = new TextField();
		layoutCPF.setLeft(labelCPF);
		layoutCPF.setRight(textCPF);

		BorderPane layoutRG = new BorderPane();
		Label labelRG = new Label("RG:");
		TextField textRG = new TextField();
		layoutRG.setLeft(labelRG);
		layoutRG.setRight(textRG);

		BorderPane layoutIdade = new BorderPane();
		Label labelIdade = new Label("Idade:");
		TextField textIdade = new TextField();
		layoutIdade.setLeft(labelIdade);
		layoutIdade.setRight(textIdade);

		ToggleGroup genero = new ToggleGroup();
		RadioButton botaoM = new RadioButton("M");
		botaoM.setToggleGroup(genero);
		botaoM.setAlignment(Pos.TOP_LEFT);
		RadioButton botaoF = new RadioButton("F");
		botaoF.setToggleGroup(genero);
		botaoF.setAlignment(Pos.TOP_LEFT);

		HBox layoutCheck = new HBox(20);
		CheckBox chkIn = new CheckBox("Check in");
		CheckBox chkOut = new CheckBox("Check out");
		layoutCheck.getChildren().addAll(chkIn, chkOut);
		layoutCheck.setSpacing(20);

		HBox layoutFinalizar = new HBox(20);
		Button buttonSalvar = new Button("Salvar");
		Button buttonBuscar = new Button("Buscar");
		Button buttonRemover = new Button("Remover");
		buttonSalvar.setPrefWidth(70);
		buttonBuscar.setPrefWidth(70);
		buttonRemover.setPrefWidth(70);
		layoutFinalizar.setAlignment(Pos.CENTER);
		layoutFinalizar.getChildren().addAll(buttonSalvar, buttonBuscar, buttonRemover);

		ComboBox cbxQuartos = new ComboBox(FXCollections.observableArrayList(quartos));

		buttonSalvar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				Novo_Hospede hospedes = new Novo_Hospede();
				hospedes.setNome(textNome.getText());
				hospedes.setEndereco(textEndereco.getText());
				hospedes.setCPF(textCPF.getText());
				hospedes.setRG(textRG.getText());
				hospedes.setIdade(Integer.parseInt(textIdade.getText()));
				hospedes.setSexoM(botaoM.getText());
				hospedes.setSexoF(botaoF.getText());
				hospedes.setQtdQuartos(Integer.parseInt(cbxQuartos.getSelectionModel().getSelectedItem().toString()));
				hospedes.setCheckIn(chkIn.isSelected());
				hospedes.setCheckOut(chkOut.isSelected());

				if (ch.salvar(hospedes)) {
					JOptionPane.showMessageDialog(null, "Hóspede cadastrado com sucesso!");
					textNome.setText("");
					textEndereco.setText("");
					textCPF.setText("");
					textRG.setText("");
					textIdade.setText("");
					botaoM.setSelected(false);
					botaoF.setSelected(false);
					cbxQuartos.setValue(1);
					chkIn.setSelected(false);
					chkOut.setSelected(false);
					textNome.requestFocus();

				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar hóspede!");
				}
			}

		});

		buttonBuscar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Novo_Hospede hospede = ch.buscar(textCPF.getText());
				if (hospede == null) {
					JOptionPane.showMessageDialog(null, "CPF não cadastrado! Tente novamente.");

				} else {
					textNome.setText(hospede.getNome());
					textEndereco.setText(hospede.getEndereco());
					textCPF.setText(hospede.getCPF());
					textRG.setText(hospede.getRG());
					textIdade.setText(Integer.toString(hospede.getIdade()));
					botaoM.setUserData(hospede.getSexoM());
					botaoF.setUserData(hospede.getSexoF());
					cbxQuartos.setValue(hospede.getQtdQuartos());
					chkIn.setSelected(hospede.isCheckIn());
					chkOut.setSelected(hospede.isCheckOut());

				}

			}
		});

		buttonRemover.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Novo_Hospede hospede = ch.buscar(textCPF.getText());
				if (hospede==null) {
					JOptionPane.showMessageDialog(null, "Não encontramos um hóspede com este CPF. Tente novamente.");
				} else {
					switch(JOptionPane.showConfirmDialog(null, "Deseja remover o(a) hóspede "+textNome.getText()+"?","Remoção de Hóspede", JOptionPane.YES_NO_OPTION))
					{
					case 0:
						Novo_Hospede hospedeRemove = ch.remover(textCPF.getText());
						textNome.setText("");
						textEndereco.setText("");
						textCPF.setText("");
						textRG.setText("");
						textIdade.setText("");
						botaoM.setSelected(false);
						botaoF.setSelected(false);
						cbxQuartos.setValue(1);
						chkIn.setSelected(false);
						chkOut.setSelected(false);
						textNome.requestFocus();
						JOptionPane.showMessageDialog(null, "Hóspede removido com sucesso!");
						break;
						
					case 1:
						JOptionPane.showMessageDialog(null, "Nenhuma alteração foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
						break;
					
					}
										
				}
			}
		});

		layoutPrincipal.setSpacing(10);
		layoutPrincipal.getChildren().addAll(layoutNome, layoutEndereco, layoutCPF, layoutRG, layoutIdade,
				new Label("Sexo:"), botaoM, botaoF, new Label("Quartos:"), cbxQuartos, layoutCheck, layoutFinalizar);

		Scene cena = new Scene(layoutPrincipal, 350, 400);
		palco.setScene(cena);
		palco.show();
		palco.setTitle("Cadastro do Hóspede");
		

	}

	public static void main(String[] args) {
		launch();

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemadatelevisao;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javafx.scene.effect.BlendMode.ADD;
import static javafx.scene.effect.BlendMode.SRC_OVER;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.Screen;

/**
 *
 * @author Lucas
 */
public class TelaEntrada implements Initializable {
    
    long tempo;
    FadeTransition tv = new FadeTransition();
    FadeTransition power = new FadeTransition();
    FadeTransition descFade = new FadeTransition();
    FadeTransition tvFade = new FadeTransition();
    FadeTransition tvFadeOff = new FadeTransition();
    FadeTransition descFadeOff = new FadeTransition();
    FadeTransition camposFadeOff = new FadeTransition();
    FadeTransition camposFade = new FadeTransition();
    SequentialTransition tvSeq;
    SequentialTransition descSeq;
    SequentialTransition camposSeq;
    int teste[] = new int[4];
    
    @FXML
    ImageView avisoDesc;
    @FXML
    ImageView avisoTv;

    private final String AUDIO = getClass().getResource("audios/hotelMusic.wav").toString();
    AudioClip clip = new AudioClip(AUDIO);
    private boolean valor=true;
    
    @FXML
    private Label lblHospede;
    @FXML
    private ImageView maisCanal;
    @FXML
    private ImageView menosCanal;
    @FXML
    private Label lblCanal;
    @FXML
    private TextField txtMinTv;
    @FXML
    private TextField txtMaxTv;
    @FXML
    private TextField txtMaxDesc;
    @FXML
    private TextField txtMinDesc;
    @FXML
    private ImageView menosHosp;
    @FXML
    private ImageView maisHosp;
    @FXML
    private ImageView maisHospPressed;
    @FXML
    private ImageView maisCanalPressed;
    @FXML
    private ImageView menosHospPressed;
    @FXML
    private ImageView menosCanalPressed;    
    @FXML
    private ImageView btnPlay;
    @FXML
    private ImageView btnPower;
    @FXML
    private ImageView btnPowerPressed;
    @FXML
    private ImageView btnPlayPressed;
    @FXML
    private ImageView tvDesl;
    @FXML
    private ImageView campos;
    @FXML
    private ImageView ligue;
    @Override
    
    public void initialize(URL url, ResourceBundle rb){
        tv.setDuration(Duration.seconds(1));
        tv.setNode(tvDesl);
        tv.setFromValue(1);
        tv.setToValue(0);
        tv.setOnFinished((ActionEvent actionEvent) -> {
            tvDesl.setVisible(false);
        });
        
        tvFade.setDuration(Duration.seconds(1));
        tvFade.setNode(avisoTv);
        tvFade.setFromValue(0);
        tvFade.setToValue(1);
        
        tvFadeOff.setDuration(Duration.seconds(2));
        tvFadeOff.setNode(avisoTv);
        tvFadeOff.setFromValue(1);
        tvFadeOff.setToValue(0.99);
        tvFadeOff.setOnFinished((ActionEvent actionEvent) -> {
            avisoTv.setOpacity(0);
        });
        
        camposFade.setDuration(Duration.seconds(1));
        camposFade.setNode(campos);
        camposFade.setFromValue(0);
        camposFade.setToValue(1);
        
        camposFadeOff.setDuration(Duration.seconds(4));
        camposFadeOff.setNode(campos);
        camposFadeOff.setFromValue(1);
        camposFadeOff.setToValue(0.99);
        camposFadeOff.setOnFinished((ActionEvent actionEvent) -> {
            campos.setOpacity(0);
        });
        
        descFade.setDuration(Duration.seconds(1));
        descFade.setNode(avisoDesc);
        descFade.setFromValue(0);
        descFade.setToValue(1);
        
        descFadeOff.setDuration(Duration.seconds(4));
        descFadeOff.setNode(avisoDesc);
        descFadeOff.setFromValue(1);
        descFadeOff.setToValue(0.99);
        descFadeOff.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                avisoDesc.setOpacity(0);
            }
        });
        
        tvSeq = new SequentialTransition(tvFade,tvFadeOff);
        descSeq = new SequentialTransition(descFade,descFadeOff);
        camposSeq = new SequentialTransition(camposFade, camposFadeOff);
        
        power.setNode(btnPower);
        power.setFromValue(1);
        power.setToValue(0.6);
        power.setDuration(Duration.millis(400));
        power.setAutoReverse(true);
        power.setCycleCount(Timeline.INDEFINITE);

        power.play();
    }
    
    
    
    @FXML
    private void maisHospApertar(MouseEvent event) {
        if(Integer.parseInt(lblHospede.getText())<10){
        lblHospede.setText(Integer.toString(Integer.parseInt(lblHospede.getText())+1));
        }
        maisHospPressed.setVisible(true);
        maisHosp.setVisible(false);
    }
    @FXML
    private void maisHospSoltar(MouseEvent event){
        maisHospPressed.setVisible(false);
        maisHosp.setVisible(true);
    }

    @FXML
    private void maisHospSair(MouseEvent event) {
        
        maisHosp.setBlendMode(SRC_OVER);
    }

    @FXML
    private void maisHospEntrar(MouseEvent event) {
        
        maisHosp.setBlendMode(ADD);
    }

    @FXML
    private void maisCanalClicar(MouseEvent event) {
        
        
    }

    @FXML
    private void menosCanalClicar(MouseEvent event) {
        
    }

    @FXML
    private void maisHospClicar(MouseEvent event) {
        
    }

    @FXML
    private void menosHospClicar(MouseEvent event) {
        
    }

    @FXML
    private void maisCanalSair(MouseEvent event) {
        maisCanal.setBlendMode(SRC_OVER);
    }

    @FXML
    private void maisCanalEntrar(MouseEvent event) {
        maisCanal.setBlendMode(ADD);
    }

    @FXML
    private void maisCanalApertar(MouseEvent event) {
        if(Integer.parseInt(lblCanal.getText())<99){
        lblCanal.setText(Integer.toString(Integer.parseInt(lblCanal.getText())+1));
        }
        maisCanalPressed.setVisible(true);
        maisCanal.setVisible(false);
        
    }
    
    @FXML
    private void maisCanalSoltar(MouseEvent event) {
        maisCanalPressed.setVisible(false);
        maisCanal.setVisible(true);
    }

    @FXML
    private void menosCanalSoltar(MouseEvent event) {
        menosCanalPressed.setVisible(false);
        menosCanal.setVisible(true);
    }

    @FXML
    private void menosCanalSair(MouseEvent event) {
        
        menosCanal.setBlendMode(SRC_OVER);
        
    }

    @FXML
    private void menosCanalEntrar(MouseEvent event) {
        menosCanal.setBlendMode(ADD);
    }

    @FXML
    private void menosCanalApertar(MouseEvent event) {
        if(Integer.parseInt(lblCanal.getText())>1){
        lblCanal.setText(Integer.toString(Integer.parseInt(lblCanal.getText())-1));
        }
        menosCanalPressed.setVisible(true);
        menosCanal.setVisible(false);
    }

    @FXML
    private void menosHospSoltar(MouseEvent event) {
        menosHospPressed.setVisible(false);
        menosHosp.setVisible(true);
    }

    @FXML
    private void menosHospSair(MouseEvent event) {
        menosHosp.setBlendMode(SRC_OVER);
    }

    private void menoHospEntrar(MouseEvent event) {
        
        menosHosp.setBlendMode(ADD);
    }

    @FXML
    private void menosHospApertar(MouseEvent event) {
        if(Integer.parseInt(lblHospede.getText())>1){
        lblHospede.setText(Integer.toString(Integer.parseInt(lblHospede.getText())-1));
        }
        menosHospPressed.setVisible(true);
        menosHosp.setVisible(false);
    }

    @FXML
    private void menosHospEntrar(MouseEvent event) {
        menosHosp.setBlendMode(ADD);
    }

    @FXML
    private void maisCanalPressedApertar(MouseEvent event) {
        
    }

    @FXML
    private void playSoltar(MouseEvent event) {
        btnPlay.setVisible(true);
        btnPlayPressed.setVisible(false);
    }

    @FXML
    private void playSair(MouseEvent event) {
        btnPlay.setBlendMode(SRC_OVER);
    }

    @FXML
    private void playEntrar(MouseEvent event) {
        btnPlay.setBlendMode(ADD);
    }

    @FXML
    private void playApertar(MouseEvent event) throws IOException {
        btnPlay.setVisible(false);
        btnPlayPressed.setVisible(true);
        
        try {
            teste[0] = Integer.parseInt(txtMinTv.getText());
            teste[1] = Integer.parseInt(txtMaxTv.getText());
            teste[2] = Integer.parseInt(txtMinDesc.getText());
            teste[3] = Integer.parseInt(txtMaxDesc.getText());
            if (Integer.parseInt(txtMinTv.getText()) > Integer.parseInt(txtMaxTv.getText())) {
                tvSeq.play();
            } else if (Integer.parseInt(txtMinDesc.getText()) > Integer.parseInt(txtMaxDesc.getText())) {
                descSeq.play();
            }
            else {
                clip.stop();
                Dados hotel = new Dados();

                hotel.setQtdHospedes(Integer.parseInt(lblHospede.getText()));
                hotel.setQtdCanais(Integer.parseInt(lblCanal.getText()));
                hotel.setAtributosTempo();
                hotel.setMinTV(Integer.parseInt(txtMinTv.getText()));
                hotel.setMaxTV(Integer.parseInt(txtMaxTv.getText()));
                hotel.setMinDesc(Integer.parseInt(txtMinDesc.getText()));
                hotel.setMaxDesc(Integer.parseInt(txtMaxDesc.getText()));
                hotel.setTemposThreads();

                FXMLLoader sala = new FXMLLoader(getClass().getResource("Sala.fxml"));
                // Definindo quem é o controller desse 'fxml':
                sala.setController(new SalaController(hotel));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                stage.setScene(new Scene(sala.load()));
                stage.setResizable(false);
                stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
                stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 4);
                stage.show();
                
            }
            
        } catch (NumberFormatException ex) {

            camposSeq.play();
        }
        
        
        
    }

    @FXML
    private void powerSoltar(MouseEvent event) {
        btnPower.setVisible(true);
        btnPowerPressed.setVisible(false);
    }

    @FXML
    private void powerSair(MouseEvent event) {
        btnPower.setBlendMode(SRC_OVER);
    }

    @FXML
    private void powerEntrar(MouseEvent event) {
        btnPower.setBlendMode(ADD);
    }

    @FXML
    private void powerApertar(MouseEvent event) throws InterruptedException {
        ligue.setVisible(false);
        power.stop();
        btnPower.setVisible(false);
        btnPowerPressed.setVisible(true);
        
        if(valor){
            tv.play();
            clip.play();
            valor=false;
            
        }
        else{
            tvDesl.setVisible(true);
            tvDesl.setOpacity(1);
            valor=true;
            clip.stop();
        }
        
        txtMinTv.setText("");
        txtMaxTv.setText("");
        txtMinDesc.setText("");
        txtMaxDesc.setText("");
        lblHospede.setText("1");
        lblCanal.setText("1");
    }

    
}

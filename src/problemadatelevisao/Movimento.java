package problemadatelevisao;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Movimento{
    TranslateTransition cimaP = new TranslateTransition(Duration.millis(100));
    TranslateTransition baixoP = new TranslateTransition(Duration.millis(200));
    TranslateTransition esquerdaP = new TranslateTransition(Duration.seconds(1));
    TranslateTransition direitaP = new TranslateTransition(Duration.seconds(1));
    
    TranslateTransition cima = new TranslateTransition(Duration.seconds(1));
    TranslateTransition baixo = new TranslateTransition(Duration.seconds(1));
    TranslateTransition esquerda = new TranslateTransition(Duration.seconds(1));
    TranslateTransition direita = new TranslateTransition(Duration.seconds(1));
    
    TranslateTransition cimaFast = new TranslateTransition(Duration.millis(500));
    TranslateTransition baixoFast= new TranslateTransition(Duration.millis(500));
    TranslateTransition direitaFast = new TranslateTransition(Duration.millis(500));
    TranslateTransition esquerdaFast = new TranslateTransition(Duration.millis(500));
    
    TranslateTransition cimaFastest = new TranslateTransition(Duration.millis(200));
    TranslateTransition baixoFastest = new TranslateTransition(Duration.millis(200));
    TranslateTransition esquerdaFastest = new TranslateTransition(Duration.millis(300));
    TranslateTransition direitaFastest = new TranslateTransition(Duration.millis(200));
    
    TranslateTransition cimaTocar = new TranslateTransition(Duration.millis(200));
    
    SequentialTransition cicloAssistir, cicloDescansar, cicloBloquear, cicloDeslocar, cicloAssistirDnv, cicloPiano, cicloSairPiano;
    private final long poltrona[] = {-88, -108, -136, -158, -184, -206, -232, -254, -280, -302};
    ImageView personagem, tocar;
    private long deslocamento;
    private int numThread;

    public Movimento(ImageView personagem, int numThread) {
        cimaP.setNode(personagem);
        baixoP.setNode(personagem);
        esquerdaP.setNode(personagem);
        direitaP.setNode(personagem);
        
        cima.setNode(personagem);
        baixo.setNode(personagem);
        esquerda.setNode(personagem);
        direita.setNode(personagem);
        
        cimaFast.setNode(personagem);
        baixoFast.setNode(personagem);
        esquerdaFast.setNode(personagem);
        direitaFast.setNode(personagem);
        
        cimaFastest.setNode(personagem);
        baixoFastest.setNode(personagem);
        esquerdaFastest.setNode(personagem);
        direitaFastest.setNode(personagem);
        
        cicloDeslocar = new SequentialTransition(cimaP, direitaP);
        cicloAssistir = new SequentialTransition(baixoFastest, direitaFastest, cima, esquerdaFast, baixoFast);
        cicloDescansar = new SequentialTransition(cimaFast, esquerda, baixoFastest, esquerdaFastest);
        cicloBloquear = new SequentialTransition(direitaFastest, baixo, direita, cimaFastest);
        cicloAssistirDnv = new SequentialTransition(direitaFastest, cimaFastest, direita, baixoFast);
        cicloPiano = new SequentialTransition(cimaFast, esquerda, cimaFastest);
        cicloSairPiano = new SequentialTransition(baixoFastest, direita, baixoFast);
        
        this.deslocamento = 25*numThread;
        this.numThread=numThread;
    }
    
    public void setNodeTocar(ImageView cima){
        tocar=cima;
    }
    public void posicionar(){
        Platform.runLater(() -> {
            cimaP.setToY(-185);
            direitaP.setToX(300 - deslocamento);
            cicloDeslocar.play();
        });
                
    }
    public void assistir(){
        Platform.runLater(() -> {
            baixoFastest.setToY(-150);
            direitaFastest.setToX(382);
            cima.setToY(-523);
            esquerdaFast.setToX(215 - (25 * numThread));
            baixoFast.setToY(-450);
            cicloAssistir.play();
        });
               
    }
    public void assistirDnv(){
        Platform.runLater(() -> {
        direitaFastest.setToX(-310);
        cimaFastest.setToY(-487);
        direita.setToX(215-(25*numThread));
        baixoFast.setToY(-450);
        cicloAssistirDnv.play();
        });
    }
    public void descansar(){
        Platform.runLater(() -> {
            cimaFast.setToY(-523);
            esquerda.setToX(-360 + 25);
            baixoFastest.setToY(-523 + deslocamento-5);
            esquerdaFastest.setToX(-360);
            cicloDescansar.play();
        });
             
    }
    public void bloquear(){
        Platform.runLater(() -> {
            direitaFastest.setToX(-310);
            baixo.setToY(-149);
            direita.setToX(300 - deslocamento);
            cimaFastest.setToY(-185);
            cicloBloquear.play();
        });
      
    }
    public void piano(){
        Platform.runLater(() -> {
            cimaFast.setToY(-523);
            esquerda.setToX(-360 + 70);
            cimaFastest.setToY(-543);
            cicloPiano.play();
        });
        
    }
    public void sairPiano(){
        Platform.runLater(() -> {
            baixoFastest.setToY(-487);
            direita.setToX(215-(25*numThread));
            baixoFast.setToY(-450);
            cicloSairPiano.play();
        });
    }
}

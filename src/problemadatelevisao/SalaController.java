package problemadatelevisao;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
/**
 * FXML Controller class
 *
 * @author Lucas
 */
public class SalaController implements Initializable {

    @FXML
    private Label lblCanalAtual;
    @FXML
    private Label dh0;
    @FXML
    private Label ch0;
    @FXML
    private Label dh1;
    @FXML
    private Label ch1;
    @FXML
    private Label ah0;
    @FXML
    private Label ah1;
    @FXML
    private AnchorPane ancora0;
    @FXML
    private AnchorPane ancora1;
    @FXML
    private AnchorPane ancora2;
    @FXML
    private Label ah2;
    @FXML
    private Label dh2;
    @FXML
    private Label ch2;
    @FXML
    private AnchorPane ancora3;
    @FXML
    private Label ah3;
    @FXML
    private Label dh3;
    @FXML
    private Label ch3;
    @FXML
    private AnchorPane ancora4;
    @FXML
    private Label ah4;
    @FXML
    private TextArea logText;
    @FXML
    private Label dh4;
    @FXML
    private Label ch4;
    @FXML
    private AnchorPane ancora5;
    @FXML
    private Label ah5;
    @FXML
    private Label dh5;
    @FXML
    private Label ch5;
    @FXML
    private AnchorPane ancora6;
    @FXML
    private Label ah6;
    @FXML
    private Label dh6;
    @FXML
    private Label ch6;
    @FXML
    private AnchorPane ancora7;
    @FXML
    private Label ah7;
    @FXML
    private Label dh7;
    @FXML
    private Label ch7;
    @FXML
    private AnchorPane ancora8;
    @FXML
    private Label ah8;
    @FXML
    private Label dh8;
    @FXML
    private Label ch8;
    @FXML
    private AnchorPane ancora9;
    @FXML
    private Label ah9;
    @FXML
    private Label dh9;
    @FXML
    private Label ch9;
    @FXML
    private ImageView boy1;
    @FXML
    private ImageView girl1;
    @FXML
    private ImageView boy2;
    @FXML
    private ImageView girl2;
    @FXML
    private ImageView boy3;
    @FXML
    private ImageView girl3;
    @FXML
    private ImageView girl4;
    @FXML
    private ImageView oldMan;
    @FXML
    private ImageView oldWoman;
    @FXML
    private ImageView boy4;
    @FXML
    private ImageView deondevem;
    @FXML
    private ImageView globorural;
    @FXML
    private ImageView quesomeesse;
    @FXML
    private ImageView fundoPreto;
    @FXML
    private ImageView maluco;
    @FXML
    private ImageView jogo;
    @FXML
    private ImageView bb;
    @FXML
    private ImageView discoveryy;
    @FXML
    private ImageView rato;
    @FXML
    private ImageView queonda;
    @FXML
    private ImageView bear;
    @FXML
    private ImageView balao;
    @FXML
    private ImageView controleTv;
    @FXML
    private Button proximo;
    @FXML
    private ImageView info1;
    @FXML
    private ImageView info2;
    @FXML
    private ImageView info3;
    @FXML
    private ImageView info4;
    @FXML
    private ImageView info5;
    @FXML
    private Button dicas;
    @FXML
    private Button anterior;
    @FXML
    private ImageView boy1Back;
    

    public SalaController(Dados hotel) {
        this.hotel = hotel;
    }
    
    Semaphore log = new Semaphore(1);
    Semaphore mutex = new Semaphore(1);
    Semaphore mutex2 = new Semaphore(1);
    Semaphore assistir = new Semaphore(1);
    Semaphore descansar = new Semaphore(1);
    Semaphore barreira = new Semaphore(1);
    Semaphore barrier = new Semaphore(0);
    Semaphore printar = new Semaphore(1);

    private final Thread hosp[] = new Thread[10];
    private int canal = 0, count = 0, nome, barrierCount=0;
    private final long contagem[] = new long[10];
    private long garantia;
    private final Dados hotel;
    private final ImageView sprite[] = new ImageView[10];
    private final ImageView canais[] = new ImageView[10];
    private final AudioClip audios[] = new AudioClip[11];
    
    private final String BB = getClass().getResource("audios/bb.mp3").toString();
    private final String RATO = getClass().getResource("audios/rato.mp3").toString();
    private final String DISC = getClass().getResource("audios/discovery.mp3").toString();
    private final String QUEONDA = getClass().getResource("audios/157.mp3").toString();
    private final String BEAR = getClass().getResource("audios/bear.mp3").toString();
    private final String JOGO = getClass().getResource("audios/jogo.mp3").toString();
    private final String MALUCO = getClass().getResource("audios/maluco.mp3").toString();
    private final String DOV = getClass().getResource("audios/deondevem.mp3").toString();
    private final String GLOBO = getClass().getResource("audios/globorural.mp3").toString();
    private final String SOMDAFLAUTA = getClass().getResource("audios/somdaflauta.mp3").toString();
    private final String PIANO = getClass().getResource("audios/piano.mp3").toString();
    
    private final Movimento move[] = new Movimento[10];
    boolean assistirDnv[] = new boolean[10];
    boolean verificarCanais=true, mesmosCanais=false, umHospede=false;
    private int referencia, info=0;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
              
        canais[0] = deondevem;
        audios[0] = new AudioClip(DOV);

        canais[1] = globorural;
        audios[1] = new AudioClip(GLOBO);

        canais[2] = quesomeesse;
        audios[2] = new AudioClip(SOMDAFLAUTA);
        
        canais[3] = bb;
        audios[3] = new AudioClip(BB);
        
        canais[4] = rato;
        audios[4] = new AudioClip(RATO);
        
        canais[5] = discoveryy;
        audios[5] = new AudioClip(DISC);
        
        canais[6] = queonda;
        audios[6] = new AudioClip(QUEONDA);
        
        canais[7] = bear;
        audios[7] = new AudioClip(BEAR);
        
        canais[8] = jogo;
        audios[8] = new AudioClip(JOGO);
        
        canais[9] = maluco;
        audios[9] = new AudioClip(MALUCO);
        
        audios[10] = new AudioClip(PIANO);
        
        sprite[0] = boy1;
        sprite[1] = girl1;
        sprite[2] = boy2;
        sprite[3] = girl2;
        sprite[4] = boy3;
        sprite[5] = girl3;
        sprite[6] = boy4;
        sprite[7] = girl4;
        sprite[8] = oldMan;
        sprite[9] = oldWoman;
        
        
        criarHospedes();
    }
    private void print(Label label, String x) {
        Platform.runLater(() -> {
            label.setText(x);
        });
    }
    
    private void paint(AnchorPane i, String x){ 
        try {
            printar.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Platform.runLater(() -> {i.setStyle(x);});
        printar.release();
    }
    public void logLigarTv(int x){
        Platform.runLater(() -> {
            logText.appendText("\n["+LocalDateTime.now().getHour()+":" + LocalDateTime.now().getMinute()+":"
                    + LocalDateTime.now().getSecond()+"] - Hóspede " + hotel.getNome(x) + " ligou a TV no canal " + hotel.getCanalFav(x));
        });
    }
    public void logAssistir(int x){
        Platform.runLater(() -> {
            logText.appendText("\n["+LocalDateTime.now().getHour()+":" + LocalDateTime.now().getMinute()+":"
                    + LocalDateTime.now().getSecond()+"] - Hóspede " + hotel.getNome(x) + " está assistindo");
        });
    }
    public void logDescansar(int x){
        Platform.runLater(() -> {
            logText.appendText("\n["+LocalDateTime.now().getHour()+":" + LocalDateTime.now().getMinute()+":"
                    + LocalDateTime.now().getSecond()+"] - Hóspede " + hotel.getNome(x) + " está descansando");
        });
    }
    public void logDesligarTv(int x){
        Platform.runLater(() -> {
            logText.appendText("\n["+LocalDateTime.now().getHour()+":" + LocalDateTime.now().getMinute()+":"
                    + LocalDateTime.now().getSecond()+"] - Hóspede " + hotel.getNome(x) + " desligou a TV");
        });
    }
    
    public void mudarCanal(){//Seleção de canais da TV
        if(hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName())) == hotel.getCanalTv(0)){
            canais[0].setVisible(true);
            audios[0].play();
            referencia=0;
        }
        if(hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName())) == hotel.getCanalTv(1)){
            canais[1].setVisible(true);
            audios[1].play();
            referencia=1;
        }
        if(hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName())) == hotel.getCanalTv(2)){
            canais[2].setVisible(true);
            audios[2].play();
            referencia=2;
        }
        if(hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName())) == hotel.getCanalTv(3)){
            canais[3].setVisible(true);
            audios[3].play();
            referencia=3;
        }
        if(hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName())) == hotel.getCanalTv(4)){
            canais[4].setVisible(true);
            audios[4].play();
            referencia=4;
        }
        if(hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName())) == hotel.getCanalTv(5)){
            canais[5].setVisible(true);
            audios[5].play();
            referencia=5;
        }
        if(hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName())) == hotel.getCanalTv(6)){
            canais[6].setVisible(true);
            audios[6].play();
            referencia=6;
        }
        if(hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName())) == hotel.getCanalTv(7)){
            canais[7].setVisible(true);
            audios[7].play();
            referencia=7;
        }
        if(hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName())) == hotel.getCanalTv(8)){
            canais[8].setVisible(true);
            audios[8].play();
            referencia=8;
        }
        if(hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName())) == hotel.getCanalTv(9)){
            canais[9].setVisible(true);
            audios[9].play();
            referencia=9;
        }
        
    }
    
    public void sala(){
        
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
        }
//Cada thread ativa sua célula na tela e atualiza seus dados
        if (Integer.parseInt(Thread.currentThread().getName()) == 0) {
            print(ch0, Integer.toString(hotel.getCanalFav(0)));
            print(ah0, Integer.toString(hotel.getTemposThreadsTV(0)));
            print(dh0, Integer.toString(hotel.getTemposThreadsDesc(0)));
            ancora0.setOpacity(1);
            move[0].posicionar();
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 1) {
            print(ch1, Integer.toString(hotel.getCanalFav(1)));
            print(ah1, Integer.toString(hotel.getTemposThreadsTV(1)));
            print(dh1, Integer.toString(hotel.getTemposThreadsDesc(1)));
            ancora1.setOpacity(1);
            move[1].posicionar
        ();
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 2) {
            print(ch2, Integer.toString(hotel.getCanalFav(2)));
            print(ah2, Integer.toString(hotel.getTemposThreadsTV(2)));
            print(dh2, Integer.toString(hotel.getTemposThreadsDesc(2)));
            ancora2.setOpacity(1);
            move[2].posicionar
        ();
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 3) {
            print(ch3, Integer.toString(hotel.getCanalFav(3)));
            print(ah3, Integer.toString(hotel.getTemposThreadsTV(3)));
            print(dh3, Integer.toString(hotel.getTemposThreadsDesc(3)));
            ancora3.setOpacity(1);
            move[3].posicionar
        ();
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 4) {
            print(ch4, Integer.toString(hotel.getCanalFav(4)));
            print(ah4, Integer.toString(hotel.getTemposThreadsTV(4)));
            print(dh4, Integer.toString(hotel.getTemposThreadsDesc(4)));
            ancora4.setOpacity(1);
            move[4].posicionar
        ();
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 5) {
            print(ch5, Integer.toString(hotel.getCanalFav(5)));
            print(ah5, Integer.toString(hotel.getTemposThreadsTV(5)));
            print(dh5, Integer.toString(hotel.getTemposThreadsDesc(5)));
            ancora5.setOpacity(1);
            move[5].posicionar
        ();
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 6) {
            print(ch6, Integer.toString(hotel.getCanalFav(6)));
            print(ah6, Integer.toString(hotel.getTemposThreadsTV(6)));
            print(dh6, Integer.toString(hotel.getTemposThreadsDesc(6)));
            ancora6.setOpacity(1);
            move[6].posicionar
        ();
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 7) {
            print(ch7, Integer.toString(hotel.getCanalFav(7)));
            print(ah7, Integer.toString(hotel.getTemposThreadsTV(7)));
            print(dh7, Integer.toString(hotel.getTemposThreadsDesc(7)));
            ancora7.setOpacity(1);
            move[7].posicionar
        ();
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 8) {
            print(ch8, Integer.toString(hotel.getCanalFav(8)));
            print(ah8, Integer.toString(hotel.getTemposThreadsTV(8)));
            print(dh8, Integer.toString(hotel.getTemposThreadsDesc(8)));
            ancora8.setOpacity(1);
            move[8].posicionar
        ();
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 9) {
            print(ch9, Integer.toString(hotel.getCanalFav(9)));
            print(ah9, Integer.toString(hotel.getTemposThreadsTV(9)));
            print(dh9, Integer.toString(hotel.getTemposThreadsDesc(9)));
            ancora9.setOpacity(1);
            move[9].posicionar
        ();
        }
        contagem[Integer.parseInt(Thread.currentThread().getName())] = System.currentTimeMillis();
        while (contagem[Integer.parseInt(Thread.currentThread().getName())] > (System.currentTimeMillis() - 500)) {
        }
        barrierCount=barrierCount+1;
        mutex.release();
        if(barrierCount==hotel.getQtdHospedes()){
            barrier.release();
        }
        try {
            barrier.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        barrier.release();
        
        while (true) {
            try {
                mutex.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            

            //Se canal for 0, TV está desligada
            if (canal == 0) {
                
                logLigarTv(Integer.parseInt(Thread.currentThread().getName()));//Adiciona ao log que a thread entrou na sala e ligou a Tv
                canal = hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName()));
                contagem[Integer.parseInt(Thread.currentThread().getName())] = System.currentTimeMillis();
                while (contagem[Integer.parseInt(Thread.currentThread().getName())] > (System.currentTimeMillis() - 300)) {}
                controleTv.setVisible(false);
                balao.setVisible(true);
                print(lblCanalAtual,Integer.toString(hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName()))));
            }
            if (hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName())) == canal) {//Threads com mesmo canal favorito entram
                mutex.release();
                try {
                    mutex2.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                count++;
                if (count == 1){
                    mudarCanal();
                    garantia = System.currentTimeMillis();
                    while (garantia > System.currentTimeMillis() - 500) {}
                    //Espera de meio segundo pra garantir que todas as threads que têm o mesmo canal favorito tenham entrado.
                    try {                                           
                        barreira.acquire();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                mutex2.release();
                
                assistir();
                
                try {
                    mutex2.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(verificarCanais){
                    if (hotel.verificarCanais()) {
                        mesmosCanais=true;
                    }
                    verificarCanais=false;
                }
                
                count--;
                
                if (count == 0) {
                    logDesligarTv(Integer.parseInt(Thread.currentThread().getName())); //Thread desligou a TV
                        canais[referencia].setVisible(false);
                        audios[referencia].stop();
                        balao.setVisible(false);
                        controleTv.setVisible(true);
                        Platform.runLater(() -> {
                            lblCanalAtual.setText("");
                    });
                        canal=0;
                    
                    
                    barreira.release();//Última thread a sair abre a barreira e acorda todas as threads bloqueadas
                }

                mutex2.release();

                descansar();
            } else {
                mutex.release();
                
                try {
                    barreira.acquire();//Threads de canais distintos ficam bloqueadas aqui
                } catch (InterruptedException ex) {
                    Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                barreira.release();
            }
        }
    }
    
    public void assistir() {
        try {
            assistir.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        contagem[Integer.parseInt(Thread.currentThread().getName())] = System.currentTimeMillis();
        while (contagem[Integer.parseInt(Thread.currentThread().getName())] > (System.currentTimeMillis() - 100)) {}
        logAssistir(Integer.parseInt(Thread.currentThread().getName()));//Adiciona ao log que thread está assistindo
        
        if (Integer.parseInt(Thread.currentThread().getName()) == 0) {
            paint(ancora0, "-fx-background-color: #51ff62");
            assistir.release();
            
            
            if(assistirDnv[0] || mesmosCanais){
                if(umHospede){
                    sprite[0].setVisible(true);
                    boy1Back.setVisible(false);
                    move[0].sairPiano();
                    audios[10].stop();
                }
                else {move[0].assistirDnv();}
            }
            else{move[0].assistir();}
            
            contagem[0] = System.currentTimeMillis();
            while (contagem[0] > (System.currentTimeMillis() - 2000)) {}
            
            for (int i = hotel.getTemposThreadsTV(0) - 1; i >= 0; i--) {
                contagem[0] = System.currentTimeMillis();
                while (contagem[0] > (System.currentTimeMillis() - 1000)) {}
                print(ah0, Integer.toString(i));
            }
            print(ah0, Integer.toString(hotel.getTemposThreadsTV(0)));
        }
        
        if (Integer.parseInt(Thread.currentThread().getName()) == 1) {
            paint(ancora1, "-fx-background-color: #51ff62");
            assistir.release();
            if(assistirDnv[1] || mesmosCanais){move[1].assistirDnv();} 
            else {move[1].assistir();}
            contagem[1] = System.currentTimeMillis();
            while (contagem[1] > (System.currentTimeMillis() - 2000)) {}            
            for (int i = hotel.getTemposThreadsTV(1) - 1; i >= 0; i--) {
                contagem[1] = System.currentTimeMillis();
                while (contagem[1] > (System.currentTimeMillis() - 1000)) {
                }
                print(ah1, Integer.toString(i));
            }
            print(ah1, Integer.toString(hotel.getTemposThreadsTV(1)));
        }
        
        if (Integer.parseInt(Thread.currentThread().getName()) == 2) {
            paint(ancora2, "-fx-background-color: #51ff62");
            assistir.release();
            if(assistirDnv[2] || mesmosCanais){move[2].assistirDnv();} 
            else {move[2].assistir();}
            contagem[2] = System.currentTimeMillis();
            while (contagem[2] > (System.currentTimeMillis() - 2000)) {}
            for (int i = hotel.getTemposThreadsTV(2) - 1; i >= 0; i--) {
                contagem[2] = System.currentTimeMillis();
                while (contagem[2] > (System.currentTimeMillis() - 1000)) {
                }
                print(ah2, Integer.toString(i));
            }
            print(ah2, Integer.toString(hotel.getTemposThreadsTV(2)));
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 3) {
            paint(ancora3, "-fx-background-color: #51ff62");
            assistir.release();
            if(assistirDnv[3] || mesmosCanais){move[3].assistirDnv();}
            else{move[3].assistir();}
            
            contagem[3] = System.currentTimeMillis();
            while (contagem[3] > (System.currentTimeMillis() - 2000)) {}
            
            for (int i = hotel.getTemposThreadsTV(3) - 1; i >= 0; i--) {
                contagem[3] = System.currentTimeMillis();
                while (contagem[3] > (System.currentTimeMillis() - 1000)) {}
                print(ah3, Integer.toString(i));
            }
            print(ah3, Integer.toString(hotel.getTemposThreadsTV(3)));
        }
        
        if (Integer.parseInt(Thread.currentThread().getName()) == 4) {
            paint(ancora4, "-fx-background-color: #51ff62");
            assistir.release();
            if(assistirDnv[4] || mesmosCanais){move[4].assistirDnv();}
            else{move[4].assistir();}
            
            contagem[4] = System.currentTimeMillis();
            while (contagem[4] > (System.currentTimeMillis() - 2000)) {}
            
            for (int i = hotel.getTemposThreadsTV(4) - 1; i >= 0; i--) {
                contagem[4] = System.currentTimeMillis();
                while (contagem[4] > (System.currentTimeMillis() - 1000)) {}
                print(ah4, Integer.toString(i));
            }
            print(ah4, Integer.toString(hotel.getTemposThreadsTV(0)));
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 5) {
            paint(ancora5, "-fx-background-color: #51ff62");
            assistir.release();
            if(assistirDnv[5] || mesmosCanais){move[5].assistirDnv();}
            else{move[5].assistir();}
            
            contagem[5] = System.currentTimeMillis();
            while (contagem[5] > (System.currentTimeMillis() - 2000)) {}
            
            for (int i = hotel.getTemposThreadsTV(5) - 1; i >= 0; i--) {
                contagem[5] = System.currentTimeMillis();
                while (contagem[5] > (System.currentTimeMillis() - 1000)) {}
                print(ah5, Integer.toString(i));
            }
            print(ah5, Integer.toString(hotel.getTemposThreadsTV(5)));
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 6) {
            paint(ancora6, "-fx-background-color: #51ff62");
            assistir.release();
            if(assistirDnv[6] || mesmosCanais){move[6].assistirDnv();}
            else{move[6].assistir();}
            
            contagem[6] = System.currentTimeMillis();
            while (contagem[6] > (System.currentTimeMillis() - 2000)) {}
            
            for (int i = hotel.getTemposThreadsTV(6) - 1; i >= 0; i--) {
                contagem[6] = System.currentTimeMillis();
                while (contagem[6] > (System.currentTimeMillis() - 1000)) {}
                print(ah6, Integer.toString(i));
            }
            print(ah6, Integer.toString(hotel.getTemposThreadsTV(6)));
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 7) {
            paint(ancora7, "-fx-background-color: #51ff62");
            assistir.release();
            if(assistirDnv[7] || mesmosCanais){move[7].assistirDnv();}
            else{move[7].assistir();}
            
            contagem[7] = System.currentTimeMillis();
            while (contagem[7] > (System.currentTimeMillis() - 2000)) {}
            
            for (int i = hotel.getTemposThreadsTV(7) - 1; i >= 0; i--) {
                contagem[7] = System.currentTimeMillis();
                while (contagem[7] > (System.currentTimeMillis() - 1000)) {}
                print(ah7, Integer.toString(i));
            }
            print(ah7, Integer.toString(hotel.getTemposThreadsTV(7)));
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 8) {
            paint(ancora8, "-fx-background-color: #51ff62");
            assistir.release();
            if(assistirDnv[8] || mesmosCanais){move[8].assistirDnv();}
            else{move[8].assistir();}
            
            contagem[8] = System.currentTimeMillis();
            while (contagem[8] > (System.currentTimeMillis() - 2000)) {}
            
            for (int i = hotel.getTemposThreadsTV(8) - 1; i >= 0; i--) {
                contagem[8] = System.currentTimeMillis();
                while (contagem[8] > (System.currentTimeMillis() - 1000)) {}
                print(ah8, Integer.toString(i));
            }
            print(ah8, Integer.toString(hotel.getTemposThreadsTV(8)));
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 9) {
            paint(ancora9, "-fx-background-color: #51ff62");
            assistir.release();
            if(assistirDnv[9] || mesmosCanais){move[9].assistirDnv();}
            else{move[9].assistir();}
            
            contagem[9] = System.currentTimeMillis();
            while (contagem[9] > (System.currentTimeMillis() - 2000)) {}
            
            for (int i = hotel.getTemposThreadsTV(9) - 1; i >= 0; i--) {
                contagem[9] = System.currentTimeMillis();
                while (contagem[9] > (System.currentTimeMillis() - 1000)) {}
                print(ah9, Integer.toString(i));
            }
            print(ah9, Integer.toString(hotel.getTemposThreadsTV(9)));
        }
    }

    public void descansar() {
        try {
            descansar.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        logDescansar(Integer.parseInt(Thread.currentThread().getName()));//Adiciona ao log que thread está descançando
        
        if (Integer.parseInt(Thread.currentThread().getName()) == 0) {
            paint(ancora0, "-fx-background-color: #f3ff51");
            descansar.release();
            if(umHospede){move[0].piano();}
            else {move[0].descansar();}
            contagem[0] = System.currentTimeMillis();
            while (contagem[0] > (System.currentTimeMillis() - 1800)) {
            }
            if(umHospede){
            sprite[0].setVisible(false);
            boy1Back.setVisible(true);
            audios[10].play();
            }
            
            for (int i = hotel.getTemposThreadsDesc(0) - 1; i >= 0; i--) {
                contagem[0] = System.currentTimeMillis();
                while (contagem[0] > (System.currentTimeMillis() - 1000)) {
                }
                print(dh0, Integer.toString(i));
            }
            print(dh0, Integer.toString(hotel.getTemposThreadsDesc(0)));
            
            if(mesmosCanais==true){}
            else if(canal==hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName()))){
                assistirDnv[0]=true;
            }
            else{
                assistirDnv[0]=false;
                paint(ancora0, "-fx-background-color: #f2eded");
                move[0].bloquear();
                contagem[0] = System.currentTimeMillis();
                while (contagem[0] > (System.currentTimeMillis() - 2000)) {
                }
            }
        }
        
        if (Integer.parseInt(Thread.currentThread().getName()) == 1) {
            
            paint(ancora1, "-fx-background-color: #f3ff51");
            descansar.release();
            move[1].descansar();
            contagem[1] = System.currentTimeMillis();
            while (contagem[1] > (System.currentTimeMillis() - 1600)) {
            }
            
            for (int i = hotel.getTemposThreadsDesc(1) - 1; i >= 0; i--) {
                contagem[1] = System.currentTimeMillis();
                while (contagem[1] > (System.currentTimeMillis() - 1000)) {
                }
                print(dh1, Integer.toString(i));
            }
            print(dh1, Integer.toString(hotel.getTemposThreadsDesc(1)));
            if (mesmosCanais == true) {
            }
            else if (canal == hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName()))) {
                assistirDnv[1] = true;
            } else {
                assistirDnv[1] = false;
                paint(ancora1, "-fx-background-color: #f2eded");
                move[1].bloquear();
                contagem[1] = System.currentTimeMillis();
                while (contagem[1] > (System.currentTimeMillis() - 2000)) {
                }
            }         
        }
        
        if (Integer.parseInt(Thread.currentThread().getName()) == 2) {
            paint(ancora2, "-fx-background-color: #f3ff51");
            descansar.release();
            move[2].descansar();
            contagem[2] = System.currentTimeMillis();
            while (contagem[2] > (System.currentTimeMillis() - 1600)) {
            }
            
            
            for (int i = hotel.getTemposThreadsDesc(2) - 1; i >= 0; i--) {
                contagem[2] = System.currentTimeMillis();
                while (contagem[2] > (System.currentTimeMillis() - 1000)) {
                }
                print(dh2, Integer.toString(i));
            }
            print(dh2, Integer.toString(hotel.getTemposThreadsDesc(2)));
            if (mesmosCanais == true) {
            }
            else if (canal == hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName()))) {
                assistirDnv[2] = true;
            } else {
                assistirDnv[2] = false;
                paint(ancora2, "-fx-background-color: #f2eded");
                move[2].bloquear();
                contagem[2] = System.currentTimeMillis();
                while (contagem[2] > (System.currentTimeMillis() - 2000)) {
                }
            }
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 3) {
            paint(ancora3, "-fx-background-color: #f3ff51");
            descansar.release();
            move[3].descansar();
            contagem[3] = System.currentTimeMillis();
            while (contagem[3] > (System.currentTimeMillis() - 1600)) {
            }
            
            for (int i = hotel.getTemposThreadsDesc(3) - 1; i >= 0; i--) {
                contagem[3] = System.currentTimeMillis();
                while (contagem[3] > (System.currentTimeMillis() - 1000)) {
                }
                print(dh3, Integer.toString(i));
            }
            print(dh3, Integer.toString(hotel.getTemposThreadsDesc(3)));
            
            if(mesmosCanais==true){}
            else if(canal==hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName()))){
                assistirDnv[3]=true;
            }
            else{
                assistirDnv[3]=false;
                paint(ancora3, "-fx-background-color: #f2eded");
                move[3].bloquear();
                contagem[3] = System.currentTimeMillis();
                while (contagem[3] > (System.currentTimeMillis() - 2000)) {
                }
            }
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 4) {
            paint(ancora4, "-fx-background-color: #f3ff51");
            descansar.release();
            move[4].descansar();
            contagem[4] = System.currentTimeMillis();
            while (contagem[4] > (System.currentTimeMillis() - 1600)) {
            }
            
            for (int i = hotel.getTemposThreadsDesc(4) - 1; i >= 0; i--) {
                contagem[4] = System.currentTimeMillis();
                while (contagem[4] > (System.currentTimeMillis() - 1000)) {
                }
                print(dh4, Integer.toString(i));
            }
            print(dh4, Integer.toString(hotel.getTemposThreadsDesc(4)));
            
            if(mesmosCanais==true){}
            else if(canal==hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName()))){
                assistirDnv[4]=true;
            }
            else{
                assistirDnv[4]=false;
                paint(ancora4, "-fx-background-color: #f2eded");
                move[4].bloquear();
                contagem[4] = System.currentTimeMillis();
                while (contagem[4] > (System.currentTimeMillis() - 2000)) {
                }
            }
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 5) {
            paint(ancora5, "-fx-background-color: #f3ff51");
            descansar.release();
            move[5].descansar();
            contagem[5] = System.currentTimeMillis();
            while (contagem[5] > (System.currentTimeMillis() - 1600)) {
            }
            
            for (int i = hotel.getTemposThreadsDesc(5) - 1; i >= 0; i--) {
                contagem[5] = System.currentTimeMillis();
                while (contagem[5] > (System.currentTimeMillis() - 1000)) {
                }
                print(dh5, Integer.toString(i));
            }
            print(dh5, Integer.toString(hotel.getTemposThreadsDesc(5)));
            
            if(mesmosCanais==true){}
            else if(canal==hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName()))){
                assistirDnv[5]=true;
            }
            else{
                assistirDnv[5]=false;
                paint(ancora5, "-fx-background-color: #f2eded");
                move[5].bloquear();
                contagem[5] = System.currentTimeMillis();
                while (contagem[5] > (System.currentTimeMillis() - 2000)) {
                }
            }
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 6) {
            paint(ancora6, "-fx-background-color: #f3ff51");
            descansar.release();
            move[6].descansar();
            contagem[6] = System.currentTimeMillis();
            while (contagem[6] > (System.currentTimeMillis() - 1600)) {
            }
            
            for (int i = hotel.getTemposThreadsDesc(6) - 1; i >= 0; i--) {
                contagem[6] = System.currentTimeMillis();
                while (contagem[6] > (System.currentTimeMillis() - 1000)) {
                }
                print(dh6, Integer.toString(i));
            }
            print(dh6, Integer.toString(hotel.getTemposThreadsDesc(6)));
            
            if(mesmosCanais==true){}
            else if(canal==hotel.getCanalFav(6)){
                assistirDnv[6]=true;
            }
            else{
                assistirDnv[6]=false;
                paint(ancora6, "-fx-background-color: #f2eded");
                move[6].bloquear();
                contagem[6] = System.currentTimeMillis();
                while (contagem[6] > (System.currentTimeMillis() - 2000)) {
                }
            }
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 7) {
            paint(ancora7, "-fx-background-color: #f3ff51");
            descansar.release();
            move[7].descansar();
            contagem[7] = System.currentTimeMillis();
            while (contagem[7] > (System.currentTimeMillis() - 1600)) {
            }
            
            for (int i = hotel.getTemposThreadsDesc(7) - 1; i >= 0; i--) {
                contagem[7] = System.currentTimeMillis();
                while (contagem[7] > (System.currentTimeMillis() - 1000)) {
                }
                print(dh7, Integer.toString(i));
            }
            print(dh7, Integer.toString(hotel.getTemposThreadsDesc(7)));
            
            if(mesmosCanais==true){}
            else if(canal==hotel.getCanalFav(7)){
                assistirDnv[7]=true;
            }
            else{
                assistirDnv[7]=false;
                paint(ancora7, "-fx-background-color: #f2eded");
                move[7].bloquear();
                contagem[7] = System.currentTimeMillis();
                while (contagem[7] > (System.currentTimeMillis() - 2000)) {
                }
            }
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 8) {
            paint(ancora8, "-fx-background-color: #f3ff51");
            descansar.release();
            move[8].descansar();
            contagem[8] = System.currentTimeMillis();
            while (contagem[8] > (System.currentTimeMillis() - 1600)) {
            }
            
            for (int i = hotel.getTemposThreadsDesc(8) - 1; i >= 0; i--) {
                contagem[8] = System.currentTimeMillis();
                while (contagem[8] > (System.currentTimeMillis() - 1000)) {
                }
                print(dh8, Integer.toString(i));
            }
            print(dh8, Integer.toString(hotel.getTemposThreadsDesc(8)));
            
            if(mesmosCanais==true){}
            else if(canal==hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName()))){
                assistirDnv[8]=true;
            }
            else{
                assistirDnv[8]=false;
                paint(ancora8, "-fx-background-color: #f2eded");
                move[8].bloquear();
                contagem[8] = System.currentTimeMillis();
                while (contagem[8] > (System.currentTimeMillis() - 2000)) {
                }
            }
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == 9) {
            paint(ancora9, "-fx-background-color: #f3ff51");
            descansar.release();
            move[9].descansar();
            contagem[9] = System.currentTimeMillis();
            while (contagem[9] > (System.currentTimeMillis() - 1600)) {
            }
            
            for (int i = hotel.getTemposThreadsDesc(9) - 1; i >= 0; i--) {
                contagem[9] = System.currentTimeMillis();
                while (contagem[9] > (System.currentTimeMillis() - 1000)) {
                }
                print(dh9, Integer.toString(i));
            }
            print(dh9, Integer.toString(hotel.getTemposThreadsDesc(9)));
            
            if(mesmosCanais==true){}
            else if(canal==hotel.getCanalFav(Integer.parseInt(Thread.currentThread().getName()))){
                assistirDnv[9]=true;
            }
            else{
                assistirDnv[9]=false;
                paint(ancora9, "-fx-background-color: #f2eded");
                move[9].bloquear();
                contagem[9] = System.currentTimeMillis();
                while (contagem[9] > (System.currentTimeMillis() - 2000)) {
                }
            }
        }
    }

    public void criarHospedes() {
        for (int i = 0; i < hotel.getQtdHospedes(); i++) {
            hosp[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    sala();
                }
            });
            hosp[i].setName(Integer.toString(i));
            hotel.setCanalFav(i);
            move[i] = new Movimento(sprite[i], i);
        }
        
        if(hotel.getQtdHospedes()==1){
            umHospede=true;
            move[0].setNodeTocar(boy1Back);
        }
        
        for (int i = 0; i < hotel.getQtdHospedes(); i++) {
            for (int j = 0; j < hotel.getQtdHospedes(); j++) {
                if(i!=j){
                    if(hotel.getCanalTv(i) == hotel.getCanalTv(j)){
                        hotel.setCanalTv(i);
                    }
                }
            }
        }
    }

    public void comecar() {
        for (int i = 0; i < hotel.getQtdHospedes(); i++) {
            hosp[i].start();
        }
    }

    @FXML
    private void proxInfo(ActionEvent event) {
        if(info==0){
            anterior.setVisible(true);
            info1.setVisible(false);
            info2.setVisible(true);
        }
        if(info==1){
            info2.setVisible(false);
            info3.setVisible(true);
        }
        if(info==2){
            info3.setVisible(false);
            info4.setVisible(true);
        }
        if(info==3){
            info4.setVisible(false);
            info5.setVisible(true);
            proximo.setText("Vamos lá!");
        }
        if(info==4){
            proximo.setVisible(false);
            info5.setVisible(false);
            dicas.setVisible(false);
            anterior.setVisible(false);
            comecar();
        }
        if (info<4) {info++;}
    }

    @FXML
    private void pularDicas(ActionEvent event) {
        info1.setVisible(false);
        info2.setVisible(false);
        info3.setVisible(false);
        info4.setVisible(false);
        info5.setVisible(false);
        dicas.setVisible(false);
        proximo.setVisible(false);
        anterior.setVisible(false);
        comecar();
    }

    @FXML
    private void anteInfo(ActionEvent event) {
        
        if(info==1){
            info2.setVisible(false);
            info1.setVisible(true);
            anterior.setVisible(false);
        }
        if(info==2){
            info3.setVisible(false);
            info2.setVisible(true);
        }
        if(info==3){
            info4.setVisible(false);
            info3.setVisible(true);
            
        }
        if(info==4){
            proximo.setText("Próximo");
            info4.setVisible(true);
            info5.setVisible(false);
        }
        if(info>0){info--;}
    }


}

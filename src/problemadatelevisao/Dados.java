package problemadatelevisao;

public class Dados {
 //Criação das variáveis
    private int qtdHospedes;
    private int qtdCanais;
    private int temposThreads[][] = new int[10][2];
    private int minTV;
    private int maxTV;
    private int minDesc;
    private int maxDesc;
    private int canal=0;
    private int count = 0;
    private final int canalFav[]= new int[10];
    private boolean mesmoCanal=false;
    private final int nome[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int canalTv[] = {0,0,0,0,0,0,0,0,0,0};
    public boolean verificarCanais(){
        int total=0;
        for (int i = 0; i < qtdHospedes; i++) {
            if(getCanalFav(i)==getCanalFav(0)){
                total++;
            }
        }
        if(total == qtdHospedes){mesmoCanal=true;}
        return mesmoCanal;
    }

    public int getCanalTv(int x) {
        return canalTv[x];
    }

    public void setCanalTv(int posicao) {
        canalTv[posicao] = 0;
    }

    public int getNome(int x) {
        return nome[x];
    }
    
    
    public int getCanalFav(int x) {
        return canalFav[x];
    }

    public void setCanalFav(int y) {
        this.canalFav[y] = (int) (1 + Math.random() * (getQtdCanais() - 1));
        canalTv[y] = this.canalFav[y];
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public void setAtributosTempo() {
        temposThreads = new int[getQtdHospedes()][2];
    }
    
    public int getQtdHospedes() {
        return qtdHospedes;
    }
    
    public void setQtdHospedes(int qtdHospedes) {
        this.qtdHospedes = qtdHospedes;
    }
    
    public int getQtdCanais() {
        return qtdCanais;
    }

    public void setQtdCanais(int qtdCanais) {
        this.qtdCanais = qtdCanais;
    }
    
    public int getMinTV() {
        return minTV;
    }

    public void setMinTV(int setMinTV) {
        this.minTV = setMinTV;
    }

    public int getMaxTV() {
        return maxTV;
    }

    public void setMaxTV(int maxTV) {
        this.maxTV = maxTV;
    }

    public int getMinDesc() {
        return minDesc;
    }

    public void setMinDesc(int minDesc) {
        this.minDesc = minDesc;
    }

    public int getMaxDesc() {
        return maxDesc;
    }

    public void setMaxDesc(int maxDesc) {
        this.maxDesc = maxDesc;
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }
    
    public int getTemposThreadsTV(int x){
        return this.temposThreads[x][0];
    }
    
    public int getTemposThreadsDesc(int x){
        return this.temposThreads[x][1];
    }
    
    public void setTemposThreads() {
        for (int i = 0; i < qtdHospedes; i++){
            this.temposThreads[i][0] = (int)(minTV+(Math.random()*(maxTV-minTV)));
        }
        for (int i = 0; i < qtdHospedes; i++){
            this.temposThreads[i][1]= (int)(minDesc+(Math.random()*(maxDesc-minDesc)));
        }
    }
}

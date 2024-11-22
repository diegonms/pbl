abstract class Personagem {
    protected boolean vivo;
    protected float posicao_x;
    protected float posicao_y;
    protected float posicao_z;
    protected  String traje;

    public Personagem(boolean vivo, float posicao_x, float posicao_y, float posicao_z, String traje){
        this.vivo = vivo;
        this.posicao_x = posicao_x;
        this.posicao_y = posicao_y;
        this.posicao_z = posicao_z;
        this.traje = traje;
        this.traje = traje;
    }

    public abstract void correr();
    public abstract void saltar(float posicao_z);
    public abstract void atirar();
    public void morrer(){
        System.out.println("Morrendo...");
    }
}

abstract class Heroi extends Personagem{

    public Heroi(boolean vivo, float posicao_x, float posicao_y, float posicao_z, String traje){
        super(vivo, posicao_x, posicao_y, posicao_z, traje);
    }

    @Override
    public void atirar() {
        System.out.println("Heroi atirando...");
    }

    @Override
    public void correr() {
    }

    @Override
    public void saltar(float posicao_z) {
        System.out.println("saltando para a posicao "+posicao_z);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
abstract class Vilao extends Personagem{
    public Vilao(boolean vivo, float posicao_x, float posicao_y, float posicao_z, String traje){
        super(vivo, posicao_x, posicao_y, posicao_z, traje);
    }

    @Override
    public void saltar(float posicao_z) {
        System.out.println("Saltando para a posicao "+posicao_z);
    }

    @Override
    public void atirar() {
    }

    @Override
    public void correr() {
    }
}
class Batman extends Heroi implements Camuflagem{
    public Batman(boolean vivo, float posicao_x, float posicao_y, float posicao_z, String traje){
        super(vivo, posicao_x, posicao_y, posicao_z, traje);
    }

    @Override
    public void atirar() {
        System.out.println("Batman atirando...");
    }
    public void camuflar(String traje){
        System.out.println("Bamtman camuflando no traje "+traje);
    }
}
class JamesBond extends Heroi{
    public JamesBond(boolean vivo, float posicao_x, float posicao_y, float posicao_z, String traje){
        super(vivo, posicao_x, posicao_y, posicao_z, traje);
    }
    public void atirar(){
        System.out.println("James Bond atirando...");
    }
    public void saltar(){
        System.out.println("James Bond saltando..."+"...");
    }
}
interface Camuflagem{
    void camuflar(String traje);
}

interface Personificacao extends Camuflagem{
    void personificar(Heroi h);
}
class Ladrao extends Vilao{
    public Ladrao(boolean vivo, float posicao_x, float posicao_y, float posicao_z, String traje){
        super(vivo, posicao_x, posicao_y, posicao_z, traje);
    }

    @Override
    public void saltar(float posicao_z) {
        System.out.println("Ladrao saltando para a posicao "+posicao_z+"...");
    }
}
class Coringa extends Ladrao{
    public Coringa(boolean vivo, float posicao_x, float posicao_y, float posicao_z, String traje) {
        super(vivo, posicao_x, posicao_y, posicao_z, traje);
    }
    @Override
    public void atirar() {
        System.out.println("Coringa atirando...");
    }
}
class Pinguim extends Ladrao{
    public Pinguim(boolean vivo, float posicao_x, float posicao_y, float posicao_z, String traje){
        super(vivo , posicao_x, posicao_y, posicao_z, traje);
    }

    @Override
    public void atirar() {
        System.out.println("Pinguim atirando...");
    }

    @Override
    public void correr() {
        System.out.println("Pinguim correndo...");
    }
}
class Terrorista extends Vilao{
    public Terrorista(boolean vivo, float posicao_x, float posicao_y, float posicao_z, String traje){
        super(vivo, posicao_x, posicao_y, posicao_z, traje);
    }

    @Override
    public void atirar() {
        System.out.println("Terrorista atirando...");
    }
}
class Drno extends Terrorista{
    public Drno(boolean vivo, float posicao_x, float posicao_y, float posicao_z, String traje){
        super(vivo, posicao_x, posicao_y, posicao_z, traje);
    }

    @Override
    public void atirar() {
        System.out.println("Dr. No atirando...");
    }

    @Override
    public void saltar(float posicao_z) {
        System.out.println("Dr. No saltando para a posicao "+posicao_z+"...");
        this.posicao_z = posicao_z;
    }

    @Override
    public void correr() {
        System.out.println("Dr. No correndo...");
    }
}
class Goldfinger extends Terrorista implements Personificacao{
    private Heroi heroi;
    public Goldfinger(boolean vivo, float posicao_x, float posicao_y, float posicao_z, String traje, Heroi h){
        super(vivo, posicao_x, posicao_y, posicao_z, traje);
        this.heroi = h;
    }

    @Override
    public void saltar(float posicao_z) {
        this.posicao_z = posicao_z;
        System.out.println("Gold finger esta saltando...");
    }
    public void camuflar(String traje){
        System.out.println("Gold finger camuflando de "+traje+"...");
    }
    public void personificar(Heroi h){
        this.heroi = h;
        System.out.println("Gold finger personificando para " + h.getClass().getSimpleName());


    }
}
public class pbl07 {
    public static void main(String[] args) {
        Batman batman = new Batman(true, 5, 6, 7, "pretasso");
        JamesBond james = new JamesBond(false, 6, 7, 0, "branco");
        Coringa coringa = new Coringa(true, 4, 9, 45, "Paleto verde");
        Pinguim pinguim = new Pinguim(false, 1, 2, 4, "bengala");
        Goldfinger gFinger = new Goldfinger(false, 8, 9, 7, "dedo de ouro", james);
        Drno drno = new Drno(true, 4, 9, 7, "Branco");


        batman.atirar();
        batman.camuflar("capa");

        james.atirar();
        james.saltar();

        coringa.atirar();

        pinguim.atirar();
        pinguim.correr();

        gFinger.saltar(6);
        gFinger.camuflar("planta");
        gFinger.personificar(james);

        drno.saltar(6);
        drno.atirar();
        drno.correr();
    }
}
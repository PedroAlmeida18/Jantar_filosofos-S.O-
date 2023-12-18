import java.util.Random;

public class Filosofos { 
    public class Garfos extends Thread{ // thread garfo
        private final int garfoEsquerda;
        private final int garfoDireita ;
        public Garfos(int garfoDireita, int garfoEsquerda){
            this.garfoDireita = garfoDireita;
            this.garfoEsquerda = garfoEsquerda;
            
        }
        public void run(){ // método para executar a thread
            while(true){
                try{
                    SorteioDireita();
                    SorteioESuqerda();
                    Thread.sleep(1000);

                }
                catch(InterruptedException e){
                    System.out.println(e);

                }
            }
        }
        
        private void SorteioDireita() { // Sorteio do Garfo
            int garfoD;
            Random R = new Random();
            garfoD=R.nextInt(5);
            System.out.println("O garfo da direita sorteado "+ garfoDireita);
            
        }
        private void SorteioESuqerda() {
            int garfoE;
            Random e = new Random();
            garfoE=e.nextInt(5);
            System.out.println("O garfo da esquerda sorteado "+ garfoEsquerda);
        }
        

    } 
    public class Filosofo extends Thread{ //  Classe : Thread para o Filosofo
        String nome ;
        Garfos garfo;
        int lugar_mesa;
        public Filosofo(String nome,Garfos garfo,int lugar_mesa ){ // construtor da classe
            this.nome = nome;
            this.garfo=garfo;
            this.lugar_mesa=lugar_mesa;
            System.out.println("o filosofo "+ nome + " sentou a mesa");
        }
        public void Pensar() throws InterruptedException{ // método para filosofo pensar
            System.out.println("o filosofo "+ nome+ " está no mundo da lua ");
            Thread.sleep(1000);


        }
        
        public void run(){ //método para verificar os 
                           //garfos da direita e esquerda para permitir que a filosofo coma 

            while(true){

                if(garfo.garfoDireita==5){

                    System.out.println("O filosofo "+nome+" pegou o grafo "+ garfo.garfoDireita);

                    if(garfo.garfoEsquerda==1){
                        System.out.println("o filosofo "+ nome+" pegou o garfo "+ garfo.garfoEsquerda);
                        System.out.println("o filosofo "+ nome+ " Está comendo");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da direita");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da esquerda");
                    } else{
                        System.out.println("o filosofo "+ nome+ " largou o garfo "+ garfo.garfoDireita);
                    }

                } else {
                    try {
                        Pensar();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
                if (garfo.garfoDireita==1){
                    System.out.println("O filosofo "+nome+" pegou o grafo"+ garfo.garfoDireita);
                    if (garfo.garfoEsquerda==2) {
                        System.out.println("o filosofo "+ nome+" pegou o garfo "+ garfo.garfoEsquerda);
                        System.out.println("o filosofo "+ nome+ " ESTÁ COMENDO");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da direita");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da esquerda");
                        
                    }
                    else{
                        System.out.println("o filosofo "+ nome+ " largou o garfo"+ garfo.garfoDireita);
                    }

                } else{
                     try {
                        Pensar();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }

                }
                if (garfo.garfoDireita==2) {
                    System.out.println("O filosofo "+nome+" pegou o grafo "+ garfo.garfoDireita);
                    if (garfo.garfoEsquerda==3) {
                        System.out.println("o filosofo "+ nome+" pegou o garfo "+ garfo.garfoEsquerda);
                        System.out.println("o filosofo "+ nome+ " Está comendo");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da direita");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da esquerda");
                    }
                    else{
                        System.out.println("o filosofo "+ nome+ " largou o garfo "+ garfo.garfoDireita);
                    }
             
                } else{
                    try {
                        Pensar();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    
                }
                if (garfo.garfoDireita==3) {
                    System.out.println("O filosofo " +nome+" pegou o grafo "+ garfo.garfoDireita);
                    if (garfo.garfoEsquerda==4) {
                        System.out.println("o filosofo "+ nome+" pegou o garfo "+ garfo.garfoEsquerda);
                        System.out.println("o filosofo "+ nome+ " Está comendo");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da direita");
                        System.out.println(" o filosofo "+ nome+ " largou o garfo da esquerda");
                        
                    } else{
                        System.out.println(" o filosofo "+ nome+ " largou o garfo "+ garfo.garfoDireita);
                    }
                    
                } else {
                    try {
                        Pensar();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }

                } if (garfo.garfoDireita==4) {
                    System.out.println("O filosofo "+nome+" pegou o grafo "+ garfo.garfoDireita);
                    if (garfo.garfoEsquerda==5) {
                        System.out.println("o filosofo "+ nome+" pegou o garfo "+ garfo.garfoEsquerda);
                        System.out.println("o filosofo "+ nome+ " Está comendo");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da direita");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da esquerda");
                        
                    } else {
                        System.out.println("o filosofo "+ nome+ " largou o garfo "+ garfo.garfoDireita);
                        
                    }
                } else {
                    try {
                        Pensar();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    
                }
            }
        }
        

    }
    public void test(){
            Garfos g1 = new Garfos(5, 1); // criação dos garfos
            Garfos g2 = new Garfos(1, 2);
            Garfos g3 = new Garfos(2, 3);
            Garfos g4 = new Garfos(3, 4);
            Garfos g5 = new Garfos(4, 5);
            
            // Não é necessário inicializar threads para os garfos
            // Pois os garfos são inicializado como threads no momneto da criação 

            Filosofo filosofo1 = new Filosofo("PEDRO", g1, 1); // criação dos filosofos
            Filosofo filosofo2 = new Filosofo("JOÃO", g2, 2);
            Filosofo filosofo3 = new Filosofo("CARLOS", g3, 3);
            Filosofo filosofo4 = new Filosofo("WALDEMAR", g4, 4);
            Filosofo filosofo5 = new Filosofo("EZEQUEIL", g5, 5);
                
                new Thread(filosofo1).start(); // iniciando a thread filoosofo 5 vezes para cada filosofo
                new Thread(filosofo2).start();
                new Thread(filosofo3).start();
                new Thread(filosofo4).start();
                new Thread(filosofo5).start();
            // é necessário, pois quero que lógica defindida seja executada em uma thread separada para cada filosofo

        }
    
    
}

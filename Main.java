import java.util.Scanner;

public class Main {
    
    //função para fatoração do valor racional
    public static String simplifica(int numerador, int denominador, String racional) {
        
        //lista de fatores primos para futura fatoração
	    int[] fatores = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541,547,557,563,569,571,577,587,593,599,601,607,613,617,619,631,641,643,647,653,659,661,673,677,683,691,701,709,719,727,733,739,743,751,757,761,769,773,787,797,809,811,821,823,827,829,839,853,857,859,863,877,881,883,887,907,911,919,929,937,941,947,953,967,971,977,983,991,997};
        
        //loop 'for' para percorrer cada elemento da lista de fatores primos
        for (int i : fatores) {
            
            //loop 'while' é executado enquanto o numerador e o denominador forem ambos divisiveis pelo mesmo fator
            while (numerador % i == 0 && denominador % i == 0) {
                
                //fatoração do numerador
                numerador /= i;
                //fatoração do denominador
                denominador /= i;
            }
        }
        
        //saída do resultado formatado com o valor racional e o valor fatorado
        return String.format("%s = %s/%s", racional, numerador, denominador);
    }
    
    //método para realizar a operação aritmética
    public static void tdaRacional(int N1, int D1, int N2, int D2, char op) {
        
        //declarando variaveis numerador e denominador e o n° racional
        int numerador = 0;
        int denominador = 1;  // Inicializando denominador com 1, pois não pode ser zero
        String racional;
        
        /* cada condição é um operador aritmético diferente (+. -, *, /)
        cada condição realiza a chamada do função de fatoração */
        if (op == '+') {
            numerador = N1*D2 + N2*D1;
            denominador = D1*D2;
        }
        else if (op == '-') {
            numerador = N1*D2 - N2*D1;
            denominador = D1*D2;
        }
        else if (op == '*') {
            numerador = N1*N2;
            denominador = D1*D2;
        }
        else if (op == '/') {
            numerador = N1*D2;
            denominador = N2*D1;
        }
        
        //n° racional recebe seu valor
        racional = String.format("%s/%s", numerador, denominador);
        
        //chamando e imprimindo o resultado da fatoração
        System.out.println(simplifica(numerador, denominador, racional));
    }
    
	public static void main(String[] args) {
	    
	    //instanciando o leitor de entrada do teclado
	    Scanner leitor = new Scanner(System.in);
   
        //quantidade de casos de teste
        int qtdCasoTeste = leitor.nextInt();
        
        //pula uma linha no CLI
        leitor.nextLine();
        
        //loop 'for' para executar cada caso de teste 1 a 1
        for (int i = 0; i < qtdCasoTeste; i++) {
            
            //entrada de caso de teste
            String casoTeste = leitor.nextLine();
            
            String[] listaDeComponentesDaString = casoTeste.split(" ");
        
    
            //guardando os valores do caso de teste dentro de variaveis separadas
            
            // Numerador 1
            int N1 = Integer.parseInt(listaDeComponentesDaString[0]);
            
            // Denominador 1
            int D1 = Integer.parseInt(listaDeComponentesDaString[2]);
            
            // Numerador 2
            int N2 = Integer.parseInt(listaDeComponentesDaString[4]);
            
            // Denominador 2 
            int D2 = Integer.parseInt(listaDeComponentesDaString[6]);
            
            // Operador aritmético {+ , -, *, /}
            char op = listaDeComponentesDaString[3].charAt(0);
            
            // chamada do método para realizar o cálculo e a fatoração
            tdaRacional(N1, D1, N2, D2, op);
            
        }
	    
	    // fechando o leitor de entrada do teclado
	    leitor.close();
	}
}

class BubbleSort {
    public static void bubble(int[] num) {
        int n = num.length; // Obtém o comprimento do array
        int aux, i, j;
        
        // Loop externo percorrendo o array
        for (i = 0; i <= n-2; i++) {
            // Loop interno percorrendo os elementos não ordenados
            for (j = 0; j <= n-2-i; j++) {
                // Compara elementos adjacentes e os troca se necessário
                if (num[j] > num[j+1]) {
                    aux = num[j];
                    num[j] = num[j+1];
                    num[j+1] = aux;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] vet = {9, 10, 34, 300, 0, 2, 105, 22, 5, -10}; // Array de inteiros
        
        // Chama a função bubble para ordenar o array
        bubble(vet);
        
        // Loop para imprimir os elementos do array ordenado
        for (int i = 0; i < vet.length; i++) {
            System.out.println(vet[i]);
        }
    }
}

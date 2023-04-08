import java.io.File;

public class RenomearArquivos {
    public static void main(String[] args) {
        // Define o caminho da pasta onde estão os arquivos a serem renomeados
        String caminhoDaPasta = "src\\res\\tiles";
        
        // Cria um objeto File que representa a pasta
        File pasta = new File(caminhoDaPasta);

        // Obtém a lista de arquivos da pasta
        File[] listaDeArquivos = pasta.listFiles();

        // Verifica se a lista de arquivos não está vazia
        if (listaDeArquivos != null) {
            // Inicia um contador para nomear os arquivos de forma sequencial
            int contador = 0;
            
            // Itera sobre a lista de arquivos
            for (File arquivo : listaDeArquivos) {
                // Verifica se o arquivo é realmente um arquivo (e não uma pasta, por exemplo)
                if (arquivo.isFile()) {
                    // Cria o novo nome do arquivo com base no contador, usando a formatação "%03d"
                    // para gerar um número com três dígitos, preenchidos com zeros à esquerda se necessário
                    String novoNome = String.format("%03d.png", contador);
                    
                    // Cria um novo objeto File que representa o arquivo com o novo nome
                    File novoArquivo = new File(pasta, novoNome);

                    // Tenta renomear o arquivo antigo para o novo nome
                    if (arquivo.renameTo(novoArquivo)) {
                        // Se o arquivo foi renomeado com sucesso, exibe uma mensagem de sucesso e incrementa o contador
                        // o File nao mudou de nome por isso o getName funciona
                        System.out.println("Arquivo " + arquivo.getName() + " renomeado para " + novoNome);
                        contador++;
                    } else {
                        // Se não foi possível renomear o arquivo, exibe uma mensagem de erro
                        System.out.println("Não foi possível renomear o arquivo " + arquivo.getName());
                    }
                }
            }
        } else {
            // Se a lista de arquivos está vazia, exibe uma mensagem de erro
            System.out.println("Não foi possível encontrar arquivos na pasta " + caminhoDaPasta);
        }
    }
}

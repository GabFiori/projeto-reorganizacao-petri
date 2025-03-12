Arquivo Árvore binária:

public class ArvoreBinaria {
    private No raiz;
    public ArvoreBinaria() {
        this.raiz = null;
    }
    public void inserir(int conteudo) {
        No novoNo = new No(conteudo);
        No pai;
        if(raiz == null) {
            //System.out.println("A raiz foi criada com o conteúdo " + novoNo.getConteudo() + ".");
            raiz = novoNo;
        } else {
            //Verificar se ficara a esq ou direita
            No atual = raiz;
            while(true) {
                pai = atual;
                if(novoNo.getConteudo() <= atual.getConteudo()) {
                    //posicionar o nó à esq
                    atual = atual.getEsquerda();
                    if(atual == null) {
                        pai.setEsquerda(novoNo);
                        //System.out.println("O nó com conteúdo " + novoNo.getConteudo() + " foi inserido com sucesso, onde seu pai é igual a: " + pai.getConteudo());
                        return;
                    }
                } else {
                    //posicionar o nó à dir
                    atual = atual.getDireita();
                    if(atual == null) {
                        pai.setDireita(novoNo);
                        //System.out.println("O nó com conteúdo " + novoNo.getConteudo() + " foi inserido com sucesso, onde seu pai é igual a: " + pai.getConteudo());
                        return;
                    }
                }
            }
            /*Problemas e Melhorias
            Uso de pai desnecessário

            A variável pai armazena o nó pai, mas já podemos definir atual.getEsquerda() ou atual.getDireita() diretamente.
                    Código duplicado nas condições if(atual == null)

                Tanto para a esquerda quanto para a direita, a lógica de atribuir novoNo ao filho do pai se repete. Isso pode ser simplificado.
            Conversão para um loop mais claro

             O while(true) pode ser reformulado para tornar o código mais intuitivo.
                    Uso correto de else

            Como o primeiro if já retorna se a raiz for nula, o else não é necessário.
                    Adição de comentários explicativos.*/



        }

        //Método Inserir melhorado

        /*public void inserir(int conteudo) {
            No novoNo = new No(conteudo);

            if (raiz == null) {
                raiz = novoNo;  // Se a árvore está vazia, o novo nó se torna a raiz.
                return;
            }

            No atual = raiz;

            while (true) {
                // Se o valor for menor ou igual, vá para a esquerda
                if (conteudo <= atual.getConteudo()) {
                    if (atual.getEsquerda() == null) {
                        atual.setEsquerda(novoNo);
                        return;
                    }
                    atual = atual.getEsquerda();
                } else {
                    // Se o valor for maior, vá para a direita
                    if (atual.getDireita() == null) {
                        atual.setDireita(novoNo);
                        return;
                    }
                    atual = atual.getDireita();*/
                }
            }
        }



    }
    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }
    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }
    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }
    public No getRaiz() {
        return raiz;
    }


        public void remover(int conteudo) {
        buscarNo(conteudo);
        No noParaRemover = noEncontrado;

        if (noParaRemover == null) {
            return; // Nó não encontrado, nada a fazer
        }

        if (isFolha(noParaRemover)) {
            removerFolha(noParaRemover);
        } else if (temApenasUmFilho(noParaRemover)) {
            removerNoComUmFilho(noParaRemover);
        } else if (temDoisFilhos(noParaRemover)) {
            removerNoComDoisFilhos(noParaRemover);
        }
    }

        // Verifica se o nó é uma folha (não tem filhos)
        private boolean isFolha(No no) {
            return no.getEsquerda() == null && no.getDireita() == null;
        }

        // Remove um nó folha
        private void removerFolha(No no) {
            if (paiDoNo.getDireita() == no) {
                paiDoNo.setDireita(null);
            } else {
                paiDoNo.setEsquerda(null);
            }
        }

        // Verifica se o nó tem apenas um filho
        private boolean temApenasUmFilho(No no) {
            return (no.getEsquerda() == null && no.getDireita() != null) ||
                (no.getEsquerda() != null && no.getDireita() == null);
        }

        // Remove um nó que tem apenas um filho
        private void removerNoComUmFilho(No no) {
            No filho = no.getEsquerda() != null ? no.getEsquerda() : no.getDireita();

            if (paiDoNo.getDireita() == no) {
                paiDoNo.setDireita(filho);
            } else {
                paiDoNo.setEsquerda(filho);
            }
        }

        // Verifica se o nó tem dois filhos
        private boolean temDoisFilhos(No no) {
            return no.getEsquerda() != null && no.getDireita() != null;
        }

        // Remove um nó que tem dois filhos
        private void removerNoComDoisFilhos(No no) {
            No sucessor = encontrarSucessor(no);
            No paiSucessor = encontrarPaiSucessor(sucessor);

        if (sucessor.getDireita() != null) {
            // Sucessor tem um filho à direita
            if (paiSucessor.getDireita() == sucessor) {
                paiSucessor.setDireita(sucessor.getDireita());
            } else {
                paiSucessor.setEsquerda(sucessor.getDireita());
            }
        } else {
            // Sucessor não tem filhos
            if (paiSucessor.getDireita() == sucessor) {
                paiSucessor.setDireita(null);
            } else {
                paiSucessor.setEsquerda(null);
            }
        }

        // Substitui o nó a ser removido pelo sucessor
        if (no == raiz) {
            raiz = sucessor;
        } else if (paiDoNo.getDireita() == no) {
            paiDoNo.setDireita(sucessor);
        } else {
            paiDoNo.setEsquerda(sucessor);
        }

        sucessor.setEsquerda(no.getEsquerda());
        sucessor.setDireita(no.getDireita());
    }

        // Encontra o sucessor de um nó (menor nó na subárvore direita)
        private No encontrarSucessor(No no) {
            No atual = no.getDireita();
            while (atual.getEsquerda() != null) {
                atual = atual.getEsquerda();
            }
            return atual;
        }

        // Encontra o pai do sucessor
        private No encontrarPaiSucessor(No sucessor) {
            No atual = raiz;
            No pai = null;

            while (atual != sucessor) {
                pai = atual;
                if (sucessor.getConteudo() < atual.getConteudo()) {
                    atual = atual.getEsquerda();
                } else {
                    atual = atual.getDireita();
                }
            }
            return pai;
        }

        /*
        O código anterior era extenso e repetitivo, dificultando a leitura e manutenção. Para melhorar, dividi a lógica em métodos menores e focados, 
        como removerFolha e removerNoComUmFilho, e renomeei variáveis para nomes mais descritivos. Além disso, eliminei duplicações e adicionei comentários
        explicativos para clareza. O problema principal do código original era a complexidade desnecessária, que podia levar a erros e dificultava a compreensão da lógica.
        */

    public No sucessor = null;
    public No paiSucessor = null;
    public No paiRemover = null;

    public No novaEsquerda = null;
    public No novaDireita = null;

    public No temp = null;
    public void acharSucessor(No atual2) {
        paiSucessor = atual2;
        if(atual2.getDireita()!=null){
            atual2 = atual2.getDireita();
            while(true){
                if(atual2.getEsquerda() == null){
                    sucessor = atual2;
                    return;
                }else{
                    paiSucessor = atual2;
                    atual2 = atual2.getEsquerda();
                }
            }
        }else{
            atual2 = atual2.getEsquerda();
            while(true){
                if(atual2.getDireita() == null){
                    sucessor = atual2;
                    return;
                }else{
                    paiSucessor = atual2;
                    atual2 = atual2.getDireita();
                }
            }
        }

    }

    public No achado = null;
    public void searchNo(int conteudo){
        No atual = raiz;
        while(true){
            if (conteudo == raiz.getConteudo()) {
                achado = raiz;
                System.out.println("Nó achado!");
                System.out.println(achado.getConteudo());
                System.out.println("É a raiz!");
                return;
            }
            if(conteudo == atual.getConteudo()){
                achado = atual;
                System.out.println("Nó achado!");
                System.out.println(achado.getConteudo());
                return;
            }

            if (conteudo < atual.getConteudo()) {
                paiRemover = atual;
                atual = atual.getEsquerda();
            }

            if (conteudo > atual.getConteudo()) {
                paiRemover = atual;
                atual = atual.getDireita();
            }

        }
    }
}

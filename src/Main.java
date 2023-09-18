import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int escolha;

        ListaDeObjetos<Quarto> listaDeQuartos = new ListaDeObjetos<>();

        int numero;
        boolean ocupado;
        String nome;

        Quarto quarto;

        int posicao;
        int tipoBusca;
        int numeroBuscado;
        String nomeBuscado;
        boolean disponibilidadeBuscada;

        int tipoAlteracao;

        while(true) {
            System.out.println("Que operação você deseja fazer: ");
            System.out.println("1: Cadastrar quarto");
            System.out.println("2: Excluir quarto");
            System.out.println("3: Alterar quarto");
            System.out.println("4: Buscar quarto");
            System.out.println("5: Imprimir todos os quartos e seus ocupantes");
            escolha = input.nextInt();

            switch(escolha) {

                case 1: {
                    System.out.println("Número do quarto: ");
                    numero = input.nextInt();

                    if(listaDeQuartos.quartoCadastrado(numero)) {
                        System.out.println("Quarto já cadastrado: \n");
                        break;
                    }
                    System.out.println("O quarto está ocupado: (true/false): ");
                    ocupado = input.nextBoolean();

                    if(ocupado) {
                        System.out.println("Qual o nome do ocupante: ");
                        nome = input.next();
                        quarto = new Quarto(numero, nome);
                    }
                    else {
                        quarto = new Quarto(numero);

                    }
                    listaDeQuartos.inserir(quarto);
                        break;


                }
                case 2: {
                    System.out.println("Qual quarto você deseja excluir: ");
                    numero =  input.nextInt();
                    if (listaDeQuartos.quartoCadastrado(numero)) {
                        listaDeQuartos.excluir(numero);
                    }
                    else {
                        System.out.println("Quarto invalido");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Qual quarto será modificado?: ");
                    numero = input.nextInt();
                    posicao = listaDeQuartos.buscaNumero(numero, 1);
                    listaDeQuartos.getObjeto(posicao).imprimeObjeto();

                    System.out.println("O que você deseja modificar:");
                    System.out.println("1: Nome: ");
                    System.out.println("2: Disponibilidade: ");
                    tipoAlteracao = input.nextInt();
                    switch (tipoAlteracao) {
                        case 1: {
                            quarto = listaDeQuartos.localizaPorNumero(numero);
                            System.out.println("Qual será o novo nome?: ");
                            nome = input.next();
                            quarto.setOcupante(nome);
                            listaDeQuartos.getObjeto(posicao).imprimeObjeto();
                            break;
                        }
                        case 2: {
                            quarto = listaDeQuartos.localizaPorNumero(numero);
                            if(quarto.isOcupado()) {
                                quarto.setOcupante(null);
                                quarto.setOcupado(false);
                            }
                            else {
                                quarto.setOcupado(true);
                                System.out.println("Qual será o nome do ocupante?: ");
                                nome = input.next();
                                quarto.setOcupante(nome);

                            }
                            listaDeQuartos.getObjeto(posicao).imprimeObjeto();
                            break;
                        }
                    }

                    break;
                }


                case 4: {
                    System.out.println("Você deseja buscar por número(1), nome(2) ou disponibilidade(3)");
                    tipoBusca = input.nextInt();

                    switch (tipoBusca) {
                        case 1: {
                            System.out.println("Qual numero do quarto você deseja procurar");
                            numeroBuscado = input.nextInt();
                            posicao = listaDeQuartos.buscaNumero(numeroBuscado, 1);
                            listaDeQuartos.getObjeto(posicao).imprimeObjeto();
                            break;
                            //fazer trow e catch aqui
                        }
                        case 2: {
                            System.out.println("Qual nome você deseja procurar");
                            nomeBuscado = input.next();
                            listaDeQuartos.buscaNome(nomeBuscado, 2);
                            break;
                        }
                        case 3: {
                            System.out.println("Quer saber os quartos disponíveis(false) ou ocupados(true) ");
                            disponibilidadeBuscada = input.nextBoolean();
                            listaDeQuartos.buscaDisponibilidade(disponibilidadeBuscada, 3);;
                            break;
                        }
                    }
                    break;
                }

                case 5: {
                    listaDeQuartos.imprimirLista();
                    }
                    break;
                }

            }

        }

    }

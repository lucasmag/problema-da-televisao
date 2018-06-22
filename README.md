# problema-da-televisao
Projeto I - Cadeira de Sistemas Operacionais, Engenharia da computação - 2018.1 | Instituto Federal do Ceará

## Descrição

O presente projeto é o primeiro de dois projetos previstos para serem feitos na disciplina de Sistemas Operacionais com o objetivo de fixar os conteúdos ensinados em sala, referentes à concorrência de processos (threads). 

### Problema
Em uma pousada há apenas uma televisão que pega N canais. Os hóspedes apenas descansam ou então assistem televisão, mas cada hóspede tem um canal preferido e só assiste televisão nesse canal. O hóspede que tiver o controle remoto pode escolher o canal de sua preferência, e então todos os outros hóspedes que gostam desse mesmo canal e quiserem assistir televisão, podem assistir juntos. Os que preferem outros canais ficam dormindo (bloqueado). Apenas quando o último hóspede que está assistindo televisão em determinado canal sai e vai descansar, é que o controle remoto fica livre, e algum hóspede pode escolher outro canal. Utilizando semáforos, modele os processos “hóspedes".

### Pré-requisitos

* Java Runtime Environment (JRE) 8 ou mais recente.


 Link: [JRE 8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jre8-downloads-2133155.html)


### Executando

- Baixe o arquivo *ProblemaDaTelevisao.jar* que se encontra no diretório *dist/ProblemaDaTelevisao.jar*
- Com o JRE já instalada na máquina execute o *ProblemaDaTelevisao.jar*

## Testes
### Entradas
Ao iniciar a execução, o usuário deverá definir as seguintes informações:
* Quantidade total de hóspedes (H).
* Quantidade de canais que podem ser sintonizados (N).
* Ao instanciar cada hóspede, o programa deverá gerar aleatoriamente o canal preferido do hóspede (1 à N).
* Intervalo para sorteio do tempo que o hóspede fica assistindo televisão: [ta1, ta2]
* Ao instanciar cada hóspede, o programa deverá gerar aleatoriamente o tempo (em segundos) que ele fica assistindo televisão no seu canal preferido.
* Intervalo para sorteio do tempo que o hóspede fica descansando: [td1, td2]
* Ao instanciar cada hóspede, o programa deverá gerar aleatoriamente o tempo (em segundos) que ele fica descansando sem assistir televisão e sem dormir. 

### Saídas
A interface deverá atender aos seguintes requisitos:
* Mostrar o canal selecionado naquele instante.
* Mostrar os dados de cada hóspede: identificador (sequencial criado automaticamente), canal preferido, tempo que ele passa assistindo televisão, e o tempo que ele fica descansando.
* Mostrar a cada instante, o status de cada processo hóspede (assistindo televisão, descansando ou dormindo (bloqueado)).
* Mostrar um log com os principais eventos de cada hóspede.

### Imagens
![Menu](https://github.com/lucasmag/problema-da-televisao/blob/master/src/imagens/img1.png)

![Tutorial](https://github.com/lucasmag/problema-da-televisao/blob/master/src/imagens/img2.png)

![Principal](https://github.com/lucasmag/problema-da-televisao/blob/master/src/imagens/img3.png)

## Feito com

* [JavaFX Scene Builder + Netbeans](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk-netbeans-jsp-3413153-ptb.html) 

## Autor

* **Lucas Magalhães** - [LucasMag](https://github.com/lucasmag)

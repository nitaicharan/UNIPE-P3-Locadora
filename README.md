### Descrição

Na locadora de veículos podem ser locados dois tipos de veículos:

* Carros
* Motos

### Requisitos

#### Cadastro de Veículos:

No cadastro de veículos devemos informar:
* O tipo de veículo (Carro ou Moto)
* O valor de locação (valor referente a um dia diária)
* Descrição do veículo
* Placa do veículo
* Se for um carro deve ainda ser informado o número de passageiros.
* Se for uma moto deve ainda ser informado se tem partida elétrica.

#### Cadastro de Clientes

  * Para locar um veículo o cliente precisa estar cadastrado.
  * No cadastro do cliente precisa ser informado os seus dados pessoais.

### Locação de Veículos

Na locação de um veículo deve ser informado:
  * O cliente que está locando o veículo
  * O número de dias da locação
  * A data da locação
  * Se a locação é com seguro ou não.
  * Valor do desconto.
  *  O valor da locação deve ser calculado e exibido após a confirmação da locação. O cálculo é feito com base no valor da diária do veículo, no número de dias da locação e no valor do seguro.
  * O valor do seguro referente a um dia é calculado da seguinte forma:
    * Carro: 0.05 * valor da diária * ( 1 + número de passageiro/20)
    * Moto: 0.09 * valor da diária
  * Sobre o valor da locação é possível dar um desconto de no máximo 12%.
  * Dentre os veículos cadastrados deve ser possível saber quais estão locados.
  * Funções do sistema para a segunda unidade:
    * Cadastro de veículos (carros e motos)
    * Cadastro de clientes
    * Locação de veículos
    * Listagem de veículos cadastrados
    * Listagem de clientes
    * Listagem das locações
    * Listagem de veículos disponíveis

```java
  int op;
  String firstOp;
  while (true) {
    firstOp = JOptionPane.showInputDialog( "Selecione uma opção: \n\n" + "1 -- Cadastrar Cliente\n" + "2 -- ........\n" + "3 -- Sair\n");
    op = Integer.parseInt(firstOp);
    switch (op) {
      case 1: //chamar método para cadastrar cliente
        break;
      case 2: //chamar método....
        break;
      case 3:
        System.exit(0);
      default:
        JOptionPane.showMessageDialog(null,op + " é uma opção Invalida!", "ERRO",JOptionPane.ERROR_MESSAGE );
    }
}
```

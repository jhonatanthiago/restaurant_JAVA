# Restaurante Sabor & Sabores 🍕🥤🍔

## Descrição
O **Restaurante BomSabor** é um sistema de gerenciamento de pedidos desenvolvido em **Java**, utilizando **Orientação a Objetos**.  
O software permite registrar pedidos, remover pedidos existentes e listar todos os pedidos ativos de forma organizada, tudo via console.  

O sistema foi implementado como atividade acadêmica e demonstra conceitos fundamentais de:
- Classes e Objetos (`Pedido` e `Item`)  
- Composição (`Pedido` contém uma lista de `Item`)  
- Estruturas de dados (`ArrayList`)  
- Controle de fluxo (`switch-case` e `while`)  
- Interação com o usuário via console (`Scanner`)  

---

## Funcionalidades

1. **Registrar Pedido**
   - Solicita o nome do cliente.
   - Gera um número de pedido automaticamente (sequencial).
   - Permite adicionar um ou mais itens ao pedido, solicitando nome e preço.
   - Calcula o valor total do pedido.
   - Exibe um resumo completo do pedido.

2. **Remover Pedido**
   - Permite remover um pedido pelo número.
   - Exibe mensagem de erro caso o pedido não exista.

3. **Listar Pedidos**
   - Lista todos os pedidos registrados.
   - Mostra informações detalhadas: número do pedido, nome do cliente, itens com preço e valor total.
   - Lista ordenada pelo número do pedido.

4. **Sair**
   - Encerra o programa.

---

## Requisitos

- **Java JDK 24** ou superior instalado.  
- **IDE Eclipse** (ou qualquer outra IDE Java).  
- Conhecimento básico de terminal/console para interação com o programa.  

---

## Estrutura de Arquivos

```

RestauranteApp/
└─ src/
└─ Restaurante/
├─ Item.java
├─ Pedido.java
└─ Restaurante.java
README.md

```

---

## Como Rodar o Projeto

1. Abra o **Eclipse** e importe o projeto:
   - `File > Import > Existing Projects into Workspace`  
   - Selecione a pasta do projeto `RestauranteApp`  
   - Finish  

2. Certifique-se de que o **JDK 24** está configurado no Eclipse:
   - `Project > Properties > Java Build Path > Libraries`  
   - Adicione o JDK 24 se não estiver presente  

3. Compile e execute a classe principal:
   - Clique com o direito em `Restaurante.java > Run As > Java Application`  

4. Interaja com o menu:
   - **1** → Registrar pedido  
   - **2** → Remover pedido  
   - **3** → Listar pedidos  
   - **4** → Sair do programa  

5. Para registrar itens em um pedido:
   - Digite o nome do item e o preço.  
   - Quando terminar, digite `fim` para encerrar a adição de itens.  

---

## Exemplo de Uso

```

\=== MENU ===

1. Registrar pedido
2. Remover pedido
3. Listar pedidos
4. Sair
   Escolha uma opção: 1

Nome do cliente: Ana
Nome do item (ou 'fim' para encerrar): Pizza
Preço do item: 40.00
Nome do item (ou 'fim' para encerrar): Suco
Preço do item: 7.50
Nome do item (ou 'fim' para encerrar): fim

Pedido registrado com sucesso!
Pedido nº 1 - Cliente: Ana
Pizza - R\$ 40.00
Suco - R\$ 7.50
Total: R\$ 47.50

```

---

## Autor
- **Jhonatan Thiago**

---

## Observações
- Este projeto é uma aplicação de console e não possui interface gráfica.  
- Pode ser expandido futuramente para incluir persistência em arquivos ou banco de dados.  
- Foi desenvolvido para fins acadêmicos, demonstrando conceitos de Java e Orientação a Objetos.

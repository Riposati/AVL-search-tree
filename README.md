PROJETO FEITO POR MIM COM AUXILIO DE IA GENERATIVA, CHAT GPT, AMAZON Q

# AVL Tree em Java

Este projeto implementa uma **árvore AVL** — uma árvore binária de busca auto-balanceada — utilizando a linguagem **Java**. A árvore suporta inserções, remoções, buscas e travessias em ordem, pré-ordem e pós-ordem.

## 📁 Estrutura do Projeto

```
org.example
├── AvlNode.java      // Classe do nó da árvore AVL
├── AvlTree.java      // Lógica da árvore AVL (inserção, remoção, balanceamento etc.)
└── Main.java         // Classe principal com exemplo de uso
```

## ✅ Funcionalidades

- Inserção de nós com balanceamento automático
- Remoção de nós com casos para 0, 1 ou 2 filhos
- Busca de valores
- Travessias:
  - In-order (esquerda → raiz → direita)
  - Pre-order (raiz → esquerda → direita)
  - Post-order (esquerda → direita → raiz)
- Balanceamento com rotações simples e duplas (esquerda/direita)

## 🔧 Como Usar

### Compilar o projeto

```bash
javac Main.java
```

### Executar

```bash
java org.example.Main
```

### Saída esperada (exemplo)

```
Inorder: 
1 2 3 4 
Preorder: 
2 1 3 4 
Posorder: 
1 4 3 2 
--------------------
Inorder: 
1 4 
Preorder: 
4 1 
Posorder: 
1 4 
--------------------
Inorder: 
-3 0 1 4 5 
Preorder: 
4 1 0 -3 5 
Posorder: 
-3 0 1 5 4 
--------------------
```

## 📘 Classes Principais

### `AvlNode`

Representa um nó da árvore AVL com:
- `int data`: valor armazenado
- `AvlNode left`, `right`: filhos esquerdo e direito
- `int height`: altura do nó para cálculos de balanceamento

### `AvlTree`

Contém os métodos principais:
- `insert(int data)`
- `delete(int data)`
- `search(int data)`
- `inorder()`, `preorder()`, `postorder()`

Internamente, utiliza métodos privados para reestruturação e rebalanceamento da árvore (como `leftRotate`, `rightRotate` e `rebalance`).

### `Main`

Classe de exemplo que testa a árvore AVL com inserções, remoções e exibe os percursos.

## 🧠 Sobre Árvores AVL

Uma árvore AVL (Adelson-Velsky e Landis) é uma árvore binária de busca auto-balanceada. Após cada inserção ou remoção, a árvore verifica o fator de balanceamento de cada nó e aplica rotações quando necessário para garantir que a altura da árvore permaneça log(n), mantendo assim as operações eficientes.

## 📜 Licença

Este projeto está disponível sob a licença MIT.

# 🧩 Sudoku em Java (Console)

Este é um projeto de **Sudoku** desenvolvido em **Java**, rodando diretamente no console.  
O jogo segue as regras clássicas do Sudoku e permite que o usuário **gere um jogo aleatório** ou **defina seu próprio jogo**.  

---

## 📌 Regras do Sudoku
O objetivo é preencher a grade **9x9** com números de **1 a 9**, seguindo estas regras:

1. Não repetir números nas **linhas**.  
2. Não repetir números nas **colunas**.  
3. Não repetir números nos **quadrados 3x3**.  

---

## 🎮 Funcionalidades

- **Tela de boas-vindas** ao iniciar o programa.  
- Escolha entre:
  - 🔹 **Jogo aleatório** → o usuário escolhe quantos números deseja sortear (máximo 20).  
  - 🔹 **Definir jogo** → o usuário insere valores iniciais no formato `(linha,coluna,valor)`.  
- **Loop de execução** → após cada jogada ou remoção, o tabuleiro é **automaticamente reimpresso**, mostrando a atualização em tempo real.  
- **Adicionar jogadas** no formato `(linha,coluna,valor)`.  
  - Permite múltiplas jogadas em uma única entrada, ex: `(1,1,2)(2,2,3)`.  
  - Entradas inválidas são rejeitadas com mensagem explicativa.  
- **Remover jogadas** informando `(linha,coluna)`.  
  - Não é permitido remover valores definidos no início do jogo.  
- **Dicas** → informe `(linha,coluna)` e o programa retorna os valores possíveis que podem ser adicionados nessa posição.  

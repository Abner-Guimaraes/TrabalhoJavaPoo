import tkinter as tk
from tkinter import messagebox
from Produtos import Produtos
from BotoesModal import BotoesModal

class BotoesDeOpcoes(tk.Frame):
    def __init__(self, produto, screenFx, master=None):
        super().__init__(master)
        self.atualizarBtn = tk.Button(self, text="Atualizar", bg="DodgerBlue", fg="white", font=("Arial", 10, "bold"),
                                      cursor="hand", command=lambda: BotoesModal.updateModal("Atualizar", produto, screenFx))
        self.deletarBtn = tk.Button(self, text="Deletar", bg="Crimson", fg="white", font=("Arial", 10, "bold"),
                                    cursor="hand", command=lambda: self.confirmarDelecao(produto, screenFx))

        self.atualizarBtn.pack(side=tk.LEFT, padx=10)
        self.deletarBtn.pack(side=tk.LEFT, padx=10)
        self.pack()

    def confirmarDelecao(self, produto, screenFx):
        if messagebox.askyesno("Deletar", "Tem certeza que deseja deletar?"):
            screenFx.deletarProduto(True, produto)
        else:
            screenFx.deletarProduto(False, produto)

# Exemplo de uso:
if __name__ == "__main__":
    class ScreenFx:
        def deletarProduto(self, flag, produto):
            if flag:
                print(f"Produto '{produto.getNome()}' deletado.")
            else:
                print("Operação de deleção cancelada.")

    # Criando uma instância de ScreenFx simulada para testar
    screenFx = ScreenFx()
    produto_exemplo = Produtos("Produto A", "Descrição do Produto A", "Marca A", "Categoria A", 100.0, 50.0)

    # Criando os botões de opções para o produto de exemplo
    botoes_opcoes = BotoesDeOpcoes(produto_exemplo, screenFx)

    # Exibindo a janela principal do Tkinter
    root = tk.Tk()
    root.geometry("300x100")
    root.title("Exemplo de Botões de Opções")
    botoes_opcoes.pack()

    root.mainloop()

import tkinter as tk
from tkinter import messagebox
from Produtos import Produtos

class BotoesModal:
    @staticmethod
    def updateModal(titulo, produto, screenFx):
        modal = tk.Toplevel()
        modal.title(titulo)
        modal.geometry("400x400")

        mensagem = tk.Label(modal, text="Atualize as informações do produto", font=("Arial", 14, "bold"))
        mensagem.pack(pady=10)

        nomeLabel = tk.Label(modal, text="Nome:")
        nomeLabel.pack()
        nomeInput = tk.Entry(modal, width=30)
        nomeInput.insert(0, produto.getNome())
        nomeInput.pack()

        descricaoLabel = tk.Label(modal, text="Descrição:")
        descricaoLabel.pack()
        descricaoInput = tk.Entry(modal, width=30)
        descricaoInput.insert(0, produto.getDescricao())
        descricaoInput.pack()

        marcaLabel = tk.Label(modal, text="Marca:")
        marcaLabel.pack()
        marcaInput = tk.Entry(modal, width=30)
        marcaInput.insert(0, produto.getMarca())
        marcaInput.pack()

        categoriaLabel = tk.Label(modal, text="Categoria:")
        categoriaLabel.pack()
        categoriaInput = tk.Entry(modal, width=30)
        categoriaInput.insert(0, produto.getCategoria())
        categoriaInput.pack()

        precoLabel = tk.Label(modal, text="Preço:")
        precoLabel.pack()
        precoInput = tk.Entry(modal, width=30)
        precoInput.insert(0, str(produto.getPreco()))
        precoInput.pack()

        custoLabel = tk.Label(modal, text="Custo:")
        custoLabel.pack()
        custoInput = tk.Entry(modal, width=30)
        custoInput.insert(0, str(produto.getCusto()))
        custoInput.pack()

        btnContainer = tk.Frame(modal)
        btnContainer.pack(pady=10)

        simBtn = tk.Button(btnContainer, text="Atualizar", bg="MediumSeaGreen", fg="white", font=("Arial", 10, "bold"),
                           cursor="hand", command=lambda: BotoesModal.atualizar(screenFx, produto, nomeInput.get(),
                                                                                  descricaoInput.get(), marcaInput.get(),
                                                                                  categoriaInput.get(),
                                                                                  float(precoInput.get()),
                                                                                  float(custoInput.get()), modal))
        simBtn.pack(side=tk.LEFT, padx=10)

        naoBtn = tk.Button(btnContainer, text="Cancelar", bg="Crimson", fg="white", font=("Arial", 10, "bold"),
                           cursor="hand", command=modal.destroy)
        naoBtn.pack(side=tk.LEFT, padx=10)

        modal.transient(screenFx.tela)
        modal.grab_set()
        screenFx.tela.wait_window(modal)

    @staticmethod
    def atualizar(screenFx, produto, novoNome, novaDescricao, novaMarca, novaCategoria, novoPreco, novoCusto, modal):
        screenFx.atualizarProduto(True, produto, novoNome, novaDescricao, novaMarca, novaCategoria, novoPreco, novoCusto)
        modal.destroy()

    @staticmethod
    def deleteModal(titulo):
        modal = tk.Toplevel()
        modal.title(titulo)
        modal.geometry("216x144")

        mensagem = tk.Label(modal, text="Tem certeza que deseja deletar?", font=("Arial", 12, "bold"))
        mensagem.pack(pady=10)

        btnContainer = tk.Frame(modal)
        btnContainer.pack(pady=10)

        simBtn = tk.Button(btnContainer, text="Sim", bg="MediumSeaGreen", fg="white", font=("Arial", 10, "bold"),
                           cursor="hand", command=lambda: BotoesModal.confirmarDelecao(modal, True))
        simBtn.pack(side=tk.LEFT, padx=10)

        naoBtn = tk.Button(btnContainer, text="Não", bg="Crimson", fg="white", font=("Arial", 10, "bold"),
                           cursor="hand", command=lambda: BotoesModal.confirmarDelecao(modal, False))
        naoBtn.pack(side=tk.LEFT, padx=10)

        modal.transient(screenFx.tela)
        modal.grab_set()
        screenFx.tela.wait_window(modal)

        return BotoesModal.flag

    @staticmethod
    def confirmarDelecao(modal, flag):
        BotoesModal.flag = flag
        modal.destroy()

# Exemplo de uso:
if __name__ == "__main__":
    class ScreenFx:
        def __init__(self):
            self.tela = tk.Tk()

        def atualizarProduto(self, flag, produto, novoNome, novaDescricao, novaMarca, novaCategoria, novoPreco, novoCusto):
            print(f"Atualizando produto: {produto.getNome()} - Novo nome: {novoNome}")

    # Exemplo de utilização dos modais
    screenFx = ScreenFx()
    produto = Produtos("Produto A", "Descrição do Produto A", "Marca A", "Categoria A", 100.0, 50.0)

    # Exemplo de atualização de produto
    BotoesModal.updateModal("Atualizar Produto", produto, screenFx)

    # Exemplo de deleção de produto
    flag_delecao = BotoesModal.deleteModal("Deletar Produto")
    if flag_delecao:
        print("Produto deletado")
    else:
        print("Operação cancelada")
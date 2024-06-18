import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
from functools import partial

class Produtos:
    def __init__(self, nome, descricao, marca, categoria, preco, custo):
        self.nome = nome
        self.descricao = descricao
        self.marca = marca
        self.categoria = categoria
        self.preco = preco
        self.custo = custo

class ProdutosControlador:
    def __init__(self):
        self.produtos = []
    
    def criar_produto(self, nome, descricao, marca, categoria, preco, custo):
        produto = Produtos(nome, descricao, marca, categoria, preco, custo)
        self.produtos.append(produto)
        return produto
    
    def atualizar_produto(self, produto, novo_nome, nova_descricao, nova_marca, nova_categoria, novo_preco, novo_custo):
        produto.nome = novo_nome
        produto.descricao = nova_descricao
        produto.marca = nova_marca
        produto.categoria = nova_categoria
        produto.preco = novo_preco
        produto.custo = novo_custo
    
    def deletar_produto(self, produto):
        self.produtos.remove(produto)
    
    def filtrar_produtos(self, termo_busca):
        return [p for p in self.produtos if termo_busca.lower() in p.nome.lower()]

class ScreenTk:
    def __init__(self, root):
        self.root = root
        self.produtos_controlador = ProdutosControlador()
        
        self.criar_interface()
    
    def criar_interface(self):
        self.root.title("Trabalho 1 Poo")
        
        # Container principal
        main_frame = ttk.Frame(self.root, padding="10 10 10 10")
        main_frame.grid(column=0, row=0, sticky=(tk.N, tk.W, tk.E, tk.S))
        
        # Nome do produto
        ttk.Label(main_frame, text="Nome").grid(column=0, row=0, sticky=tk.W)
        self.nome_input = ttk.Entry(main_frame, width=40)
        self.nome_input.grid(column=0, row=1, padx=5, pady=5, sticky=tk.W)
        
        # Descrição do produto
        ttk.Label(main_frame, text="Descrição").grid(column=0, row=2, sticky=tk.W)
        self.descricao_input = ttk.Entry(main_frame, width=40)
        self.descricao_input.grid(column=0, row=3, padx=5, pady=5, sticky=tk.W)
        
        # Marca do produto
        ttk.Label(main_frame, text="Marca").grid(column=0, row=4, sticky=tk.W)
        self.marca_input = ttk.Entry(main_frame, width=40)
        self.marca_input.grid(column=0, row=5, padx=5, pady=5, sticky=tk.W)
        
        # Categoria do produto
        ttk.Label(main_frame, text="Categoria").grid(column=0, row=6, sticky=tk.W)
        self.categoria_input = ttk.Entry(main_frame, width=40)
        self.categoria_input.grid(column=0, row=7, padx=5, pady=5, sticky=tk.W)
        
        # Preço do produto
        ttk.Label(main_frame, text="Lista de Preço").grid(column=0, row=8, sticky=tk.W)
        self.preco_input = ttk.Entry(main_frame, width=40)
        self.preco_input.grid(column=0, row=9, padx=5, pady=5, sticky=tk.W)
        
        # Custo do produto
        ttk.Label(main_frame, text="Custo").grid(column=0, row=10, sticky=tk.W)
        self.custo_input = ttk.Entry(main_frame, width=40)
        self.custo_input.grid(column=0, row=11, padx=5, pady=5, sticky=tk.W)
        
        # Botão Criar
        criar_btn = ttk.Button(main_frame, text="Criar", command=self.criar_produto)
        criar_btn.grid(column=0, row=12, padx=5, pady=5, sticky=tk.W)
        
        # Container de Busca
        busca_container = ttk.Frame(main_frame, padding="0 10 0 0")
        busca_container.grid(column=0, row=13, padx=5, pady=5, sticky=tk.W)
        
        self.busca_input = ttk.Entry(busca_container, width=50)
        self.busca_input.grid(column=0, row=0, padx=5, pady=5, sticky=tk.W)
        busca_btn = ttk.Button(busca_container, text="Buscar", command=self.atualizar_paginacao)
        busca_btn.grid(column=1, row=0, padx=5, pady=5, sticky=tk.W)
        
        # Tabela de Produtos
        columns = ("Nome", "Descrição", "Marca", "Categoria", "Lista de Preço", "Custo", "Opções")
        self.tabela = ttk.Treeview(main_frame, columns=columns, show="headings")
        for col in columns:
            self.tabela.heading(col, text=col)
            self.tabela.column(col, width=100)
        self.tabela.grid(column=1, row=0, rowspan=10, padx=10, pady=10, sticky=(tk.W, tk.E, tk.N, tk.S))
        
        # Paginação
        self.paginacao = ttk.Treeview(main_frame)
        self.paginacao.grid(column=1, row=10, padx=10, pady=10, sticky=(tk.W, tk.E, tk.N, tk.S))
        
        # Atualizar Paginação
        self.atualizar_paginacao()
        
        self.root.mainloop()
    
    def criar_produto(self):
        nome = self.nome_input.get()
        descricao = self.descricao_input.get()
        marca = self.marca_input.get()
        categoria = self.categoria_input.get()
        preco = float(self.preco_input.get())
        custo = float(self.custo_input.get())
        
        produto = self.produtos_controlador.criar_produto(nome, descricao, marca, categoria, preco, custo)
        self.atualizar_paginacao()
        
        messagebox.showinfo("Produto Criado", f"Produto {produto.nome} criado com sucesso!")
    
    def atualizar_paginacao(self):
        termo_busca = self.busca_input.get().lower()
        produtos_filtrados = self.produtos_controlador.filtrar_produtos(termo_busca)
        
        # Limpar tabela
        for i in self.tabela.get_children():
            self.tabela.delete(i)
        
        # Preencher tabela
        for produto in produtos_filtrados:
            self.tabela.insert("", "end", values=(produto.nome, produto.descricao, produto.marca,
                                                  produto.categoria, produto.preco, produto.custo, "Editar/Deletar"))
        
        # Atualizar paginação
        # (implementar paginação manualmente no tkinter é mais complexo, isso pode variar de acordo com a necessidade)
        
if __name__ == "__main__":
    root = tk.Tk()
    app = ScreenTk(root)
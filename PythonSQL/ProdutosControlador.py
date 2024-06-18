import sqlite3

class Produtos:
    def __init__(self):
        self.id = None
        self.nome = None
        self.descricao = None
        self.marca = None
        self.categoria = None
        self.preco = None
        self.custo = None
    
    def setId(self, id):
        self.id = id
    
    def setNome(self, nome):
        self.nome = nome
    
    def setDescricao(self, descricao):
        self.descricao = descricao
    
    def setMarca(self, marca):
        self.marca = marca
    
    def setCategoria(self, categoria):
        self.categoria = categoria
    
    def setPreco(self, preco):
        self.preco = preco
    
    def setCusto(self, custo):
        self.custo = custo

class ProdutosControlador:
    def __init__(self):
        self.conn = sqlite3.connect('produtos.db')
        self.criar_tabela()
        self.produtos = self.getProdutos()
    
    def criar_tabela(self):
        sql = '''
            CREATE TABLE IF NOT EXISTS produtos_table (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                short_description TEXT,
                brand TEXT,
                category TEXT,
                list_price REAL,
                cost REAL
            )
        '''
        self.conn.execute(sql)
        self.conn.commit()
    
    def getProdutos(self):
        sql = "SELECT * FROM produtos_table"
        cursor = self.conn.execute(sql)
        produtos = []
        for row in cursor:
            p = Produtos()
            p.setId(row[0])
            p.setNome(row[1])
            p.setDescricao(row[2])
            p.setMarca(row[3])
            p.setCategoria(row[4])
            p.setPreco(row[5])
            p.setCusto(row[6])
            produtos.append(p)
        return produtos
    
    def criarProduto(self, nome, descricao, marca, categoria, preco, custo):
        sql = "INSERT INTO produtos_table (name, short_description, brand, category, list_price, cost) VALUES (?, ?, ?, ?, ?, ?)"
        self.conn.execute(sql, (nome, descricao, marca, categoria, preco, custo))
        self.conn.commit()
        self.produtos = self.getProdutos()
    
    def atualizarProduto(self, flag, p, novoNome, novaDescricao, novaMarca, novaCategoria, novoPreco, novoCusto):
        if flag:
            sql = "UPDATE produtos_table SET name = ?, short_description = ?, brand = ?, category = ?, list_price = ?, cost = ? WHERE id = ?"
            self.conn.execute(sql, (novoNome, novaDescricao, novaMarca, novaCategoria, novoPreco, novoCusto, p.id))
            self.conn.commit()
            self.produtos = self.getProdutos()
    
    def deletarProduto(self, flag, produto):
        if flag:
            sql = "DELETE FROM produtos_table WHERE id = ?"
            self.conn.execute(sql, (produto.id,))
            self.conn.commit()
            self.produtos = self.getProdutos()
    
    def filtrarProdutos(self, criterio):
        if not criterio:
            return self.getProdutos()
        sql = "SELECT * FROM produtos_table WHERE name LIKE ?"
        cursor = self.conn.execute(sql, (f'{criterio}%',))
        produtos = []
        for row in cursor:
            p = Produtos()
            p.setId(row[0])
            p.setNome(row[1])
            p.setDescricao(row[2])
            p.setMarca(row[3])
            p.setCategoria(row[4])
            p.setPreco(row[5])
            p.setCusto(row[6])
            produtos.append(p)
        return produtos

# Exemplo de uso:
if __name__ == "__main__":
    controlador = ProdutosControlador()
    
    # Criar produto
    controlador.criarProduto("Produto A", "Descrição do Produto A", "Marca A", "Categoria A", 100.0, 50.0)
    
    # Atualizar produto
    produtos = controlador.getProdutos()
    if produtos:
        produto = produtos[0]
        controlador.atualizarProduto(True, produto, "Novo Nome", "Nova Descrição", "Nova Marca", "Nova Categoria", 150.0, 70.0)
    
    # Deletar produto
    if produtos:
        produto = produtos[-1]
        controlador.deletarProduto(True, produto)
    
    # Filtrar produtos
    produtos_filtrados = controlador.filtrarProdutos("Produto")
    for p in produtos_filtrados:
        print(f"ID: {p.id}, Nome: {p.nome}, Descrição: {p.descricao}, Marca: {p.marca}, Categoria: {p.categoria}, Preço: {p.preco}, Custo: {p.custo}")
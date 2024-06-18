class Produtos:
    def __init__(self, nome="", descricao="", marca="", categoria="", preco=0.0, custo=0.0):
        self.nome = nome
        self.descricao = descricao
        self.marca = marca
        self.categoria = categoria
        self.preco = preco
        self.custo = custo
        self.id = None

    def getId(self):
        return self.id

    def setId(self, id):
        self.id = id

    def getNome(self):
        return self.nome

    def setNome(self, nome):
        self.nome = nome

    def getDescricao(self):
        return self.descricao

    def setDescricao(self, descricao):
        self.descricao = descricao

    def getMarca(self):
        return self.marca

    def setMarca(self, marca):
        self.marca = marca

    def getCategoria(self):
        return self.categoria

    def setCategoria(self, categoria):
        self.categoria = categoria

    def getPreco(self):
        return self.preco

    def setPreco(self, preco):
        self.preco = preco

    def getCusto(self):
        return self.custo

    def setCusto(self, custo):
        self.custo = custo

# Exemplo de uso:
if __name__ == "__main__":
    produto = Produtos("Produto A", "Descrição do Produto A", "Marca A", "Categoria A", 100.0, 50.0)
    print(f"Nome: {produto.getNome()}, Descrição: {produto.getDescricao()}, Marca: {produto.getMarca()}, Categoria: {produto.getCategoria()}, Preço: {produto.getPreco()}, Custo: {produto.getCusto()}")

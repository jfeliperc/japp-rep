-- DROP TABLE nf_entrada;
-- DROP TABLE item_nf_entrada ;
-- DROP TABLE parcelas_nfe;
-- DROP TABLE cfop_nfentrada;

-- tabela:nfentrada será a tabela mestre da nf.
CREATE TABLE IF NOT EXISTS nf_entrada (
id INT NOT NULL AUTO_INCREMENT,
codigo VARCHAR(10) NOT NULL,
notafiscal VARCHAR(15) NOT NULL,
notafiscalinterna VARCHAR(15),
fornecedor INT,
ordemdecompra INTEGER,
entrada DATE NOT NULL,
emissao DATE NOT NULL,
saida DATE,
transportadora INTEGER,
tipofrete INT NOT NULL,
freteagregado INT NOT NULL,
baseicms NUMERIC(15,2) NOT NULL,
valoricms NUMERIC(15,2) NOT NULL,
basesubstituicao NUMERIC(15,2) NOT NULL,
valorsubstituicao NUMERIC(15,2) NOT NULL,
valordofrete NUMERIC(15,2) NOT NULL,
valordoseguro NUMERIC(15,2) NOT NULL,
outrasdespesas NUMERIC(15,2) NOT NULL,
valordoipi NUMERIC(15,2) NOT NULL,
valordosprodutos NUMERIC(15,2) NOT NULL,
valordanota NUMERIC(15,2) NOT NULL,
baseicmscalculado NUMERIC(15,4) NOT NULL,
valoricmscalculado NUMERIC(15,4) NOT NULL,
basesubstituicaocalculado NUMERIC(15,4) NOT NULL,
valorsubstituicaocalculado NUMERIC(15,4) NOT NULL,
valordofretecalculado NUMERIC(15,4) NOT NULL,
valordosegurocalculado NUMERIC(15,4) NOT NULL,
outrasdespesascalculado NUMERIC(15,4) NOT NULL,
valordoipicalculado NUMERIC(15,4) NOT NULL,
valordosprodutoscalculado NUMERIC(15,4) NOT NULL,
valordanotacalculado NUMERIC(15,4) NOT NULL,
descontogeral NUMERIC(15,2) NOT NULL,
descontogeralcalculado NUMERIC(15,4) NOT NULL,
pesobruto NUMERIC(15,3) NOT NULL,
pesoliquido NUMERIC(15,3) NOT NULL,
quantidadevolume NUMERIC(15,3) NOT NULL,
especievolume VARCHAR(10),
marcavolume VARCHAR(10),
numerovolume INTEGER,
placaveiculo VARCHAR(10),
ufveiculo VARCHAR(2),
`status` INT NOT NULL,
impresso INT NOT NULL,
observacao VARCHAR(200),
serienf VARCHAR(10),
modelo VARCHAR(2) NOT NULL,
cancelada INT DEFAULT 0 NOT NULL,
ratear_desconto INT DEFAULT 0 NOT NULL,
PRIMARY KEY (id),
INDEX `idx_num_notafiscal` (notafiscal ASC)
);

-- tabela:itemnfentrada será a tebela detalhes dos itens.
CREATE TABLE IF NOT EXISTS item_nf_entrada (
id INT NOT NULL AUTO_INCREMENT,
itemnfentrada INTEGER NOT NULL,
nfentrada INTEGER NOT NULL,
ean VARCHAR(15) NOT NULL,
produto INTEGER NOT NULL,
cst INT NOT NULL,
quantidade NUMERIC(15,3) NOT NULL,
unidadeembalagem NUMERIC(15,3) NOT NULL,
valorunitario NUMERIC(15,4) NOT NULL,
desconto NUMERIC(7,2) NOT NULL,
ipi NUMERIC(7,2) NOT NULL,
icmsentrada NUMERIC(7,2) NOT NULL,
icmssaida NUMERIC(7,2) NOT NULL,
cfop VARCHAR(5) NOT NULL,
PRIMARY KEY (id),
CONSTRAINT `fk_nfent_item_nfent` FOREIGN KEY (`nfentrada`) REFERENCES nf_entrada (id) 
);

-- tabela:parcelasnfe será a tabela detalhes das parcelas da nf.
CREATE TABLE IF NOT EXISTS parcelas_nfe (
id INT NOT NULL AUTO_INCREMENT,
parcelasnfe INTEGER NOT NULL,
nfentrada INTEGER NOT NULL,
notafiscal VARCHAR(15) NOT NULL,
documento VARCHAR(15) NOT NULL,
vencimento DATE NOT NULL,
valor NUMERIC(15,2) NOT NULL,
PRIMARY KEY (id),
CONSTRAINT `fk_nfent_parc_nfent` FOREIGN KEY (`nfentrada`) REFERENCES nf_entrada (id) 
);

-- tabela:cfop_nfentrada será a tabela detalhes das cfop´s contidas na nf.
CREATE TABLE IF NOT EXISTS cfop_nfentrada (
id INT NOT NULL AUTO_INCREMENT,
cfop_nfentrada INTEGER NOT NULL,
nfentrada INTEGER NOT NULL,
cfop VARCHAR(5) NOT NULL,
PRIMARY KEY (id),
CONSTRAINT `fk_nfent_cfop_nfent` FOREIGN KEY (`nfentrada`) REFERENCES nf_entrada (id) 
);

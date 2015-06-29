-- FetchType.LAZY = Doesn�t load the relationships unless explicitly �asked for� via getter
-- FetchType.EAGER = Loads ALL relationships

-- drop database japp;
-- create database japp;
-- MySQL Script generated by MySQL Workbench
-- Thu Mar  5 22:03:34 2015
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema japp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `japp` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `japp` ;

-- -----------------------------------------------------
-- Table `japp`.`tipo_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`tipo_produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `datainclusao` DATETIME NULL,
  `dataalteracao` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_id_tipoproduto` (`id` ASC),
  INDEX `idx_nome_tipoproduto` (`nome` ASC))
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`tipo_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`grupo_produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `grupo_pai` INT NULL,
  `datainclusao` DATETIME NULL,
  `dataalteracao` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_id_grupoproduto` (`id` ASC),
  INDEX `idx_nome_grupoproduto` (`nome` ASC))
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `cod_externo` VARCHAR(45) NULL,
  `medida` VARCHAR(45) NULL,
  `qtd_minima` DOUBLE NULL,
  `qtd_ref_compra` VARCHAR(45) NULL,
  `qtd_ref_saida` VARCHAR(45) NULL,
  `tipo_produto_id` INT NOT NULL,
  `grupo_produto_id` INT NOT NULL,
  `aliq_ipi` DOUBLE NULL,
  `aliq_icms` DOUBLE NULL,
  `fator_coaccao` DOUBLE NULL,
  `indice_coaccao` DOUBLE NULL,
  `datainclusao` DATETIME NULL,
  `dataalteracao` DATETIME NULL,
  PRIMARY KEY (`id`),
INDEX `idx_id_produto` (`id` ASC),
INDEX `idx_nome_produto` (`nome` ASC),  
INDEX `fk_produto_tipo_produto_idx` (`tipo_produto_id` ASC),
  CONSTRAINT `fk_produto_tipo_produto` FOREIGN KEY (`tipo_produto_id`) REFERENCES `japp`.`tipo_produto` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_grupo_produto` FOREIGN KEY (`grupo_produto_id`) REFERENCES `japp`.`grupo_produto` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION  )
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`valor_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`valor_produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `produto_id` INT NOT NULL,
  `valor_compra` DOUBLE(10,2) NOT NULL,
  `valor_venda` DOUBLE(10,2) NOT NULL,
  `data_referencia` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
INDEX `idx_id_valor_produto` (`id` ASC),
INDEX `idx_produto_id` (`produto_id` ASC),  
  CONSTRAINT `fk_produto`
    FOREIGN KEY (`produto_id`) REFERENCES `japp`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`estoque` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `produto_id` INT NOT NULL,
  `pessoa_id` INT NULL,
  `dataultimofechamento` VARCHAR(45) NULL,
  `datacontagem` VARCHAR(45) NULL,
  `quantidade` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_estoque_produto_idx` (`produto_id` ASC),
  CONSTRAINT `fk_estoque_produto`
    FOREIGN KEY (`produto_id`) REFERENCES `japp`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`tipo_atividade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`tipo_atividade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `datainclusao` DATETIME NULL,
  `dataalteracao` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`atividade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`atividade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `tipo_atividade_id` INT NOT NULL,
  `datainclusao` DATETIME NULL,
  `dataalteracao` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produto_tipo_atividade_idx` (`tipo_atividade_id` ASC),
  CONSTRAINT `fk_atividade_tipo_atividade`
    FOREIGN KEY (`tipo_atividade_id`)
    REFERENCES `japp`.`tipo_atividade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`servico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `datainclusao` DATETIME NULL,
  `dataalteracao` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`atividade_servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`atividade_servico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `atividade_id` INT NOT NULL,
  `servico_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_atividade_servico_atv_idx` (`atividade_id` ASC),
  INDEX `fk_atividade_servico_srv_idx` (`servico_id` ASC),
  CONSTRAINT `fk_atividade_servico_atv`
    FOREIGN KEY (`atividade_id`)
    REFERENCES `japp`.`atividade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_atividade_servico_srv`
    FOREIGN KEY (`servico_id`)
    REFERENCES `japp`.`servico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)	
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`pessoa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(1) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `nomecompleto` VARCHAR(45) NULL,
  `datanascimento` DATETIME NULL,
  `cpf` VARCHAR(45) NULL,
  `documento` VARCHAR(45) NULL,
  `tipodocumento` VARCHAR(10) NULL,
  `tipo_pessoa`  VARCHAR(3) NOT NULL,  
  `login` VARCHAR(45) NULL,
  `pass` VARCHAR(45) NULL,
  `validade_login` DATETIME NULL,
  `tipo_usuario` VARCHAR(3) NOT NULL,
  `email` VARCHAR(125) NULL,
  `empresa_id` INT NULL, 
  `dataultimoacesso` DATETIME NULL, 
  `datainclusao` DATETIME NULL,
  `dataalteracao` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `id_pessoa_idx` (`id` ASC),
  INDEX `login_pessoa_idx` (`login` ASC),
  CONSTRAINT `fk_empresa_pessoa`
    FOREIGN KEY (`empresa_id`)
    REFERENCES `japp`.`empresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`rotina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`rotina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rotina` VARCHAR(45) NULL,
  `descricao` VARCHAR(150) NULL,
  `status` INT NOT NULL,
  `rotina_pai` INT NULL,  
  PRIMARY KEY (`id`))
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`acesso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`acesso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pessoa_id` INT NOT NULL,
  `status` INT NOT NULL,
  `rotina_master` INT NULL,
  `rotina_slave` INT NULL,  
  PRIMARY KEY (`id`),
  INDEX `fk_acesso_pessoaidx` (`pessoa_id` ASC),
  CONSTRAINT `fk_acesso_pessoa` FOREIGN KEY (`pessoa_id`) REFERENCES `japp`.`pessoa` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rotina_master` FOREIGN KEY (`rotina_master`) REFERENCES `japp`.`rotina` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rotina_slave` FOREIGN KEY (`rotina_slave`) REFERENCES `japp`.`rotina` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION)
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`contato` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL,
  `descricao` VARCHAR(45) NULL,
  `pessoa_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_contato_pessoa1_idx` (`pessoa_id` ASC),
  CONSTRAINT `fk_contato_pessoa1`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `japp`.`pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = INNODB;


-- -----------------------------------------------------
-- Table `japp`.`orcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`orcamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(10) NULL,
  `pessoa_id` INT NOT NULL COMMENT 'pessoa fisica que solicitou orcamento',
  `empresa_id` INT NOT NULL COMMENT 'pessoa juridica que solicitou orcamento',
  `servico_id` INT NOT NULL,
  `datasolicitacao` VARCHAR(45) NULL,
  `dataconclusao` VARCHAR(45) NULL,
  `datavalidade` VARCHAR(45) NULL,
  `garantia` VARCHAR(45) NULL,
  `valormaoobra` VARCHAR(45) NULL,
  `valortotal` VARCHAR(45) NULL,
  `descricao` VARCHAR(45) NULL,
  `tipoorcamento` VARCHAR(45) NULL,
  `datainclusao` VARCHAR(45) NULL,
  `dataalteracao` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orcamento_pessoal_idx` (`pessoa_id` ASC),
  CONSTRAINT `fk_orcamento_pessoa` FOREIGN KEY (`pessoa_id`) REFERENCES `japp`.`pessoa` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_orcamento_empresa` FOREIGN KEY (`empresa_id`) REFERENCES `japp`.`empresa` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_orcamento_servico` FOREIGN KEY (`servico_id`) REFERENCES `japp`.`servico` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION)	
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`orcamento_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`orcamento_produto` (
  `orcamento_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  PRIMARY KEY (`orcamento_id`, `produto_id`),
  INDEX `fk_orcamento_has_produto_produto1_idx` (`produto_id` ASC),
  INDEX `fk_orcamento_has_produto_orcamento1_idx` (`orcamento_id` ASC),
  CONSTRAINT `fk_orcamento_has_produto_orcamento1`
    FOREIGN KEY (`orcamento_id`)
    REFERENCES `japp`.`orcamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orcamento_has_produto_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `japp`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`empresa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `razao_social` VARCHAR(45) NOT NULL,
  `nome_fantasia` VARCHAR(45) NULL,
  `cnpj` VARCHAR(45) NULL,
  `inscricao_est` VARCHAR(45) NULL,
  `inscricao_mun` VARCHAR(45) NULL,
  `matriz` INT(6) COMMENT 'refere-se ao id da propria tab empresa',
  `tipo` INT(2) COMMENT '1 = matriz; 2 = filial',
  `ativo` TINYINT(1),   
  `datainclusao` DATETIME NULL,
  `dataalteracao` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_id_empresa` (`id` ASC),
  INDEX `idx_rs_empresa` (`razao_social` ASC),
  INDEX `idx_nf_empresa` (`nome_fantasia` ASC))
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo_endereco` VARCHAR(45) NULL,
  `uf` VARCHAR(45) NULL,
  `cidade` VARCHAR(2) NULL,  
  `bairro` VARCHAR(45) NULL,
  `tipo_logradouro` VARCHAR(45) NULL,
  `logradouro` VARCHAR(45) NULL,
  `numero` VARCHAR(45) NULL,
  `complemento` VARCHAR(45) NULL,
  `pessoa_id` INT NULL,
  `empresa_id` INT NULL,
  `datainclusao` DATETIME NULL,
  `dataalteracao` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_endereco_pessoa_idx` (`pessoa_id` ASC),
  CONSTRAINT `fk_endereco_pessoa` FOREIGN KEY (`pessoa_id`) REFERENCES `japp`.`pessoa` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco_empresa` FOREIGN KEY (`empresa_id`) REFERENCES `japp`.`empresa` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION)
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`fornec_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`agente_externo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(1) NOT NULL COMMENT 'F = Fornecedor; C = Cliente',
  `tipo_pessoa`  VARCHAR(3) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `nomecompleto` VARCHAR(45) NULL,
  `razao_social` VARCHAR(45) NOT NULL,
  `nome_fantasia` VARCHAR(45) NULL,  
  `datanascimento` DATETIME NULL,
  `cpf` VARCHAR(45) NULL,
  `cnpj` VARCHAR(45) NULL,
  `inscricao_est` VARCHAR(45) NULL,
  `inscricao_mun` VARCHAR(45) NULL,  
  `tipodocumento` VARCHAR(10) NULL,
  `documento` VARCHAR(45) NULL,    
  `empresa_id` INT NULL COMMENT 'empresa/filial relacionada a este fornecedor/cliente', 
  `ativo` TINYINT(1),    
  `observacao` VARCHAR(255) NULL,  
  `datainclusao` DATETIME NULL,
  `dataalteracao` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `agente_externo_idx` (`id` ASC),
  INDEX `fk_empresa_id_idx` (`empresa_id` ASC),
  CONSTRAINT `fk_empresa_id` FOREIGN KEY (`empresa_id`) REFERENCES `japp`.`empresa` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION)
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`fornec_produto` 
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`fornec_produto` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`fornecedor_id` INT NOT NULL,
	`produto_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fornec_cliente_idx` (`id` ASC),
  INDEX `fk_produto_id_idx` (`produto_id` ASC),
  CONSTRAINT `fk_fornecedor_id` FOREIGN KEY (`fornecedor_id`) REFERENCES `japp`.`agente_externo` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_id` FOREIGN KEY (`produto_id`) REFERENCES `japp`.`produto` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION	)
ENGINE = INNODB;

-- ---------------------------------- origem web --------------------------------------------------
CREATE TABLE `japp`.`pedido` (
`id` INT(11) NOT NULL DEFAULT '0',
`empresa_id` INT(11) DEFAULT NULL,
`fornecedor_id` INT(11) DEFAULT NULL,
`datapedido` DATE DEFAULT NULL,
`dataprevista` DATE DEFAULT NULL,
`dataenvio` DATE DEFAULT NULL,
`enviovia` INT(11) DEFAULT NULL,
`valorfrete` DECIMAL(16,4) DEFAULT NULL,
`valorpedido` DECIMAL(16,2) DEFAULT NULL,
`destnome` VARCHAR(40) DEFAULT NULL,
`destendereco` VARCHAR(60) DEFAULT NULL,
`destcidade` VARCHAR(15) DEFAULT NULL,
`destestado` VARCHAR(15) DEFAULT NULL,
`destcaixapostal` VARCHAR(10) DEFAULT NULL,
`destpais` VARCHAR(15) DEFAULT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `fk_pedido_empresa` FOREIGN KEY (`empresa_id`) REFERENCES `japp`.`empresa` (`id`),
CONSTRAINT `fk_pedido_agente_externo` FOREIGN KEY (`fornecedor_id`) REFERENCES `japp`.`agente_externo` (`id`)
) ENGINE=INNODB;

 
CREATE TABLE `japp`.`pedido_item` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`pedido_id` INT(11) NOT NULL DEFAULT '0',
`produto_id` INT(11) NOT NULL DEFAULT '0',
`precounit` DECIMAL(16,4) NOT NULL DEFAULT '0.00',
`quantidade` SMALLINT(6) NOT NULL DEFAULT '0',
`desconto` DECIMAL(16,2) NOT NULL DEFAULT '0.00',
`total` DECIMAL(16,2) NOT NULL DEFAULT '0.00',
PRIMARY KEY (`id`),
CONSTRAINT `fk_pedido_item_pedido_id` FOREIGN KEY (`pedido_id`) REFERENCES `japp`.`pedido` (`id`),
CONSTRAINT `fk_pedido_item_produto_id` FOREIGN KEY (`produto_id`) REFERENCES `japp`.`produto` (`id`)
) ENGINE=INNODB;

-- ------------------------------------------------------------------------
-- -----------------------------------------------------
-- Table `japp`.`receita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`receita` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pessoa_id` INT NULL COMMENT 'pessoa responsavel',
  `servico_id` INT NULL,
  `resumo` VARCHAR(150) NULL,
  `descricao` VARCHAR(255) NULL,
  `tempo_medio` VARCHAR(25) NULL,
  `receita_origem` INT NULL,
  `tipo_receita` INT NULL,
  `datainclusao` DATETIME NULL,
  `dataalteracao` DATETIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_receita_pessoa` FOREIGN KEY (`pessoa_id`) REFERENCES `japp`.`pessoa` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_receita_servico` FOREIGN KEY (`servico_id`) REFERENCES `japp`.`servico` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION)	
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`receita_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`receita_produto` (
  `id` INT NOT NULL AUTO_INCREMENT,  
  `receita_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  `quantidade` SMALLINT(6) NOT NULL DEFAULT '0',
  `observacao` VARCHAR(150) NULL,
  PRIMARY KEY (`id`),
  INDEX `receita_produto_receita_idx` (`receita_id` ASC),
  INDEX `receita_produto_produto_idx` (`produto_id` ASC),
  CONSTRAINT `fk_receita_produto_receita` FOREIGN KEY (`receita_id`) REFERENCES `japp`.`receita` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_receita_produto_produto` FOREIGN KEY (`produto_id`) REFERENCES `japp`.`produto` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION)
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`cardapio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`cardapio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pessoa_id` INT NULL COMMENT 'pessoa responsavel',
  `servico_id` INT NULL,
  `descricao` VARCHAR(255) NULL,
  `dataexecucao` DATETIME NULL,
  `tempo_medio` VARCHAR(25) NULL,
  `cardapio_origem` INT NULL,
  `tipo_cardapio` INT NULL,
  `datainclusao` DATETIME NULL,
  `dataalteracao` DATETIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cardapio_pessoa` FOREIGN KEY (`pessoa_id`) REFERENCES `japp`.`pessoa` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cardapio_servico` FOREIGN KEY (`servico_id`) REFERENCES `japp`.`servico` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION)	
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`cardapio_receita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`cardapio_receita` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cardapio_id` INT NOT NULL,  
  `receita_id` INT NOT NULL,
  `quantidade` SMALLINT(6) NOT NULL DEFAULT '0',
  `observacao` VARCHAR(150) NULL,
  PRIMARY KEY (`id`),
  INDEX `cardapio_receita_idx` (`receita_id` ASC),
  INDEX `cardapio_receita_car_idx` (`cardapio_id` ASC),
  CONSTRAINT `fk_receita_cardapio_rec` FOREIGN KEY (`receita_id`) REFERENCES `japp`.`receita` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_receita_cardapio_car` FOREIGN KEY (`cardapio_id`) REFERENCES `japp`.`cardapio` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION)
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`receita_cardapio_his`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`receita_cardapio_his` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pessoa_id` INT NULL COMMENT 'pessoa responsavel',
  `servico_id` INT NULL,
  `cardapio_id` INT NOT NULL,
  `resumo` VARCHAR(150) NULL,
  `descricao` VARCHAR(255) NULL,
  `tempo_medio` VARCHAR(25) NULL,
  `receita_origem` INT NULL,
  `tipo_receita` INT NULL,
  `datainclusao` DATETIME NULL,
  `dataalteracao` DATETIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_rec_car_his_pessoa` FOREIGN KEY (`pessoa_id`) REFERENCES `japp`.`pessoa` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rec_car_his_servico` FOREIGN KEY (`servico_id`) REFERENCES `japp`.`servico` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,  
  CONSTRAINT `fk_rec_card_card_his` FOREIGN KEY (`cardapio_id`) REFERENCES `japp`.`cardapio` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION)  
ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `japp`.`receita_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `japp`.`receita_card_produto_his` (
  `id` INT NOT NULL AUTO_INCREMENT,  
  `receita_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  `quantidade` SMALLINT(6) NOT NULL DEFAULT '0',
  `observacao` VARCHAR(150) NULL,
  PRIMARY KEY (`id`),
  INDEX `receita_prod_rec_his_idx` (`receita_id` ASC),
  INDEX `receita_prod_prod_his_idx` (`produto_id` ASC),
  CONSTRAINT `fk_receita_prod_rec_his` FOREIGN KEY (`receita_id`) REFERENCES `japp`.`receita` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_receita_prod_prod_his` FOREIGN KEY (`produto_id`) REFERENCES `japp`.`produto` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION)
ENGINE = INNODB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- ---------------------------------------------------------------------------------------------
INSERT INTO `japp`.`rotina`(`rotina`, `descricao`, `status`) VALUES ('Cadastros', 'cadastros b�sicos', 1);
INSERT INTO `japp`.`rotina`(`rotina`, `descricao`, `status`) VALUES ('Produtos', 'produtos', 1);
INSERT INTO `japp`.`rotina`(`rotina`, `descricao`, `status`) VALUES ('Cozinha', 'cozinha', 1);
INSERT INTO `japp`.`rotina`(`rotina`, `descricao`, `status`) VALUES ('Financeiro', 'financeiro', 1);
INSERT INTO `japp`.`rotina`(`rotina`, `descricao`, `status`) VALUES ('Relat�rios', 'ambiente relat�rios', 1);
INSERT INTO `japp`.`rotina`(`rotina`, `descricao`, `status`) VALUES ('Operacional', 'ambiente operacional', 1);
INSERT INTO `japp`.`rotina`(`rotina`, `descricao`, `status`) VALUES ('Acesso', 'configura��o acesso', 1);

INSERT INTO `japp`.`rotina`(`rotina`, `descricao`, `status`, `rotina_pai`) VALUES ('Empresa', 'cadastro empresa', 1, 1);
INSERT INTO `japp`.`rotina`(`rotina`, `descricao`, `status`, `rotina_pai`) VALUES ('Pessoas', 'cadastro pessoas', 1, 1);
INSERT INTO `japp`.`rotina`(`rotina`, `descricao`, `status`, `rotina_pai`) VALUES ('Fornecedores', 'cadastro fornecedores', 1, 1);
INSERT INTO `japp`.`rotina`(`rotina`, `descricao`, `status`, `rotina_pai`) VALUES ('Clientes', 'cadastro clientes', 1, 1);
INSERT INTO `japp`.`rotina`(`rotina`, `descricao`, `status`, `rotina_pai`) VALUES ('Servi�os', 'cadastro servi�os', 1, 1);

INSERT INTO `japp`.`rotina`(`rotina`, `descricao`, `status`, `rotina_pai`) VALUES ('Produto', 'cadastro produto', 1, 2);
INSERT INTO `japp`.`rotina`(`rotina`, `descricao`, `status`, `rotina_pai`) VALUES ('Estoque', 'estoque', 1, 2);



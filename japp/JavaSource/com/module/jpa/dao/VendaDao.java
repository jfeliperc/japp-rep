package com.module.jpa.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

public class VendaDao {

    private EntityManager em;

    public VendaDao(EntityManager em) {
        this.em = em;
    }

//    /**
//     * Método usando a API de Criteria para gerar a seguinte consulta:
//     * SELECT * FROM Venda
//     *
//     * @return uma lista com todas as vendas.
//     */
//    public List<Venda> consultarTodas() {
//        /* CriteriaBuilder é uma fabrica de definições de consultas (CriteriaQuery). */
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        /**
//         *   CriteriaQuery é uma estrutura de consulta, ele pode ser criado a partir de um dos três métodos createQuery() sobrecarregados
//         * na interface CriteriaBuilder.
//         *
//         *   O método createQuery(Class<T>) cria uma estrutura de consulta onde a sua projeção será a classe passada por parâmetro Class<T>.
//         *
//         *   A CriteriaQuery não é uma consulta como o JPQL, ele é apenas a estrutura da consulta, a diferença principal entre eles é a forma
//         * de definir a consulta através de métodos ao invés de usar texto.
//         */
//        CriteriaQuery<Venda> c = cb.createQuery(Venda.class);
//
//        /**
//         *   Após montar a estrutura da consulta, é necessário passar o CriteriaQuery para o em.createQuery(), porque a CriteriaQuery tem 
//         * apenas a estrutura para montar a consulta, diferente de um JPQL.
//         *
//         *   Quando chamamos o método em.createQuery passando uma CriteriaQuery temos uma consulta fortemente tipada, por isso o retorno 
//         * deste método é um TypedQuery<T>.
//         */
//        TypedQuery<Venda> q = em.createQuery(c);
//
//        return q.getResultList();
//
//        /**
//         *   Como a API do Criteria usa o padrão de projeto Builder, fazendo com que os objetos fiquem imutáveis, podemos executar a mesma
//         * consulta em uma única linha:
//         *
//         *   return em.createQuery(em.getCriteriaBuilder().createQuery(Venda.class)).getResultList();
//         */
//    }
//
//    /**
//     * Método usando a API de Criteria para gerar a seguinte consulta:
//     * SELECT * FROM Venda
//     * WHERE id = :id
//     *
//     * @param id - ID da venda
//     * @return o objeto Venda que possui o ID informado.
//     */
//    public Venda consultarPorId(Long id) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Venda> c = cb.createQuery(Venda.class);
//        /**
//         *   A partir da CriteriaQuery podemos informar de qual tabela os dados serão consultados usando o método from(), que dado uma classe
//         * ou tipo de entidade (EntityType) ele retorna um objeto do tipo Root<T>, que representa a clausula "from" da consulta.
//         *
//         *   Através do Root<T> é possível obter as colunas, fazer joins, usar a clausula "in" e outros.
//         */
//        Root<Venda> venda = c.from(Venda.class);
//        /**
//         *   A partir do Root<T> é chamado o método where() que adiciona uma comparação se o campo "id" da entidade possui o valor do parametro "id".
//         *
//         *   Diferente do JPQL a passagem de parâmetro é fortemente tipada, a partir da CriteriaBuilder é necessário criar um parâmetro
//         * (ParameterExpression<T>) que possui o tipo do parametro e seu nome.
//         */
//        c.where(cb.equal(venda.get("id"), cb.parameter(String.class, "id")));
//
//        TypedQuery q = em.createQuery(c);
//        /* A passagem de parâmetros é igual ao do JPQL. */
//        q.setParameter("id", id);
//
//        return (Venda) q.getSingleResult();
//    }
//
//    /**
//     * Método usando a API de Criteria para gerar a seguinte consulta:
//     * SELECT * FROM Venda
//     * WHERE data BETWEEN (:inicio, :fim)
//     *
//     * @param inicio - data inicio do período.
//     * @param fim - data fim do período.
//     * @return Uma lista de objetos venda dentro do período informado.
//     */
//    public List<Venda> consultarPorPeriodo(Date inicio, Date fim) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Venda> c = cb.createQuery(Venda.class);
//        Root<Venda> venda = c.from(Venda.class);
//
//        /**
//         * Criado dois parâmetros (ParameterExpression<T>) para representar o período.
//         */
//        ParameterExpression<Date> dataInicio = cb.parameter(Date.class, "inicio");
//        ParameterExpression<Date> dataFim = cb.parameter(Date.class, "fim");
//
//        /**
//         * A partir do CriteriaBuilder podemos chamar o método between() passando qual o campo data entidade e os parâmetros que serão passados.
//         */
//        Expression<Date> data = venda.get("data");
//        c.where(cb.between(data, dataInicio, dataFim));
//
//        TypedQuery q = em.createQuery(c);
//        q.setParameter("inicio", inicio);
//        q.setParameter("fim", fim);
//
//        return q.getResultList();
//    }
//
//    /**
//     * Método usando a API de Criteria para gerar a seguinte consulta:
//     * SELECT DISTINCT c.*
//     * FROM Cliente c, Venda v
//     * WHERE c.id = v.cliente_id
//     *
//     * @return uma lista com os clientes que compraram algum doce.
//     */
//    public List<Cliente> consultarClientesQueCompraramUmDoce() {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Cliente> c = cb.createQuery(Cliente.class);
//
//        /**
//         * Podemos ter várias entidades informadas na clausula FROM.
//         */
//        Root<Cliente> cliente = c.from(Cliente.class);
//        Root<Venda> venda = c.from(Venda.class);
//
//        /**
//         * O método distinct(true), informa para a consulta usar a clausula DISTINCT na projeção.
//         *
//         * Usando o método equals(cliente, venda.get("cliente")) é feito a comparação "cliente.id = venda.cliente_id" no SQL.
//         */
//        c.distinct(true).where(cb.equal(cliente, venda.get("cliente")));
//
//        TypedQuery q = em.createQuery(c);
//        return q.getResultList();
//    }
//
//    /**
//     * Método usando a API de Criteria para gerar a seguinte consulta:
//     * SELECT DISTINCT v.*
//     * FROM Venda v
//     * INNER JOIN (Venda_Doce vd JOIN Doce d ON (d.id = vd.doce_id)) ON (vd.venda_id = v.id)
//     * WHERE d.id = 2
//     *
//     * @param id - ID do Doce.
//     * @return Uma lista de venda que possui o doce com o ID informado.
//     */
//    public List<Venda> consultarVendasPorDoce(Long id) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Venda> c = cb.createQuery(Venda.class);
//        Root<Venda> venda = c.from(Venda.class);
//
//        /**
//         * A partir do Root<T> podemos fazer um relacionamento com outra entidade através do join.
//         *
//         * O método join() possui várias sobrecargas, a forma simples é passar o nome do atributo que tem o relacionamento.
//         *
//         * Se queremos especificar o tipo de join INNER, LEFT, RIGHT, podemos passar um segundo parametro para o método join(), exemplo:
//         * venda.join("doces", JoinType.LEFT). Por padrão é usado o JoinType.INNER.
//         *
//         * Também é possível fazer o JOIN FETCH usando o método fetch(), exemplo: venda.fetch("doces").
//         */
//        Join<Venda, Doce> doce = venda.join("doces");
//
//        c.distinct(true).where(cb.equal(doce.get("id"), cb.parameter(Long.class, "id")));
//
//        TypedQuery q = em.createQuery(c);
//        q.setParameter("id", id);
//
//        return q.getResultList();
//    }
//
//    /**
//     * Método usando a API de Criteria para gerar a seguinte consulta:
//     * SELECT DISTINCT v.data, c.nome, d.descricao, d.preco
//     * FROM Venda v
//     * INNER JOIN (Venda_Doce vd JOIN Doce d ON (d.id = vd.doce_id)) ON (vd.venda_id = v.id)
//     * INNER JOIN Cliente c on (v.cliente_id = c.id)
//     *
//     * @return Uma lista com as informações data da venda, nome do cliente, descrição do doce e preço do doce.
//     */
//    public List<Object[]> relatorioVendasPorCliente() {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        /**
//         * Quando consultamos informações de várias entidades, podemos retornar um array de Object.
//         */
//        CriteriaQuery<Object[]> dados = cb.createQuery(Object[].class);
//        Root<Venda> venda = dados.from(Venda.class);
//        Join<Venda, Doce> doce = venda.joinList("doces");
//        Join<Venda, Cliente> cliente = venda.join("cliente");
//
//        /**
//         * Com o método multiselect() do CriteriaQuery podemos informar os atributos das entidades que serão retornados.
//         */
//        dados.multiselect(venda.get("data"), cliente.get("nome"), doce.get("descricao"), doce.get("preco"));
//
//        TypedQuery<Object[]> q = em.createQuery(dados);
//
//        return q.getResultList();
//    }
//
//    /**
//     * Método usando a API de Criteria para gerar a seguinte consulta:
//     * SELECT d.descricao as doce, count(*) as qtd, (count(*) * d.preco) as total
//     * FROM Venda v
//     * INNER JOIN (Venda_Doce vd JOIN Doce d ON (d.id = vd.doce_id)) ON (vd.venda_id = v.id)
//     * WHERE v.id = vd.venda_id
//     * AND   d.id = vd.doce_id
//     * GROUP BY vd.doce_id
//     * ORDER BY d.descricao
//     *
//     * @return Uma lista de objetos RelatorioVendaDoce que sumariza a quantidade de doces vendidos.
//     */
//    public List<RelatorioVendaDoce> relatorioDocesPorVenda() {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        /**
//         * Quando efetuar a consulta será guardado os objetos em uma classe que representa o relatório,
//         * esta classe possui os atributos descricao, quantidade e total.
//         */
//        CriteriaQuery<RelatorioVendaDoce> relatorio = cb.createQuery(RelatorioVendaDoce.class);
//        Root<Venda> venda = relatorio.from(Venda.class);
//        Join<Venda, Doce> doce = venda.joinList("doces");
//
//        /**
//         * A interface Selection<T> representa cada coluna que será retornada na consulta.
//         *
//         * Ela possui o método alias() onde você pode dar um apelido para a coluna que será consultada.
//         */
//        Selection<String> nomeDoce = doce.get("descricao").as(String.class).alias("doce");
//
//        /**
//         * Com o método count() da CriteriaBuilder está sendo usado para contar quantas vendas foram feitas por doce.
//         * Para isso também adicionei um groupBy por doce no CriteriaQuery.
//         */
//        Selection<Long> qtd = cb.count(venda).alias("qtd");
//
//        /**
//         * A interface CriteriaBuilder possui métodos para diversas funções, como por exemplo:
//         * - Funções de agregação:
//         *      - avg(), count(), countDistinct(), max(), min(), sum() e outros.
//         * - Funções de dados:
//         *      - abs(), concat(), length(), sqrt(), substring(), upper(), trim() e outros.
//         * - Expressões escalares:
//         *      - all(), any(), sum(), prod(), diff(), quot(), selectCase() e outros.
//         * - Predicado:
//         *      - and(), or(), not(), equal(), notEqual(), gt(), ge(), lt(), le(), between(), isNull(), isNotNull(),
//         *        exists(), not(exists()), isEmpty(), isNotEmpty(), like(), notLike(), in(), not(in()) e outros.
//         *
//         * Usando o método prod() podemos multiplicar dois valores, então estamos multiplicando o preço do doce pela quantidade de vezes
//         * que ele foi vendido.
//         */
//        Selection<Double> total = cb.prod(doce.get("preco").as(Double.class), cb.count(venda)).as(Double.class).alias("total");
//
//        /**
//         * O método construct() do CriteriaBuilder vai guardar as colunas informadas na em objetos do tipo da classe informado.
//         *
//         * A classe informada precisa ter um construtor que recebe como parâmetro as colunas que serão retornadas, com seus respectivos
//         * tipos de dados e na ordem que eles serão consultados. Neste exemplo a classe RelatorioVendaDoce tem o construtor:
//         *
//         * public RelatorioVendaDoce(String descricao, Long quantidade, Double total) {
//         *     this.descricao = descricao;
//         *     this.quantidade = quantidade;
//         *     this.total = total;
//         * }
//         */
//        relatorio.select(cb.construct(RelatorioVendaDoce.class, nomeDoce, qtd, total));
//
//        /**
//         * O método groupBy() da CriteriaQuery agrupa as informações, neste exemplo queremos agrupar as vendas por doce.
//         */
//        relatorio.groupBy(doce);
//
//        /**
//         * O método orderBy da CriteriaQuery pode ordenar de forma crescent (asc) ou decrescente (desc) os resultados,
//         * ele recebe como parametro um objeto do tipo Order que pode ser objetido através do método asc() ou desc() do
//         * CriteriaBuilder.
//         */
//        relatorio.orderBy(cb.asc(doce.get("descricao")));
//
//        TypedQuery<RelatorioVendaDoce> q = em.createQuery(relatorio);
//        return q.getResultList();
//    }
}

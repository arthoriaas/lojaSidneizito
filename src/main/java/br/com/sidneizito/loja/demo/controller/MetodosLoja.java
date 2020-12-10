package br.com.sidneizito.loja.demo.controller;

import br.com.sidneizito.loja.demo.model.ClienteQtCompras;
import br.com.sidneizito.loja.demo.model.ClientesValor;
import br.com.sidneizito.loja.demo.model.Compras;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MetodosLoja {
    private static final String url = "jdbc:h2:mem:loja-sidneizito";
    private static final String user = "sa";
    private static final String senha = "";
    private String query = "SELECT c.nome, sum(cm.valor_total) as valor_total FROM COMPRAS cm JOIN CLIENTES c WHERE c.cpf = cm.cliente GROUP BY cliente ORDER BY sum(cm.VALOR_TOTAL) DESC";
    private String query2 =  "SELECT top 1 c.nome, cp.valor_total FROM COMPRAS cp JOIN CLIENTES c WHERE cp.data like '%2019' AND cp.cliente = c.cpf order by valor_total desc";
    private String query3 = "SELECT c.nome, Count(cp.valor_total) as qt_compras FROM COMPRAS AS cp JOIN CLIENTES c WHERE data LIKE '%2018' AND cp.cliente = c.cpf GROUP BY cliente ORDER BY qt_compras DESC";


    @GetMapping("/listar-valor-total")
    public List<ClientesValor> resultClientes() throws SQLException {
        Connection conn = DriverManager.getConnection(url,user,senha);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<ClientesValor> cv = new ArrayList<ClientesValor>();
        while(rs.next()){
            String nome = rs.getString("nome");
            Double valor = rs.getDouble("valor_total");
            ClientesValor cvrs = new ClientesValor(nome, valor);
            cv.add(cvrs);
        }
        conn.close();
        return cv;
    }
    @GetMapping("/listar-clientes-maior")
    public List<ClientesValor> resultClienteMaior() throws SQLException {
        Connection conn = DriverManager.getConnection(url,user,senha);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query2);
        List<ClientesValor> cv = new ArrayList<ClientesValor>();
        while(rs.next()) {
            String nome = rs.getString("nome");
            Double valor = rs.getDouble("valor_total");
            ClientesValor cvrs = new ClientesValor(nome, valor);
            cv.add(cvrs);
        }

        conn.close();
        return cv;
    }
    @GetMapping("/listar-numero-compras")
    public List<ClienteQtCompras> resultClienteNumeroCompras() throws SQLException {
        Connection conn = DriverManager.getConnection(url,user,senha);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query3);
        List<ClienteQtCompras> cqt = new ArrayList<ClienteQtCompras>();
        while(rs.next()) {
            String nome = rs.getString("nome");
            int qtCompras = rs.getInt("qt_compras");
            ClienteQtCompras cqtc = new ClienteQtCompras(nome, qtCompras);
            cqt.add(cqtc);
        }

        conn.close();
        return cqt;
    }

}







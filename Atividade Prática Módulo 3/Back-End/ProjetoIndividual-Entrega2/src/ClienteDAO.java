import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class ClienteDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
    public void saveCliente(Cliente cliente) { 
        // Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
        // de dados   
        String sql = "INSERT INTO cliente(nome,sobrenome,cpf,dataNasc, telefone, email, endereco, numero, cep)"+
        " VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            // Cria uma conexão com o banco
            conn = Conexao.createConnectionToMySQL();
 
            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
 
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getSobrenome());
            pstm.setString(3, cliente.getCPF());
            pstm.setDate(4, new Date(cliente.getDataNascimento().getTime()));
            pstm.setString(5, cliente.getTelefone());
            pstm.setString(6, cliente.getEmail());
            pstm.setString(7, cliente.getEndereco());
            pstm.setInt(8, cliente.getNumero());
            pstm.setString(9, cliente.getCEP());
 
            // Executa a sql para inserção dos dados
            pstm.execute();
        } catch (Exception e) { 
            e.printStackTrace();
        } finally { 
            // Fecha as conexões 
            try {
                if (pstm != null) {
 
                    pstm.close();
                }
 
                if (conn != null) {
                    conn.close();
                }
 
            } catch (Exception e) {
 
                e.printStackTrace();
            }
        }
    }
    public void removeById(int id) {

        String sql = "DELETE FROM cliente WHERE id = ?";
        try {
            conn = Conexao.createConnectionToMySQL(); // cria a conexao
            pstm = conn.prepareStatement(sql); // passa comando sql para o objeto pstm
            pstm.setInt(1, id); // seta o id no comando sql
            pstm.execute(); // executa o comando sql que está no objeto pstm
        } catch (Exception e) {            
             e.printStackTrace();
         } finally {
            try {
                 if (pstm != null) {
                    pstm.close();
                 }
                if (conn != null) {
                     conn.close();
                 }
            } catch (Exception e) {
                e.printStackTrace();
             }
         }
     }
    public void updateCliente(Cliente cliente) {
	   String sql = "UPDATE cliente SET nome = ?, sobrenome = ?, cpf = ?, dataNasc = ?,"
	   		+ " telefone = ?, email = ?, endereco = ?, numero = ?, cep = ?" + " WHERE id = ?";
	   try {
	        // Cria uma conexão com o banco
	        conn = Conexao.createConnectionToMySQL();
	       // Cria um PreparedStatment, classe usada para executar a query
	        pstm = conn.prepareStatement(sql);
	
	        pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getSobrenome());
            pstm.setString(3, cliente.getCPF());
            pstm.setDate(4, new Date(cliente.getDataNascimento().getTime()));
            pstm.setString(5, cliente.getTelefone());
            pstm.setString(6, cliente.getEmail());
            pstm.setString(7, cliente.getEndereco());
            pstm.setInt(8, cliente.getNumero());
            pstm.setString(9, cliente.getCEP());
	
	       pstm.setInt(10, cliente.getId());
	       // Executa a sql para inserção dos dados
	        pstm.execute();
	
	   } catch (Exception e) {
	       e.printStackTrace();
	    } finally {
	       // Fecha as conexões
	       try {
	            if (pstm != null) {
	               pstm.close();
	            }
	           if (conn != null) {
	                conn.close();
	            }
	       } catch (Exception e) {
	           e.printStackTrace();
	        }
	    }
	}
    public List<Cliente> getClientes() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList<Cliente>();
         ResultSet rset = null;
        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
             while (rset.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rset.getInt("id"));
                cliente.setNome(rset.getString("nome"));
                cliente.setSobrenome(rset.getString("sobrenome"));
                cliente.setCPF(rset.getString("cpf"));
                cliente.setDataNascimento(rset.getDate("dataNasc"));
                cliente.setTelefone(rset.getString("telefone"));
                cliente.setEmail(rset.getString("email"));
                cliente.setEndereco(rset.getString("endereco"));
                cliente.setNumero(rset.getInt("numero"));
                cliente.setCEP(rset.getString("cep"));
                clientes.add(cliente);
             }
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            try {
                if (rset != null) {
                    rset.close();
                 }
                if (pstm != null) {
                    pstm.close();
                 }
                if (conn != null) {
                     conn.close();
                 }
            } catch (Exception e) {
                e.printStackTrace();
             }
         }
        return clientes;
     }
    public List<Cliente> getClientesNome(String nome) {
        String sql = "SELECT * FROM cliente\r\n" + "WHERE nome LIKE '%" + nome + "%';";
        List<Cliente> clientes = new ArrayList<Cliente>();
        // Classe que vai recuperar os dados do banco de dados
         ResultSet rset = null;
        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            // Enquanto existir dados no banco de dados, faça
             while (rset.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rset.getInt("id"));
                cliente.setNome(rset.getString("nome"));
                cliente.setSobrenome(rset.getString("sobrenome"));
                cliente.setCPF(rset.getString("cpf"));
                cliente.setDataNascimento(rset.getDate("dataNasc"));
                cliente.setTelefone(rset.getString("telefone"));
                cliente.setEmail(rset.getString("email"));
                cliente.setEndereco(rset.getString("endereco"));
                cliente.setNumero(rset.getInt("numero"));
                cliente.setCEP(rset.getString("cep"));
                clientes.add(cliente);
             }
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            try {
                if (rset != null) {
                    rset.close();
                 }
                if (pstm != null) {
                    pstm.close();
                 }
                if (conn != null) {
                     conn.close();
                 }
            } catch (Exception e) {
                e.printStackTrace();
             }
         }
        return clientes;
     }
    public Cliente getClientesID(int id) {
        String sql = "SELECT * FROM cliente\r\n" + "WHERE id LIKE '" + id + "';";
        // Classe que vai recuperar os dados do banco de dados
        Cliente cliente = new Cliente();
        ResultSet rset = null;
        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            // Enquanto existir dados no banco de dados, faça
             while (rset.next()) {
            	 cliente.setId(rset.getInt("id"));
                 cliente.setNome(rset.getString("nome"));
                 cliente.setSobrenome(rset.getString("sobrenome"));
                 cliente.setCPF(rset.getString("cpf"));
                 cliente.setDataNascimento(rset.getDate("dataNasc"));
                 cliente.setTelefone(rset.getString("telefone"));
                 cliente.setEmail(rset.getString("email"));
                 cliente.setEndereco(rset.getString("endereco"));
                 cliente.setNumero(rset.getInt("numero"));
                 cliente.setCEP(rset.getString("cep"));
             }
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            try {
                if (rset != null) {
                    rset.close();
                 }
                if (pstm != null) {
                    pstm.close();
                 }
                if (conn != null) {
                     conn.close();
                 }
            } catch (Exception e) {
                e.printStackTrace();
             }
         }
        return cliente;
     }
}
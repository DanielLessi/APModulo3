import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class DestinoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
    public void saveDestino(Destino destino) { 
        // Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
        // de dados   
        String sql = "INSERT INTO destino(nome,aeroporto,pais,cidade)"+" VALUES(?,?,?,?)";
        try {
            // Cria uma conexão com o banco
            conn = Conexao.createConnectionToMySQL();
 
            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
 
            pstm.setString(1, destino.getNome());
            pstm.setString(2, destino.getAeroporto());
            pstm.setString(3, destino.getPais());
            pstm.setString(4, destino.getCidade());
 
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

        String sql = "DELETE FROM destino WHERE id = ?";
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
    public void updateDestino(Destino destino) {
	   String sql = "UPDATE destino SET nome = ?, aeroporto = ?, pais = ?, cidade = ?," + " WHERE id = ?";
	   try {
	        // Cria uma conexão com o banco
	        conn = Conexao.createConnectionToMySQL();
	       // Cria um PreparedStatment, classe usada para executar a query
	        pstm = conn.prepareStatement(sql);
	
	        pstm.setString(1, destino.getNome());
            pstm.setString(2, destino.getAeroporto());
            pstm.setString(3, destino.getPais());
            pstm.setString(4, destino.getCidade());
	
	       pstm.setInt(5, destino.getId());
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
    public List<Destino> getDestinos() {
        String sql = "SELECT * FROM destino";
        List<Destino> destinos = new ArrayList<Destino>();
         ResultSet rset = null;
        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
             while (rset.next()) {
                Destino destino = new Destino();
                destino.setId(rset.getInt("id"));
                destino.setNome(rset.getString("nome"));
                destino.setAeroporto(rset.getString("aeroporto"));
                destino.setPais(rset.getString("pais"));
                destino.setCidade(rset.getString("cidade"));
                destinos.add(destino);
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
        return destinos;
     }
    public List<Destino> getDestinosNome(String nome) {
        String sql = "SELECT * FROM destino\r\n" + "WHERE nome LIKE '%" + nome + "%';";
        List<Destino> destinos = new ArrayList<Destino>();
        // Classe que vai recuperar os dados do banco de dados
         ResultSet rset = null;
        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            // Enquanto existir dados no banco de dados, faça
             while (rset.next()) {
            	 Destino destino = new Destino();
                 destino.setId(rset.getInt("id"));
                 destino.setNome(rset.getString("nome"));
                 destino.setAeroporto(rset.getString("aeroporto"));
                 destino.setPais(rset.getString("pais"));
                 destino.setCidade(rset.getString("cidade"));
                 destinos.add(destino);
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
        return destinos;
     }
    public Destino getDestinosID(int id) {
        String sql = "SELECT * FROM destino\r\n" + "WHERE id LIKE '" + id + "';";
        // Classe que vai recuperar os dados do banco de dados
        Destino destino = new Destino();
        ResultSet rset = null;
        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            // Enquanto existir dados no banco de dados, faça
             while (rset.next()) {
                 destino.setId(rset.getInt("id"));
                 destino.setNome(rset.getString("nome"));
                 destino.setAeroporto(rset.getString("aeroporto"));
                 destino.setPais(rset.getString("pais"));
                 destino.setCidade(rset.getString("cidade"));
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
        return destino;
     }
}
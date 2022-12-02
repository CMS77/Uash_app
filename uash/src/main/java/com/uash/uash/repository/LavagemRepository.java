// Queries no banco de dados

package com.uash.uash.repository;
 
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uash.uash.model.Lavagem;
import com.uash.uash.views.LavagemView;
 
public interface LavagemRepository extends CrudRepository<Lavagem, Integer> {
    @Query(value = "Select lavagem_id as id, lavagem_val as valor, "+
        "lavagem_tipo as tipoLavagem, lavagem_loc as localizacao, lavagem_hora as horario, lavagem_sta as status, lavagem_rat as rating, "+
        "uasher_id as uasherId, veiculo_id as veiculoId from lavagem "+
        "INNER JOIN uasher ON lavagem_uasher = uasher_id " +
        "INNER JOIN veiculo ON lavagem_veic = veiculo_id ", nativeQuery = true)
    Iterable<LavagemView> findAllLavagem();

    @Query(value = "Select lavagem_id as id, lavagem_val as valor, "+
        "lavagem_tipo as tipoLavagem, lavagem_loc as localizacao, lavagem_hora as horario, lavagem_sta as status, lavagem_rat as rating, "+
        "uasher_id as uasherId, veiculo_id as veiculoId from lavagem " + 
        "INNER JOIN uasher ON lavagem_uasher = uasher_id " +
        "INNER JOIN veiculo ON lavagem_veic = veiculo_id " +
        "where lavagem_id = :lavagemId", nativeQuery = true)
    LavagemView findLavagemById(@Param("lavagemId") int lavagemId);


    @Modifying  
    @Transactional    
    @Query(value="Update lavagem set "+
        "lavagem_rat = :#{#lavagem.rating}, lavagem_sta = :#{#lavagem.status}", nativeQuery=true) 
    Integer updateLavagem(@Param("lavagem") Lavagem lavagem);
    

    @Modifying  
    @Transactional
    @Query(value=" Delete from lavagem "+
        "where lavagem_id = :lavagemId", nativeQuery=true) 
    Integer deleteLavagem(@Param("lavagemId") int lavagemId);
}
package com.uash.uash.repository;
 
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uash.uash.model.Veiculo;
import com.uash.uash.views.VeiculoView;
 
public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {
    @Query(value = "Select veiculo_id as id, veiculo_tipo as tipo, "+
        "veiculo_mat as matricula, veiculo_loc as localizacao, users_user_id as userId from veiculo " +
        "INNER JOIN veiculo_users ON veiculo_veiculo_id = veiculo_id", nativeQuery = true)
    Iterable<VeiculoView> findAllVeiculo();

    @Query(value = "Select veiculo_id as id, veiculo_tipo as tipo, "+
        "veiculo_mat as matricula, veiculo_loc as localizacao, users_user_id as userId from veiculo "+
        "INNER JOIN veiculo_users ON veiculo_veiculo_id = veiculo_id "+
        "where veiculo_id = :veiculoId", nativeQuery = true)
    VeiculoView findVeiculoById(@Param("veiculoId") int veiculoId);

    @Modifying  
    @Transactional    
    @Query(value="Update veiculo set "+
        "veiculo_tipo = :#{#veiculo.tipo}, veiculo_mat = :#{#veiculo.matricula}, veiculo_loc = :#{#veiculo.localizacao} "+
        "where veiculo_id = :#{#veiculo.id}", nativeQuery=true) 
    Integer updateVeiculo(@Param("veiculo") Veiculo veiculo);
    

    @Modifying  
    @Transactional
    @Query(value=" Delete from veiculo "+
        "where veiculo_id = :veiculoId", nativeQuery=true) 
    Integer deleteVeiculo(@Param("veiculoId") int veiculoId);

}
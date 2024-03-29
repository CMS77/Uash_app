package com.uash.uash.repository;
 
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uash.uash.model.Uasher;
import com.uash.uash.views.UasherView;
 
public interface UasherRepository extends CrudRepository<Uasher, Integer> {
    @Query(value = "Select uasher_id as id, uasher_rat as rating, "+
        "uasher_carta as cartaConducao, uasher_mat as material, uasher_loc as localizacao, user_id as userId from uasher " +
        "INNER JOIN usuario ON uasher_user = user_id", nativeQuery = true)
    Iterable<UasherView> findAllUasher();

    @Query(value = "Select uasher_id as id, uasher_rat as rating, "+
        "uasher_carta as cartaConducao, uasher_mat as material, uasher_loc as localizacao, uasher_user as userId from uasher "+
        "where uasher_id = :uasherId", nativeQuery = true)
    UasherView findUasherById(@Param("uasherId") int uasherId);

    @Query(value = "Select uasher_id as id, uasher_rat as rating, "+
        "uasher_carta as cartaConducao, uasher_mat as material, uasher_loc as localizacao, uasher_user as userId from uasher " +
        "INNER JOIN usuario ON uasher_user = user_id " +
        "where user_id = :userId", nativeQuery = true)
    UasherView findUasherByUser(@Param("userId") int userId);

    @Modifying  
    @Transactional    
    @Query(value="Update uasher set "+
        "uasher_rat = :#{#uasher.rating}, uasher_carta = :#{#uasher.cartaConducao}, uasher_mat = :#{#uasher.material}, uasher_loc = :#{#uasher.localizacao} "+
        "where uasher_id = :#{#uasher.id}", nativeQuery=true) 
    Integer updateUasher(@Param("uasher") Uasher uasher);

    @Modifying  
    @Transactional    
    @Query(value="Update uasher set "+
        "uasher_rat = :#{#rating}, uasher_carta = :#{#uasher.cartaConducao}, uasher_mat = :#{#uasher.material}, uasher_loc = :#{#uasher.localizacao} "+
        "where uasher_id = :#{#uasher.id}", nativeQuery=true) 
    Integer updateUasherRating(@Param("uasher") Uasher uasher, @Param("rating") int rating);    

    @Modifying  
    @Transactional
    @Query(value=" Delete from uasher "+
        "where uasher_id = :uasherId", nativeQuery=true) 
    Integer deleteUasher(@Param("uasherId") int uasherId);
}
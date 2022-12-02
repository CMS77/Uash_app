package com.uash.uash.repository;


import javax.transaction.Transactional;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uash.uash.model.User;
import com.uash.uash.views.UserView;
 
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "Select user_id as id, user_nome as name, "+
    "user_dt_nasc as dataNasc, user_email as email, user_tel as telefone, user_loc as localizacao from usuario " 
    /*"INNER JOIN usuario_veiculos ON user_id = user_user_id " //não funciona se deixar esse inner join
    "INNER JOIN veiculo ON user_id = user_user_id "*/, nativeQuery = true)
    Iterable<UserView> findAllUsers();

    @Query(value = "Select user_id as id, user_nome as name, "+
        "user_dt_nasc as dataNasc, user_email as email, user_tel as telefone, user_loc as localizacao from usuario "+
        "where user_id = :userId", nativeQuery = true)
    UserView findUserById(@Param("userId") int userId);

    @Modifying
    @Transactional    
    @Query(value="Insert into usuario "+ 
              "(user_nome, user_email, user_pass, user_tel, user_dt_nasc, user_loc) "+
              "values(:#{#user.nome}, :#{#user.email}, :#{#user.password}, :#{#user.telefone}, :#{#user.dataNasc}, :#{#user.localizacao})",
               nativeQuery=true) 
    Integer registerUser(@Param("user") User user);

    @Modifying  
    @Transactional    
    @Query(value="Update usuario set "+
        "user_nome = :#{#user.nome}, user_tel = :#{#user.telefone}, user_dt_nasc = :data, user_loc = :#{#user.localizacao} "+
        "where user_id = :#{#user.id}", nativeQuery=true) 
    Integer updateUser(@Param("user") User user, @Param("data") LocalDate data);
    

    @Modifying  
    @Transactional    
    @Query(value="Update usuario set "+
        "user_pass = :password "+
        "where user_id = :userId", nativeQuery=true) 
    Integer updateUserPass(@Param("userId") int userId, @Param("password") String password);

    @Modifying  
    @Transactional
    @Query(value=" Delete from usuario "+
        "where user_id = :userId", nativeQuery=true) 
    Integer deleteUser(@Param("userId") int userId);
}
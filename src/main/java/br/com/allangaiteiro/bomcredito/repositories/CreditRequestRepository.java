package br.com.allangaiteiro.bomcredito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.allangaiteiro.bomcredito.model.CreditRequest;

@Repository
public interface CreditRequestRepository extends JpaRepository<CreditRequest, Integer> {
    @Query("SELECT COUNT(id) FROM CreditRequest")
    long countAll();

    @Query("SELECT  SUM( CASE WHEN  MONTH(created_at) = MONTH(NOW()) THEN 1 ELSE 0 END ) from  CreditRequest")
    long countMonth();

    @Query("SELECT  SUM( CASE WHEN  MONTH(created_at) = MONTH(NOW())-1 THEN 1 ELSE 0 END ) from  CreditRequest")
    long countBeforeMonth();

    @Query("SELECT  SUM( CASE WHEN MONTH(created_at) = MONTH(NOW()) AND  DAY(created_at) = DAY(NOW()) THEN 1 ELSE 0 END ) from  CreditRequest")
    long countDAY();

    @Query("SELECT  SUM( CASE WHEN MONTH(created_at) = MONTH(NOW()) AND  DAY(created_at) = DAY(NOW())-1 THEN 1 ELSE 0 END ) from  Opportunity")
    long countBeforeDAY();
}

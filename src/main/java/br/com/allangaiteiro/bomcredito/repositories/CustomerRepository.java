package br.com.allangaiteiro.bomcredito.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.allangaiteiro.bomcredito.model.Customer;
import br.com.allangaiteiro.bomcredito.model.RequestDay;
import br.com.allangaiteiro.bomcredito.model.RequestMonth;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT COUNT(id) FROM Customer")
    long countAll();

    @Query("SELECT  SUM( CASE WHEN  MONTH(created_at) = MONTH(NOW()) THEN 1 ELSE 0 END ) from  Customer")
    long countMonth();

    @Query("SELECT  SUM( CASE WHEN  MONTH(created_at) = MONTH(NOW())-1 THEN 1 ELSE 0 END ) from  Customer")
    long countBeforeMonth();

    @Query("SELECT  SUM( CASE WHEN MONTH(created_at) = MONTH(NOW()) AND  DAY(created_at) = DAY(NOW()) THEN 1 ELSE 0 END ) from  Customer")
    long countDAY();

    @Query("SELECT  SUM( CASE WHEN MONTH(created_at) = MONTH(NOW()) AND  DAY(created_at) = DAY(NOW())-1 THEN 1 ELSE 0 END ) from  Customer")
    long countBeforeDAY();

    /* dashboard do mes */
    @Query("SELECT SUM(1) as total, Day(created_at) AS dia FROM Customer where Month(created_at) = Month(now()) GROUP BY Day(created_at)")
    List<RequestDay> dashboardMonth();

    /* dashboard do ano */
    @Query("SELECT SUM(1) as Total, Month(created_at) AS month FROM Customer where year (created_at) = year(now()) GROUP BY Month(created_at)")
    List<RequestMonth> dashboardYear();
}

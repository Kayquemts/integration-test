package io.github.kayque.integration_test.Repository;

import io.github.kayque.integration_test.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT vehicle " +
            "FROM Vehicle vehicle " +
            "WHERE vehicle.brand = :brand")
    public List<Vehicle> findByBrand(@Param("brand") String brand);
}

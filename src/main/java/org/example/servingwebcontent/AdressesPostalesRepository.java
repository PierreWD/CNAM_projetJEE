package org.example.servingwebcontent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdressesPostalesRepository extends JpaRepository<AdressesPostales, Long> {

}
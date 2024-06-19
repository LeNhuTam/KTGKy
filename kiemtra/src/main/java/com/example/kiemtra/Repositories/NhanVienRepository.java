package com.example.kiemtra.Repositories;

import com.example.kiemtra.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    NhanVien searchNhanVienByTenNV(String keyword);
}
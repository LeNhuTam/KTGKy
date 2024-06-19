package com.example.kiemtra.Service;

import com.example.kiemtra.Repositories.NhanVienRepository;
import com.example.kiemtra.model.NhanVien;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional
public class NhanVienService {
    private final NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    public Optional<NhanVien> getNhanVienById(String id) {
        return nhanVienRepository.findById(id);
    }

    public NhanVien addProduct(@Valid NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public NhanVien updateNhanVien(@NotNull NhanVien nhanVien) {
        NhanVien existingNhanVien = nhanVienRepository.findById(nhanVien.getMaNV())
                .orElseThrow(() -> new IllegalStateException("Nhân viên với mã: " +
                        nhanVien.getMaNV() + " không tồn tại."));
        existingNhanVien.setTenNV(nhanVien.getTenNV());
        existingNhanVien.setLuong(nhanVien.getLuong());
        existingNhanVien.setNoiSinh(nhanVien.getNoiSinh());
        existingNhanVien.setPb(nhanVien.getPb());
        return nhanVienRepository.save(existingNhanVien);
    }
    // Delete a NhanVien by its id
    public void deleteNhanVienById(String id) {
        if (!nhanVienRepository.existsById(id)) {
            throw new IllegalStateException("Nhân Viên với id: " + id + " không tồn tại.");
        }
        nhanVienRepository.deleteById(id);
    }
    public Optional<NhanVien> searchNhanVienByTenNV(String keyword) throws
            UsernameNotFoundException {
        return Optional.ofNullable(nhanVienRepository.searchNhanVienByTenNV(keyword));
    }
}
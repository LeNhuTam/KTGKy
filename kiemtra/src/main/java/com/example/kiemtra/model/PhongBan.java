package com.example.kiemtra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PhongBan")
public class PhongBan {
    @Id
    @Column(length = 2)
    private String MaPhong;
    @NotBlank(message = "Tên là bắt buộc")
    @Column(length = 30)
    private String name;
}
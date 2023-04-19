package com.example.goods.model;

import com.example.goods.dto.GoodsDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Goods
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rollNo;
    private String firstName = "VIGNESHWARAN";
    private String lastName = "NALLASAMY";

    public Goods(GoodsDTO goodsDTO)
    {
        this.firstName = goodsDTO.getFirstName();
        this.lastName = goodsDTO.getLastName();
    }
}

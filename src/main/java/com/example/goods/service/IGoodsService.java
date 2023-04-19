package com.example.goods.service;

import com.example.goods.dto.GoodsDTO;
import com.example.goods.model.Goods;

public interface IGoodsService
{

    Goods insert(GoodsDTO goodsDTO);
}

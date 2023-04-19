package com.example.goods.service;

import com.example.goods.dto.GoodsDTO;
import com.example.goods.model.Goods;
import com.example.goods.repository.GoodsRepository;
import com.example.goods.utility.EmailSender;
import com.example.goods.utility.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService implements IGoodsService
{
    @Autowired
    GoodsRepository repository;
    @Autowired
    TokenUtility tokenUtility;
    @Autowired
    EmailSender emailSender;
    public Goods insert(GoodsDTO goodsDTO)
    {
        Goods goods = new Goods(goodsDTO);
        String token=tokenUtility.createToken(goods.getRollNo());
        repository.save(goods);
        emailSender.sendEmail("vickyshanehunter@gmail.com","Regarding Data Insertion....","Data Inserted Successfully"+"\nTOKEN : "+token);
        return goods;
    }

}

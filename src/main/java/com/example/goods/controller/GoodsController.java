package com.example.goods.controller;

import com.example.goods.dto.GoodsDTO;
import com.example.goods.dto.ResponseDTO;
import com.example.goods.model.Goods;
import com.example.goods.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class GoodsController
{
    @Autowired
    IGoodsService service;
    @GetMapping("/get")
    public String greeting(GoodsDTO goodsDTO)
    {
     return "Good Evening"+" "+goodsDTO.getFirstName()+" "+goodsDTO.getLastName();
    }
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> posting(@RequestBody GoodsDTO goodsDTO)
    {
        Goods goods = service.insert(goodsDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data Inserted Successfully..!!",goods);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}

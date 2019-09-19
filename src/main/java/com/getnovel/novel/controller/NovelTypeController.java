package com.getnovel.novel.controller;

import com.getnovel.novel.pojo.NovelType;
import com.getnovel.novel.serviceImpl.NovelTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * *
 */
@RestController
public class NovelTypeController {
    @Autowired
    private NovelTypeServiceImpl novelTypeService;

    /**
     * 查询小说的分类列表
     * @return
     */
    @RequestMapping(value = "/types",method = RequestMethod.GET)
    public List<NovelType> getNovelTypes(){
       return novelTypeService.getNovelType();

    }


}

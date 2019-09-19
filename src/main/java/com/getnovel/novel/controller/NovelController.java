package com.getnovel.novel.controller;

import com.getnovel.novel.pojo.Novel;
import com.getnovel.novel.serviceImpl.NovelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * *
 */
@RestController
public class NovelController {
    @Autowired
    private NovelServiceImpl novelService;

    /**
     * 添加小说
     * @param novel
     */
    @PostMapping ("/novel")//添加 @RequestMapping(method = RequestMethod.POST)缩写为@PostMapping。
    public void add(Novel novel){
        novelService.add(novel);

    }
    /**
     * 查询所有小说
     *   @GetMapping("/novel/{{currPage}/{pageSize}") 分页
     */
     @GetMapping("/novels")
     public List<Novel> getHotNovels(){
         return novelService.getHotNovels(1 ,50);
     }

     /**
      * 搜索输入建议
      */
     @GetMapping("/novels/suggestions")
     public List<Map<String,Object>> getSearchSuggestions(){
         return novelService.getSearchSuggestions();
     }
    /**
     * 按类型查询
     * @param novelType
     * @return
     */
    @RequestMapping(value = "/novel/{type}", method = RequestMethod.GET)
    public List<Novel> getNovelsByType(@PathVariable(value = "type",required = true) String novelType){
        System.out.println(novelType);
        List<Novel> list = novelService.getNovelsByType(novelType);
        if(list!=null && !list.isEmpty()){
            return list;
        } else {
            return null;
        }
    }

//    @RequestMapping(value = "/novel/{id}",method = RequestMethod.GET)//按ID查询
//    public List<Novel> getNovelsById(@PathVariable("id") Integer novelId){
//        return novelService.getNovelsById(novelId);
//    }
}

package com.getnovel.novel.dao;

import com.getnovel.novel.pojo.Novel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NovelDao {
    public void add(Novel novel);
   // public void  add(@Param("list") List<Novel> list);
    public List<Novel> queryNovelsBySql(Map data);
    public List<Map<String,Object>> getSearchSuggestions();
    public List<Novel> getNovelsByType(String novelType);
    public Novel getNovelById(Integer novelId);
}

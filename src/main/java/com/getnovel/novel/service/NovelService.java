package com.getnovel.novel.service;

import com.getnovel.novel.pojo.Novel;

import java.util.List;
import java.util.Map;

public interface NovelService {
    public void add(Novel novel);
    public List<Map<String,Object>> getSearchSuggestions();
    public List<Novel> getHotNovels(int currPage, int pageSize);
    public List<Novel> getNovelsByType(String novelType);
    public  Novel getNovelById(Integer novelId);
}


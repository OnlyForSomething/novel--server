package com.getnovel.novel.serviceImpl;

import com.getnovel.novel.dao.NovelDao;
import com.getnovel.novel.pojo.Novel;
import com.getnovel.novel.service.NovelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("NovelService")
public class NovelServiceImpl implements NovelService {

    @Autowired
    private NovelDao dao;
    @Override
    public void add(Novel novel) {
        dao.add(novel);

    }

    @Override
    public List<Map<String,Object>> getSearchSuggestions() {
        return dao.getSearchSuggestions();
    }

    @Override
    public List<Novel> getHotNovels(int currPage, int pageSize) {
        Map<String,Object> data =new HashMap<>();
        data.put("currIndex",(currPage-1)*pageSize); // 开始的index
        data.put("pageSize", pageSize); // 每页的数量
        return dao.queryNovelsBySql(data);
    }

    @Override
    public List<Novel> getNovelsByType(String novelType) {
        return dao.getNovelsByType(novelType);
    }

    @Override
    public Novel getNovelById(Integer novelId) {
        return dao.getNovelById(novelId);
    }

}

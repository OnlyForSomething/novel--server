package com.getnovel.novel.dao;



import com.getnovel.novel.pojo.NovelType;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NovelTypeDao {
    public List<NovelType> getNovelType();
}

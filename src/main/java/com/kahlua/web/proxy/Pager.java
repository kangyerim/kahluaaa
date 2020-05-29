package com.kahlua.web.proxy;

import com.kahlua.web.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pager {
    @Autowired MovieMapper movieMapper;
    private int rowCount, rowStart, rowEnd,
            pageCount, pageSize, pageStart, pageEnd, pageNow,
            blockCount, blockSize, preBlock, nextBlock, nowBlock;
    private boolean existPre, existNext;
    private String search;

    public void paging(){
       rowCount = movieMapper.count();
       pageSize = 5;
       pageCount = (rowCount%pageSize == 0) ? rowCount/pageSize : (rowCount/pageSize)+1;
       blockSize = 5;
       blockCount = (pageCount%blockSize == 0) ? pageCount/blockSize : (pageCount/blockSize)+1;
       pageNow = 1;
       rowStart = ((pageCount-1) * pageSize) + 1;
       rowEnd = (pageNow == pageEnd) ? rowCount : pageSize*pageNow ;
       nowBlock = (pageNow % blockSize != 0) ? pageNow / blockSize+1 : pageNow / blockSize;
       pageStart = ((nowBlock-1) * blockSize) + 1;
       pageEnd = (nowBlock == blockCount) ? pageCount : pageStart + nowBlock ;
       preBlock = pageStart - blockSize;
       nextBlock = pageStart - blockSize;
       existPre = (nowBlock != 1);
       existNext = (nowBlock != blockCount);
    }
}

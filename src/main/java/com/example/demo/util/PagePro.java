package com.example.demo.util;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Mr.ma.com
 * @explain
 * @date 2021/6/21 11:44
 */
@Data
public class PagePro implements Serializable {

    private Integer pageNum;
    private Integer pageSize;
    private String name; // 名称(用于模糊查询)
    private String stype; //类型 （1 获取推荐  2 获取ai识图 3 微信文章）
    private String isAudit;
    private String isRelease;//是否发布 1:未发布 2:已发布
    private Integer start;
    private Integer id;
    private String courseType;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagePro pagePro = (PagePro) o;
        return pageNum.equals(pagePro.pageNum) && pageSize.equals(pagePro.pageSize) && Objects.equals(stype, pagePro.stype)
                && Objects.equals(name, pagePro.name)&&Objects.equals(isAudit, pagePro.isAudit)&&Objects.equals(isRelease, pagePro.isRelease)&&Objects.equals(id, pagePro.id) &&Objects.equals(courseType, pagePro.courseType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNum, pageSize, stype,name,isAudit,isRelease,id,courseType);
    }
}

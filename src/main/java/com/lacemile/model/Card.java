package com.lacemile.model;

/**
 * Created by yuume on 16/12/20.
 */

import javax.persistence.*;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.validation.constraints.Size;

@Entity
@Table(name="card")
//只有一个图片与超链的卡片 自定义标签 实现类
public class Card extends SimpleTagSupport
{
    //标签的属性
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max=200)
    @Column(name = "urlImage", nullable = false)
    private String urlImage;

    //标签属性id的setter、getter方法
    public void setId(int id) { this.id = id; }
    public int getId() { return (this.id); }

    //标签属性urlImage的setter、getter方法
    public void setUrlImage(String urlImage) { this.urlImage = urlImage; }
    public String getUrlImage() { return (this.urlImage); }

    @Override
    public String toString() {
        return "Card [id=" + id + ", urlImage=" + urlImage + "]";
    }
}
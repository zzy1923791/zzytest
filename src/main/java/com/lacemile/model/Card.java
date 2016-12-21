package com.lacemile.model;

/**
 * Created by yuume on 16/12/20.
 */

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.Writer;

@Entity
@Table(name="card")
//只有一个图片与超链的卡片 自定义标签 实现类
public class Card extends SimpleTagSupport
{
    //标签的属性
    private int id;
    private String urlImage;

    //标签属性id的setter、getter方法
    public void setId(int Id) { this.id = Id; }
    public int getId() { return (this.id); }

    //标签属性urlImage的setter、getter方法
    public void setUrlImage(String urlImage) { this.urlImage = urlImage; }
    public String getUrlImage() { return (this.urlImage); }

    public void doTag()throws JspException, IOException {

        Writer out = getJspContext().getOut();

        out.write("<div class=\"card\">");
        out.write("<div class=\"card_content\">");
        out.write("<a href=\"/list\">");
        out.write("<img width=100% src=" + this.urlImage +">");
        out.write("</a>");
        out.write("</div>");
        out.write("<div class=\"card_space\"></div>");
        out.write("</div>");

    }
}
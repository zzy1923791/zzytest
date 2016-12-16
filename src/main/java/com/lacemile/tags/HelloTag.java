package com.lacemile.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class HelloTag extends SimpleTagSupport {

//    自定义静态标签
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("Hello Custom Tag!");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>NAME</td><td>Joining Date</td><td>Salary</td><td>SSN</td><td></td>");
        out.println("</tr>");
        out.println("</table>");
    }
}



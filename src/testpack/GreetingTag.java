package testpack;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class GreetingTag extends SimpleTagSupport {

	private String colour = "black";
	private String size = "12px";
	private String fontstyle = "italic";


	
	
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		JspWriter out = getJspContext().getOut();
		out.println("<h1 style=\"color:" + colour + "; font-size: " + size + "; font-style:"+fontstyle+";\">");
		getJspBody().invoke(null);
		out.println("</h1>");
	}

	public void setColour(String color) {
		this.colour = color;
	}

	public void setSize(String size) {
		this.size = size;
	}

}

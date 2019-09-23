package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("   <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Clueweb Search Interface</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"displayres.css\" />\n");
      out.write("        <script src=\"jquery/spin.js\"></script>\n");
      out.write("        <script>\n");
      out.write("        var opts = {\n");
      out.write("          lines: 13 // The number of lines to draw\n");
      out.write("        , length: 28 // The length of each line\n");
      out.write("        , width: 14 // The line thickness\n");
      out.write("        , radius: 42 // The radius of the inner circle\n");
      out.write("        , scale: 1 // Scales overall size of the spinner\n");
      out.write("        , corners: 1 // Corner roundness (0..1)\n");
      out.write("        , color: '#000' // #rgb or #rrggbb or array of colors\n");
      out.write("        , opacity: 0.25 // Opacity of the lines\n");
      out.write("        , rotate: 0 // The rotation offset\n");
      out.write("        , direction: 1 // 1: clockwise, -1: counterclockwise\n");
      out.write("        , speed: 1 // Rounds per second\n");
      out.write("        , trail: 60 // Afterglow percentage\n");
      out.write("        , fps: 20 // Frames per second when using setTimeout() as a fallback for CSS\n");
      out.write("        , zIndex: 2e9 // The z-index (defaults to 2000000000)\n");
      out.write("        , className: 'spinner' // The CSS class to assign to the spinner\n");
      out.write("        , top: '50%' // Top position relative to parent\n");
      out.write("        , left: '50%' // Left position relative to parent\n");
      out.write("        , shadow: false // Whether to render a shadow\n");
      out.write("        , hwaccel: false // Whether to use hardware acceleration\n");
      out.write("        , position: 'absolute' // Element positioning\n");
      out.write("        };\n");
      out.write("        var spinner;\n");
      out.write("        \n");
      out.write("        function isNumeric(n) {\n");
      out.write("            return !isNaN(parseFloat(n)) && isFinite(n);\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function retrieveAdhoc() {\n");
      out.write("            var qtext = document.getElementById(\"query\").value;\n");
      out.write("            if (qtext.length == 0) {\n");
      out.write("                document.getElementById(\"query\").focus();\n");
      out.write("                return;\n");
      out.write("            }\n");
      out.write("                \n");
      out.write("           // var simf = document.getElementById(\"simf\").value;\n");
      out.write("           // var nwanted = document.getElementById(\"numwanted\").value;\n");
      out.write("            \n");
      out.write("            var xmlhttp;\n");
      out.write("            if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari\n");
      out.write("                xmlhttp=new XMLHttpRequest();\n");
      out.write("            }\n");
      out.write("            else {// code for IE6, IE5\n");
      out.write("                xmlhttp=new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("            }\n");
      out.write("            xmlhttp.onreadystatechange = function() {\n");
      out.write("                spinner.stop();\n");
      out.write("                if (xmlhttp.readyState==4 && xmlhttp.status==200) {\n");
      out.write("                    document.getElementById(\"srchres\").innerHTML = xmlhttp.responseText;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            var k = 1;\n");
      out.write("            var b = 1;\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("            var req = \"SearchServlet?query=\" + qtext ;\n");
      out.write("            \n");
      out.write("            xmlhttp.open(\"GET\", req, true);\n");
      out.write("            xmlhttp.send();\n");
      out.write("            var target = document.getElementById('containerdiv');\n");
      out.write("            spinner = new Spinner(opts).spin(target);\n");
      out.write("            target.appendChild(spinner.el);\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("       \n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("    <div id=\"containerdiv\">        \n");
      out.write("        <img src=\"images/adapt_logo.png\" alt=\"ADAPT Centre, DCU\"\n");
      out.write("             border=\"0\" style=\"max-width: 400px; max-height:100px;\">\n");
      out.write("        <br>\n");
      out.write("        <div>\n");
      out.write("            <input type=\"text\" id=\"query\" name=\"query\" size=\"50\">\n");
      out.write("            <input type=\"button\" value=\"Search\" onclick=\"retrieveAdhoc()\"/>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    </center>\n");
      out.write("    <div id=\"srchres\" name=\"srchres\"></div>         \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

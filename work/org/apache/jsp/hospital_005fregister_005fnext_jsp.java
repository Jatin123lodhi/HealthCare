/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.1
 * Generated at: 2021-07-21 06:51:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Hospital;
import models.Patient;
import models.Doctor;
import java.util.ArrayList;
import models.City;

public final class hospital_005fregister_005fnext_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1622022121355L));
    _jspx_dependants.put("/head.jsp", Long.valueOf(1623656425017L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1626845841126L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("models.Patient");
    _jspx_imports_classes.add("models.Doctor");
    _jspx_imports_classes.add("models.Hospital");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("models.City");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write(" \t");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"icon\" href=\"static/images/favicon.ico\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/common.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/font-awesome.css\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js\" integrity=\"sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\t.dropdown-toggle::after{\r\n");
      out.write("\t\tcontent:none;\r\n");
      out.write("\t}\r\n");
      out.write("</style>");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/hospital_signup.css\">\r\n");
      out.write("     \r\n");
      out.write("    <script src=\"https://www.google.com/recaptcha/api.js\" async defer></script>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"header\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container-fluid  \">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-4 \">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-4  \">\r\n");
      out.write("                    \t<a href=\"index.jsp\" style=\"text-decoration:none\"><img src=\"static/images/logo.jpg\" alt=\"\" class=\"img-fluid\" style=\"height:100px;\"></a>\r\n");
      out.write("                    \t\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-8   pt-3 pb-1\">\r\n");
      out.write("                       <a href=\"index.jsp\" style=\"text-decoration:none\"> <h2 class=\"text-success py-1 font-weight-bold\">Health Care</h2></a>\r\n");
      out.write("                        <p class=\"text-primary text-info\">We take care of your health.</p>\r\n");
      out.write("                        \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-4  px-5 pt-2  \">\r\n");
      out.write("                <button class=\"btn btn-outline-info\">Hospitals</button>\r\n");
      out.write("                <a href=\"doctor.do\" class=\"btn btn-outline-info\">Doctors</a>\r\n");
      out.write("                <button class=\"btn btn-outline-info\">Medicines</button>\r\n");
      out.write("\r\n");
      out.write("                <form action=\"\" class=\"form-inline pt-3 \">\r\n");
      out.write("                    <input type=\"search\" class=\"form-control\" name=\"search\" id=\"id_search\">\r\n");
      out.write("                    <input type=\"submit\" value=\"Search\" name=\"srch_btn\" id=\"id_srch_btn\" class=\"btn btn-info ml-1\">\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-4  pt-2 \">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col mt-2 text-right\">\r\n");
      out.write("                        \r\n");
      out.write("                        <a href=\"index.jsp\"><i class=\"fa fa-home mr-3 fa-lg \" style=\"cursor: pointer;color:info\"></i></a>\r\n");
      out.write("                        <div class=\"dropdown pr-3\"  style=\"display:inline\">\r\n");
      out.write("                        \t<a href=\"#\" class=\"dropdown-toggle mr-3\" id=\"dropdownMenuLink\" data-toggle=\"dropdown\"><i class=\"fa fa-sliders fa-lg\"></i></a>\r\n");
      out.write("                        \t");
 Hospital hospital = (Hospital)session.getAttribute("hospital");  
      out.write("                      \t \r\n");
      out.write("                        \t");
 Patient patient = (Patient)session.getAttribute("patient");  
      out.write("                      \t \r\n");
      out.write("                        \t");
 Doctor doctor = (Doctor)session.getAttribute("doctor");  
      out.write("                      \t \r\n");
      out.write("                        \t                      \t \r\n");
      out.write("                       \t\r\n");
      out.write("                    \r\n");
      out.write("                        \t<div class=\"dropdown-menu border border-primary ml-n5 pr-0 mt-2\" style=\"min-width:20px;\"  aria-labelledby=\"dropdownMenuLink\">\r\n");
      out.write("                        \t\t");
 if(hospital==null && patient==null && doctor==null ){ 
      out.write("\r\n");
      out.write("\t                        \t\t<a href=\"login_opt.jsp\" class=\"dropdown-item text-info \"><i class=\"fa fa-sign-in  \"></i> Login</a>\r\n");
      out.write("\t                        \t\t<a href=\"register_opt.jsp\" class=\"dropdown-item text-info \"><i class=\"fa fa-user-plus  \"></i> Register</a>\r\n");
      out.write("\t                     \t   \t");
}else{ 
      out.write("\r\n");
      out.write("\t                     \t   \t\t\r\n");
      out.write("\t                     \t   \t\t<a href=\"logout.do\" class=\"dropdown-item text-info\"><i class=\"fa fa-sign-out  \"></i> Logout</a> \r\n");
      out.write("\t                     \t   \t\t<a href=\"hospital_profile.do\" class=\"dropdown-item text-info \"><i class=\"fa fa-user  \"></i> Profile</a> \r\n");
      out.write("\t                     \t   \t");
} 
      out.write("\r\n");
      out.write("\t\t                                         \r\n");
      out.write("\t\t                        \r\n");
      out.write("                        \t</div>\r\n");
      out.write("                        \t<span class=\"ml-3\"></span>\r\n");
      out.write("                        \t\r\n");
      out.write("                        </div>\r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                     \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-6 ml-auto\" >\r\n");
      out.write("                        ");
 ArrayList<City> cities = City.getAllCities(); 
      out.write("\r\n");
      out.write("                        <div class=\"form-group pt-4  city-select  \">\r\n");
      out.write("                            <select name=\"\" id=\"\" class=\"form-control\">\r\n");
      out.write("                                <option>Select city</option>                      \t\t\t                      \t\t\t\r\n");
      out.write("                       \t\t\t");
 for(City city:cities){ 
      out.write("\r\n");
      out.write("                       \t\t\t\t");
if(hospital!=null && city.getCityId()==hospital.getCity().getCityId()){ 
      out.write("\r\n");
      out.write("                       \t\t\t\t<option value=\"");
      out.print(city.getCityId() );
      out.write("\" selected> ");
      out.print( city.getCity()+" ("+city.getState().getState()+")"  );
      out.write(" </option>\t\r\n");
      out.write("                       \t\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("                       \t\t\t\t<option value=\"");
      out.print(city.getCityId() );
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print( city.getCity()+" ("+city.getState().getState()+")"  );
      out.write(" </option>\r\n");
      out.write("                       \t\t\t\t");
 }
      out.write("\r\n");
      out.write("                       \t\t\t");
} 
      out.write("\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <span class=\"text-primary text-center ml-3\">Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${hospital.getName()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${patient.getName()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${doctor.getName()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" </span>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("    <div class=\"navigate border border-info mb-3\" style=\"background-color:#131324\">\r\n");
      out.write("        <div class=\"container  \">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("               <div class=\"col py-2  \">\r\n");
      out.write("               \t   <a href=\"index.jsp\">Home </a> <span class=\"text-white\">></span>\r\n");
      out.write("                   <a href=\"register_opt.jsp\">Registration Options  </a> <span class=\"text-white\">></span>\r\n");
      out.write("                   <a href=\"#\">Hospital Registration  </a> <span class=\"text-white\">></span>\r\n");
      out.write("                   \r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("     </div>\r\n");
      out.write("     \r\n");
      out.write("\r\n");
      out.write("    <div class=\"main_body\">\r\n");
      out.write("       \r\n");
      out.write("        <div class=\"container  \" style=\"min-height: 500px;\">\r\n");
      out.write("            <div class=\"row pt-4 \">\r\n");
      out.write("                <div class=\"col-6 pt-5 text-center\"  >\r\n");
      out.write("                     \r\n");
      out.write("                    <img src=\"static/images/hospitallogo.png\" alt=\"\" style=\"width: 50%;\" class=\" pt-5 \">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-6  pt-5 pl-5 \">\r\n");
      out.write("                  \r\n");
      out.write("                  <h3>Registered Successfully</h3>\r\n");
      out.write("     \t\t\t\t<h5 class=\"mt-3 mb-5\">Activate the account using the activation link sent to your mail</h5>\r\n");
      out.write("\t\t\t\t\t<h6 class=\"mt-3 text-muted p-2\">Mail not received ? Register again using the <a href=\"hospital_register.jsp\">link.</a></h6>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("<div class=\"footer text-center pt-5\">\r\n");
      out.write("    <p >Copyright © 2000-2021 HealthCare.com. All rights reserved</p>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("    <!-- <script type=\"text/javascript\" src=\"static/js/hospital_register.js\"></script> -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

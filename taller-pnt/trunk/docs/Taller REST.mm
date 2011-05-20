<map version="0.9.0">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1305639049794" ID="ID_1805969397" MODIFIED="1305895340377" STYLE="fork">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      REST :&#160;&#160;<br /><br />Rest (Transferencia de Estado Representacional) es una t&#233;cnica de arquitectura de desarrollo de software, que utiliza una interfase est&#225;ndar (HTTP <font face="SansSerif" size="2">GET, POST, PUT, DELETE</font>), define recursos que son los elementos de informaci&#243;n de inter&#233;s en una aplicaci&#243;n, define identificadores globales (URLs) que son mediante los cuales se accede a estos recursos y define las representaci&#243;n de los recursos que suele ser en formatos Html, xml o json.&#160;&#160;&#160;<br /><br />Ejemplo: La empresa Ford puede definir un recurso &#8220;focus&#8221; al cual se podr&#237;a acceder mediante la siguiente URL:&#160;&#160;<br /><br />http://www.ford.com/focus&#160;&#160;<br /><br />La representaci&#243;n de este recurso puede se la pagina FordFocus.html, esta representaci&#243;n pone al cliente en un estado, en el caso de que se acceda a otro vinculo (URL) en la pagina FordFocus.html esto transferir&#225; al cliente a otra representaci&#243;n con otro estado.&#160;&#160;La &#8220;Transferencia de Estado Representacional&#8221; se da a medida que el cliente navega por los distintos v&#237;nculos de la aplicaci&#243;n.
    </p>
    <p>
      
    </p>
    <p>
      Ejemplos:
    </p>
    <p>
      
    </p>
    <p>
      Borrar el id 1 de focus con la operaci&#243;n HTTP DELETE
    </p>
    <p>
      http://www.ford.com/focus/1/borrar
    </p>
    <p>
      
    </p>
    <p>
      Obtener el recurso con id 1 de focus con la operaci&#243;n HTTP GET
    </p>
    <p>
      http://www.ford.com/focus/1
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      <br />
      
    </p>
    <p>
      <br />
    </p>
  </body>
</html>
</richcontent>
<node CREATED="1305639382276" HGAP="48" ID="ID_758198660" MODIFIED="1305722813706" POSITION="right" VSHIFT="-62">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      @Controller:&#160;<br />Anotaci&#243;n de Spring MVC que indica que la clase actuara como un controlador.
    </p>
    <p>
      
    </p>
    <p>
      <br />
    </p>
  </body>
</html></richcontent>
<node CREATED="1305721782353" HGAP="19" ID="ID_908163541" MODIFIED="1305722818706" VSHIFT="24">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Configuraci&#243;n para activar anotaciones de Spring MVC, en archivo xml de Spring.
    </p>
    <p>
      
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1305639786430" HGAP="58" ID="ID_968804180" MODIFIED="1305722755050" POSITION="right" VSHIFT="-91">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      @RequestMapping:&#160;<br />Anotaci&#243;n de Spring MVC que indica las URLs a publicar.
    </p>
    <p>
      
    </p>
    <p>
      <br />
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1305893743294" HGAP="57" ID="ID_461726918" MODIFIED="1305893837496" POSITION="right" VSHIFT="-56">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      @ResponseBody:&#160;
    </p>
    <p>
      Anotaci&#243;n de Spring MVC que indica el mapeio de la respuesta del metodo con el body HTTP.
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
<node CREATED="1305639805477" HGAP="51" ID="ID_1957574074" MODIFIED="1305722760206" POSITION="right" VSHIFT="-23">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      @RequestBody:&#160;<br />Anotaci&#243;n de Spring MVC que indica el mapeo del body HTTP a un objeto en particular.
    </p>
    <p>
      
    </p>
    <p>
      <br />
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1305639821695" HGAP="59" ID="ID_710194121" MODIFIED="1305722763753" POSITION="right" VSHIFT="52">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      @PathVariable:&#160;<br />Anotaci&#243;n de Spring MVC que indica el mapeo del parametro en la URL con el parametro del metodo.
    </p>
    <p>
      
    </p>
    <p>
      <br />
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1305639834430" HGAP="63" ID="ID_1138304788" MODIFIED="1305890784250" POSITION="right" VSHIFT="56">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      @ExceptionHandler: <o p="#DEFAULT"></o>(ConstraintViolationException)
    </p>
    <p>
      Anotaci&#243;n de Spring MVC que permite manejar excepciones lanzadas en el controlador. <o p="#DEFAULT"></o>
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
<node CREATED="1305722185726" HGAP="19" ID="ID_44106279" MODIFIED="1305722875549" VSHIFT="24">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Configuraci&#243;n del conversor JSON para el response de los handler de excepciones, en archivo xml de Spring.
    </p>
    <p>
      
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1305639850445" HGAP="65" ID="ID_1148770237" MODIFIED="1305722773847" POSITION="right" VSHIFT="31">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      @ResponseStatus:&#160;<br />Anotaci&#243;n de Spring MVC que indica httpstatus de la respuesta.
    </p>
    <p>
      
    </p>
    <p>
      <br />
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1305639860242" HGAP="44" ID="ID_998235748" MODIFIED="1305722777316" POSITION="right" VSHIFT="99">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      RestTemplate:&#160;<br />Clase de Spring Web que se utiliza para crear clientes de los servicios REST.
    </p>
    <p>
      
    </p>
    <p>
      <br />
    </p>
  </body>
</html></richcontent>
</node>
</node>
</map>

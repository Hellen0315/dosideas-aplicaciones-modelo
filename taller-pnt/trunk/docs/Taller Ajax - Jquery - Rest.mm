<map version="0.9.0">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1306927999373" ID="ID_1593942453" MODIFIED="1306937819642">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      <b>Taller Ajax - Jquery - Rest:</b>
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
<font NAME="SansSerif" SIZE="12"/>
<node CREATED="1306928018639" HGAP="34" ID="ID_1841453836" MODIFIED="1306937473988" POSITION="right" VSHIFT="-107">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Ajax, acr&#243;nimo de Asynchronous JavaScript And XML (JavaScript as&#237;ncrono y XML), es una t&#233;cnica de desarrollo web para crear aplicaciones interactivas o RIA (Rich Internet Applications). Estas aplicaciones se ejecutan en el cliente, es decir, en el navegador de los usuarios mientras se mantiene la comunicaci&#243;n as&#237;ncrona con el servidor en segundo plano. De esta forma es posible realizar cambios sobre las p&#225;ginas sin necesidad de recargarlas, lo que significa aumentar la interactividad, velocidad y usabilidad en las aplicaciones.&#160;&#160;
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
  </body>
</html>
</richcontent>
<font NAME="SansSerif" SIZE="12"/>
</node>
<node CREATED="1306928117406" HGAP="27" ID="ID_1610391225" MODIFIED="1306937502379" POSITION="right" VSHIFT="-29">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      jQuery consiste en un &#250;nico fichero JavaScript que contiene las funcionalidades comunes al DOM, eventos, efectos y AJAX.&#160;&#160;&#160;La caracter&#237;stica principal de la biblioteca es que permite cambiar el contenido de una p&#225;gina web sin necesidad de recargarla, mediante la manipulaci&#243;n del &#225;rbol DOM y peticiones AJAX. Para ello utiliza las funciones $() o jQuery().&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      Funci&#243;n $()&#160;&#160;La forma de interactuar con la p&#225;gina es mediante la funci&#243;n $(), un alias de jQuery(), que recibe como par&#225;metro una expresi&#243;n CSS o el nombre de una etiqueta HTML y devuelve todos los nodos (elementos) que concuerden con la expresi&#243;n.&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      Jquery Template&#160;&#160;Permite crear elementos Html de forma din&#225;mica mediante una estructura de datos.&#160;&#160;&#160;
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
  </body>
</html>
</richcontent>
<font NAME="SansSerif" SIZE="12"/>
</node>
<node CREATED="1306928858778" HGAP="27" ID="ID_8910292" MODIFIED="1306937668503" POSITION="right">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      <b>Archivo alumnoService.js</b>
    </p>
    <p>
      .
    </p>
    <p>
      Definici&#243;n de postJson
    </p>
    <p>
      .
    </p>
    <p>
      Definici&#243;n de borrar
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
  </body>
</html>
</richcontent>
<font NAME="SansSerif" SIZE="12"/>
</node>
<node CREATED="1306928249812" ID="ID_1833625475" MODIFIED="1306937699956" POSITION="right">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      <b>GET&#160;&#160;(Buscar Todos )</b>
    </p>
    <p>
      .
    </p>
    <p>
      <b>Contenedor :</b>
    </p>
    <p>
      .
    </p>
    <div class="Section1">
      <p class="MsoNormal">
        <font face="Times New Roman">&lt;div id=&quot;listaAlumnos&quot; class=&quot;listaAlumnosClass&quot;&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&lt;/div&gt;<o p="#DEFAULT"></o></font>
      </p>
    </div>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      <b>Template :</b>
    </p>
    <p>
      .
    </p>
    <div class="Section1">
      <p class="MsoNormal">
        <font face="Times New Roman">&lt;script id=&quot;alumnoTemplate&quot; type=&quot;text/x-jquery-tmpl&quot;&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman"><o p="#DEFAULT">
        &#160;</o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160; </font><font size="3" face="Times New Roman">&lt;div class=&quot;alumno&quot;&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;div class=&quot;header&quot;&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;h1&gt;${apellido}, ${nombre}&lt;/h1&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;small&gt;${email}&lt;/small&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;/div&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;div class=&quot;content&quot;&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;h2&gt;Cursos&lt;/h2&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;ol&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{{each cursos}}<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;li&gt;&lt;em&gt;${$value.titulo}.&lt;/em&gt;&lt;/li&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{{/each}}<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;/ol&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;/div&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;div class=&quot;footer&quot;&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;a class=&quot;borrar&quot; onclick=&quot;borrarAlumno(${id})&quot; href=&quot;#&quot;&gt;borrar&lt;/a&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;/div&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&#160;&#160;&#160;&#160;&lt;/div&gt;<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Times New Roman">&lt;/script&gt;<o p="#DEFAULT"></o></font>
      </p>
    </div>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      <b>redy :</b>
    </p>
    <p>
      .
    </p>
    <div class="Section1">
      <p class="MsoNormal">
        <font face="Arial">$(document).ready(function() {&#160;&#160;&#160;&#160;&#160;&#160;&#160; <o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Arial">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;alumnoService_buscarTodos(dibujarAlumnos); <o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Arial">&#160;&#160;&#160;&#160;});<o p="#DEFAULT"></o></font>
      </p>
    </div>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      <b>Callback:</b>
    </p>
    <p>
      .
    </p>
    <div class="Section1">
      <p class="MsoNormal">
        <font face="Arial">function dibujarAlumnos(data) {<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Arial">&#160;&#160;&#160;&#160;&#160;&#160;&#160; <o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Arial">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;$(&quot;#listaAlumnos&quot;).empty(); </font><font face="Wingdings">&#232;</font><font face="Arial">&#160; Limpia<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Arial">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;$( &quot;#listaAlumnos&quot; ).sortable({revert: true}); </font><font face="Wingdings">&#232;</font><font face="Arial">&#160; Drag<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Arial">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;$(&quot;#contactTemplate&quot; ).tmpl(data).appendTo(&quot;#listaAlumnos&quot;); </font><font face="Wingdings">&#232;</font><font face="Arial">&#160; Utiliza el template<o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Arial">&#160;&#160;&#160;&#160;&#160;&#160;&#160; <o p="#DEFAULT"></o></font>
      </p>
      <p class="MsoNormal">
        <font face="Arial">&#160;&#160;&#160;&#160;}<o p="#DEFAULT"></o></font>
      </p>
    </div>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
  </body>
</html>
</richcontent>
<font NAME="SansSerif" SIZE="12"/>
</node>
<node CREATED="1306928415031" ID="ID_936576492" MODIFIED="1306937705940" POSITION="right">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      <b>DELETE :</b>
    </p>
    <p>
      .
    </p>
    <p>
      function borrarAlumno(id) {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;alumnoService_borrar(id,onSuccessDelete);
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
  </body>
</html>
</richcontent>
<font NAME="SansSerif" SIZE="12"/>
</node>
<node CREATED="1306928457421" ID="ID_1886657685" MODIFIED="1306937764455" POSITION="right">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <p>
      <b>POST :</b>
    </p>
    <p>
      .
    </p>
    <p>
      <b>Formulario:</b>
    </p>
    <p>
      .
    </p>
    <p>
      &lt;form id=&quot;save&quot;&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&lt;div class=&quot;alta&quot;&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;fieldset&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;div class=&quot;header_alta&quot;&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;h1&gt;Formulario de Alta&lt;/h1&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;/div&gt;
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;label&gt; Nombre : &lt;/label&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;input type=&quot;text&quot; name=&quot;nombre&quot; /&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;label&gt; Apellido : &lt;/label&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;input type=&quot;text&quot; name=&quot;apellido&quot;&#160;&#160;/&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;label&gt; Email : &lt;/label&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;input type=&quot;text&quot; name=&quot;email&quot;&#160;&#160;/&gt;
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;/fieldset&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;input type=&quot;submit&quot; value=&quot;Guardar Alumno&quot; id=&quot;save&quot;/&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&lt;input type=&quot;reset&quot; value=&quot;Cancelar&quot; id=&quot;saveCancel&quot; /&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&lt;/div&gt;
    </p>
    <p>
      &lt;/form&gt;
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      <b>Redy :</b>
    </p>
    <p>
      .
    </p>
    <p>
      <b>Error (Falta convertir el formulario en Json)</b>
    </p>
    <p>
      .
    </p>
    <p>
      $(document).ready(function() {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;$(&quot;#save&quot;).submit(function(){
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;guardar($('#save'));
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;return false;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;});
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;});
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      <b>Definimos un plugin de Jquery para convertir el formulario a Json : (Se define en el objeto fn para utilizarla con los selectores) </b>
    </p>
    <p>
      <b>.</b>
    </p>
    <p>
      $.fn.serializeObject = function()
    </p>
    <p>
      &#160;&#160;&#160;&#160;{
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;var o = {};
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;var a = this.serializeArray();
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;$.each(a, function() {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if (o[this.name] !== undefined) {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if (!o[this.name].push) {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;o[this.name] = [o[this.name]];
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;o[this.name].push(this.value || '');
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;} else {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;o[this.name] = this.value || '';
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;});
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;return o;
    </p>
    <p>
      &#160;&#160;&#160;&#160;};
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      <b>Ok (Pasamos el objeto json)</b>
    </p>
    <p>
      .
    </p>
    <p>
      $(document).ready(function() {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;$(&quot;#save&quot;).submit(function(){
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;guardar($('#save').serializeObject());
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;return false;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;});
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;});
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      <b>Guardar :</b>
    </p>
    <p>
      .
    </p>
    <p>
      function guardar(data) {&#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;alumnoService_guardar(data, onSuccessSave,onCompleteSave,onErrorSave);
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      <b>Callbacks:</b>
    </p>
    <p>
      .
    </p>
    <p>
      function onSuccessSave(data) {&#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;$().toastmessage('showSuccessToast', 'Alta realizada con id:'+data.id);
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      .
    </p>
    <p>
      function onErrorSave(data) {&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;$().toastmessage('showToast', {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;text&#160;&#160;&#160;&#160;&#160;: 'Error realizando alta de alumno: '+data.responseText,
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;sticky&#160;&#160;&#160;: true,
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;type&#160;&#160;&#160;&#160;&#160;: 'error'
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;});
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      .
    </p>
    <p>
      function onCompleteSave() {&#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;$('#saveCancel').click();
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
    <p>
      .
    </p>
  </body>
</html>
</richcontent>
<font NAME="SansSerif" SIZE="12"/>
</node>
</node>
</map>

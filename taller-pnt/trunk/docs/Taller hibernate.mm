<map version="0.9.0">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1302521445504" ID="ID_1612780683" MODIFIED="1302609470505" TEXT="Taller hibernate">
<font NAME="SansSerif" SIZE="12"/>
<node COLOR="#000000" CREATED="1302521564130" HGAP="177" ID="ID_1677930547" MODIFIED="1302618469066" POSITION="right" STYLE="fork" TEXT="Validaciones : Para estas validaciones, Hibernate implementa un listener &#x201c;BeanValidationEventListener&#x201d;, cada vez que un PreInsertEvent, PreUpdateEvent o PreDeleteEvent se produce, el listener verifica las validaciones y si alg&#xfa;na no se cumple se tira la exception &#x201c;ConstraintViolationException&#x201d;. Por defecto el listener controla los insert y los updates, en caso de querer controlar los deletes esto es posible mediante configuraci&#xf3;n en el archivo de hibernate." VSHIFT="60">
<edge COLOR="#808080" STYLE="bezier" WIDTH="thin"/>
<font NAME="SansSerif" SIZE="12"/>
<node CREATED="1302521595614" HGAP="178" ID="ID_615895605" MODIFIED="1302618308252" TEXT="@Email : Valida que el atributo sea un email valido." VSHIFT="-13"/>
<node CREATED="1302521630287" HGAP="182" ID="ID_295419626" MODIFIED="1302618303611" TEXT="@NotEmpty: Valida que el atributo no este vacio." VSHIFT="23"/>
<node CREATED="1302521860944" HGAP="29" ID="ID_1074813855" MODIFIED="1302618283908" TEXT="Algunas validaciones :" VSHIFT="30">
<node CREATED="1302522627480" ID="ID_1657723148" MODIFIED="1302522657949" TEXT="@Pattern : Eval&#xfa;a expresiones regulares."/>
<node CREATED="1302522658324" ID="ID_1877182180" MODIFIED="1302522663699" TEXT="@NotNull"/>
<node CREATED="1302522664309" ID="ID_18869968" MODIFIED="1302522726950" TEXT="@Min: Tama&#xf1;o minimo de un String."/>
<node CREATED="1302522728200" ID="ID_1206020058" MODIFIED="1302522845841" TEXT="@AssertTrue y @AssertFalse"/>
<node CREATED="1302522846435" ID="ID_1158391967" MODIFIED="1302522990108" TEXT="@Range(min=, max=)"/>
<node CREATED="1302522977280" ID="ID_815258519" MODIFIED="1302522981405" TEXT="@URL(protocol=, host=, port=)"/>
<node CREATED="1302523015920" ID="ID_544452741" MODIFIED="1302523028467" TEXT="@Future y @Past : Para fechas"/>
</node>
</node>
<node CREATED="1302521583333" HGAP="25" ID="ID_759201412" MODIFIED="1302609470505" POSITION="right" TEXT="Relaciones" VSHIFT="50">
<font NAME="SansSerif" SIZE="12"/>
<node CREATED="1302521642427" HGAP="151" ID="ID_856247818" MODIFIED="1302618457878" TEXT="@ManyToMany : Esta anotaci&#xf3;n indica una relaci&#xf3;n muchos a muchos, en objetos esta relaci&#xf3;n se puede realizar simplemente con dos entidades mientras que en la base se necesita una tercera que contenga las relaciones de las pks de las dos tablas relacionadas." VSHIFT="240">
<node CREATED="1302522066117" HGAP="44" ID="ID_1768468598" MODIFIED="1302525228513" TEXT="@JoinTable : Tabla que tiene las relaciones entre las dos tablas relacionadas muchos a muchos." VSHIFT="-8"/>
<node CREATED="1302522082086" HGAP="57" ID="ID_971207178" MODIFIED="1302525231403" TEXT="@JoinColumn : Columna de relaci&#xf3;n de la tabla A." VSHIFT="61">
<node CREATED="1302522127946" HGAP="13" ID="ID_1197437928" MODIFIED="1302523501017" TEXT="inverseJoinColumns" VSHIFT="23">
<node CREATED="1302522147649" HGAP="12" ID="ID_1641813866" MODIFIED="1302523504236" TEXT="@JoinColumn : Columna de relaci&#xf3;n de la tabla B." VSHIFT="26"/>
</node>
</node>
<node CREATED="1302524711759" HGAP="55" ID="ID_1451803466" MODIFIED="1302525213981" TEXT="FetchType :" VSHIFT="57">
<node CREATED="1302524754432" ID="ID_1345889310" MODIFIED="1302525145247" TEXT="Lazy: Por default el fetchMode es un select al momento de solicitar la infiormaci&#xf3;n."/>
<node CREATED="1302524758978" ID="ID_1362668017" MODIFIED="1302525179606" TEXT="Eager : Por default el fetchMode es un un outer join al momento de cargar la entidad."/>
</node>
<node CREATED="1302524805541" HGAP="22" ID="ID_409407093" MODIFIED="1302525209763" TEXT="FetchMode:" VSHIFT="48">
<node CREATED="1302524833557" ID="ID_942717653" MODIFIED="1302608702359" TEXT="Join : Se ejecuta cuando se carga la entidad."/>
<node CREATED="1302524838276" HGAP="21" ID="ID_1684250749" MODIFIED="1302608697281" TEXT="Select : Se ejecuta el select de la asociaci&#xf3;n cuando es solicitada." VSHIFT="9"/>
<node CREATED="1302524842120" ID="ID_1551272058" MODIFIED="1302608692359" TEXT="Subselect : Es solo para las colecciones, usa una estrategia de subselect en lugar de un join."/>
</node>
</node>
<node CREATED="1302521651037" HGAP="182" ID="ID_217408013" MODIFIED="1302618461315" TEXT="@ManyToOne" VSHIFT="-271"/>
<node CREATED="1302521664146" HGAP="191" ID="ID_1044209710" MODIFIED="1302618463628" TEXT="@OneToMany :  Esta anotaci&#xf3;n indica una relaci&#xf3;n muchos a muchos, en objetos esta relaci&#xf3;n se puede realizar simplemente con dos entidades mientras que en la base se necesita una tercera que contenga las relaciones de las pks de las dos tablas relacionadas." VSHIFT="-166">
<node CREATED="1302522066117" ID="ID_1799648369" MODIFIED="1302522257603" TEXT="@JoinTable : Tabla que tiene las relaciones entre las dos tablas relacionadas muchos a muchos."/>
<node CREATED="1302522082086" HGAP="22" ID="ID_981756571" MODIFIED="1302523513970" TEXT="@JoinColumn : Columna de relaci&#xf3;n de la tabla A." VSHIFT="23">
<node CREATED="1302522127946" HGAP="23" ID="ID_1740779200" MODIFIED="1302523490252" TEXT="inverseJoinColumns" VSHIFT="15">
<node CREATED="1302522147649" HGAP="19" ID="ID_1423714193" MODIFIED="1302523494205" TEXT="@JoinColumn : Columna de relaci&#xf3;n de la tabla B." VSHIFT="16"/>
</node>
</node>
</node>
<node CREATED="1302522350932" HGAP="128" ID="ID_1514235828" MODIFIED="1302618443300" TEXT="@Fetch(FetchMode.SUBSELECT) : Por un problema de Hibernate con las colecciones y los Joins, en algunos casos hay que indicar que realice subselct para obtener las colecciones." VSHIFT="-281"/>
</node>
</node>
</map>

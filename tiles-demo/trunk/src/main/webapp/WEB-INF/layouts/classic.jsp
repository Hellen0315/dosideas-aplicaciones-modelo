<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
    <head>
        <title><tiles:getAsString name="title"/></title>
    </head>
    <body>
        <table>
            <tr>
                <td colspan="2" style="background-color: lightcoral">
                    <tiles:insertAttribute name="header" />
                </td>
            </tr>
            <tr>
                <td style="background-color: lightblue">
                    <tiles:insertAttribute name="menu" />
                </td>
                <td style="background-color: lightgray">
                    <tiles:insertAttribute name="body" />
                </td>
            </tr>
            <tr>
                <td colspan="2" style="background-color: lightyellow">
                    <tiles:insertAttribute name="footer" />
                </td>
            </tr>
        </table>
    </body>
</html>

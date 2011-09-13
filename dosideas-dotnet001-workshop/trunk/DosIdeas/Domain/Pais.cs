using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DosIdeas.Domain
{
    /**
     * Este objeto de dominio será usado por NHibernate para mapear los datos
     * de la tabla Paises. En el archivo Models/Pais.hbm.xml se encuentra la 
     * asociación entre cada atributo de esta clase y cada columna de dicha tabla.
     * 
     */
    public class Pais
    {
        public virtual Int64 Id { get; set; }
        public virtual String Nombre { get; set; }
    }
}

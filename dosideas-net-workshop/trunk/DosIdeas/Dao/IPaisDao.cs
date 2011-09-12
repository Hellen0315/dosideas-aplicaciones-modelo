using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using DosIdeas.Domain;

namespace DosIdeas.Dao
{
    public interface IPaisDao
    {
        Pais BuscarPaisPorId(Int64 id);
        Int64 Guardar(Pais pais);
    }
}

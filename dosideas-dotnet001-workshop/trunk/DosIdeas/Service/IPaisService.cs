using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using DosIdeas.Domain;

namespace DosIdeas.Service
{
    public interface IPaisService
    {
        Pais BuscarPaisPorId(Int64 id);
        void Guardar(Pais pais);
    }
}

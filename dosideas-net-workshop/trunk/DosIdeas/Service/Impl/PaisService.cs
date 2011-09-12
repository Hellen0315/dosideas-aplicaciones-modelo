using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using DosIdeas.Domain;
using DosIdeas.Dao;

using Spring.Stereotype;
using Spring.Transaction;
using Spring.Transaction.Interceptor;

namespace DosIdeas.Service.Impl
{
    [Service]
    public class PaisService : IPaisService
    {
        public IPaisDao PaisDao { protected get; set; }

        [Transaction(TransactionPropagation.Required, ReadOnly=true)]
        public Pais BuscarPaisPorId(long id)
        {
            return PaisDao.BuscarPaisPorId(id);
        }

        [Transaction(TransactionPropagation.Required)]
        public void Guardar(Pais pais)
        {
            this.PaisDao.Guardar(pais);
        }
    }
}

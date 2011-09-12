using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using NHibernate;
using Spring.Data.NHibernate.Support;

using Spring.Stereotype;
using DosIdeas.Domain;

using Spring.Transaction;
using Spring.Transaction.Interceptor;

namespace DosIdeas.Dao.Impl
{
    [Repository]
    public class PaisDao: IPaisDao
    {
        public ISessionFactory SessionFactory { protected get; set; }

        [Transaction(ReadOnly = true)]
        public Pais BuscarPaisPorId(long id)
        {
            return SessionFactory.GetCurrentSession().Get<Pais>(id);
        }

        [Transaction]
        public Int64 Guardar(Pais pais)
        {
            return (Int64)SessionFactory.GetCurrentSession().Save(pais);
        }
    }
}

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
    /**
     * Esta clase se encarga de acceder al medio donde se almacenan los datos referidos
     * a un Pais. Esta implementación utiliza NHibernate para acceder a dichos datos.
     * 
     * La propiedad [Repository] es de Spring, y le indica a Spring que
     * esta clase deberá ser tratada como clase de acceso a datos. Spring registrará 
     * esta clase para ser inyectada en donde sea necesario. 
     * 
     * El atributo SessionFactory de esta clase será inyectado por Spring según la 
     * configuración de application-dao.xml (esta la clase base de Hibernate para 
     * interactuar con las entidades).
     * 
     */
    [Repository]
    public class PaisDao: IPaisDao
    {
        public ISessionFactory SessionFactory { protected get; set; }
 
        public Pais BuscarPaisPorId(long id)
        {
            return SessionFactory.GetCurrentSession().Get<Pais>(id);
        }

        public Int64 Guardar(Pais pais)
        {
            return (Int64)SessionFactory.GetCurrentSession().Save(pais);
        }
    }
}

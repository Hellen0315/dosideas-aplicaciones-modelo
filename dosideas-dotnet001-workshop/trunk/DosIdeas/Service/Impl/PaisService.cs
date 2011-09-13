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

    /**
     * Esta es la clase de negocio que expone operaciones relacionadas con el objeto
     * de dominio Pais. 
     * 
     * La propiedad [Service] es de Spring, y le indica a Spring que
     * esta clase deberá ser tratada como clase de servicios. Spring registrará esta
     * clase para ser inyectada en donde sea necesario. 
     * 
     * La propiedad [Transactional] indica que todos los métodos de esta clase 
     * deberán ser transaccionales (necesario para NHibernate). 
     * 
     * La propiedad PaisDao será inyectada por Spring según la configuración en application-service.xml
     */
    [Service]
    public class PaisService : IPaisService
    {
        public IPaisDao PaisDao { protected get; set; }

        [Transaction(TransactionPropagation.Required, ReadOnly=true)]
        public Pais BuscarPaisPorId(long id)
        {
            return PaisDao.BuscarPaisPorId(id);
        }

        [Transaction()]
        public void Guardar(Pais pais)
        {
            this.PaisDao.Guardar(pais);
        }
    }
}

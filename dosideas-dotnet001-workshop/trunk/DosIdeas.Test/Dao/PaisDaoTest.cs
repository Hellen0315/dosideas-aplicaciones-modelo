using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.IO;

using DosIdeas.Domain;
using DosIdeas.Dao;

using NHibernate;
using NUnit.Framework;

using Spring.Context;
using Spring.Context.Support;
using Spring.Data.Common;
using Spring.Data.Core;
using Spring.Testing.NUnit;
using Spring.Testing.Ado;
using DosIdeas.Test.Utils;

namespace DosIdeas.Test.Dao
{
    /**
     * Esta clase representa un test de componente. Los tests de componentes
     * se encargan de testear una clase en particular, y todas las dependencias
     * que la misma tiene. 
     * 
     * Esta clase hereda de una clase de test de Spring, que provee varias
     * facilidades para el testeo de componentes con Spring.
     * 
     * Este test comprueba el funcionamiento de la clase PaisDao. Esta clase
     * utiliza Hibernate para acceder a la base de datos. En el caso de este
     * proyecto, la base de datos se inicializa en memoria automáticamente
     * (en el método Init()). 
     *
     */
    [TestFixture]
    public class PaisDaoTest : AbstractTransactionalDatabaseTest
    {

        public IPaisDao Instancia { protected get; set; }

        public ISessionFactory SessionFactory { get; set; }
        

        [Test]
        public void BuscarPaisPorId_PaisExistente_RetornaUnPais()
        {
            Int64 paisId = 1;
            String query = String.Format("select nombre from Paises where id = {0}", paisId);

            String nombreEsperado = (String)AdoTemplate.ExecuteScalar(CommandType.Text, query);
            
            Pais unPais = this.Instancia.BuscarPaisPorId(paisId);
            Assert.IsNotNull(unPais, "El pais no puede ser NULO");

            Assert.AreEqual(paisId, unPais.Id, "El id del pais no es el mismo que se pidió");
            Assert.AreEqual(nombreEsperado, unPais.Nombre, "El nombre del pais no es el esperado");
        }

        [Test]
        public void BuscarPaisPorId_PaisInexistente_RetornaPaisNulo()
        {
            Int64 paisId = 60;

            Pais unPais = this.Instancia.BuscarPaisPorId(paisId);
            Assert.IsNull(unPais);
        }

        [Test]
        public void Guardar_PaisCorrecto_RetornaPais()
        {
            Pais pais = new Pais()
            {
                Nombre = "EEUU"
            };

            String query = "select count(*) from Paises";
            Int64 cantidadAntes = (Int64)AdoTemplate.ExecuteScalar(CommandType.Text, query);

            Int64 idRetorno = this.Instancia.Guardar(pais);
            //forzamos un flush para que NHibernate ejecute el query, ya que estamos dentro de una transacción
            this.SessionFactory.GetCurrentSession().Flush();

            Int64 cantidadDespues = (Int64)AdoTemplate.ExecuteScalar(CommandType.Text, query);

            Assert.AreEqual(cantidadAntes + 1, cantidadDespues);
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

using NHibernate;
using NUnit.Framework;
using Spring.Data.NHibernate;
using Spring.Testing.NUnit;
using Spring.Context;
using Spring.Context.Support;

using System.Data;

using DosIdeas.Domain;
using DosIdeas.Dao;

using Spring.Transaction;
using Spring.Transaction.Interceptor;

namespace DosIdeas.Test.Dao
{
    [TestFixture]
    public class PaisDaoTest : DosIdeasTestBase
    {
        public IPaisDao Instancia { protected get; set; }
        
        [SetUp()]
        public override void Init()
        {
            base.Init();   
        }

        [TearDown()]
        public override void Clean()
        {
            
        }

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
        [Transaction(ReadOnly=true)]
        public void Guardar_PaisCorrecto_RetornaPais()
        {
            Pais pais = new Pais()
            {
                Nombre = "EEUU"
            };

            Int64 idRetorno = this.Instancia.Guardar(pais);

            String query = "select count(*) from Paises";
            Int64 cantidadAntes = (Int64)AdoTemplate.ExecuteScalar(CommandType.Text, query);

            SessionFactoryUtils.GetSession(SessionFactory, true).Flush();

            Int64 cantidadDespues = (Int64)AdoTemplate.ExecuteScalar(CommandType.Text, query);

            Assert.AreEqual(cantidadAntes + 1, cantidadDespues);
        }
    }
}

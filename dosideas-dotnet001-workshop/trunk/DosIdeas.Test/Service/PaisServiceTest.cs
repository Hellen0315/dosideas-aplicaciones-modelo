using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.IO;

using DosIdeas.Domain;
using DosIdeas.Service;

using NHibernate;
using NUnit.Framework;

using Spring.Context;
using Spring.Context.Support;
using Spring.Data.Common;
using Spring.Data.Core;
using Spring.Testing.NUnit;
using Spring.Testing.Ado;

namespace DosIdeas.Test.Service
{
    [TestFixture]
    public class PaisServiceTest : AbstractDependencyInjectionSpringContextTests
    {
        protected override string[] ConfigLocations
        {
            get { return new string[] { "assembly://DosIdeas.Test/DosIdeas.Test/application-context-test.xml" }; }
        }

        public IPaisService Instancia { protected get; set; }
        public AdoTemplate AdoTemplate { get; set; }

        [SetUp()]
        public void Init()
        {
            Assert.IsNotNull(this.AdoTemplate);

            string sqlTablas = File.ReadAllText("../../scripts/CreacionTablas.sql");
            string sqlDatos = File.ReadAllText("../../scripts/CreacionDatos.sql");

            SimpleAdoTestUtils.ExecuteSqlScript(this.AdoTemplate, sqlTablas);
            SimpleAdoTestUtils.ExecuteSqlScript(this.AdoTemplate, sqlDatos);
        }

        [TearDown()]
        public void Clean()
        {

        }

        [Test]
        public void BuscarPaisPorId_PaisExistente_RetornaUnPais()
        {
            Int64 paisId = 2;
            String query = String.Format("select nombre from Paises where id = {0}", paisId);

            String nombreEsperado = (String)AdoTemplate.ExecuteScalar(CommandType.Text, query);

            Pais unPais = this.Instancia.BuscarPaisPorId(2);
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
        public void Guardar_PaisCorrecto()
        {
            Pais pais = new Pais()
            {
                Nombre = "EEUU"
            };

            String query = "select count(*) from Paises";
            Int64 cantidadAntes = (Int64)AdoTemplate.ExecuteScalar(CommandType.Text, query);

            this.Instancia.Guardar(pais);

            Int64 cantidadDespues = (Int64)AdoTemplate.ExecuteScalar(CommandType.Text, query);

            Assert.AreEqual(cantidadAntes + 1, cantidadDespues);
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.IO;

using NUnit.Framework;
using Spring.Data.NHibernate;
using Spring.Testing.NUnit;
using Spring.Context;
using Spring.Context.Support;

using DosIdeas.Domain;
using DosIdeas.Service;

using Spring.Data.Common;
using Spring.Data.Core;
using NHibernate;
using Spring.Transaction.Interceptor;



namespace DosIdeas.Test.Service
{
    [TestFixture]
    public class PaisServiceTest : AbstractDependencyInjectionSpringContextTests //: DosIdeasTestBase
    {
        public AdoTemplate AdoTemplate { get; set; }
        
        
        protected override string[] ConfigLocations
        {
            get { return new string[] { "assembly://DosIdeas.Test/DosIdeas.Test/application-context-test.xml" }; }
        }

        //public IDbProvider DbProvider { get; set; }
        public ISessionFactory SessionFactory { get; set; }

        protected ISession session
        {
            get { return this.SessionFactory.GetCurrentSession(); }
        }

        [SetUp()]
        public virtual void Init()
        {
            

            Assert.IsNotNull(Instancia);
        
            //this.AdoTemplate = new AdoTemplate(DbProvider);

            //Assert.IsNotNull(SessionFactory);
            //SessionFactory.GetCurrentSession().FlushMode = FlushMode.Never;

            string sql = File.ReadAllText("../../scripts/creacionDatosPrueba.sql");
            session.CreateSQLQuery(sql).ExecuteUpdate();

            //string sql = File.ReadAllText("../../scripts/creacionDatosPrueba.sql");
            //AdoTemplate.ExecuteNonQuery(CommandType.Text, sql);


            /*session.CreateSQLQuery(sql).ExecuteUpdate();*/
        }
        /*
        [SetUp()]
        public virtual void Init()
        {
            Assert.IsNotNull(SessionFactory);
            //SessionFactory.GetCurrentSession().FlushMode = FlushMode.Never;

            string sql = File.ReadAllText("../../scripts/creacionDatosPrueba.sql");
            session.CreateSQLQuery(sql).ExecuteUpdate();
        }
        */
     
        public IPaisService Instancia { protected get; set; }
      
        [TearDown()]
        public void Clean()
        {

        }

        //[Test]
        //public void BuscarPaisPorId_PaisExistente_RetornaUnPais()
        //{
        //    Int64 paisId = 2;
        //    String query = String.Format("select nombre from Paises where id = {0}", paisId);

        //    String nombreEsperado = (String)AdoTemplate.ExecuteScalar(CommandType.Text, query);

        //    Pais unPais = this.Instancia.BuscarPaisPorId(2);
        //    Assert.IsNotNull(unPais, "El pais no puede ser NULO");

        //    Assert.AreEqual(paisId, unPais.Id, "El id del pais no es el mismo que se pidió");
        //    Assert.AreEqual(nombreEsperado, unPais.Nombre, "El nombre del pais no es el esperado");
        //}

        //[Test]
        //public void BuscarPaisPorId_PaisInexistente_RetornaPaisNulo()
        //{
        //    Int64 paisId = 60;

        //    Pais unPais = this.Instancia.BuscarPaisPorId(paisId);
        //    Assert.IsNull(unPais);
        //}

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

            //this.session.Flush();

            //SessionFactoryUtils.GetSession(SessionFactory, true).Flush();

            Int64 cantidadDespues = (Int64)AdoTemplate.ExecuteScalar(CommandType.Text, query);

            Assert.AreEqual(cantidadAntes + 1, cantidadDespues);

            
        }


    }
}

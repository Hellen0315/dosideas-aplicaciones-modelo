using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

using NHibernate;
using NUnit.Framework;
using Spring.Testing.NUnit;
using Spring.Context;
using Spring.Context.Support;

namespace DosIdeas.Test
{
    public class DosIdeasTestBase : AbstractTransactionalDbProviderSpringContextTests
    {
        protected override string[] ConfigLocations
        {
            get { return new string[] { "assembly://DosIdeas.Test/DosIdeas.Test/application-context-test.xml" }; }
        }

        public ISessionFactory SessionFactory { get; set; }
        
        protected ISession session
        {
            get { return this.SessionFactory.GetCurrentSession(); }
        }

        [SetUp()]
        public virtual void Init()
        {
            Assert.IsNotNull(SessionFactory);
            //SessionFactory.GetCurrentSession().FlushMode = FlushMode.Never;

            string sql = File.ReadAllText("../../scripts/creacionDatosPrueba.sql");
            session.CreateSQLQuery(sql).ExecuteUpdate();
        }

        [TearDown()]
        public virtual void Clean()
        {

        }

    }
}

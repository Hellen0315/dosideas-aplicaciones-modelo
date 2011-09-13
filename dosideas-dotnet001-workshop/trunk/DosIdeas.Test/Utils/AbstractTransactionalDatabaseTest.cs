using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using Spring.Testing.NUnit;
using Spring.Testing.Ado;
using Spring.Data.Common;
using Spring.Data.Core;
using NUnit.Framework;

namespace DosIdeas.Test.Utils
{
    public abstract class AbstractTransactionalDatabaseTest : AbstractTransactionalDbProviderSpringContextTests
    {
        protected override string[] ConfigLocations
        {
            get { return new string[] { "assembly://DosIdeas.Test/DosIdeas.Test/application-context-test.xml" }; }
        }

        [SetUp()]
        public void Init()
        {
            string sqlTablas = File.ReadAllText("../../scripts/CreacionTablas.sql");
            string sqlDatos = File.ReadAllText("../../scripts/CreacionDatos.sql");

            SimpleAdoTestUtils.ExecuteSqlScript(this.AdoTemplate, sqlTablas);
            SimpleAdoTestUtils.ExecuteSqlScript(this.AdoTemplate, sqlDatos);
        }

    }
}

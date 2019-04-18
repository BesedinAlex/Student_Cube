using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cube
{
    class Program
    {
        public static void Main()
        {
            var Form = new MainForm(new Geometry.Cube(100));
            Form.ShowDialog();
        }
    }
}

using System;
using System.Drawing;
using System.Windows.Forms;

namespace Cube
{
    public partial class MainForm : Form
    {
        public MainForm(Geometry.Cube cube)
        {
            InitializeComponent();
            
        }

        private void MainForm_Paint(object sender, PaintEventArgs e)
        {
            Graphics graphicsObj;

            graphicsObj = CreateGraphics();

            Pen myPen = new Pen(Color.Red, 5);

            Rectangle myRectangle = new Rectangle(20, 20, 250, 200);

            graphicsObj.DrawRectangle(myPen, myRectangle);
        }
    }
}

using System;
using System.Drawing;

namespace Cube.Geometry
{
    class Face
    {
        public Vector[] Vectors { get; private set; }
        public Color Color { get; private set; }
        public Face(Vector v1, Vector v2, Vector v3, Vector v4, Color color)
        {
            Vectors = new Vector[] { v1, v2, v3, v4 };
            Color = color;
        }
        public void Rotate(double angleX, double angleY, double angleZ)
        {
            for (int i = 0; i < 4; i++)
                Vectors[i] = Vectors[i].Rotate(angleX, angleY, angleZ);
        }
        public Vector Normal() =>
            Vectors[2] - Vectors[1].Cross(Vectors[1] - Vectors[0]);
        public Vector Normal(double c)
        {
            Vector[] vectors = new Vector[4];
            for (int i = 0; i < 4; i++)
                vectors[i] = new Vector(
                    Vectors[i].X * c / (c - this.Vectors[i].Z),
                    Vectors[i].Y * c / (c - this.Vectors[i].Z),
                    Vectors[i].Z
                );
            return Vectors[2] - Vectors[1].Cross(Vectors[1] - Vectors[0]);
        }
    }
}

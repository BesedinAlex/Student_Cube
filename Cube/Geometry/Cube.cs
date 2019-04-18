using System;
using System.Drawing;

namespace Cube.Geometry
{
    public class Cube
    {
        //private Vector[] Vectors;
        private readonly Face[] faces;
        public double[] Angles { get; private set; } = { 0, 0, 0 };
        public Cube(double size)
        {
            var vectors = new Vector[] {
                new Vector(0, 0, 0),
                new Vector(size, 0, 0),
                new Vector(size, size, 0),
                new Vector(0, size, 0),
                new Vector(0, 0, size),
                new Vector(size, 0, size),
                new Vector(size, size, size),
                new Vector(0, size, size)
            };
            faces = new Face[] {
                new Face(vectors[0], vectors[1], vectors[2], vectors[3], Color.FromKnownColor(KnownColor.Chartreuse)),
                new Face(vectors[1], vectors[5], vectors[6], vectors[2], Color.FromKnownColor(KnownColor.Aqua)),
                new Face(vectors[6], vectors[7], vectors[3], vectors[2], Color.FromKnownColor(KnownColor.Yellow)),
                new Face(vectors[0], vectors[3], vectors[7], vectors[4], Color.FromKnownColor(KnownColor.DimGray)),
                new Face(vectors[0], vectors[4], vectors[5], vectors[1], Color.FromKnownColor(KnownColor.Orange)),
                new Face(vectors[4], vectors[7], vectors[6], vectors[5], Color.FromKnownColor(KnownColor.Pink))
            };
        }
        public void Rotate(double angleX, double angleY, double angleZ)
        {
            for (int i = 0; i < 6; i++)
                faces[i].Rotate(angleX, angleY, angleZ);
            Angles[0] += angleX;
            Angles[1] += angleY;
            Angles[2] += angleZ;
        }
    }
}

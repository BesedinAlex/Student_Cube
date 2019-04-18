using System;

namespace Cube.Geometry
{
    class Vector
    {
        public double X { get; private set; }
        public double Y { get; private set; }
        public double Z { get; private set; }
        public Vector(double x, double y, double z)
        {
            X = x;
            Y = y;
            Z = z;
        }
        public void Move(double x, double y, double z)
        {
            X += x;
            Y += y;
            Z += z;
        }
        public Vector Cross(Vector vector) =>
            new Vector(
                Y * vector.Z - Z * vector.Y,
                Z * vector.X - X * vector.Z,
                X * vector.Y - Y * vector.X
                );
        public Vector Rotate(double angleX, double angleY, double angleZ) =>
            RotateByX(angleX).RotateByY(angleY).RotateByZ(angleZ);
        private Vector RotateByX(double angle)
        {
            angle *= Math.PI / 180;
            return new Vector(
                X,
                Y * Math.Cos(angle) + Z * Math.Sin(angle),
                -Y * Math.Sin(angle) + Z * Math.Cos(angle)
            );
        }
        private Vector RotateByY(double angle)
        {
            angle *= Math.PI / 180;
            return new Vector(
                X * Math.Cos(angle) + Z * Math.Sin(angle),
                Y,
                -X * Math.Sin(angle) + Z * Math.Cos(angle)
            );
        }
        private Vector RotateByZ(double angle)
        {
            angle *= Math.PI / 180;
            return new Vector(
                X * Math.Cos(angle) - Y * Math.Sin(angle),
                X * Math.Sin(angle) + Y * Math.Cos(angle),
                Z
            );
        }
        public static Vector operator -(Vector vectorOne, Vector vectorTwo) =>
            new Vector(
                vectorOne.X - vectorTwo.X,
                vectorOne.Y - vectorTwo.Y,
                vectorOne.Z - vectorTwo.Z
                );
    }
}


import java.util.*;
public class Complex_Number
{
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        System.out.println(" Enter complex numbers \n");
        Complex com1 = new Complex(ob.nextDouble(),ob.nextDouble());
        Complex com2 = new Complex(ob.nextDouble(),ob.nextDouble());
        com1.setConjugateAndNegate();
        com2.setConjugateAndNegate();        
        System.out.println("Addition of "+com1.print()+" + "+com2.print()+" = "+(com1.add(com2)).print());
        System.out.println("Subtraction of "+com1.print()+" - "+com2.print()+" = "+(com1.subtract(com2)).print());
        System.out.println("Multiplication of "+com1.print()+" * "+com2.print()+" = "+(com1.multiply(com2)).print());
        System.out.println("Division of "+com1.print()+" / "+com2.print()+" = "+(com1.divide(com2)).print());       
    }
    static class Complex
    {
        double real;
        double complex;
        boolean isZero;
        Complex conjugate;
        double magnitude;
        Complex negate;
        public Complex(double real,double complex)
        {
            this.real=real;
            this.complex=complex;
            if(real == 0 && complex == 0)
                isZero = true;
            else
                isZero = false;
            conjugate = null;
            negate = null;
            magnitude = (real*real) + (complex*complex);            
            magnitude = Math.sqrt(magnitude);
        }

        public void setConjugateAndNegate()
        {
            conjugate = new Complex(real,(-1*complex));
            negate = new Complex((-1*real),(-1*complex));            
        }

        public Complex add(Complex plus)
        {
            return new Complex((real + plus.real),(complex + plus.complex));
        }

        public Complex subtract(Complex minus)
        {
            return new Complex((real - minus.real),(complex - minus.complex));
        }

        public Complex multiply(Complex multiplicand)
        {
            // foil method
            double f = real * multiplicand.real ;
            double o = real * multiplicand.complex;
            double i = complex * multiplicand.real;
            double l = (complex * multiplicand.complex) * -1;
            return new Complex((f+l),(i+o)); 
        }

        public Complex divide(Complex dividend)
        {
            // foil method
            Complex num = multiply(dividend.conjugate);
            double den = dividend.magnitude * dividend.magnitude;
            double realPart = num.real/den;
            double complexPart = num.complex/den;
            return new Complex(realPart,complexPart);
        }

        public String print()
        {
            if(isZero)
                return "0";
            String s="";
            if(complex == 0 && real != 0)
                s = s+real;
            else if(complex !=0 && real == 0)
            {
                if(complex == 1)
                    s = s+"i";
                else if(complex == -1)
                    s = s+"-i";
                else if(complex>0)
                    s = s+"+i"+complex;
                else 
                    s = s+ "-i"+(-1*complex);
            }
            else if(complex !=0 && real !=0)
            {
                s = s+real;
                if(complex == 1)
                    s = s+"i";
                else if(complex == -1)
                    s = s+"-i";
                else if(complex>0)
                    s = s+"+i"+complex;
                else 
                    s = s+ "-i"+(-1*complex);                
            }
            return s;
        }
    }
}

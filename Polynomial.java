package il.ac.tau.cs.sw1.hw6;

public class Polynomial {
	
	private double [] Polynoma;
	/*
	 * Creates the zero-polynomial with p(x) = 0 for all x.
	 */
	public Polynomial()
	{
		double [] Polynom=new double[1];
		Polynom[0]=0;

		this.Polynoma=Polynom;
	} 
	/*
	 * Creates a new polynomial with the given coefficients.
	 */
	public Polynomial(double[] coefficients) 
	{
		int darga=coefficients.length;
		double [] Polynom=new double[darga];
		for(int i=0;i<darga;i++)
		{
			Polynom[i]=coefficients[i];
			
		}
		
		this.Polynoma=Polynom;
	}
	/*
	 * Addes this polynomial to the given one
	 *  and retruns the sum as a new polynomial.
	 */
	public Polynomial adds(Polynomial polynomial)
	{
		double [] the_curr=Polynoma;
		double[]the_sec=polynomial.Polynoma;
		
		int curr_darga=the_curr.length;//degree
		int sec_darga=the_sec.length;//degree
		
		int AddDarga=Math.max(curr_darga, sec_darga);
		int Mutual=Math.min(sec_darga, curr_darga);
		
		double[] AddResult=new double[AddDarga];
		
		for(int i=0;i<Mutual;i++)
		{
			AddResult[i]=the_curr[i]+the_sec[i];
		}
		
		if(AddDarga!=Mutual)
		{
			if(curr_darga>sec_darga)
			{
				for(int i=Mutual;i<curr_darga;i++)
				{
					AddResult[i]=the_curr[i];
				}
			}
			else
			{
				for(int i=Mutual;i<curr_darga;i++)
				{
					AddResult[i]=the_sec[i];
				}
			}
		}
		Polynomial Result=new Polynomial(AddResult);
		return Result;
		
	}
	/*
	 * Multiplies a to this polynomial and returns 
	 * the result as a new polynomial.
	 */
	public Polynomial multiply(double a)
	{
		int degree=Polynoma.length;
		double[]Array_Result=new double[degree];
		
		for(int i=0;i<degree;i++)
		{
			Array_Result[i]=Polynoma[i]*a;
		}
		
		Polynomial Result=new Polynomial(Array_Result);
		return Result;
		
	}
	/*
	 * Returns the degree (the largest exponent) of this polynomial.
	 */
	public int getDegree()
	{
		return Polynoma.length-1;
	}
	/*
	 * Returns the coefficient of the variable x 
	 * with degree n in this polynomial.
	 */
	public double getCoefficient(int n)
	{
		if(n<this.Polynoma.length)
		{
			return this.Polynoma[n];
		}
		return 0.0;
	}
	
	/*
	 * set the coefficient of the variable x 
	 * with degree n to c in this polynomial.
	 * If the degree of this polynomial < n, it means that that the coefficient of the variable x 
	 * with degree n was 0, and now it will change to c. 
	 */
	public void setCoefficient(int n, double c)
	{
		int len=getDegree();
		
		if (len < n)
		{
			double[] Result = new double[n+1];
			for (int i=0; i< len; i++ ) 
			{
				Result[i]=this.Polynoma[i]; 
			}
			Result[n] = c;
			
			this.Polynoma = Result;
		}
		
		else
		{
			this.Polynoma[n] = c;
		}
	}
	
	/*
	 * Returns the first derivation of this polynomial.
	 *  The first derivation of a polynomal a0x0 + ...  + anxn is defined as 1 * a1x0 + ... + n anxn-1.
	
	 */
	public Polynomial getFirstDerivation()
	{
		double[] Result_arr = new double[Polynoma.length-1];
			
		for (int i=0; i<Result_arr.length; i++) 
		{
			Result_arr[i]= getCoefficient(i+1)*(i+1);
			
		}
			
		Polynomial Result = new Polynomial(Result_arr);
			
		return Result;
		
		
	}
	
	/*
	 * given an assignment for the variable x,
	 * compute the polynomial value
	 */
	public double computePolynomial(double x)
	{
		Double Res=0.0;
		double curr=1;
		for(int i=0;i<Polynoma.length;i++)
		{
			Res=Res+(Polynoma[i]*curr);
			curr=curr*x;
		}
		return Res;
	}
	
	/*
	 * given an assignment for the variable x,
	 * return true iff x is an extrema point (local minimum or local maximum of this polynomial)
	 * x is an extrema point if and only if The value of first derivation of a polynomal at x is 0
	 * and the second derivation of a polynomal value at x is not 0.
	 */
	public boolean isExtrema(double x)
	{
		Polynomial First_derive=getFirstDerivation();
		Polynomial Second_derive=First_derive.getFirstDerivation();
		
		if(First_derive.computePolynomial(x)==0)
		{
			if(Second_derive.computePolynomial(x)<0||Second_derive.computePolynomial(x)>0)
				return true;
		}
		return false;
	}
	
	
	
	

    
    

}

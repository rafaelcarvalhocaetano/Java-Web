package br.uninove.edu;

public class CalculandoBhaskara {
	
	private String a,b,c;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}
	
	public double delta() {

		try {
			double valorA, valorB, valorC;

			valorA = Double.parseDouble(a);
			valorB = Double.parseDouble(b);
			valorC = Double.parseDouble(c);

			double delta = (valorB * valorB) - 4 * valorA * valorC;
			return delta;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
	
	public String raizPositiva(){
		try {
			double valorA, valorB;

			valorA = Double.parseDouble(a);
			valorB = Double.parseDouble(b);
			
			if(delta() < 0 ){
				return "Delta é negativo";
			}else{
				double raizPositiva;
				raizPositiva = ((-valorB + Math.sqrt(delta())) / (2 * valorA));
				return String.valueOf(raizPositiva);
			}

		} catch (Exception e) {
			return "Erro";
		}

	}
	public String raizNegativa(){
		try {
			double valorA, valorB;

			valorA = Double.parseDouble(a);
			valorB = Double.parseDouble(b);
			
			if(delta() < 0 ){
				return "Delta é negativo";
			}else{
				double raizPositiva;
				raizPositiva = (( -valorB - Math.sqrt(delta()) ) / (2 * valorA));
				return String.valueOf(raizPositiva);
			}
		} catch (Exception e) {
			return "Erro";
		}
	}

}

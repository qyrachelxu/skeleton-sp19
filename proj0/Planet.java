public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static double gravity = 6.67E-11;

	public Planet(double xP, double yP, double xV, 
		         double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Planet b){
		double xxdistance = this.xxPos - b.xxPos;
		double yydistance = this.yyPos - b.yyPos;
		xxdistance = Math.pow(xxdistance, 2);
		yydistance = Math.pow(yydistance, 2);
		double xydistance = Math.sqrt(xxdistance + yydistance);
		return xydistance;
	}

	public double calcForceExertedBy(Planet b){
		double forceresult;
		forceresult = (this.mass * b.mass) * Planet.gravity / Math.pow(this.calcDistance(b), 2);
		return forceresult;
	}

	public double calcForceExertedByX(Planet b){
		double xxdistance = b.xxPos - this.xxPos;
		double forceresultbyx;
		forceresultbyx = this.calcForceExertedBy(b) * xxdistance / this.calcDistance(b);
		return forceresultbyx;
	}

	public double calcForceExertedByY(Planet b){
		double yydistance = b.yyPos - this.yyPos;
		double forceresultbyy;
		forceresultbyy = this.calcForceExertedBy(b) * yydistance / this.calcDistance(b);
		return forceresultbyy;
	}

	public double calcNetForceExertedByX(Planet[] bs){
		double xforceresult = 0;
		for(int i = 0; i < bs.length; i++){
			if (this.equals(bs[i])){
				continue;
			}
			xforceresult = xforceresult + calcForceExertedByX(bs[i]);
		}
		return xforceresult;
	}

	public double calcNetForceExertedByY(Planet[] bs){
		double yforceresult = 0;
		for(int i = 0; i < bs.length; i++){
			if (this.equals(bs[i])){
				continue;
			}
			yforceresult = yforceresult + calcForceExertedByY(bs[i]);
		}
		return yforceresult;
	}

	public void update(double dt, double fX, double fY){
		double acceleratex;
		acceleratex = fX / this.mass;
		double acceleratey;
		acceleratey = fY / this.mass;
		this.xxVel = this.xxVel + dt * acceleratex;
		this.yyVel = this.yyVel + dt *acceleratey;
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}

	public void draw(){
		StdDraw.enableDoubleBuffering();
    	String imagepos = "./images/" + this.imgFileName;
    	StdDraw.picture(this.xxPos, this.yyPos, imagepos);
	}
}

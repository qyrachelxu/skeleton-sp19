public class NBody{

	public static double readRadius(String name){
		In in = new In(name);
		double radiusuniver = in.readDouble();
		radiusuniver = in.readDouble();
		return radiusuniver;
    }

    public static Planet[] readBodies(String name){
    	In in = new In(name);
    	double first = in.readDouble();
    	double second = in.readDouble();
    	Planet[] bodys = new Planet[5];
    	for (int i = 0; i < 5; i++){
    		double xxp = in.readDouble();
    		double yyp = in.readDouble();
    		double xxv = in.readDouble();
    		double yyv = in.readDouble();
    		double mas = in.readDouble();
    		String str = in.readString();
    		bodys[i] = new Planet(xxp, yyp, xxv, yyv, mas, str);
    	}
    	return bodys;
    }

    public static void main(String[] args) {
    	double T = Double.parseDouble(args[0]);
    	double dt = Double.parseDouble(args[1]);
    	String filename = args[2];
    	NBody.readBodies(filename);
    	Planet bodies[] = NBody.readBodies(filename);
    	double univerradius = NBody.readRadius(filename);
    	StdDraw.enableDoubleBuffering();
    	StdDraw.setScale(-univerradius, univerradius);
    	StdDraw.clear();
    	StdDraw.picture(0, 0, "./images/starfield.jpg");

    	for(Planet i: bodies){
    		i.draw();
    	}

    	//StdDraw.show();

    	for(double time = 0; time < T;  T = T + dt){
    		double xForces[] = new double[bodies.length];
    		double yForces[] = new double[bodies.length];
    		for (int i = 0; i < bodies.length; i++) {
    			xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
    			yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
    		}

    		for (int i = 0; i < bodies.length; i++) {
    			bodies[i].update(dt, xForces[i], yForces[i]);
    		}

    		StdDraw.clear();
    	    StdDraw.picture(0, 0, "./images/starfield.jpg");

    	    for(Planet i: bodies){
    		i.draw();
    	    }

    	    StdDraw.show();
    	    StdDraw.pause(100);
    	    StdOut.printf("%d\n", bodies.length);
            StdOut.printf("%.2e\n", univerradius);
            for (int i = 0; i < bodies.length; i++) {
                StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                       bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                       bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
            }
    	}
    }
}
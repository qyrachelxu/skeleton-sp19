public class NBody{

	public static double readRadius(String name){
		In in = new In(name);
		double radiusuniver = in.readDouble();
		radiusuniver = in.readDouble();
		return radiusuniver;
    }

    public static Planet[] readPlanets(String name){
    	In in = new In(name);
    	int first = in.readInt();
    	double second = in.readDouble();
    	double xxp;
    	double yyp;
    	double xxv;
    	double yyv;
    	double mas;
    	String imgf;
    	Planet[] bodys = new Planet[first];
    	for (int i = 0; i < first; i++){
    		xxp = in.readDouble();
    		yyp = in.readDouble();
    		xxv = in.readDouble();
    		yyv = in.readDouble();
    		mas = in.readDouble();
    		imgf = in.readString();
    		bodys[i] = new Planet(xxp, yyp, xxv, yyv, mas, imgf);
    	}
    	return bodys;
    }

    public static void main(String[] args) {
    	double T = Double.parseDouble(args[0]);
    	double dt = Double.parseDouble(args[1]);
    	String filename = args[2];

    	Planet bodies[] = NBody.readPlanets(filename);
    	double univerradius = NBody.readRadius(filename);

    	StdDraw.enableDoubleBuffering();
    	StdDraw.setScale(-univerradius, univerradius);

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

    	    StdDraw.picture(0, 0, "./images/starfield.jpg");

    	    for(Planet i: bodies){
    		    i.draw();
    	    }

    	    StdDraw.show();
    	    StdDraw.pause(100);

    	    StdDraw.clear();
   
        }

            StdOut.printf("%d\n", bodies.length);
            StdOut.printf("%.2e\n", univerradius);
            for (int i = 0; i < bodies.length; i++) {
                StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                       bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                       bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
    	    }
     }
}
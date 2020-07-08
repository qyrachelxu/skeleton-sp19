public class TestBody{

	public static void main(String[] args) {
		In in = new In("./data/planets.txt");
		double first = in.readDouble();
    	double second = in.readDouble();
    	System.out.println("Number:" + first);
    	System.out.println("radius:" + second);
    	for (int i = 0; i < 5; i++){
    		double xxp = in.readDouble();
    		double yyp = in.readDouble();
    		double xxv = in.readDouble();
    		double yyv = in.readDouble();
    		double mas = in.readDouble();
    		double str = in.readString();
    		System.out.println("XXP:" + xxp + " yyp:" + yyp + " XXV:" + xxv + " yyv:" + yyv
    			                       + " mass:" + mas + " str:" + str);
    	}
	}
}
import java.util.Scanner;

// Java does not allow declaring a static class syntactically.
// But, we can make a class that is just like a static class in Java as follows:
public final class AppView {
	
	// "final" will prevent inheritance of static class "AppView"
	// because inheritance has no meaning for a static class
	
	private static Scanner scanner = new Scanner(System.in);
	// Ever variable of a static class should be static
	
	// The constructor should be private.
	// Otherwise, this constructor could be called some other places.
	// But, such a call which cannot be prevented by Java compiler has no meaning for a static class.
	private AppView() {
		
	}
	
	// Ever member method should be static.
	// Although you can declare non-static members, such members will be useless.
	public static void outputLine(String aString) {
		System.out.println(aString);
	}
	public static void output(String aString) {
		System.out.print(aString);;
	}
	
	public static int inputNumberOfVertices() {
		int numberOfVertices;
		String scannedToken;
		while (true) {
			AppView.output("? vertex 수를 입력하시오: ");
			scannedToken = AppView.scanner.next();
			try {
				numberOfVertices = Integer.parseInt(scannedToken);
				return numberOfVertices;
			}
			catch (NumberFormatException e) {
				AppView.outputLine("(오류) Verte 수 입력에 오류가 있습니다: " + scannedToken);
			}
		}
	}
	public static int inputNumberOfEdges() {
		int numberOfEdges;
		String scannedToken;
		while (true) {
			AppView.output("? edge 수를 입력하시오: ");
			scannedToken = AppView.scanner.next();
			try {
				numberOfEdges = Integer.parseInt(scannedToken);
				return numberOfEdges;
			}
			catch (NumberFormatException e) {
				AppView.outputLine("(오류) edge 수 입력에 오류가 있습니다: " + scannedToken);
			}
		}
	}
	public static int inputTailVertex() {
		int tailVertex;
		String scannedToken;
		while (true) {
			AppView.output("? tail vertex 수를 입력하시오: ");
			scannedToken = AppView.scanner.next();
			try {
				tailVertex = Integer.parseInt(scannedToken);
				return tailVertex;
			}
			catch (NumberFormatException e) {
				AppView.outputLine("(오류) tail vertex 수 입력에 오류가 있습니다: " + scannedToken);
			}
		}
	}
	public static int inputHeadVertex() {
		int headVertex;
		String scannedToken;
		while (true) {
			AppView.output("? head vertex 수를 입력하시오: ");
			scannedToken = AppView.scanner.next();
			try {
				headVertex = Integer.parseInt(scannedToken);
				return headVertex;
			}
			catch (NumberFormatException e) {
				AppView.outputLine("(오류) head vertex 수 입력에 오류가 있습니다: " + scannedToken);
			}
		}
	}
}

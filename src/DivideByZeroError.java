
public class DivideByZeroError extends Exception {
	int errorKind;
	DivideByZeroError() {
		errorKind = 0;
	}
	DivideByZeroError(int x){
		errorKind = x;
	}
	public String toString(){
		return("Erro de divisão por zero");
	}
}

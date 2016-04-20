
public class CalculatorEngine {
	int value;
	int keep;		//two calculator registers
	char toDo;
	
	void binaryOperation(char op){
		keep = value;		//keep first operand
		value = 0;			//initialize and get ready for second operand
		toDo = op;
	}
	
	void add(){
		binaryOperation('+');
	}
	void subtract(){
		binaryOperation('-');
	}
	void multiply(){
		binaryOperation('*');
	}
	void divide(){
		binaryOperation('/');
	}
	
	void compute(){
		if (toDo == '+')
			value+=keep;
		else if (toDo == '-')
			value=keep-value;
		else if (toDo == '*')
			value*=keep;
		else if (toDo == '/')
			value=keep/value;
		keep = 0;
	}
	
	void clear(){
		value = 0;
		keep = 0;
	}
	
	void digit(int x){
		value=value*10 + x;
	}
	
	int display(){
		return(value);
	}
	
	CalculatorEngine(){
		clear();
	}
}

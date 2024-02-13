package by.tms.lesson25.server.service;


import by.tms.lesson25.server.model.Operation;

public class OperationService {

    public Operation calculate(Operation operation){
        switch (operation.getType()){
            case "sum":
                operation.setResult(operation.getNum1()+operation.getNum2());
                return operation;
            case "min":
                operation.setResult(operation.getNum1() - operation.getNum2());
                return operation;
            case "multi":
                operation.setResult(operation.getNum1() * operation.getNum2());
                return operation;
            case "div":
                if(operation.getNum2() !=0) {
                    operation.setResult(operation.getNum1() / operation.getNum2());
                    return operation;
                }
        }
        throw new RuntimeException();
    }
}

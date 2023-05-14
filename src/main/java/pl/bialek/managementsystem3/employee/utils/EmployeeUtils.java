package pl.bialek.managementsystem3.employee.utils;

import pl.bialek.managementsystem3.employee.Employee;
import pl.bialek.managementsystem3.employee.dto.transactiondto.EmployeeTransactionDto;

import java.util.Optional;


public class EmployeeUtils {

    public static void convertDetailsIfEmpty(EmployeeTransactionDto transactionDto){
        if(transactionDto.getPhoneNumber()=="")
            transactionDto.setPhoneNumber(null);
        if(transactionDto.getEmail()=="")
            transactionDto.setEmail(null);
        if(transactionDto.getCity()=="")
            transactionDto.setCity(null);
    }

    public static boolean checkIfEmpty(Optional<Employee> employeeOptional){
        return employeeOptional.isEmpty();
    }

}

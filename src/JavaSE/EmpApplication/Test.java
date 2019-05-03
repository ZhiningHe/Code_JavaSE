package JavaSE.EmpApplication;

import java.lang.reflect.InvocationTargetException;

/**
 * 输入信息自动分隔存储
 */
//客户端主要实现
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        String str = "emp.name:hexuan|emp.job:Coder";
        EmpAction empAction = new EmpAction();
        empAction.setEmpValue(str);
        System.out.println(empAction.getEmp().toString());
    }
}

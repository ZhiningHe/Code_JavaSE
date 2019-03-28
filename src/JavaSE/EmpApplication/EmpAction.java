package JavaSE.EmpApplication;

import JavaSE.EmpApplication.Emp;

import java.lang.reflect.InvocationTargetException;

//操作Emp的类，最后给用户使用
public class EmpAction {
    //真实对象
    private Emp emp = new Emp();

    //用户传入值
    public void setEmpValue(String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        BeanUtil.setBeanValue(this,str);
        //this代表EmpAction对象
    }

    //取出真实对象emp
    public Emp getEmp (){
        return this.emp;
    }
}

package JavaSE.EmpApplication;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//操作Emp类的简单工具类
public class BeanUtil {
    //私有构造
    private BeanUtil(){};

    /**
     * 拿到类对象
     * @param actionObj xxAction对象
     * @param beanValue 要设置的具体值
     */
    public static void setBeanValue(Object actionObj,String beanValue) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        //把每个属性分隔开
        String[] tmp = beanValue.split("\\|");
        //开始设置每个属性
        for (int i = 0; i <tmp.length; i++){
            //emp.name:hahaha
            String[] result = tmp[i].split(":");
            String objValue = result[1];//hahaha
            String classname = result[0].split("\\.")[0];//emp
            String objname = result[0].split("\\.")[1];//name
            //根据xxAction类获取真正操作对象
            Object realobj = getRealObj(actionObj,classname);
            //设置真实对象的属性
            setRealObj(realobj,objname,objValue);

        }
    }

    /**
     * 调用真正类的set方法
     * @param obj 真实的对象
     * @param objname 要设置的属性名称
     * @param value 要设置的属性值
     */
    private static void setRealObj(Object obj,String objname,String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class cls = obj.getClass();
        String methodname =  "set"+objname.substring(0,1).toUpperCase()
                +objname.substring(1);
        //相当于用obj调用setXX（）
        cls.getMethod(methodname).invoke(obj,value);
    }

    /**
     * 取得真正操作的对象
     * @param obj  XXAction对象
     * @param classname 真实操作的类名称
     */
    private static Object getRealObj(Object obj,String classname) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        //获取empaction对象
        Field field = obj.getClass().getField(classname);
        if(field !=null){
            //getEmp
            String methodName = "get"+classname.substring(0,1).toUpperCase()
                    +classname.substring(1);
            Method method = obj.getClass().getMethod(methodName);
            //因为getEmp是EmpAction的方法，所以必须用其类的对象obj调用
            method.invoke(obj);
        }
        return null;
    }
}

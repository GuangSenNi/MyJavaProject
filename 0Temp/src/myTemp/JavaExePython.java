package myTemp;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class JavaExePython {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("E:\\Documents\\Java Workspace\\0Temp\\src\\text.py");

        // ��һ������Ϊ������õĺ����������������֣��ڶ�������Ϊ�������صĶ�������
        PyFunction pyFunction = interpreter.get("add", PyFunction.class);
        int a = 5, b = 10;
        //���ú��������������Ҫ��������Java�б����Ƚ�����ת��Ϊ��Ӧ�ġ�Python���͡�
        PyObject pyobj = pyFunction.__call__(new PyInteger(a), new PyInteger(b)); 
        System.out.println("the anwser is: " + pyobj);

	}

}

//��Ч�м�Ϊ��ȥ�����Լ�ע���еĴ����У��ڱ�����ҵ�в����Ƕ���ע������
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = ".\\src\\Main.java";
        readFile(fileName);
    }

    //���ж�ȡ�ļ�
    private static void readFile(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String context = null;
            int line = 0;
            while ((context = reader.readLine()) != null) {
                if (isEffective(context)) {
                    line++;
                }
            }
            System.out.println("There is " + line + " effective lines.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }
    }

    //�жϸ����Ƿ�Ϊ��Ч��
    private static boolean isEffective(String context) {
        context = context.trim();//ȥ���ո�
        if (context.length() == 0) {//����
            return false;
        } else if (context.length() > 0 && (context.charAt(0) == '/' && (context.charAt(1) == '/' || context.charAt(1) == '*'))) { //ע����
            return false;
        } else {
            return true;
        }
    }
}
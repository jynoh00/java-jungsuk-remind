import java.io.File;

public class ExceptionEx {
    public static void main(String[] args) {
        try {
            File f = createFile(args[0]);
            System.out.println(f.getName() + "파일이 생성 완료");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " 재입력 바랍니다.");
        }
    }

    static File createFile(String fileName) throws Exception {
        if (fileName == null || fileName.isEmpty()) throw new Exception("유효하지 않은 파일명");

        File f = new File(fileName);

        f.createNewFile();
        return f;
    }
}
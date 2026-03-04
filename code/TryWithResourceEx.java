public class TryWithResourceEx {
    public static void main(String[] args) {
        try (CloseableResource cr = new CloseableResource()) {
            cr.exceptionWork(false); // try블럭 내 예외 발생 x
        } catch (WorkException | CloseException e) {
            e.printStackTrace();
        }

        try (CloseableResource cr = new CloseableResource()) {
            cr.exceptionWork(true); // try블럭 내 예외 발생 o
        } catch (WorkException | CloseException e) {
            e.printStackTrace();
        }
    }
}

class CloseableResource implements AutoCloseable {
    public void exceptionWork(boolean exception) throws WorkException {
        System.out.println("exceptionWork(" + exception + ") 호출됨");

        if (exception) throw new WorkException("WorkException 발생");
    }

    public void close() throws CloseException {
        System.out.println("close() 호출됨");
        throw new CloseException("CloseException 발생");
    }
}
/* 예외는 클래스이기에 직접 Exception을 상속받아 예외 클래스를 만들 수 있다. */
class WorkException extends Exception {
    WorkException(String message) { super(message); }
}
class CloseException extends Exception {
    CloseException(String message) { super(message); }
}
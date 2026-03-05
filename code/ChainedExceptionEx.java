public class ChainedExceptionEx {
    public static void main(String[] args) {
        try {
            install();
        } catch (InstallException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void install() throws InstallException {
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException se) {
            InstallException ie = new InstallException("install exception occur");
            ie.initCause(se); // SpaceException(설치 공간 부족)으로 인한 InstallException
            throw ie;
        } catch (MemoryException me) {
            InstallException ie = new InstallException("install exception occur");
            ie.initCause(me);
            throw ie;
        } finally {
            deleteTempFiles();
        }
    }

    static void startInstall() throws SpaceException, MemoryException {
        if (!enoughSpace()) throw new SpaceException("not enough space");
        if (!enoughMemory()) throw new MemoryException("not enough memory");
    }

    static void copyFiles() { /* copy files */ }
    static void deleteTempFiles() { /* delete temp files */}

    static boolean enoughSpace() { return false; }
    static boolean enoughMemory() { return true; }
}

class InstallException extends Exception { InstallException(String msg) { super(msg); } }
class SpaceException extends Exception { SpaceException(String msg) { super(msg) ; } }
class MemoryException extends Exception { MemoryException(String msg) { super(msg) ; } }

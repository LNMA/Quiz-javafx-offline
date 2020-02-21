package quiz.iofile;

import java.io.*;

public interface IOOut {

    public static void writeAccount(Object o) {
        File file = new File("accounts.dat");
        if (file.exists()) {
            iOOutExist(o);
        } else
            iOOutNew(o);
    }

    static void iOOutExist(Object o) {
        try (AppendingObjectOutputStream out = new AppendingObjectOutputStream(new BufferedOutputStream(new FileOutputStream("accounts.dat", true)))) {
            out.writeObject(o);
            out.writeStreamHeader();
        } catch (IOException e) {
            System.out.print("\n>> " + e.getMessage() + "\n");
        }
    }

    static void iOOutNew(Object o) {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("accounts.dat", false)))) {
            out.writeObject(o);
        } catch (IOException e) {
            System.out.print("\n>> " + e.getMessage() + " \n");
        }
    }

    public static void checkToSaveAllAccount() {
        File file = new File("accounts.dat");
        if (file.exists())
            file.delete();
    }



    public static void writeQuestion(Object o) {
        File file = new File("question.dat");
        if (file.exists()) {
            iOOutExistQuestion(o);
        } else
            iOOutNewQuestion(o);
    }

    static void iOOutExistQuestion(Object o) {
        try (AppendingObjectOutputStream out = new AppendingObjectOutputStream(new BufferedOutputStream(new FileOutputStream("question.dat", true)))) {
            out.writeObject(o);
            out.writeStreamHeader();
        } catch (IOException e) {
            System.out.print("\n>> " + e.getMessage() + "\n");
        }
    }

    static void iOOutNewQuestion(Object o) {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("question.dat", false)))) {
            out.writeObject(o);
        } catch (IOException e) {
            System.out.print("\n>> " + e.getMessage() + " \n");
        }
    }

    public static void checkToSaveAllQuestion() {
        File file = new File("question.dat");
        if (file.exists())
            file.delete();
    }


}


import java.io.*;

public class Main {

    public static void main(String[] args) {
        Solver s = new Solver("example.in");

        try (PrintStream out = new PrintStream(new FileOutputStream("example.txt"))) {
            out.print(s.solveIt());
        }
        catch (FileNotFoundException e){}
        Solver a = new Solver("b_should_be_easy.in");

        try (PrintStream out = new PrintStream(new FileOutputStream("b_should_be_easy.txt"))) {
            out.print(a.solveIt());
        }catch (FileNotFoundException e){}

        Solver b = new Solver("c_no_hurry.in");

        try (PrintStream out = new PrintStream(new FileOutputStream("c_no_hurry.txt"))) {
            out.print(b.solveIt());
        }catch (FileNotFoundException e){}

        Solver c = new Solver("d_metropolis.in");

        try (PrintStream out = new PrintStream(new FileOutputStream("d_metropolis.txt"))) {
            out.print(c.solveIt());
        }catch (FileNotFoundException e){}

        Solver d = new Solver("e_high_bonus.in");

        try (PrintStream out = new PrintStream(new FileOutputStream("e_high_bonus.txt"))) {
            out.print(d.solveIt());
        }catch (FileNotFoundException e){}

    }


}



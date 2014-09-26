package com.meiblorn.math.factorization.app;

import com.bethecoder.ascii_table.ASCIITable;
import com.bethecoder.ascii_table.ASCIITableHeader;
import com.meiblorn.math.factorization.ComplexFactorizationMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Meiblorn on 12/09/14.
 */
public class AppRunner {

    private static String INPUT_FILE_NAME = "input.txt";
    private static String OUTPUT_FILE_NAME = "output.txt";

    private static Scanner scanner;
    private static PrintWriter printWriter;

    public static void main(String[] args) throws Exception {

        try {
            scanner = new Scanner(new File(INPUT_FILE_NAME));
            printWriter = new PrintWriter(OUTPUT_FILE_NAME);

            List<Integer> numbers = new ArrayList<Integer>();
            while (scanner.hasNextLine()) {
                numbers.add(
                        Integer.parseInt(scanner.nextLine())
                );
            }

            int i = 0;
            String[][] data = new String[numbers.size()][];

            for (Integer number : numbers) {
                data[i] = new String[3];

                ComplexFactorizationMethod complexFactorizationMethod = new ComplexFactorizationMethod();

                Map<Integer, Integer> multipliers = complexFactorizationMethod.getMultipliersFor(number);

                data[i][0] = String.valueOf(number);

                int j = 0;
                StringBuilder multipliersStringBuilder = new StringBuilder();

                for (Integer multiplier : new TreeSet<Integer>(multipliers.keySet())) {
                    if (multiplier == 1 && number != 1) {
                        continue;
                    }

                    multipliersStringBuilder.append(multiplier);
                    if (multipliers.get(multiplier) != 1) {
                        multipliersStringBuilder.append("^");
                        multipliersStringBuilder.append(multipliers.get(multiplier));
                    }

                    if (++j < multipliers.size()) {
                        multipliersStringBuilder.append(" * ");
                    }
                }

                data[i][1] = multipliersStringBuilder.toString();

                i++;
            }

            ASCIITableHeader[] headerObjs = {
                    new ASCIITableHeader("Number", ASCIITable.ALIGN_LEFT),
                    new ASCIITableHeader("Multipliers", ASCIITable.ALIGN_LEFT),
            };

            printWriter.println(ASCIITable.getInstance().getTable(headerObjs, data));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
            printWriter.close();
        }
    }
}

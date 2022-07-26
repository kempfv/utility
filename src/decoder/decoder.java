package decoder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.SortedMap;

public class decoder {

    public static void main(String[] args) throws IOException {
        //String inputString = "ÁÎÁÎØÊÎ; ÄÌÈÒÐÎ; ÄÌÈÒÐÎÂÈ×";
        System.out.println("Enter krakozyabry line: ");
        Scanner inputStringSc = new Scanner(System.in);
        // String input
        String inputString = inputStringSc.nextLine();
        System.out.println(inputStringSc);

        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        Writer output;
        output = new BufferedWriter(new FileWriter("perhap.txt"));  //clears file every time


        for (String key : charsets.keySet()) {
            for (String key2 : charsets.keySet()){
                try {
                    convert(output, charsets.get(key), charsets.get(key2), inputString);

                } catch (Exception e) {}
            }
        }
        output.close();

    }

    private static void convert(Writer w,Charset inCharset, Charset outCharset, String input) {
        byte[] byteArrray = input.getBytes(inCharset);
        try {
            w.append("from: "+inCharset.displayName()+" to : "+outCharset.displayName()+" result: "+ new String(byteArrray,outCharset)+"\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

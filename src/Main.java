import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.zip.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // print the byte[] elements
        //byte[] compRaw=Base64.getDecoder().decode("eNqlVsGO3CAMvfMV3DIrZPtu9VNGwj1sL1UVaXuoVsrH1zYkgYTMrGbJikDAj4f97NkQQrxuwiwM/TcGYJBwbVEMkLCxIbE14EtLao/RIwARtW9AzHpsm+LzJhRWmP42+NyWpUOCFWnWu+5LSM+RGqZIzPN6H2B3XOFCXwBSc6iW5ri0e7V4zD5Dki0o6krYuR7munE9HBoXz/HoMeJqXhhKgupb3oArpiTHEY0h09HFtBEBN9x4xqPWXAmAQV0NKEPdNBHuPYw81IESUm5yZrUSr8dgGeA+HwcCiIvzbTBUT3E2d3M+3bRGlXBV198vKPOhaqu6dhm83DA5K6GetAYXrbM8jfzZHIOfGglA15iu9gS0GChamqEEVx/ybBINZnGhvnlnDYlqnNm2wOzCcUNvs2lW5JjTCVo4zSqpaRdbOKZjBZFThSqJwKmFs3jXBGjgZuxqTex1vlGrCPqW+t4Q6omnQre6XrzmDAFU0+sxCcNAh02NHgHskpR5YH8Qkrjvk4nCWi+XYZHfy8TDQp0uqjxe5Fe348HPUkuxZ6yOg/DwR5CrhC2OFQjta3hyl+IavzbHUsq+k4YwTd9BwEkhVIBvL0OQYWhPjxDycJx9fMsULwB0g/3luMQl2951XFZu+U1nvjC0X+KUFTzHu43iPdZxzmW+GBZFujS3pxyyeL+Ol7g+Mf4wL8bpbK274l0J05LRaPjYerfP/tyzkfJEzxrKcxR+ffz88/5v/vj9NIyTQUymh/BqIPUfBZgUJLxq7xRes765A0II/wGVOKOq");
        String str = "\n" +
                "                                                                                        .\n" +
                "                              |                     |      |                |     \\_____)\\_____\n" +
                "                              |      _` | __ \\   _` |  __| __ \\   _` |  __| |  /  /--v____ __`<\n" +
                "                              |     (   | |   | (   |\\__ \\ | | | (   | |      <           )/\n" +
                "                             _____|\\__,_|_|  _|\\__,_|____/_| |_|\\__,_|_|   _|\\_\\          '\n" +
                "\n" +
                "\n" +
                "\n";
        byte[] byteArr = str.getBytes(StandardCharsets.US_ASCII);
        ByteArrayOutputStream finalstream=new ByteArrayOutputStream();

        compressData(byteArr, finalstream);
        System.out.println(new String(finalstream.toByteArray()));

        String strr = Base64.getEncoder().encodeToString(finalstream.toByteArray());
        System.out.println(strr);

        byte[] compRaw=Base64.getDecoder().decode(strr);

        InputStream compInflate=new InflaterInputStream(new ByteArrayInputStream(compRaw));
        ByteArrayOutputStream finalStream=new ByteArrayOutputStream();
        int copyInt=0;
        while(copyInt!=-1) {
            try {
                copyInt=compInflate.read();
            } catch (IOException e) {
                e.printStackTrace();
                copyInt=-1;
            }
            if (copyInt==-1) {
                break;
            }
            finalStream.write(copyInt);
        }
        System.out.println(new String(finalStream.toByteArray()));

    }

    public static void compressData(byte[] data, OutputStream out)
            throws IOException {
        Deflater d = new Deflater();
        DeflaterOutputStream dout = new DeflaterOutputStream(out, d);
        dout.write(data);
        dout.close();
    }
}

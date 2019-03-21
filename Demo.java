
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Demo{

    public static void main(String[] args) throws IOException{
    System.setProperty("http.agent", "Chrome");

    final String SYM = "KO";

    URL url = new URL("https://www.google.com/search?q=google+finance+coca+cola&rlz=1C1CHBF_enSG763SG763&oq=google+&aqs=chrome.0.69i59j69i60l3j0j69i59.1558j1j7&sourceid=chrome&ie=UTF-8");

    URLConnection urlConnectionz = url.openConnection();

    InputStreamReader inStream = new InputStreamReader(urlConnectionz.getInputStream());

    BufferedReader bfr = new BufferedReader(inStream);

    String price = "not found";


    String line = bfr.readLine();

    while(line != null)
    {

        if(line.contains("[\"KO\","))
        {
            int target = line.indexOf("[\"KO\",");
            int deci = line.indexOf(".",target);
            int start= deci;
            while(line.charAt(start) != '\"')
            {
               start--;
            }

            price = line.substring(start + 1, deci +3);
        }
        line= bfr.readLine();
    }


    System.out.println(price);

  }
}

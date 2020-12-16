package com.cynoteck.pdflist;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    String[] cars ={"aaaa","aaaa"};
    WebView webView;
    ArrayList<String> cars = new ArrayList<>();
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cars.add("aaaa");
        cars.add("aaaaaa");
        cars.add("aaaa");
        cars.add("aaaaaa");
        cars.add("aaaa");
        cars.add("aaaaaa");
        cars.add("aaaa");
        cars.add("aaaaaa");
        jsonArray = new JSONArray(cars);
        Log.e("aaaaaa",jsonArray.toString());
        Log.e("aaaaaa",cars.toString());

        webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String str =pdfGenarator("","44","Male");
//        webView.loadUrl("file:///android_asset/immunization.html");

        webView.loadDataWithBaseURL("file:///android_asset/index.html",str,"text/html","utf-8",null);
        new Handler().postDelayed(new Runnable(){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                Context context=MainActivity.this;
                PrintManager printManager=(PrintManager)getSystemService(context.PRINT_SERVICE);
                PrintDocumentAdapter adapter=null;
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
                    adapter=webView.createPrintDocumentAdapter();
                }
                String JobName=getString(R.string.app_name) +"Document";
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
                    PrintJob printJob=printManager.print(JobName,adapter,new PrintAttributes.Builder().build());
                }
            }
        }, 3000);





    }

//    public static String toJavascriptArray(){
//
//
//        StringBuffer sb = new StringBuffer();
//        sb.append("[");
//        for(int i=0; i<cars.size(); i++){
//            sb.append("\"").append(cars.get(i)).append("\"");
//            if(i+1 < cars.size()){
//                sb.append(",");
//            }
//        }
//        sb.append("]");
//        return sb.toString();
//    }
    public String pdfGenarator(String strForA,String strAge,String strSex) {
        String care="Vet Care";
        String str = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
                "<script src=\"//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js\"></script>\n" +
                "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n" +
                "    \n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css\">\n" +
                "\n" +
                "    <title>Invioce</title>\n" +
                "</head>\n" +
                "<style type=\"text/css\">\n" +
                "    .invoice-title h2, .invoice-title h3 {\n" +
                "        display: inline-block;\n" +
                "    }\n" +
                "\n" +
                "    .table > tbody > tr > .no-line {\n" +
                "        border-top: none;\n" +
                "    }\n" +
                "\n" +
                "    .table > thead > tr > .no-line {\n" +
                "        border-bottom: none;\n" +
                "    }\n" +
                "\n" +
                "    .table > tbody > tr > .thick-line {\n" +
                "        border-top: 2px solid;\n" +
                "    }\n" +
                "    @page {\n" +
                "      size: A4;\n" +
                "      margin: 15px;\n" +
                "    }\n" +

                "  table {\n" +
        "      width: 100%;\n" +
        "      text-align: center;\n" +
        "   }\n" +
                "           th {\n" +
                "      width: 25%;\n" +
                "     background: #ffff;\n" +
                "    color: #808080;\n" +
                "     padding: 10px;\n" +
                "     border: 1px #000000 solid;\n" +
                "    border-radius: 1px;\n" +
                "  }\n" +

                "  td {\n" +
                "     width: 25%;\n" +
                "     padding: 10px;\n" +
                "    border: 1px #000000 solid;\n" +
                "   border-radius: 1px;\n" +
                "  }\n" +
                "</style>\n" +
                "\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <p><?=date('d/m/Y')?></p> \n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-xs-12\">\n" +
                "            <div class=\"invoice-title \">\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col-lg-12 col-md-12 col-xs-12\" style=\"font-size: 25px;font-family: cizel;\">\n" +
                "                       <b>" + "Ashish Rawat" + "</b> \n" +
                "                    </div>\n" +
                "                    <div class=\"col-lg-12 col-md-12 col-xs-12\" style=\"font-size: 20px; margin-bottom: 20px;\">\n" +
                "                        MBBS,MVS \n" +
                "                    </div>\n" +
                "                    <div class=\"col-lg-6 col-md-6 col-xs-6\" style=\"font-size: 20px; \" >\n" + care +
                "                       \n" +
                "                    </div>\n" +
                "                    <div class=\"col-lg-6 col-md-6 col-xs-6 text-right\" style=\"font-size: 20px;\">\n" +
                "                       <b> Mobile :" + "7351040497" + " </b>\n" +
                "                    </div>\n" +
                "                    \n" +
                "                    <div class=\"col-lg-6 col-md-6 col-xs-6\" style=\"font-size: 17px;\">\n" +
                "                       <b> Email: " + "ashishrawat6677@gmail.com" + " </b>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-lg-6 col-md-6 col-xs-6 text-right\" style=\"font-size: 20px;\">\n" +
                "                       <b> " + "9557207281" + "</b>\n" +
                "                    </div>\n" +
                "                 \n" +
                "                    \n" +
                "                </div>\n" +
                "               \n" +
                "                \n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-md-12\" style=\"border: 1px solid black;\"></div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-xs-3\" style=\"font-size: 20px;\">\n" +
                "                    <b>For a: " + strForA + "</b>\n" +
                "                </div>\n" +
                "                <div class=\"col-xs-3\" style=\"font-size: 20px;\">\n" +
                "                    <b>Age: " + strAge + "</b>\n" +
                "                </div>\n" +
                "                <div class=\"col-xs-3\" style=\"font-size: 20px;\">\n" +
                "                    <b>Sex: " + strSex + "</b>\n" +
                "                </div>\n" +
                "                <div class=\"col-xs-3\" style=\"font-size: 20px; margin-bottom: 25px;\">\n" +
                "                    <b>Date:"+"01-10-2020"+" <?=date('d/m/Y')?></b>\n" +
                "                </div>\n" +
                "\n" +
                "\n" +
                "                <div class=\"col-xs-12\" style=\"font-size: 20px; margin-bottom: 25px;\">\n" +
                "                    <b>Pet Parant Name:" + "Ritik Rawat" + "</b>\n" +
                "                </div>\n" +
                "<div id=\"output\">\n"+
        "</div>\n"+

                "            </div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n" +
                "            <div class=\"col-md-12\" style=\"border: 1px solid black;\"></div>\n" +
                "            <div class=\"col-md-12\" style=\"font-size: 25px; text-align: center;\">Address: " + "Dehradun" + ", Registration Number: " + "5029649285402" + "</div>\n" +
                "            \n" +
                "        </div>\n" +
                "\n" +
                "\n" +
                "    </div>\n" +
                "\n" +
                "</div>\n" +
                "<script type=\"text/javascript\">\n" +
                "    $(function(){\n" +
                "        window.print();\n" +
                "        window.close();\n" +
                "    });\n" +
                "</script>\n" +

                "<script>\n"+
                // Initializing arrays
//                "var users = new Array();\n"+
//               " var jsArray = new Array();\n"+
//        "    <% for(String element:"+jsonArray+"){\n"+
//        "      %> users[users.length] = <% element %>\n"+
//        "      <% } %>\n"+
//                "  for (var i = 0; i < users.lenght; i++) {\n"+
//                "users.push()\n"+
//                " }\n"+
                "var users="+jsonArray+";\n"+
//                "var users=['brad@gmail.com', 'sarah@gmail.com', 'steven@gmail.com'];\n"+
                "var ages = [35, 38, 56];\n"+
                "var emails = ['brad@gmail.com', 'sarah@gmail.com', 'steven@gmail.com'];\n"+
        // Getting output element
                "var output = document.getElementById('output');\n"+
        // Creating table tags
                "var table = \"<table><thead><tr><th>Immunization Date</th><th>Vaccine Class</th><th>Next Due Date</th></tr></thead><tbody>\";\n"+
                "  for (var i = 0; i < users.length; i++) {\n"+
                "table += \"<tr><td>\" + users[i] + \"</td><td>\" + users[i] + \"</td><td>\" + emails[i] + \"</td></tr>\";\n"+
                " }\n"+

                "  table += \"</tbody></table>\";\n"+

        // Binding output element with table var
                " output.innerHTML = table;\n"+
                "</script>\n"+

                "</body>\n" +
                "</html>";
        return str;
    }

}

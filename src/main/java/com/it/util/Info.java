package com.it.util;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.apache.poi.ss.usermodel.DateUtil;


public class Info {

    //public static String popheight = "alliframe.height=document.body.clientHeight+";
    public static String popheight = "alliframe.style.height=document.body.scrollHeight+";


    public static HashMap getUser(HttpServletRequest request) {
        HashMap map = (HashMap) (request.getSession().getAttribute("admin") == null ? request.getSession().getAttribute("user") : request.getSession().getAttribute("admin"));
        return map;
    }


    public static int getBetweenDayNumber(String dateA, String dateB) {
        long dayNumber = 0;
        //1小时=60分钟=3600秒=3600000
        long mins = 60L * 1000L;
        long day = 24L * 60L * 60L * 1000L;//计算天数之差
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = df.parse(dateA);
            Date d2 = df.parse(dateB);
            dayNumber = (d2.getTime() - d1.getTime()) / day;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (int) dayNumber;
    }


    public static int getBetweenMouthNumber(String dateA, String dateB) throws ParseException {
        int monthCount = 0;

        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();

        startCalendar.setTime(new SimpleDateFormat("yyyy-MM").parse(dateA));
        endCalendar.setTime(new SimpleDateFormat("yyyy-MM").parse(dateB));

        int year = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        int day = Math.abs(endCalendar.get(Calendar.DATE) - startCalendar.get(Calendar.DATE));

        if (year == 0 && month == 0){
            startCalendar.set(Calendar.DATE, 1);
            endCalendar.set(Calendar.DATE, 1);
            endCalendar.roll(Calendar.DATE, -1);
            if (day == (endCalendar.get(Calendar.DATE) - startCalendar.get(Calendar.DATE))) {
                monthCount = 1;// 两日期间满一个月
            } else {
                monthCount = 0;// 两日期间不足一个月
            }
        } else if (year != 0 && month == 0) {// 年份不同月份相同
            if (startCalendar.get(Calendar.DATE) < endCalendar.get(Calendar.DATE)) {// 两日期间的天数，小于等于当月
                monthCount = 1;
            }
            monthCount += year * 12 + month;
        } else {
            if (startCalendar.get(Calendar.DATE) >= endCalendar.get(Calendar.DATE)) {// 起始日期DATE 大于等于结束日期DATE
                monthCount = year * 12 + month;
            } else {
                monthCount = year * 12 + month + 1;
            }
        }
        return (int) monthCount;
    }




    public static String getFileUpInfo() {
        String jscode = "";
        jscode += "<script src=/vehiclemanagementsys/js/popup.js></script>";
        jscode += "<font onclick=\"uploaddoc()\" src=\"js/nopic.jpg\" style='cursor:hand' id=txt >点击此处上传</font>";
        jscode += "&nbsp;&nbsp;<input type=text readonly style='border:0px' size=30  name=\"docname\" id=\"docname\" value=\"\" />";
        return jscode;
    }

    public static String tform(HashMap map) {
        String jscode = "";
        try {
            jscode += "<script type=\"text/javascript\">\n";
            jscode += "function getPvalue()\n";
            jscode += "{\n";

            Set set = map.entrySet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String pm = ((Object) it.next()).toString();
                String str1 = "";
                String str2 = "";
                String[] strs = pm.split("=");
                str1 = strs[0];
                if (strs.length == 1) str2 = "";
                if (strs.length == 2) str2 = strs[1];
                str2 = str2.replaceAll("\r\n", "-----");

                if (!str1.equals("content")) {

                    jscode += " if(document.getElementsByName(\"" + str1 + "\").length>1)\n";
                    jscode += " {\n";
                    jscode += " var radios = document.getElementsByName(\"" + str1 + "\");\n";

                    jscode += " if(radios[0].type=='radio'){\n";
                    jscode += " for(var i=0;i<radios.length;i++)\n";
                    jscode += " {\n";
                    jscode += " if(radios[i].value==\"" + str2 + "\")\n";
                    jscode += " {\n";
                    jscode += " radios[i].checked=\"checked\";\n";
                    jscode += " }\n";
                    jscode += " }\n";
                    jscode += " }\n";


                    jscode += " if(radios[0].type=='checkbox'){\n";


                    jscode += " for(var i=0;i<radios.length;i++)\n";
                    jscode += " {\n";

                    jscode += " if(\"" + str2 + "\".indexOf(radios[i].value)>-1)\n";
                    jscode += " {\n";

                    jscode += " radios[i].checked=\"checked\";\n";


                    if (str2.indexOf(" - ") > -1) {
                        for (String strch : str2.split(" ~ ")) {

                            String strchname = strch.substring(0, strch.lastIndexOf(" - "));
                            jscode += " if(document.getElementsByName('" + strchname + "').length>0)\n";
                            jscode += " {\n";
                            jscode += " document.getElementsByName('" + strchname + "')[0].value='" + strch.substring(strch.lastIndexOf(":") + 1) + "';\n";
                            jscode += " }\n";


                        }
                    }


                    jscode += " }\n";
                    jscode += " }\n";
                    jscode += " }\n";

                    jscode += " if(radios.type=='select'){\n";
                    jscode += " f1." + str1 + ".value=\"" + str2 + "\";\n";
                    jscode += " }\n";


                    jscode += " }else{\n";
                    jscode += " if(f1." + str1 + ")\n";
                    jscode += "{\n";
                    jscode += "f1." + str1 + ".value=\"" + str2 + "\";\n";
                    jscode += "}\n";
                    jscode += "}\n";


                    jscode += "if(document.getElementById(\"txt\"))\n";
                    jscode += "{\n";
                    jscode += "document.getElementById(\"txt\").src=\"/vehiclemanagementsys/upfile/" + map.get("filename") + "\";\n";
                    jscode += "}\n";

                    jscode += "if(document.getElementById(\"txt2\"))\n";
                    jscode += "{\n";
                    jscode += "document.getElementById(\"txt2\").src=\"/vehiclemanagementsys/upfile/" + map.get("filename2") + "\";\n";
                    jscode += "}\n";

                    jscode += "if(document.getElementById(\"txt3\"))\n";
                    jscode += "{\n";
                    jscode += "document.getElementById(\"txt3\").src=\"/vehiclemanagementsys/upfile/" + map.get("filename3") + "\";\n";
                    jscode += "}\n";

                    jscode += "if(document.getElementById(\"txt4\"))\n";
                    jscode += "{\n";
                    jscode += "document.getElementById(\"txt4\").src=\"/vehiclemanagementsys/upfile/" + map.get("filename4") + "\";\n";
                    jscode += "}\n";

                    jscode += "if(document.getElementById(\"txt5\"))\n";
                    jscode += "{\n";
                    jscode += "document.getElementById(\"txt5\").src=\"/vehiclemanagementsys/upfile/" + map.get("filename5") + "\";\n";
                    jscode += "}\n";

                }
            }

            jscode += "}\n";


            jscode += " getPvalue();\n";
            jscode += "</script>\n";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jscode;
    }


    public synchronized static String getID() {
        Random random = new Random();
        StringBuffer ret = new StringBuffer(20);
        String rand = String.valueOf(Math.abs(random.nextInt()));
        ret.append(getDateStr());
        ret.append(rand.substring(0, 6));

        return ret.toString();
    }


    public static String getImgUpInfo(int height) {
        String jscode = "";
        jscode += "<img style=\"cursor: hand\" onclick=\"uploadimg()\" src=\"/vehiclemanagementsys/js/nopic.jpg\" id=txt height=\"" + height + "\"/>";
        jscode += "<input type=hidden name=\"filename\" id=\"filename\" value=\"\" />";
        jscode += "<script type=\"text/javascript\"  src=\"/vehiclemanagementsys/js/popups.js\"></script>";
        return jscode;
    }


    public static String getImgUpInfo2(int height) {
        String jscode = "";
        jscode += "<img style=\"cursor: hand\" onclick=\"uploadimg2()\" src=\"/vehiclemanagementsys/js/nopic.jpg\" id=txt2 height=\"" + height + "\"/>";
        jscode += "<input type=hidden name=\"filename2\" id=\"filename2\" value=\"\" />";
        jscode += "<script type=\"text/javascript\"  src=\"/vehiclemanagementsys/js/popup.js\"></script>";
        return jscode;
    }

    public static String getImgUpInfo3(int height) {
        String jscode = "";
        jscode += "<img style=\"cursor: hand\" onclick=\"uploadimg3()\" src=\"/vehiclemanagementsys/js/nopic.jpg\" id=txt3 height=\"" + height + "\"/>";
        jscode += "<input type=hidden name=\"filename3\" id=\"filename3\" value=\"\" />";
        jscode += "<script type=\"text/javascript\"  src=\"/vehiclemanagementsys/js/popup.js\"></script>";
        return jscode;
    }

    public static String getImgUpInfo4(int height) {
        String jscode = "";
        jscode += "<img style=\"cursor: hand\" onclick=\"uploadimg4()\" src=\"/vehiclemanagementsys/js/nopic.jpg\" id=txt4 height=\"" + height + "\"/>";
        jscode += "<input type=hidden name=\"filename4\" id=\"filename4\" value=\"\" />";
        jscode += "<script type=\"text/javascript\"  src=\"/vehiclemanagementsys/js/popup.js\"></script>";
        return jscode;
    }

    public static String getImgUpInfo5(int height) {
        String jscode = "";
        jscode += "<img style=\"cursor: hand\" onclick=\"uploadimg5()\" src=\"/vehiclemanagementsys/js/nopic.jpg\" id=txt5 height=\"" + height + "\"/>";
        jscode += "<input type=hidden name=\"filename5\" id=\"filename5\" value=\"\" />";
        jscode += "<script type=\"text/javascript\"  src=\"/vehiclemanagementsys/js/popup.js\"></script>";
        return jscode;
    }

    public static String fck(int height, String content) {
        String jscode = "<TEXTAREA   name=\"content\" id=\"content\">" + content + "</TEXTAREA>";
        jscode += "<script type=\"text/javascript\"  src=\"/vehiclemanagementsys/fckeditor/fckeditor.js\"></script>";
        jscode += "<script language=\"javascript\">";
        jscode += "function fckinit()";
        jscode += "{";
        jscode += " var of = new FCKeditor(\"content\");";
        jscode += "of.BasePath=\"/vehiclemanagementsys/fckeditor/\";";
        jscode += "of.Height = \"" + height + "\";";
        jscode += "of.ToolbarSet=\"Default\";";
        jscode += "of.ReplaceTextarea();";
        jscode += "}";
        jscode += "fckinit();";
        jscode += "</script>";

        return jscode;
    }


    public synchronized static String subStr(String source, int length) {
        if (source.length() > length) {
            source = source.substring(0, length) + "...";
        }

        return source;
    }


    public static String getDateStr() {
        String dateString = "";
        try {//yyyyMMddHHmmss
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date currentTime_1 = new Date();
            dateString = formatter.format(currentTime_1);
        } catch (Exception e) {
        }
        return dateString;
    }


    public static String getAutoId() {
        String dateString = "";
        try {//yyyyMMddHHmmss
            SimpleDateFormat formatter = new SimpleDateFormat("ddHHmmss");
            Date currentTime_1 = new Date();
            dateString = formatter.format(currentTime_1);
        } catch (Exception e) {
        }
        return dateString;
    }


    public static String getOrderNo() {
        String dateString = "";
        try {//yyyyMMddHHmmss
            SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
            Date currentTime_1 = new Date();
            dateString = formatter.format(currentTime_1);
        } catch (Exception e) {
        }
        return "DD" + dateString;
    }


    public static String getUTFStr(String str) {
        if (str == null) {
            return "";
        }

        try {
            str = new String(str.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }

    public static String getGBKStr(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return "";
        }
        return new String(str.getBytes("ISO-8859-1"), "GBK");
    }

    public static String getGB2312Str(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return "";
        }
        return new String(str.getBytes("ISO-8859-1"), "gb2312");
    }


    /**
     * 得到多少天之后之前的日期��
     */
    public static String getDay(String date, int day) {
        String b = date.substring(0, 10);
        String c = b.substring(0, 4);
        String d = b.substring(5, 7);
        String f = b.substring(8, 10);
        String aa = c + "/" + d + "/" + f;
        String a = "";
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        GregorianCalendar grc = new GregorianCalendar();
        grc.setTime(new Date(aa));
        grc.add(GregorianCalendar.DAY_OF_MONTH, day);
        String resu = dateFormat.format(grc.getTime());
        String t[] = resu.split("-");
        String sesuu = "";
        for (int i = 0; i < t.length; i++) {
            if (t[i].length() == 1) {
                t[i] = "0" + t[i];
            }
            sesuu += t[i] + "-";
        }

        return sesuu.substring(0, 10);
    }


    /**
     * 计算两个时期之间的天数
     */
    public static int dayToday(String DATE1, String DATE2) {
        int i = 0;
        if (DATE1.indexOf(" ") > -1)
            DATE1 = DATE1.substring(0, DATE1.indexOf(" "));
        if (DATE2.indexOf(" ") > -1)
            DATE2 = DATE2.substring(0, DATE2.indexOf(" "));

        String[] d1 = DATE1.split("-");
        if (d1[1].length() == 1) {
            DATE1 = d1[0] + "-0" + d1[1];
        } else {
            DATE1 = d1[0] + "-" + d1[1];
        }

        if (d1[2].length() == 1) {
            DATE1 = DATE1 + "-0" + d1[2];
        } else {
            DATE1 = DATE1 + "-" + d1[2];
        }

        String[] d2 = DATE2.split("-");
        if (d2[1].length() == 1) {
            DATE2 = d2[0] + "-0" + d2[1];
        } else {
            DATE2 = d2[0] + "-" + d2[1];
        }

        if (d2[2].length() == 1) {
            DATE2 = DATE2 + "-0" + d2[2];
        } else {
            DATE2 = DATE2 + "-" + d2[2];
        }


        for (int j = 0; j < 10000; j++) {
            i = j;
            String gday = Info.getDay(DATE1, j);
            if (gday.equals(DATE2)) {
                break;
            }
        }
        return i;
    }


    /**
     * 比较时间大小
     */
    public static String compare_datezq(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {

                return "big";
            } else if (dt1.getTime() < dt2.getTime()) {

                return "small";
            } else {
                return "den";
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "den";
    }

    /**
     * 过滤html代码
     */
    public static String filterStrIgnoreCase(String source, String from, String to) {
        String sourceLowcase = source.toLowerCase();
        String sub1, sub2, subLowcase1, subLowcase2;
        sub1 = sub2 = subLowcase1 = subLowcase2 = "";
        int start = 0, end;
        boolean done = true;
        if (source == null) return null;
        if (from == null || from.equals("") || to == null || to.equals(""))
            return source;
        while (done) {
            start = sourceLowcase.indexOf(from, start);
            if (start == -1) {
                break;
            }
            subLowcase1 = sourceLowcase.substring(0, start);
            sub1 = source.substring(0, start);
            end = sourceLowcase.indexOf(to, start);
            if (end == -1) {
                end = sourceLowcase.indexOf("/>", start);
                if (end == -1) {
                    done = false;
                }
            } else {
                end = end + to.length();
                subLowcase2 = sourceLowcase.substring(end, source.length());
                sub2 = source.substring(end, source.length());
                sourceLowcase = subLowcase1 + subLowcase2;
                source = sub1 + sub2;
            }
            //System.out.println(start+" "+end);
        }
        return source;
    }


    public static void delPic(String path, String img) {
        if (img != null) {
            if (!img.equals("")) {
                File file1 = new File(path + "/" + img);
                if (file1.exists()) {
                    file1.deleteOnExit();
                    file1.delete();
                }
            }
        }
    }


    //计算两个时间间隔多少小时
    public static Long getDatePoor(String stime, String etime) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long hournum = 0;
        try {
            Date startDate = df.parse(stime);
            Date endDate = df.parse(etime);
            long nd = 1000 * 24 * 60 * 60;
            long nh = 1000 * 60 * 60;
            long nm = 1000 * 60;
            // long ns = 1000;
            // 获得两个时间的毫秒时间差异
            long diff = endDate.getTime() - startDate.getTime();
            // 计算差多少天
            long day = diff / nd;
            // 计算差多少小时
            long hour = diff / nh;
            long y = diff % nh;
            //计算余分钟
            long b = y / (1000 * 60);
            // 计算差多少分钟
            long min = diff % nd % nh / nm;
            // 计算差多少秒//输出结果
            // long sec = diff % nd % nh % nm / ns;
            if (b > 30) {
                hournum = hour + 1;
            } else {
                hournum = hour;
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hournum;
    }


    //过滤html标签
    public static String delHTMLTag(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); //过滤

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); //过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); //过滤html标签


        htmlStr = htmlStr.replace("&nbsp;", "");

        return htmlStr.trim(); //返回文本字符串
    }


    //之前的时间用中文表示
    public static String getBeforeTime(String date1,String date2)
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = null;
        Date date = null;
        try {
            now = df.parse(date1);
            date = df.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String str ="";
        long l = now.getTime() - date.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

        if(day>30){
            str = day/30+"个月前";
        }

        if(day>7&&day<30){
            str = day/7+"周前";
        }

        if(day>0&&day<=7){
            str = day+"天前";
        }
        if(day<=0&&hour>0){
            str = hour+"小时前";
        }
        if(day<=0&&hour<=0&&min>0){
            str = min+"分钟前";
        }
        if(day<=0&&hour<=0&&min<=0){
            str="刚刚";
        }
        return str;
    }

}

		


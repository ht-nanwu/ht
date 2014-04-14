import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetUrlContent {
	
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {

		try {
			GetUrlContent a = new GetUrlContent();
			a.getUrlContent("青");
		} catch (Exception e) {

		}
	}
	
	public  String getUrlContent(String word) {

		BufferedReader in = null;
		List<String> result = null;
		String resultStr = "";
		try {
			//String url = "http://dict.hujiang.com/em/Android/jp/%E9%9D%92";
			//URL yahoo = new URL(URLEncoder.encode(url, "UTF-8"));
			//URL yahoo = new URL(url);
			URL yahoo = new URL("http://dict.hujiang.com/em/Android/jp/" + URLEncoder.encode(word, "UTF-8"));
			URLConnection yc = yahoo.openConnection();
			InputStream ins = yc.getInputStream();
			in = new BufferedReader(new InputStreamReader(ins));

			String inputLine;
			StringBuffer outPut = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				outPut.append(inputLine);
			}
			result = getMeaning(outPut.toString());

			if (result != null) {
				for (String eachRs : result) {
					resultStr = resultStr + eachRs + "\n";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return resultStr;
	}

	private static List<String> getMeaning(String str) {
		List<String> meaningList = new ArrayList<>();
		Pattern p = Pattern.compile("<div class=\"panel_comment\">(.*?)</div>");
		// Pattern p =
		// Pattern.compile("<div id=\"jp_com_panel_.*\" class=\"jp_explain\">(.*?)</div>");
		Matcher m = p.matcher(str);
		while (m.find()) {
			meaningList.add(formatStr(m.group(1).trim()));
		}
		return meaningList;
	}

	private static String formatStr(String str) {
		str = str.replaceAll("<img(.*?)/>", "");
		str = str.replaceAll("<br/>", "\n");
		return str;
	}
}

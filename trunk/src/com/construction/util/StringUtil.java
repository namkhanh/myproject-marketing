package com.construction.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * String Utility Class This is used to encode passwords programmatically
 * @author <a href="mailto:trunghien84@gmail.com">Huynh Trung Hien</a>
 */
public class StringUtil {
	private final static Log log = LogFactory.getLog(StringUtil.class);

	//~ Methods ================================================================

	/**
	 * Encode a string using algorithm specified in web.xml and return the
	 * resulting encrypted password. If exception, the plain credentials
	 * string is returned
	 *
	 * @param password Password or other credentials to use in authenticating
	 *        this username
	 * @param algorithm Algorithm used to do the digest
	 */
	public static String encodePassword(String password, String algorithm) {
		byte[] unencodedPassword = password.getBytes();

		MessageDigest md = null;

		try {
			// first create an instance, given the provider
			md = MessageDigest.getInstance(algorithm);
		} catch (Exception e) {
			log.error("Exception: " + e);

			return password;
		}

		md.reset();

		// call the update method one or more times
		// (useful when you don't know the size of your data, eg. stream)
		md.update(unencodedPassword);

		// now calculate the hash
		byte[] encodedPassword = md.digest();

		StringBuilder buf = new StringBuilder();

		for (int i = 0; i < encodedPassword.length; i++) {
			if ((encodedPassword[i] & 0xff) < 0x10) {
				buf.append("0");
			}

			buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
		}

		return buf.toString();
	}

	/**
	 * Encode a string using Base64 encoding. Used when storing passwords
	 * as cookies.
	 *
	 * This is weak encoding in that anyone can use the decodeString
	 * routine to reverse the encoding.
	 *
	 * @param str
	 * @return String
	 */
	public static String encodeString(String str)  {
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		return encoder.encodeBuffer(str.getBytes()).trim();
	}

	/**
	 * Decode a string using Base64 encoding.
	 */
	public static String decodeString(String str) {
		sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
		try {
			return new String(dec.decodeBuffer(str));
		} catch (IOException io) {
			throw new RuntimeException(io.getMessage(), io.getCause());
		}
	}

	public static void main(String[] args) {
		System.out.println("AAAAAAAAAAAA");
		long begin = System.currentTimeMillis();
		System.out.println(new File("//192.168.11.80/vatgia-data/products/images/main_1").list().length);
		long end = System.currentTimeMillis();
		System.out.println("EXECUTE TIMES: " + (end - begin));

		/*StringBuilder strIdCatalogueSubs = new StringBuilder("223,222,221,218,");
		strIdCatalogueSubs.deleteCharAt(strIdCatalogueSubs.length() - 1);
		System.out.println(strIdCatalogueSubs);
		Long reviewCount = 7L;
		Double sumRating = 26D;
		Long a = Math.round((sumRating / reviewCount) * 2);
		Double d = a.doubleValue()/2;
		Double rating = (Math.ceil((sumRating / reviewCount) * 2)) / 2;
		System.out.println(sumRating / reviewCount);
		System.out.println(d);
		System.out.println( rating );
		System.out.println( Math.rint( rating) );

		try {
			System.out.println(URLEncoder.encode("http://vatgia.com/pictures_fullsize/APO 50-150mm F2.8 EX DC HSM(Nikon use)402620.jpg", "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println(replaceVietnameseCharacters("    ----- Code 81B @#@*&(@&$(*&@(&$(*@&(*#&@:::::- ()Giường ngủ gỗ thông Elizabeth     "));

		long start = System.currentTimeMillis();
		String strDate = "2001/09/30 12:10:20";
		Date date = convertStringToDate(strDate, "yyyy/MM/dd HH:mm:ss");
		String strD = convertDateToString(date, "dd/MM/yyyy HH:mm:ss");
		System.out.println(date);
		System.out.println(strD);
		long end = System.currentTimeMillis();
		System.out.println("TOTAL: " + (end - start));*/
		// (84)875312
		// System.out.println("Phone Number: " + getShortPhoneNumber("(65)6.8720101"));
	}

	public static final String convertDateToString(Date date) {
		if (date != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			return simpleDateFormat.format(date);
		}
		return null;
	}

	public static final String convertDateToString(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			return simpleDateFormat.format(date);
		}
		return null;
	}

	public static final Date convertStringToDate(String dateSt) {
		if (dateSt != null) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
			try {
				return simpleDateFormat.parse(dateSt);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static final Date convertStringToDate(String dateSt, String pattern) {
		if (dateSt != null) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			try {
				return simpleDateFormat.parse(dateSt);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// Convert date from yyyy-mm-dd 00:00:00.0 format to dd/mm/yyyy format
	public static final String convertToCrossDate(String dateSt) {
		StringBuilder sb = new StringBuilder("");
		dateSt = dateSt.substring(0, dateSt.indexOf("00:00") - 1);
		while (dateSt.indexOf("-") != -1) {
			sb.append(dateSt.substring(dateSt.lastIndexOf("-") + 1, dateSt.length()));
			sb.append("/");
			dateSt = dateSt.substring(0, dateSt.lastIndexOf("-"));
		}
		sb.append(dateSt);
		return sb.toString();
	}

	public static final boolean isImage(String contentType) {
		if (contentType.indexOf("image") >= 0
				&& (contentType.indexOf("gif") >= 0 || contentType.indexOf("jpg") >= 0
						|| contentType.indexOf("jpeg") >= 0)) {
			return true;
		} else {
			return false;
		}
	}

	public static final String getRandomString(int length) {
		return Long.toString(Math.abs(new Random().nextLong()), 36).substring(0, length);
	}

	public static final String getRandomNumber(int length) {
		return (Math.abs(new Random().nextInt()) + "").substring(0, length);
	}

	/* FORMAT CHARACTER */
	public static String toUTF8(String isoString) {
		String utf8String = null;
		if (null != isoString && !isoString.equals("")) {
			try {
				byte[] stringBytesISO = isoString.getBytes("ISO-8859-1");
				utf8String = new String(stringBytesISO, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				utf8String = isoString;
			}
		} else {
			utf8String = isoString;
		}
		return utf8String;
	}

	public static final String convertToWebFormat(String originString) {
		if (originString != null && originString.length() > 0) {
			if (originString.indexOf("&") >= 0) {
				originString = originString.replaceAll("&amp;", "%26");
				originString = originString.replaceAll("&#039;", "%27");
				originString = originString.replaceAll("&quot;", "%22");
				originString = originString.replaceAll("&", "%26");
			}
			originString = originString.replaceAll("'", "%27");
			originString = originString.replaceAll("\"", "%22");
		}
		return originString;
	}

	public static final String convertSpecialCharacter(String originString) {
		if (!isEmpty(originString)) {
			//originString = originString.replaceAll("&", "&amp;");
			try {
				originString = originString.replaceAll("'", "&#039;");
				originString = originString.replaceAll("\"", "&quot;");
				//originString = originString.replaceAll("\\", "");
			} catch (PatternSyntaxException e) {
				e.printStackTrace();
			}
			//originString = originString.replaceAll("%26", "&amp;");
			//originString = originString.replaceAll("%27", "&#039;");
			//originString = originString.replaceAll("%22", "&quot;");
			return originString;
		}
		return "";
	}

	public static final String deConvertToWebFormat(String originString) {
		if (originString != null && originString.length() > 0) {
			if (originString.indexOf("&") >= 0) {
				originString = originString.replaceAll("&amp;", "&");
				originString = originString.replaceAll("&#039;", "'");
				originString = originString.replaceAll("&quot;", "\"");
			}
		}
		return originString;
	}

	public static String removeHTMLTags(String originString) {
		if (!isEmpty(originString)) {
			try {
				return originString.replaceAll("\\<.*?\\>", "");
			} catch (PatternSyntaxException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	/**
	 * Convert name for displaying in browser url
	 * @param originSt
	 */
	public static final String getBrowserUrlFormat(String originSt) {
		try {
			originSt = originSt.replaceAll(" &amp; ", "&");
			originSt = originSt.replaceAll(", ", ",");
			originSt = originSt.replaceAll(" ", "_");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return originSt;
	}

	public static final String formatUsername(String username) {
		return username.replaceAll("'", "''");
	}
	/* END FORMAT CHARACTER */

	/** @return pattern #,###,00 */
	public static final String formatNumber(Number number) {
		if (number != null) {
			NumberFormat nf = NumberFormat.getInstance();
			return nf.format(number);
		}
		return "";
	}

	public static Integer getIntValue(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
		}
		return null;
	}

	public static final String getPaymentCode(String firstString, String idMember) {
		StringBuilder sb = new StringBuilder(20);
		int remainLength = 7 - idMember.length();
		sb.append(firstString).append("-");
		sb.append(getRandomNumber(7)).append("-");
		sb.append(getRandomNumber(remainLength)).append(idMember);
		return sb.toString();
	}

	public static final boolean hasSpecialCharacters(String input) {
		Matcher matcher = Pattern.compile("['!@#$%^&*()\"]").matcher(input);
		return matcher.find();
	}

	/* GET ALIAS */
	public static final String getAliasFromUrl(String url) {
		String tmpUrl = url.substring(0, url.lastIndexOf("/"));
		tmpUrl = tmpUrl.substring(tmpUrl.lastIndexOf("/") + 1, tmpUrl.length());
		return tmpUrl;
	}

	public static final String getAliasFromUrlWithCoExt(String url) {
		return url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(".co"));
	}

	public static final String getServerUrl(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		sb.append("http://").append(request.getServerName());
		if (request.getServerPort() > 0) {
			sb.append(":").append(request.getServerPort());
		}
		if (!isEmpty(request.getContextPath())) {
			sb.append(request.getContextPath());
		}
		return sb.toString();
	}
	/* END GET ALIAS */

	public static boolean isEmpty(String value) {
		return value == null || "".equals(value);
	}

	public static String replaceVietnameseCharacters(String str) {
		if (!isEmpty(str)) {
			str = str.trim();
			str = str.toLowerCase();
			str = str.replaceAll("(-)+", " ");
			str = str.replaceAll("( )+", " ");
			str = str.trim();
			str = str.replaceAll(" ", "-");
			str = str.replaceAll("(?:à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ)", "a");
			str = str.replaceAll("(?:è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ)", "e");
			str = str.replaceAll("(?:ì|í|ị|ỉ|ĩ)", "i");
			str = str.replaceAll("(?:ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ)", "o");
			str = str.replaceAll("(?:ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ)", "u");
			str = str.replaceAll("(?:ỳ|ý|ỵ|ỷ|ỹ)", "y");
			str = str.replaceAll("(?:đ)", "d");
			str = str.replaceAll("[^a-z0-9-]", "");
			str = str.replaceAll("(-)+", "-");
			return str;
		}
		return "";
	}

	/*private int checkMainImageFolder() {
		int maxFiles = Integer.parseInt(XMLReader.readConfig("product", "maxImageFilesInFolder"));
		int result = -1;
		String mainImageFolderPattern = XMLReader.readConfig("product", "mainImageFolderPattern");
		for (int i = 1; i <= 1000000; i++) {
			File imageFolder = new File(this.imagesPath + "/" + mainImageFolderPattern.replace("?", String.valueOf(i)));
			if (!imageFolder.exists()) {
				imageFolder.mkdir();
			}
			if (imageFolder.listFiles().length < maxFiles) {
				result = i;
				// Release Memory
				imageFolder = null;
				break;
			}
		}
		// Release Memory
		mainImageFolderPattern = null;
		return result;
	}*/
}
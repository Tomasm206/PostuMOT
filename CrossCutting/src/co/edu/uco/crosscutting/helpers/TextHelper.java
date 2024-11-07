package co.edu.uco.crosscutting.helpers;

public class TextHelper {

	public static final String EMPTY ="";
	public static final String ONLY_LETTERS_SPACES="[A-Za-záÁéÉíÍóÓúÚñÑ ]*";
	
	private TextHelper() {
		
	}
	
	public static boolean patternIsValid(final String string, final String pattern) {
		return applyTrim(string).matches("^".concat(pattern).concat("$"));
	}
	
	public static boolean containsOnlyLettersAndSpaces(final String string) {
		return patternIsValid(string, ONLY_LETTERS_SPACES);
	}	
	
	public static String concat(final String...strings) {
		var sb = new StringBuilder(EMPTY);
		
		for (String string : strings) {
			sb.append(getDefault(string));
		}
		return sb.toString();
	}
	
	public static boolean isNull(final String string) {
		return ObjectHelper.isNull(string);
	}
	public static String getDefault(final String string) {
		return ObjectHelper.getDefault(string, EMPTY);
	}
	
	public static boolean isEmpty(final String string) {
		return EMPTY.equals(getDefault(string));
	}
	public static boolean isEmptyapplyingTrim(final String string) {
		return isEmpty(applyTrim(string));
	}
	public static String applyTrim(final String string) {
		return getDefault(string).trim();
	}
	public static int len(final String string) {
		return applyTrim(string).length();
	}
	public static boolean lenIsValid(final String string, final int min, final int max) {
		return minlenIsValid(string, min) && maxlenIsValid(string, max);
	}
	public static boolean minlenIsValid(final String string, final int min) {
		return NumericHelper.isGreatOrEqual(len(string), min);
	}	
	public static boolean maxlenIsValid(final String string, final int max) {
		return NumericHelper.isLessOrEqual(len(string), max);
	}

	public static String getDefault(String id, String defaultAsString) {
		// TODO Auto-generated method stub
		return null;
	}
}
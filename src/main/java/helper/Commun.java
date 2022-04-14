package helper;

import java.util.HashMap;
import java.util.Map;

public class Commun {
	public static String[] getArrayFromString(String path_params, String separator1) {

		String[] params = path_params.split(separator1);

		return params;
	}

	public static Map<String, String> getMapFromString(String path_params, String separator1, String separator2) {

		Map<String, String> MapParams = new HashMap<String, String>();

		String[] params = getArrayFromString(path_params, separator1);

		for (String param : params) {
			String[] paramKeyValue = param.split(separator2);
			String key = paramKeyValue[0];

			MapParams.put(key, (paramKeyValue[1]));
		}

		return MapParams;
	}

}

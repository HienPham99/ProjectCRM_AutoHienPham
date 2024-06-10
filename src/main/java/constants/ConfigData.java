package constants;

import helpers.PropertiesHelper;

public class ConfigData {
//    public static String URL = "https://crm.anhtester.com/admin/authentication";
//    public static String EMAIL = "admin@example.com";
//    public static String PASSWORD = "123456";
//    public static String EMAILProject = "project@example.com";
//    public static String PASSWORDProject = "123456";

    static {
        PropertiesHelper.loadAllFile();
    }

    public static String URL = PropertiesHelper.getValue("url");
    public static String EMAIL = PropertiesHelper.getValue("email");
    public static String PASSWORD = PropertiesHelper.getValue("password");
}

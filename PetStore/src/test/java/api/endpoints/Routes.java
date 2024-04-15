package api.endpoints;
//routes:https://petstore.swagger.io/v2/user
public class Routes {
		public static String base_url="https://petstore.swagger.io/v2";
		
		// for user module
		public static String post_url=base_url+"/user";
		public static String get_url=base_url+"/user/{username}";
		public static String put_url=base_url+"/user/{username}";
		public static String delete_url=base_url+"/user/{username}";
}

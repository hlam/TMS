package extjs;

public class Response {
	public boolean success;
	public String message;
    public Object data;
    public Response(boolean success, String message, Object data) {
    	this.success = success;
    	this.message = message;
    	this.data = data;
    	}
    public Response(boolean success, String message) {
    	this.success = success;
    	this.message = message;
    	}
    public Response(boolean success) {
    	this.success = success;
    	}
    public Response(boolean success,  Object data) {
    	this.success = success;
    	this.data = data;
    	}

}

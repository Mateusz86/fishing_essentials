package pl.mateusz.drozdz.fishing_essentials.core;

public class RestConnector extends AsyncTask<String,Void,JSONObject> {
	private int timeout = 30000;
	private HttpClient httpClient;
	private HttpPost httpPost;
	private HttpGet httpGet;
	private HttpResponse httpResponse;

	private String error;
	private String responseString = null;
	
	public RestConnector(){
		this.httpClient = new DefaultHttpClient();
	}

	@Override
	protected JSONObject doInBackground(String... arg0) {
		get(arg0[0]);
		return getResponseJSONObject();
	}
	
	
	@Override
	protected void onPostExecute(JSONObject result) {
		super.onPostExecute(result);
	}

	private void get(String url){
		System.out.println(url);
		this.httpGet = new HttpGet(url);
		this.httpClient.getParams().setParameter("http.socket.timeout", this.timeout);
		try {
			this.httpResponse = this.httpClient.execute(this.httpGet);
		} catch (UnsupportedEncodingException e) {
			this.error = e.getMessage();
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			this.error = e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
			this.error = e.getMessage();
			e.printStackTrace();
		}
	}	

	private String getError() {
		return this.error;
	}

	private String getResponseString(){
		if(this.httpResponse!=null){
			try {
				HttpEntity httpEntity = this.httpResponse.getEntity();
				InputStream is = httpEntity.getContent();
	            BufferedReader reader = new BufferedReader(
	            	new InputStreamReader(is, "utf-8"), 8);
	            StringBuilder sb = new StringBuilder();
	            String line = null;
	            while ((line = reader.readLine()) != null) {
	                sb.append(line + "\n");
	            }
	            is.close();
	            this.responseString = sb.toString();
	            return this.responseString;
	        } catch (Exception e) {
	        	this.error = e.getMessage();
	            Log.e("pnote", "Response string buffer error. " + e.getMessage());
	        }
		} 
		return null;
	}

	private JSONObject getResponseJSONObject(){
		String JSONString = this.getResponseString();
		if(JSONString != null)
			Log.i("pnote", JSONString);
		else Log.i("pnote", "JSONString is null");
		if(JSONString != null) {
			JSONObject jObj;
			try {
				jObj = new JSONObject(JSONString);
				return jObj;
			} catch (JSONException e) {
				this.error = e.getMessage();
				e.printStackTrace();
			}
		}
		return null;
	}

}

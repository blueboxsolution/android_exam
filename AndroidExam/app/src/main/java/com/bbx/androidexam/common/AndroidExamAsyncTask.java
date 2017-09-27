package com.bbx.androidexam.common;

public class AndroidExamAsyncTask extends android.os.AsyncTask<String, Integer, String> {
    private String url,jsonString;
    private AsyncTaskListener listener;


    public AndroidExamAsyncTask(String url, AsyncTaskListener listener) {
        this.url = url;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }
    @Override
    protected String doInBackground(String... params) {

        OkHttpHelper okHttpHelper = new OkHttpHelper();
        String result = okHttpHelper.getJSONFromUrl(url);
        return result;

    }
    @Override
    protected void onProgressUpdate(Integer... progress) {

    }


    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        listener.onTaskComplete(result);

    }



}

using System;
using Android.App;
using Android.OS;
using Android.Runtime;
using Android.Views;
using AndroidX.AppCompat.Widget;
using AndroidX.AppCompat.App;

using Google.Android.Material.FloatingActionButton;
using Google.Android.Material.Snackbar;
using Android.Widget;

namespace Temperature_converter
{
    [Activity(Label = "@string/app_name", Theme = "@style/AppTheme.NoActionBar", MainLauncher = true)]
    public class MainActivity : AppCompatActivity
    {

        Button btnCovertToCelcius;
        Button btnCovertToFahrenheit;
        TextView tvResult;
        EditText etTemperature;

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            Xamarin.Essentials.Platform.Init(this, savedInstanceState);
            SetContentView(Resource.Layout.activity_main);

            etTemperature = FindViewById<EditText>(Resource.Id.etTemperature);
            tvResult = FindViewById<TextView>(Resource.Id.tvResult);

            btnCovertToCelcius = FindViewById<Button>(Resource.Id.btnCovertToCelcius);
            btnCovertToFahrenheit = FindViewById<Button>(Resource.Id.btnCovertToFahrenheit);


            btnCovertToCelcius.Click += BtnCovertToCelcius_Click;
            btnCovertToFahrenheit.Click += BtnCovertToFahrenheit_Click;
        }

        private void BtnCovertToFahrenheit_Click(object sender, EventArgs e)
        {
            float temp = float.Parse(etTemperature.Text ?? "0");
            float fahren = (temp * 1.8f) + 32f;
            setResultValue(fahren, " degrees fahrenheit.");
        }

        private void BtnCovertToCelcius_Click(object sender, EventArgs e)
        {
            float temp = float.Parse(etTemperature.Text ?? "0");
            float celcius = (temp-32f)/1.8f;
            setResultValue(celcius, " degrees celsius.");
        }

        private void setResultValue(float result, string tempType)
        {
            tvResult.Text = result.ToString() + tempType;
        }
    }
}

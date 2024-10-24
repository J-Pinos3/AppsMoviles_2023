using Android.App;
using Android.OS;
using Android.Runtime;
using Android.Widget;
using AndroidX.AppCompat.App;
using System;

namespace CookieClicker
{
    [Activity(Label = "@string/app_name", Theme = "@style/AppTheme", MainLauncher = true)]
    public class MainActivity : AppCompatActivity
    {

        private int counter = 0;
        ImageButton ibCookie;
        TextView tvClickCounter;

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            SetContentView(Resource.Layout.activity_main);

            ibCookie = FindViewById<ImageButton>(Resource.Id.ibCookie);
            tvClickCounter = FindViewById<TextView>(Resource.Id.tvClickCounter);

            ibCookie.Click += BtnIncreaseClickCounter;
        }

        private void BtnIncreaseClickCounter(object sender, EventArgs e)
        {
            counter++;
            if (counter == 1)
            {
                tvClickCounter.Text = counter.ToString() + " click";
            }
            else
            {
                tvClickCounter.Text = counter.ToString() + " clicks";
            }
        }

    }
}
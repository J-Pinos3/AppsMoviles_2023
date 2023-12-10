using System;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;
using MyFirstFormsApp.Vistas;

namespace MyFirstFormsApp
{
    public partial class App : Application
    {
        public App()
        {
            InitializeComponent();

            MainPage =  new NavigationPage( new Menuprincipal() );
        }

        protected override void OnStart()
        {
        }

        protected override void OnSleep()
        {
        }

        protected override void OnResume()
        {
        }
    }
}

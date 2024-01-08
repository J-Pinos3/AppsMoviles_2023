using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace SpinPaint.Basics
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class BasicsHomePage : ContentPage
    {
        public BasicsHomePage()
        {
            InitializeComponent();
        }

        private async void btnSimpleCircle_Clicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new SimpleCirclePage());
        }

        private async void btnPulsatingEllipse_Clicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync (new PulsatingEllipsePage());
        }

        private async void btnOutlinedText_Clicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new OutlinedTextPage());
        }

        private async void btnFingerPaint_Clicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync( new FingerPaintingPage() );
        }
    }
}
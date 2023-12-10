using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace MyFirstFormsApp.Vistas
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class Convertir : ContentPage
    {
        private double cm;
        private double met;

        public Convertir()
        {
            InitializeComponent();
        }

        private void calcular()
        {
            //cm = Double.Parse( txtcm.Text.ToString() );
            if ( !(txtcm.Text.ToString() == null) )
            {
                cm = Convert.ToDouble(txtcm.Text.ToString());
                met = cm / 100.0;

                lblResultado.Text = met.ToString() + " m";
            }
            else
            {
                DisplayAlert("Error", "Ingrese un número por favor", "OK");
            }

        }

        private void btnVolver_Clicked(object sender, EventArgs e)
        {
            Navigation.PopAsync();
        }

        private void btnCalcular_Clicked(object sender, EventArgs e)
        {
            calcular();
        }
    }
}
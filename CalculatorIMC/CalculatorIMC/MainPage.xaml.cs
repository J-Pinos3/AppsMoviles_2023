using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace CalculatorIMC
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        private void Button_Clicked(object sender, EventArgs e)
        {

            if ( !string.IsNullOrEmpty(entAltura.Text) 
                && !string.IsNullOrEmpty(entPeso.Text) )
            {
                var altura = Double.Parse(entAltura.Text.ToString());
                var peso = Double.Parse(entPeso.Text.ToString());

                var imc = peso / Math.Pow(altura, 2);
                imc = Math.Round(imc, 2);

                entIMC.Text = "IMC: " + imc.ToString();

                string resultado = "";
                if (imc < 18.5)
                {
                    resultado = "Tiene bajo peso";

                }
                else if (imc >= 18.5 && imc <= 24.9)
                {
                    resultado = "Su peso es normal";
                }
                else if (imc >= 25 && imc <= 29.9)
                {
                    resultado = "Tiene sobre peso";
                }
                else
                {
                    resultado = "Tiene obesidad mórbida, ¡Cuídese!";
                }

                DisplayAlert("Resultado", resultado, "Ok");
            }
            else
            {
                DisplayAlert("Error", "Por favor llene todos los campos", "Cerrar");
            }

        }
    }
}

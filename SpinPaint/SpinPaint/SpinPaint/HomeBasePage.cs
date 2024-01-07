using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Input;
using Xamarin.Forms;

namespace SpinPaint
{
    public class HomeBasePage: ContentPage
    {
        public HomeBasePage()
        {
            NavigateCommand = new Command<Type>( async (Type pageType) =>
            {
                Page page = (Page) Activator.CreateInstance(pageType);
                await Navigation.PushAsync(page);
            });

            BindingContext = this;
        }

        public ICommand NavigateCommand { get; set; }

    }
}

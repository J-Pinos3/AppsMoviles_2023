using System;
using System.Collections.Generic;
using System.Text;
using Xamarin.Forms;

using SkiaSharp;
using SkiaSharp.Views.Forms;

namespace SpinPaint.Basics
{
    public class OutlinedTextPage: ContentPage
    {

        private SKCanvasView canvasView;
        private Entry textEntry;
        private Button drawButton;

        public OutlinedTextPage()
        {
            Title = "Outlined Text";
            canvasView = new SKCanvasView();
            canvasView.PaintSurface += OnCanvasViewPaintSurface;

            textEntry = new Entry
            {
                Placeholder = "Ingrese una palabra",
                HorizontalOptions = LayoutOptions.FillAndExpand,
                VerticalOptions = LayoutOptions.Center
            };

            drawButton = new Button
            {
                Text = "Pintar",
                HorizontalOptions = LayoutOptions.Center, 
                VerticalOptions = LayoutOptions.Center
            };

            drawButton.Clicked += DrawButton_Clicked;

            StackLayout stackLayout = new StackLayout
            {
                Children = { textEntry, drawButton, canvasView }
            };

            Content = stackLayout;
        }

        void OnCanvasViewPaintSurface(object sender, SKPaintSurfaceEventArgs args)
        {
            SKImageInfo info = args.Info;
            SKSurface surface = args.Surface;
            SKCanvas canvas = surface.Canvas;

            canvas.Clear();

            string text = textEntry.Text;

            if (string.IsNullOrEmpty(text))
                return;

            //skpaint object to display text
            SKPaint textPaint = new SKPaint
            {
                Style = SKPaintStyle.Stroke,
                StrokeWidth = 1,
                FakeBoldText = true,
                Color = SKColors.Blue
            };

            //adjust textsize property so text is 95% of screen
            float textWidth = textPaint.MeasureText(text);
            textPaint.TextSize = 0.7f * info.Width * textPaint.TextSize / textWidth;

            //text bounds
            SKRect textBounds = new SKRect();
            textPaint.MeasureText(text, ref textBounds);

            //offsets to center the text on the screen
            float xText = info.Width / 2 - textBounds.MidX;
            float yText = info.Height  - textBounds.MidY /4;

            //paint
            canvas.DrawText(text, xText, yText, textPaint);
        }

        private void DrawButton_Clicked(object sender, EventArgs e)
        {
            canvasView.InvalidateSurface();
        }
    }
}

public class ScreenManger {
    // cureent screen
    private Screen current_screen;

    // change screen and assing new screen. make it possible to access from othe
    // classes and change it
    public void set_screen(Screen screen) {
        this.current_screen = screen;
    }
    //show the current screen
    public void display_current_screen() {
        if (current_screen != null) {
            current_screen.show_screen();
        }
    }

}

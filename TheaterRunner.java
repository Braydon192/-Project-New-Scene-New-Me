import org.code.theater.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Create scene objects for past and present
    LastYear lastYear = new LastYear();
    ThisYear thisYear = new ThisYear();

    // Draw each scene before playing
    lastYear.drawScene();
    thisYear.drawScene();

    // Play both scenes in order
    Theater.playScenes(lastYear, thisYear);
    
  }
}

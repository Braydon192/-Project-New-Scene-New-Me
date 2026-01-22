import org.code.theater.*;
import org.code.media.*;

public class LastYear extends Scene {

  private String[] memories;
  private String[] lessons;
  private int textY;

  public LastYear() {
    memories = new String[] {
      "Hawaii",
      "Decorating Floats",
      "Playing games with friends"
    };
    lessons = FileReader.toStringArray("data1.txt");
    textY = 80;
  }

  public LastYear(String[] memories, String[] lessons) {
    this.memories = memories;
    this.lessons = lessons;
    textY = 80;
  }

  public void drawScene() {
    setFillColor("AQUA");
    drawRectangle(0, 0, 400, 400);

    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("2025 Recap", 120, 40);

    drawImage("download.png", 250, 60, 150);

    textY=150;
    displayArray(memories);
    pause(1);

    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("What I Learned in 2025: ", 90, textY + 20);
    textY += 40;

    displayArray(lessons);

    pause(2);
  }

  private void displayArray(String[] arr) {
    for (String item : arr) {
      drawText("- " + item, 50, textY);
      textY += 50;
    }
  }

  public int countLessons() {
    return lessons.length;
  }
}

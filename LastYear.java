import org.code.theater.*;
import org.code.media.*;

public class LastYear extends Scene {

  private String[] memories;
  private String[] lessons;
  private int textY;

  /**
   * Default constructor.
   * Initializes memories and loads lessons from a file.
   * Sets starting Y position for text.
   */
  public LastYear() {
    memories = new String[] {
      "Hawaii",
      "Decorating Floats",
      "Playing games with friends"
    };
    lessons = FileReader.toStringArray("data1.txt");
    textY = 80;
  }

  /**
   * Overloaded constructor.
   * Allows custom memories and lessons to be passed in.
   */
  public LastYear(String[] memories, String[] lessons) {
    this.memories = memories;
    this.lessons = lessons;
    textY = 80;
  }

  /**
   * Main scene method.
   * Draws background, title, image, memories list,
   * and lessons learned.
   */
  public void drawScene() {
    setFillColor("AQUA"); // background
    drawRectangle(0, 0, 400, 400);

    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("2025 Recap", 120, 40); // title

    drawImage("download.png", 250, 60, 150); // image

    textY = 150;
    displayArray(memories); // show memories
    pause(1);

    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("What I Learned in 2025: ", 90, textY + 20);
    textY += 40;

    displayArray(lessons); // show lessons

    pause(2);
  }

  /**
   * Displays all items in an array on the screen.
   * Each item is printed on a new line.
   */
  private void displayArray(String[] arr) {
    for (String item : arr) {
      drawText("- " + item, 50, textY);
      textY += 50; // move down each time
    }
  }

  /**
   * Returns the number of lessons stored.
   * Uses the length of the lessons array.
   */
  public int countLessons() {
    return lessons.length;
  }
}

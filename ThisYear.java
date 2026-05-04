import org.code.theater.*;
import org.code.media.*;

public class ThisYear extends Scene {

  private String[] goals;
  private String[] motivations;
  private int x;

  /**
   * Default constructor.
   * Initializes goals with preset values and loads motivations
   * from a text file. Also sets starting x position.
   */
  public ThisYear() {
    goals = new String[] {
      "Upgrade PC",
      "Get a Job",
      "Get better at Games"
    };
    motivations = FileReader.toStringArray("data2.txt");
    x = 40;
  }

  /**
   * Overloaded constructor.
   * Allows custom goals and motivations to be passed in.
   * Sets x position to default.
   */
  public ThisYear(String[] goals, String[] motivations) {
    this.goals = goals;
    this.motivations = motivations;
    x = 40;
  }

  /**
   * Main scene method.
   * Draws background, title, image, goals list,
   * and displays the strongest motivation.
   */
  public void drawScene() {
    setFillColor("GREEN"); // background color
    drawRectangle(0, 0, 400, 400);

    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("2026 Goals", 120, 80); // title

    drawImage("download-(2).png", 250, 60, 150); // image

    drawGoals(); // show goals list
    pause(1);

    drawMotivation(); // show strongest motivation

    pause(2);
  }

  /**
   * Draws each goal in the goals array.
   * Uses a loop to display bullet points vertically.
   */
  private void drawGoals() {
    int y = 150;
    x = 70; // adjust position
    
    for (int i = 0; i < goals.length; i++) {
      drawEllipse(x - 15, y - 12, 10, 10); // bullet point
      drawText(goals[i], x, y); // goal text
      y += 30; // move down
    }
  }

  /**
   * Finds the longest string in the motivations array.
   * Returns it as the strongest motivation.
   */
  public String getStrongestMotivation() {
    String longest = motivations[0];

    for (String m : motivations) {
      if (m.length() > longest.length()) {
        longest = m;
      }
    }
    return longest;
  }

  /**
   * Displays the strongest motivation on the screen.
   * Calls helper method to get the longest motivation.
   */
  private void drawMotivation() {
    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("Motivation: " + getStrongestMotivation(), 40, 275);
  }
}

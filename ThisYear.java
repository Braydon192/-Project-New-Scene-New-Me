import org.code.theater.*;
import org.code.media.*;

public class ThisYear extends Scene {

  private String[] goals;
  private String[] motivations;
  private int x;

  public ThisYear() {
    goals = new String[] {
      "Upgrade PC",
      "Get a Job",
      "Get better at Games"
    };
    motivations = FileReader.toStringArray("data2.txt");
    x = 40;
  }

  public ThisYear(String[] goals, String[] motivations) {
    this.goals = goals;
    this.motivations = motivations;
    x = 40;
  }

  public void drawScene() {
    setFillColor("GREEN");
    drawRectangle(0, 0, 400, 400);

    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("2026 Goals", 120, 80);

    drawImage("download-(2).png", 250, 60, 150);

    drawGoals();
    pause(1);

    drawMotivation();

    pause(2);
  }

  private void drawGoals() {
    int y = 150;
    x=70 ;
    
    for (int i = 0; i < goals.length; i++) {
      drawEllipse(x - 15, y - 12, 10, 10);
      drawText(goals[i], x, y);
      y += 30;
    }
  }

  public String getStrongestMotivation() {
    String longest = motivations[0];

    for (String m : motivations) {
      if (m.length() > longest.length()) {
        longest = m;
      }
    }
    return longest;
  }

  private void drawMotivation() {
    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("Motivation: " + getStrongestMotivation(), 40, 275);
  }
}

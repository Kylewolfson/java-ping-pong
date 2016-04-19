import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class PingPongTest {
  @Test
  public void PingPong_countUpToGivenNumber_Array() {
    PingPong testPingPong = new PingPong();
    ArrayList<Object> expected = new ArrayList<Object>();
    expected.add(1);
    expected.add(2);
    expected.add("Ping");
    expected.add(4);
    expected.add("Pong");
    expected.add("Ping");
    expected.add(7);
    expected.add(8);
    expected.add("Ping");
    expected.add("Pong");
    expected.add(11);
    expected.add("Ping");
    expected.add(13);
    expected.add(14);
    expected.add("PingPong");
    assertEquals(expected, testPingPong.pingPong(15));
  }
}

import com.fortysevendeg.scala.android.SampleActivity;

import org.junit.*;
import org.junit.runner.RunWith;
import org.robolectric.*;
import org.robolectric.annotation.*;

@RunWith(RobolectricTestRunner.class)
@Config(manifest="src/main/AndroidManifest.xml", emulateSdk = 18)
public class RoboTest {
    @Test
    public void testShouldSomethingSimple() {
        SampleActivity activity = Robolectric.setupActivity(SampleActivity.class);
        assert  activity.makeItButton().getText().toString().equals("make it");
    }

}
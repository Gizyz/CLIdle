package view.component;

import org.junit.jupiter.api.Test;
import view.BaseComponent;

import static org.junit.jupiter.api.Assertions.*;

class MainComponentTest {
    final int WIDTH = 50;
    final int HEIGHT = 20;
    final String NAME = "testTitle";
    BaseComponent testComponent = new BaseComponent(WIDTH, HEIGHT, NAME, true, true);
    @Test
    void getTitle() {
        assertEquals(NAME, testComponent.getTitle());
    }

    @Test
    void getWidth() {
        assertEquals(WIDTH, testComponent.getWidth());
    }

    @Test
    void getHeight() {
        assertEquals(HEIGHT, testComponent.getHeight());
    }

    @Test
    void setTitle() {
        String newtestName = "Garry";
        assertEquals(NAME, testComponent.getTitle());
        testComponent.setTitle(newtestName);
        assertEquals(newtestName, testComponent.getTitle());
    }

    @Test
    void appendContent() {
    }

    @Test
    void createBorderString() {
    }

    @Test
    void drawFrameView() {
        testComponent.drawFrameView();
    }
}
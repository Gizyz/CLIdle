package view;

public interface IFrameView {

    String getTitle();
    int getWidth();
    int getHeight();

    void setTitle(String titleName);
    void appendContent(String component);
    String createBorderString();

}

package view.component;

public interface IComponent {

    String getTitle();
    int getWidth();
    int getHeight();

    void setTitle(String titleName);
    void appendContent(IComponent component);
    String createComponentString(int margin);

}

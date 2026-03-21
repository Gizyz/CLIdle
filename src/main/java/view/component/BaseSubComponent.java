package view.component;

public abstract class BaseSubComponent implements IComponent{

    public BaseSubComponent() {

    }
    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setTitle(String titleName) {

    }

    @Override
    public void appendContent(IComponent component) {

    }

    @Override
    public String createComponentString(int margin) {
        return "";
    }
}

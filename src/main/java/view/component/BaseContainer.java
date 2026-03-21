package view.component;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseContainer implements IComponent {
    private String title;
    private int height;
    private int width;
    private boolean border;
    private boolean row;
    private List<IComponent> content = new ArrayList<>();

    public BaseContainer(int width, int height, String title, boolean border, boolean row) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.border = border;
        this.row = row;
    }


    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight()  { return this.height; }

    @Override
    public int getContent() { return this.content }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void appendContent(IComponent component) {
        this.content.add(component);
    }

    private String createBorder() {
        StringBuilder borderString = new StringBuilder();

        for (int y = 0; y < height; y++) {
            for (int x=0; x < width; x++) {

                if (y == 0 && x == 1) {
                    borderString.append("[ ").append(title).append(" ]");
                    x += title.length()+1;
                } else if (y == 0 || y == height-3) {
                    if(x==0 && y == 0) {
                        borderString.append("╔");}
                    else if(x==width-1 && y == 0) {
                        borderString.append("╗");}
                    else if(x==0 && y == height-1) {
                        borderString.append("╚");}
                    else if(x==width-1 && y == height-1) {
                        borderString.append("╝");
                    } else if (x < width-1){
                        borderString.append("═");}

                } else if (x == 0 || x == width-1) {
                    borderString.append("║");
                } else {
                    borderString.append(" ");
                }
            }
            borderString.append("\n");
        }
        return borderString.toString();
    }

    @Override
    public String createComponentString(int margin) {
        String strMargin = " ".repeat(margin);
        StringBuilder componentString = new StringBuilder();
        int height = findContentHeight();

        if(row) {
            for (int i = 0; i < content.size(); i++) {
                String[] lineList = content.get(i).getContent().split("\\r?\\n");

                for (int j = 0; j < lineList.length; j++) {
                    String line = lineList[j];
                    componentString.append(line).append(strMargin);

                }
            }
        } else {
            for (String part : content) {
                componentString.append(part).append("\n");
            }
        }
        if (border){
            String border = createBorder();
        }
        return null;
    }

    private int findContentHeight() {
        int height = 0;
        for (String part : content) {
            int tempHeight = part.split("\\r?\\n").length;
            if (tempHeight > height) height = tempHeight;
        }
        return height;
    }
}

package view;

import java.util.List;

public class mainFrameView implements IFrameView{
    private int height;
    private int width;
    private String title;

    private List<String> content;
    public mainFrameView(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void appendContent(String component) {
        content.add(component);
    }

    @Override
    public String createBorderString() {
        StringBuilder borderString = new StringBuilder();

        for (int y = 0; y < height; y++) {
            for (int x=0; x < width; x++) {

                if (y == 0 && x == 1) {
                    borderString.append(" ").append(title).append(" ");
                    x += title.length()+1;
                } else if (y == 0 || y == height-1) {
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
    public void drawFrameView() {
        String border = createBorderString();


    }
}

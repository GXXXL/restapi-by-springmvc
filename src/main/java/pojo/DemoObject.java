package pojo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class DemoObject {

    public DemoObject() {

    }

    public DemoObject(String title, String content) {
        this(-1L, title, content);
    }

    public DemoObject(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object that){
        return EqualsBuilder.reflectionEquals(this, that, "title", "content");
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this, "title", "content");
    }

    private long id;
    private String title;
    private String content;

}

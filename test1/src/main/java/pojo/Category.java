package pojo;

import java.util.List;

public class Category {
    private int id;
    private String typename;
    private List<Product> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                ", list=" + list +
                '}';
    }
}

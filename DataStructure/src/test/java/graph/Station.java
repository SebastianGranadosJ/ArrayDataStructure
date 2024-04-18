package graph;

import java.util.Objects;

public class Station {

    private String name;
    private String id;

    public Station(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    
    }

    @Override
    public String toString() {
        return "Station [name=" + name + ", id=" + id + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Station other = (Station) obj;
        return Objects.equals(id, other.id) && Objects.equals(name, other.name);
    }
    
    
}

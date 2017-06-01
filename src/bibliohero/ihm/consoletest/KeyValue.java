package bibliohero.ihm.consoletest;

/**
 * Created by jiolle.cdi04 on 01/06/2017.
 */
public class KeyValue {

    // Attributes
    private String key;
    private String value;

    // Getter / Setter
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // Constructeurs

    public KeyValue()
    {

    }

    public KeyValue(String key, String value)
    {
        this.key = key;
        this.value = value;
    }
}

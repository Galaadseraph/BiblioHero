package bibliohero.ihm.consoletest;

/**
 * Objet de type Clé/Valeur / Key/Value Object Type
 * Created by jiolle.cdi04 on 01/06/2017.
 */
public class KeyValue<keyType, valueType> {

    // Attributes
    private keyType key;
    private valueType value;

    // Getter / Setter
    public keyType getKey() {
        return key;
    }

    public void setKey(keyType key) {
        this.key = key;
    }

    public valueType getValue() {
        return value;
    }

    public void setValue(valueType value) {
        this.value = value;
    }

    // Constructeurs

    public KeyValue()
    {

    }

    public KeyValue(keyType key, valueType value)
    {
        this.key = key;
        this.value = value;
    }
}

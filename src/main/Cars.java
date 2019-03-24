package main;

/**
 * @author Wojciech Wasilewski
 * @date Created on 24.03.2019
 */
public class Cars {
    private String code;
    private String name;

    public Cars(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

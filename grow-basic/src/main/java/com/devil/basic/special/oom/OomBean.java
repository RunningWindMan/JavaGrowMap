package com.devil.basic.special.oom;

/**
 * oom实体
 *
 * @author Devil
 * @date Created in 2021/7/28 9:04
 */
public class OomBean {

    private Long id;

    private String name;

    public OomBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "OomBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

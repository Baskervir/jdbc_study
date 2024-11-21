package org.newsystem.container;

public class IocBean {

    private final Object value;

    public IocBean(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}

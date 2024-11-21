package org.newsystem.container;

public interface IocContainer {
    <T> T getIocBean(String name, Class<T> clazz);
}

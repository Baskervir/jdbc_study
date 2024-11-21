package org.newsystem.container;

import java.util.HashMap;
import java.util.Map;

public class SimpleIocContainer implements IocContainer {

    private Map<String, IocBean> contaioner = new HashMap<>();


    public SimpleIocContainer(ConfigurationMap map) {   //객체의 설계도가 담긴 녀석
        this.contaioner = map.createContainer();
    }

    @Override
    public <T> T getIocBean(String name, Class<T> clazz) {
        return clazz.cast(this.contaioner.get(name).getValue());
    }
}

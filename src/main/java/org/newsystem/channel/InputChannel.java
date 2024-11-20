package org.newsystem.channel;

/**
 * @apiNote 사용자로부터 요청을 입력받는 객체.
 * **/

public interface InputChannel {
    /**
     * @return
     * C (Create)
     *  add / actors?firstName...
     * R(Read)
     *  read
     * **/
    String listen();
//    String listen2();

}

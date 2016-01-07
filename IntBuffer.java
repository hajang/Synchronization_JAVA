/**
 * Created by Ha on 16. 1. 7..
 */
/*
    크기가 고정된 버퍼와 그 버퍼에 접근하기 위한 인덱스를 고유하는 생산자(producer) 스레드와
    소비자(consumer) 스레드를 작성하라 생산자는 버퍼에 숫자를 집어넣고 소비자는 숫자를 제거해야 한다.
    숫자가 추가되거나 제거되는 순서는 중요하지 않다.
 */


 /*
    추가 : 식사하는철학자 문제
       에츠허르 데이크스트라의 해결책은 다음과 같다.
       각각의 철학자를         P1, P2, P3, P4, P5라고 하고,
       각 철학자의 왼쪽 젓가락을 f1, f2, f3, f4, f5라고 하자.
       P5를 제외한 네 명은 먼저 fn를 집은 후 f{n-1}를 집는 방식을 취한다.
       그리고 P5는 이와 반대로, f1를 먼저 집은 후 f5를 집는다.
       이것은 원래 방식의 대칭성을 제거하고, 따라서 교착 상태를 막을 수 있다.

 */

public class IntBuffer {
    private int MAX_INDEX = 7;
    private int index = 0;
    private int data[] = new int[MAX_INDEX + 1];

    // 버퍼에 데이터를 추가하는 함수. 추가 이후에는 추가했다는걸 모두에게 알린다.
    public synchronized void add(int n) {
        // 버퍼가 포화상태라면 대기
        while(index == MAX_INDEX) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        data[index++] = n;
        notifyAll();
    }

    // 버퍼에서 데이터를 삭제 하는 함수. 삭제 이후에는 삭제했다는걸 모두에게 알린다.
    public synchronized int remove(){
        // 버퍼가 비어있다면 대기
        while(index == 0) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        int ret = data[--index];
        notifyAll();
        return ret;
    }

}

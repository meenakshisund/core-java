package generics;

class DtoObject<T> {

    private T data;

    DtoObject(T data) {
        this.data = data;
    }

    T getData() {
        return data;
    }

    void setData(T data) {
        this.data = data;
    }
}

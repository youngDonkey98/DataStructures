package com.donkey.utils;

/**
 * 将动态数组添加泛型
 * @param <E>
 */
public class Array<E> {

    private E[] data; //  数组
    private int size;   //  data中能够容纳的有效个数

    /**
     * 构造函数 传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     *  用户传入一个静态数组
     */
    public Array(E[] Arrays){
        int capacity = Arrays.length;
        size = capacity;
        data = (E[]) new Object[capacity];
        for (int i = 0; i < Arrays.length;i++){
            data[i] = Arrays[i];
        }
    }


    /**
     * 无参的构造函数 默认数组的容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素的个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组容量大小
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 数组是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在数组最后添加一个元素      Illegal : 不合法的
     */
    public void addLast(E e){
       /* if(size == data.length){
            throw new IllegalArgumentException("数组添加错误");
        }
        data[size] = e;
        size++;*/

        //复用add方法
        add(size,e);
    }

    /**
     * 在指定位置index添加一个元素e
     */
    public void add(int index ,E e){
        if(size == data.length){
            throw new IllegalArgumentException("数组添加错误");

        }

        if(index < 0 || index > size){
            throw new IllegalArgumentException("数组添加错误");
        }

        //数组中 从最后一个元素开始向后移动一下标 直到指定的插入的下标
        for(int i = size - 1;i >= index;i--){
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     *  在数组头添加一个元素
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 获取最后第一个元素
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获得index位置的元素
     */
    E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("获取失败，下标不合法");
        }
        return data[index];
    }

    /**
     * 修改指定index的元素
     */
    void set(int index ,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("获取失败，下标不合法");
        }
        data[index] = e;
    }

    /**
     * 查看数组中 是否有元素e
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查看当前元素在数组中的第一个下标
     * 如果不存在 返回-1
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查看当前数组中存在多少个指定元素
     * @param e
     * @return  如果不存在 则返回 0
     */
    public int findAll(E e) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 从数组中 删除 index位置的元素 返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("指定的下标不合法");
        }

        E ret = data[index];
        // 将后面的元素 向前移一位
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        return ret;
    }

    /**
     * 删除第一个元素
     * @return  返回删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return  返回删除的元素
     */
    public E removerLast() {
        return remove(size-1);
    }

    /**
     * 找到某个元素 如果存在 则删除它（数组中第一个e）
     * @param e 删除指定的元素
     * @return  存在 返回true 不存在 返回false
     */
    public boolean removerElement(E e) {
        // 是否存在想删除的元素
        int index = find(e);
        if(index != 1){
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * 找到指定元素 如果存在 则删除数组中的所有的它
     * @param e 期望删除的元素
     * @return  被删除的元素个数 如果数组中不存在 则返回 0
     */
    public int removerAllElement(E e) {
        // 计数器
        int count = 0;
        for (int i = 0; i < size; i++) {
            boolean res = removerElement(e);
            if (res == true) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder ruslt = new StringBuilder();
        ruslt.append(String.format("Array : size = %d ,capacity = %d \n" , size ,data.length));
        ruslt.append("[");
        for (int i = 0; i < size; i++) {
            ruslt.append(data[i]);
            //如果不是最后一个元素
            if(i != size -1){
                ruslt.append(", ");
            }
        }
        ruslt.append("]");

        return ruslt.toString();
    }


}

package ru.vsu.kulikov.Table;

public class TableCell<T> {
    private T value;
    private int row, column;
    private TableCell<T> prev, next;

    public TableCell(T value, int row, int column, TableCell<T> prev, TableCell<T> next) {
        this.value = value;
        this.row = row;
        this.column = column;
        this.prev = prev;
        this.next = next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setPrev(TableCell<T> prev) {
        this.prev = prev;
    }

    public void setNext(TableCell<T> next) {
        this.next = next;
    }

    public String getStringValue() {
        if (value == null) {
            return "null";
        }
        return value.toString();
    }


    public T getValue() {
        return value;
    }

    public TableCell<T> getPrev() {
        return prev;
    }

    public TableCell<T> getNext() {
        return next;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}

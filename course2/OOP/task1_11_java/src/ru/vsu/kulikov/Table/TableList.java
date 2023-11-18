package ru.vsu.kulikov.Table;


public class TableList<Object> {
    TableCell<Object> head = null;
    TableCell<Object> tail = null;
    private int length = 0;

    public void insertLastCell(int row, int column, Object value) {
        if (tail == null) {
            TableCell<Object> cell = new TableCell<>(value, row, column, null, null);
            head = cell;
            tail = cell;
            length += 1;
        } else {
            TableCell<Object> cell = new TableCell<>(value, row, column, tail, null);
            tail.setNext(cell);
            tail = cell;
            length += 1;
        }
    }
    public void insertFirstCell(int row, int column, Object value) {
        if (head == null) {
            TableCell<Object> cell = new TableCell<>(value, row, column, null, null);
            head = cell;
            tail = cell;
            length += 1;
        } else {
            TableCell<Object> cell = new TableCell<>(value, row, column, null, head);
            head.setPrev(cell);
            head = cell;
            length += 1;
        }
    }

    public int getLength() {
        return length;
    }

    public void printTableAsList() {
        TableCell<Object> curr = head;
        String str = "";
        str += "[";
        if (curr == null) {
            str += "null]";
        } else {
            while (curr.getNext() != null) {
                str += curr.getValue()  + "; ";
                curr = curr.getNext();
            }
            str += curr.getValue() + "]";
        }
        System.out.println(str);
    }

    public Object findCellValue(int row, int column) {
        TableCell<Object> curr = head;
        while (curr != null) {
            if (curr.getRow() == row && curr.getColumn() == column) {
                return curr.getValue();
            }
            curr = curr.getNext();
        }
        return null;
    }

    public TableList<Object> findValuesInRangeOfCells(int row0, int column0, int row1, int column1) {
        TableList<Object> table_in_range = new TableList();
        if (row0 <= row1 && column0 <= column1) {
            for (int i = 0; i <= row1 - row0; i++) {
                for (int j = 0; j <= column1 - column0; j++) {
                    table_in_range.insertLastCell(i, j, findCellValue(i + row0, j + column0));
                }
            }
        } else {
            System.out.println("Неверно указаны границы диапозона: ");
        }
        return table_in_range;
    }

    public Object deleteFirst() {
        if (head == null) {
            return null;
        }
        Object result = head.getValue();
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        length -= 1;
        return result;
    }

//    public TableList sortTable() {
//        TableList sortedTable = new TableList();
//        int rows = 0, columns = 0;
//        TableCell<Object> curr = head;
//        for (int i = 0; i < length; i++) {
//            rows = Math.max(rows, curr.getRow());
//            columns = Math.max(columns, curr.getColumn());
//            curr = curr.getNext();
//        }
//        for (int i = 0; i <= rows; i++) {
//            for (int j = 0; j <= columns; j++) {
//                sortedTable.insertLastCell(i, j, findCellValue(i, j));
//            }
//        }
//        return sortedTable;
//    }

    /**
     * Этапы сортировки:
     * 1) Определение границ списка.
     * 2) Запись длины изначального списка len для удаления дублированных ячеек.
     * 3) Инициализация итератора for для перебора индексов с (0;0) до границ таблицы (columns; rows).
     *
     * 4) Переход на нужный индекс.
     * 5) Поиск ячейки с таким же значением индексов в памяти.
     * 6) Вставка значения в конец списка.
     *
     * 7) п.4 - п.7 выполняются в соответствии с п.3 (rows*columns == n_значений_в_списке раз)
     * 8) Удаление начальных элементов посредством удаления первых элементов len раз (см. п.2)
     */
    public void sortTable() {
        int rows = 0, columns = 0;
        TableCell<Object> curr = head;
        for (int i = 0; i < length; i++) {
            rows = Math.max(rows, curr.getRow());
            columns = Math.max(columns, curr.getColumn());
            curr = curr.getNext();
        }
        int len = length;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= columns; j++) {
                insertLastCell(i, j, findCellValue(i, j));
            }
        }
        for (int i = 0; i < len; i++) {
            deleteFirst();
        }
    }

    public void printTable() {
        /**
         * Сортировка таблицы для корректного отображения.
         */
        sortTable();

        /**
         * Определение границ таблицы. Верхняя левая ячейка: A(0; 0), Правая нижняя ячейка: B(columns; rows)
         */
        int rows = 0, columns = 0;
        TableCell<Object> curr = head;
        for (int i = 0; i < length; i++) {
            rows = Math.max(rows, curr.getRow());
            columns = Math.max(columns, curr.getColumn());
            curr = curr.getNext();
        }

        /**
         * Определение максимальной длины ячйки в символах. Длина ячейки = 2 пробела слева + длина самого длинного
         * значения ячейки в строковом представлении + 2 пробела справа. Для ячеек, длина значения которых меньше длины
         * самого длинного значения, печать происходит следующим образом: "|  " + cell.value + " "*a + "|", где:
         * a = cell_length - (2 + cell.value.toString().length())
         */
        int cell_length = 0;
        curr = head;
        while (curr != null) {
            cell_length = Math.max(cell_length, curr.getStringValue().length());
            curr = curr.getNext();
        }
        cell_length += 4;

        /**
         * Печать таблицы в консоль. Последняя строка печатается отдельно.
         */
        curr = head;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= columns; j++) {
                System.out.print("+");
                for (int a = 0; a < cell_length; a++) {
                    System.out.print("-");
                }
            }
            System.out.println("+");
            for (int j = 0; j <= columns; j++) {
                System.out.print("|  " + curr.getValue());
                for (int a = 0; a < cell_length - curr.getStringValue().length() - 2; a++) {
                    System.out.print(" ");
                }
                curr = curr.getNext();
            }
            System.out.println("|");
        }
        /**
         * Печать последней строки.
         */
        for (int j = 0; j <= columns; j++) {
            System.out.print("+");
            for (int a = 0; a < cell_length; a++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
        for (int j = 0; j <= columns; j++) {
            System.out.print("|  " + curr.getValue());
            for (int a = 0; a < cell_length - curr.getStringValue().length() - 2; a++) {
                System.out.print(" ");
            }
            curr = curr.getNext();
        }
        System.out.println("|");
        for (int j = 0; j <= columns; j++) {
            System.out.print("+");
            for (int a = 0; a < cell_length; a++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }

    public static void TableTest(int test) {
        if (test == 1) {
            System.out.println("/****************************************************/");
            System.out.println("/****************    Table test 1    ****************/");
            System.out.println("/****************************************************/");
            System.out.println("\n");

            TableList<Integer> test_table = new TableList<>();
            test_table.insertLastCell(2, 2, 9);
            test_table.insertLastCell(0, 0, 1);
            test_table.insertLastCell(1, 2, 6);
            test_table.insertLastCell(0, 1, 2);
            test_table.insertLastCell(0, 2, 3);
            test_table.insertLastCell(2, 1, 8);
            test_table.insertLastCell(1, 0, 4);
            test_table.insertLastCell(1, 1, 5);
            test_table.insertLastCell(2, 0, 7);

            test_table.printTableAsList();
            test_table.printTable();

            System.out.println();
        }
        if (test == 2) {
            System.out.println("/****************************************************/");
            System.out.println("/****************    Table test 2    ****************/");
            System.out.println("/****************************************************/");
            System.out.println("\n");

            TableList<String> test_table = new TableList<>();
            test_table.insertLastCell(0, 0, "name");
            test_table.insertLastCell(2, 1, "Разин");
            test_table.insertLastCell(2, 0, "Степан");
            test_table.insertLastCell(0, 1, "surname");
            test_table.insertLastCell(1, 0, "Игорь");
            test_table.insertLastCell(0, 2, "age");
            test_table.insertLastCell(1, 2, "64");
            test_table.insertLastCell(2, 2, "3");
            test_table.insertLastCell(1, 1, "Кривоусов");

            test_table.printTableAsList();
            test_table.printTable();

            System.out.println();
        }
        if (test == 3) {
            System.out.println("/****************************************************/");
            System.out.println("/****************    Table test 3    ****************/");
            System.out.println("/****************************************************/");
            System.out.println("\n");

            TableList<Double> test_table = new TableList<>();
            test_table.insertLastCell(0, 0, 0.0);
            test_table.insertLastCell(2, 1, 9.123);
            test_table.insertLastCell(2, 0, null);
            test_table.insertLastCell(0, 1, 0.0);
            test_table.insertLastCell(1, 0, null);
            test_table.insertLastCell(0, 2, null);
            test_table.insertLastCell(1, 2, 64.89);
            test_table.insertLastCell(2, 2, null);
            test_table.insertLastCell(1, 1, 9.76);

            test_table.printTableAsList();
            test_table.printTable();

            System.out.println();
        }
        if (test == 4) {
            System.out.println("/****************************************************/");
            System.out.println("/****************    Table test 4    ****************/");
            System.out.println("/****************************************************/");
            System.out.println("\n");

            TableList<Integer> test_table = new TableList<>();
            test_table.insertLastCell(2, 2, 9);
            test_table.insertLastCell(0, 0, 1);
            test_table.insertLastCell(1, 2, 6);
            test_table.insertLastCell(0, 1, 2);
            test_table.insertLastCell(0, 2, 3);
            test_table.insertLastCell(2, 1, 8);
            test_table.insertLastCell(1, 0, 4);
            test_table.insertLastCell(1, 1, 5);
            test_table.insertLastCell(2, 0, 7);

            test_table.printTableAsList();
            test_table.printTable();

            System.out.println();
            test_table.findValuesInRangeOfCells(1, 1, 2, 2).printTable();
            test_table.findValuesInRangeOfCells(1, 1, 1, 1).printTable();
            test_table.findValuesInRangeOfCells(0, 2, 2, 0).printTable();
            test_table.findValuesInRangeOfCells(0, 2, 2, 2).printTable();
        }
    }
}

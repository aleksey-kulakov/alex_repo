package ua.itea.javaAdvanced.practice.lesson04.MyTreeMap;

import java.util.TreeMap;

/**
 * Реализация MyTreeMap на основе бинарного дерева
 *
 * @author Aleksey Kulakov a_kulakov@ukr.net
 * @version 1.0
 * @since 09.02.2017.
 */
public class MyTreeMap<K extends Comparable<K>, V> {

    private Rec root;

    private class Rec{              //внутренний класс записи
        private K key;              //ключ записи
        private V value;            //значение записи
        private Rec left, right;    //ссылки на левую и правую подЗапись
        private int rCount;         //количество записей в поддереве с этим корнем

        public Rec(K key, V value, int rCount){
            this.key = key;
            this.value = value;
            this.rCount = rCount;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Rec rec){
        if (rec == null){
            return 0;
        }
        return rec.rCount;
    }

    public V get(K key){
        return get(root, key);
    }

    private V get(Rec rec, K key){
        if (rec == null){
            return null;
        }
        int comparisonValue = key.compareTo(rec.key);
        if (comparisonValue < 0){
            return get(rec.left, key);
        } else if (comparisonValue > 0){
            return get(rec.right, key);
        } else {
            return rec.value;
        }
    }

    public void put(K key, V value){
        root = put(root, key, value);
    }

    private Rec put(Rec rec, K key, V value){
        if (rec == null){
            return new Rec(key, value, 1);
        }
        int comparisonValue = key.compareTo(rec.key);
        if (comparisonValue < 0){
            rec.left = put(rec.left, key, value);
        } else if (comparisonValue > 0){
            rec.right = put(rec.right, key, value);
        } else {
            rec.value = value;
        }
        rec.rCount = size(rec.left) + size(rec.right) + 1;
        return rec;
    }

    public void removeMin(){
        root = removeMin(root);
    }

    private Rec removeMin(Rec rec){
        if(rec.left == null){
            return rec.right;
        }
        rec.left = removeMin(rec.left);
        rec.rCount = size(rec.left) + size(rec.right) + 1;
        return rec;
    }

    public void removeMax(){
        root = removeMax(root);
    }

    private Rec removeMax(Rec rec){
        if(rec.right == null){
            return rec.left;
        }
        rec.right = removeMin(rec.right);
        rec.rCount = size(rec.left) + size(rec.right) + 1;
        return rec;
    }

    public void remove(K key){
        root = remove(root, key);
    }

    private Rec remove(Rec rec, K key){
        if (rec == null){
            return null;
        }
        int comparisonValue = key.compareTo(rec.key);
        if (comparisonValue < 0){
            rec.left = remove(rec.left, key);
        } else if (comparisonValue > 0){
            rec.right = remove(rec.right, key);
        } else {
            if(rec.right == null){
                return rec.left;
            }
            if(rec.left == null){
                return rec.right;
            }
            Rec temp = rec;
            rec = firstKey(temp.right);
            rec.right = removeMin(temp.right);
            rec.left = temp.left;
        }
        rec.rCount = size(rec.left) + size(rec.right) + 1;
        return rec;
    }

    public K firstKey(){
        return firstKey(root).key;
    }

    private Rec firstKey(Rec rec){
        if (rec.left == null){
            return rec;
        }
        return firstKey(rec.left);
    }

    public K lastKey(){
        return lastKey(root).key;
    }

    private Rec lastKey(Rec rec){
        if (rec.right == null){
            return rec;
        }
        return lastKey(rec.right);
    }

    public void clear(){

    }

    public void print(){
        print(root);
    }

    private void print(Rec rec){
        if (rec == null){
            return;
        }
        print(rec.left);
        System.out.println(rec.key);
        print(rec.right);
    }


    /*public String toString(){
        String out = "";

        return "";
    }*/
}

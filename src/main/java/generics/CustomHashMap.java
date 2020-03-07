package generics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

class CustomHashMap<K extends Number, V> {

    private Logger logger = Logger.getLogger(CustomHashMap.class.getName());

    private HashMap<K, V> map = new HashMap<>();

    void insert(K key, V value){
        map.put(key, value);
    }

    void retrieve(K key){
        logger.info("Retrieving Value for " + key + " " + key.getClass() + " : ");
        //System.out.print("Retrieving Value for " + key + " " + key.getClass() + " : ");
        System.out.println(map.get(key));
    }

    void print(){
        printAllValues();
        printAllKeys();
        printAllVals();
        printWhileIterator();
        printUsingJava8();
    }

    private void printAllValues(){
        System.out.println("Printing all Values for : ");
        for(Map.Entry<K, V> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    private void printAllKeys(){
        System.out.println("Printing all Keys for : ");
        for(K key : map.keySet())
            System.out.println(key);
    }

    private void printAllVals(){
        System.out.println("Printing all Vals for : ");
        for(V value : map.values())
            System.out.println(value);
    }

    private void printWhileIterator(){
        System.out.println("Printing all Entries using Iterator : ");
        Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<K, V> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private void printUsingJava8(){
        System.out.println("Printing all Entries using Java8 BiConsumer/forEach : ");
        map.forEach((k,v) -> System.out.println(k+" : "+v));
    }
}

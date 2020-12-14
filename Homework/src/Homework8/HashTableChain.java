package Homework8;

import java.util.*;

/**
 * HashTable implementation using chaining to tack a pair of key and value pairs.
 * @param <K> Generic Key
 * @param <V> Generic Value
 */
public class HashTableChain<K, V> implements Map<K, V>  {

    private LinkedList<Entry<K, V>>[] table ;
    private  int numKeys ;
    private static final int CAPACITY = 101 ;
    private static final double LOAD_THRESHOLD = 1.5 ;

    ///////////// ENTRY CLASS ///////////////////////////////////////

    /**
     * Contains key-value pairs for HashTable
     * @param <K> the key
     * @param <V> the value
     */
    private static class Entry<K, V> implements Map.Entry<K, V>{
        private K key ;
        private V value ;

        /**
         * Creates a new key-value pair
         * @param key the key
         * @param value the value
         */
        public Entry(K key, V value) {
            this.key = key ;
            this.value = value ;
        }

        /**
         * Returns the key
         * @return the key
         */
        public K getKey() {
            return  key;
        }

        /**
         * Returns the value
         * @return the value
         */
        public V getValue() {
            return value ;
        }

        /**
         * Sets the value
         * @param val the new value
         * @return the old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val ;
            return oldVal ;
        }
        @Override
        public String toString() {
            return  key + "=" + value  ;
        }



    }

    ////////////// end Entry Class /////////////////////////////////

    ////////////// EntrySet Class //////////////////////////////////

    /**
     * Inner class to implement set view
     */
    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {


        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new SetIterator();
        }

        @Override
        public int size() {
            return numKeys ;
        }
    }

    ////////////// end EntrySet Class //////////////////////////////

    //////////////   SetIterator Class ////////////////////////////

    /**
     * Class that iterates over the table. Index is table location
     * and lastItemReturned is entry
     */
    private class SetIterator implements Iterator<Map.Entry<K, V>> {

        private int index = 0 ;
        private Entry<K,V> lastItemReturned = null;
        private Iterator<Entry<K, V>> iter = null;

        @Override
        public boolean hasNext() {
        	// FILL HERE
        	if(iter != null) {
        		return iter.hasNext();
        	}
        	return false;
        	
        }

        @Override
        public Map.Entry<K, V> next() {
        	// FILL HERE
			if(iter.hasNext()) {
				lastItemReturned = iter.next();
				return lastItemReturned;
			} else 
				throw new NoSuchElementException();
        }

        @Override
        public void remove() {
        	// FILL HERE
        	if(lastItemReturned == null) {
        		throw new IllegalStateException();
        	} else {
        		iter.remove();
        		index--;
        		
        	}
        }
    }

    ////////////// end SetIterator Class ////////////////////////////

    /**
     * Default constructor, sets the table to initial capacity size
     */
    public HashTableChain() {
        table = new LinkedList[CAPACITY] ;
    }

    // returns number of keys
    @Override
    public int size() {
        return numKeys;
    }

    // returns boolean if table has no keys
    @Override
    public boolean isEmpty() {
    	// FILL HERE
    	if(numKeys == 0)
    		return true;
    	return false;
    }
    public int find(Object key) {
    	int index = key.hashCode() % table.length;
    	if(index < 0) {
    		index += table.length;
    	}
    	
    	while((table[index] != null) && (!key.equals(( (java.util.Map.Entry<K, V>) table[index]).getKey()))) {
    		index++;
    		if(index >= table.length) {
    			index = 0;
    		}
    	}
    	return index;
    }

    // returns boolean if table has the searched for key
    @Override
    public boolean containsKey(Object key) {
    	// Fill Here

    	 for (int i = 0 ; i < table.length ; i++ ) {
             if (table[i] != null) {
                 for (Entry<K, V> item: table[i]) {
                     if(item.getKey().equals(key)) {
                    	 return true;
                     }
                 }
                 
             }
         }
    	
    	return false;
    }

    // returns boolean if table has the searched for value
    @Override
    public boolean containsValue(Object value) {
    	// FILL HERE
    	// first search through each linkedlist
    	
    	for (int i = 0 ; i < table.length ; i++ ) {
            if (table[i] != null) {
                for (Entry<K, V> item : table[i]) {
                    if(item.getValue().equals(value)) {
                   	 return true;
                    }
                }
                
            }
        }
   	
   	return false;
    }

    // returns Value if table has the searched for key
    @Override
    public V get(Object key) {
    	// FILL HERE
    	
    	int index = key.hashCode() % table.length;
		if(index < 0){
			index += table.length;
		}
		if(table[index] == null){
			return null; 
		}
		
		
		for(Entry<K, V> entry : table[index]){
			if(entry.getKey().equals(key)){
				return entry.getValue();
			}
		}
		
		return null;
    	
    }
    @Override
    public V put(K key, V value) {
    	int index = key.hashCode() % table.length;
		if(index < 0){
			index += table.length;
		}
		if(table[index] == null){
			table[index] = new LinkedList<Entry<K, V>>();
		}
		
		for(Entry<K, V> item : table[index]){
			if(item.getKey().equals(key)){
				V oldValue = item.getValue();
				item.setValue(value);
				return oldValue;
			}
		}
		
		
		table[index].addFirst(new Entry<K, V>(key, value));
		numKeys++;
		
		if(numKeys > (LOAD_THRESHOLD * table.length)){
			rehash();
			}
		
		return null;
    }


    /**
     * Resizes the table to be 2X +1 bigger than previous
     */
    private void rehash() {
    	LinkedList<Entry<K, V>>[] oldTable = this.table;
		table = new LinkedList[oldTable.length * 2 + 1];
		this.numKeys = 0;
		for(LinkedList<Entry<K, V>> list : oldTable){
			if(list != null){
				for(Entry<K, V> entry : list){
					put(entry.getKey(), entry.getValue());
					this.numKeys++;
				}
			}
		}
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder() ;
        for (int i = 0 ; i < table.length ; i++ ) {
            if (table[i] != null) {
                for (Entry<K, V> nextItem : table[i]) {
                    sb.append(nextItem.toString() + " ") ;
                }
                sb.append(" ");
            }
        }
        return sb.toString() ;

    }

    // remove an entry at the key location
    // return removed value
    @Override
    public V remove(Object key) {
    	int index = key.hashCode() % table.length;
		
		if(index < 0)
			index += table.length;
		
		if(table[index] == null)
			return null;
		
		
		for(Entry<K, V> list : table[index]){
			if(list.getKey().equals(key)){
				V value = list.getValue();
				table[index].remove(list);
				this.numKeys--;
				
				if(table[index].size() == 0)
					table[index] = null;
				
				
				return value;
			}
		}
		return null;
    }

    // throws UnsupportedOperationException
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException() ;
    }

    // empties the table
    @Override
    public void clear() {
    	for(LinkedList<Entry<K,V>> list : table) {
    		list = null;
    	}
    	numKeys = 0;
    }

    // returns a view of the keys in set view
    @Override
    public Set<K> keySet() {
    	System.out.println(table[0]);
    	Set<K> keys = new HashSet<>();
    	 for (int i = 0 ; i < table.length ; i++ ) {
             if (table[i] != null) {
                 for (Entry<K, V> item : table[i]) {
                     keys.add(item.getKey());
                 }
                 
             }
         }
    	
    	return keys;
    }

    // throws UnsupportedOperationException
    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException() ;
    }
    
    


    // returns a set view of the hash table
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
    	// FILL HERE
    	Set<Map.Entry<K, V>> values = new HashSet<>();
    	 for (int i = 0 ; i < table.length ; i++ ) {
             if (table[i] != null) {
                 for (Entry<K, V> item : table[i]) {
                     values.add(item);
                 
                 }
             }
    	 }
    	 return values;

    }

    @Override
    public boolean equals(Object o) {
    	
    	if(o == null)
    		return false;
    	if(!(o instanceof Map)) 
    		return false;
    	
    	Map map = (Map) o;
    	if(size() != map.size())
    		return false;
    	//Create both of the tables into a Set
    	Set<K> tableKeySet = keySet();
    	Set<K> oKeySet = map.keySet();
    	if(tableKeySet.equals(oKeySet))
    		return true;
    	return false;

    }

    @Override
    public int hashCode() {
    	//FILL HERE
    	int total = 0;
    	for(int i = 0; i < table.length; i++) {
    		if(table[i] != null) {
    			for(Entry<K,V> item : table[i]) {
    				total += item.getKey().hashCode() + item.getValue().hashCode();
    			}
    		}
    	}
    	return total;

    }
}


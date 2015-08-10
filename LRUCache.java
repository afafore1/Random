import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;


public class LRUCache<Key, Value> {
	private final int size;
	private ConcurrentLinkedQueue<Key> linkedQueue;
	private ConcurrentHashMap<Key, Value> hashMap;
	
	// size of our cache
	public LRUCache(final int size){
		this.size = size;
		this.linkedQueue = new ConcurrentLinkedQueue<Key>();
		this.hashMap = new ConcurrentHashMap<Key, Value>(size);
	}
	// return value corresponding to the given key in the map.
	// return null if key is not found
	public Value get(final Key key){
		return hashMap.get(key);
	}
	// add new key, value pair to our map and queue.
	// if key exist, move it to beginning of the queue.
	public synchronized void put(final Key key, final Value value){
		if(hashMap.containsKey(key)){
			linkedQueue.remove(key);
		}
		while(linkedQueue.size() >= size){
			Key oldestKey = linkedQueue.poll(); // retrieve and remove head
			if(oldestKey != null){
				hashMap.remove(oldestKey);
			}
		}
		linkedQueue.add(key);
		hashMap.put(key, value);
	}
	
	

}

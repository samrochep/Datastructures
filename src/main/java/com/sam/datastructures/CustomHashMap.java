package com.sam.datastructures;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;


public class CustomHashMap<K, V> {

	private static final int DEFAULT_CAPACITY = 16;

	private static final float DEFAULT_LOAD_FACTOR = 0.75f;

	private CustomEntry<K, V>[] buckets;
	private float capacity;
	private float loadFactor;
	private int size;

	public CustomHashMap() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	public CustomHashMap(int capacity, float loadFactor) {
		this.buckets = new CustomEntry[capacity];
		this.loadFactor = loadFactor;
		this.capacity = capacity;
		this.size = 0;
	}

	public static class CustomEntry<K, V> {
		private K key;
		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public CustomEntry<K, V> getNext() {
			return next;
		}

		public void setNext(CustomEntry<K, V> next) {
			this.next = next;
		}

		public void setValue(V value) {
			this.value = value;
		}

		private V value;
		private CustomEntry<K, V> next;

		public CustomEntry(K key, V value, CustomEntry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	// find hash
	// get bucket size
	// calculate index
	// check for existing key and override
	// if index already has element then we need to link in the same index
	// if the index does not contain any element we will insert to that index
	public void put(K key, V value) {
		ensureCapacity();
		CustomEntry<K, V> entry = null;
		int hash = getHash(key);
		int bucketsSize = getBucketsSize();
		//test collision is added just for testing collision and not part of implementation
		int targetBucketIndex = StringUtils.equals((String) key, "testcollision")?3:calculateIndex(hash, bucketsSize);
		CustomEntry<K, V> existingEntry = this.buckets[targetBucketIndex];
		if (existingEntry == null) {
			entry = createEntry(key, value);
			this.buckets[targetBucketIndex] = entry;
			this.size++;
		} else {
			while (existingEntry.next != null) {
				if (existingEntry.key.equals(key)) {
					existingEntry.value = value;
					return;
				}
				existingEntry = existingEntry.next;
			}
			if (existingEntry.key.equals(key)) {
				existingEntry.value = value;
			} else {
				entry = createEntry(key, value);
				existingEntry.next = entry;
				size++;
			}

		}

	}

	// find hash
	// get bucketsize
	// calculate index
	// find the value
	public V get(K key) {
		int hash = getHash(key);
		int bucketsSize = getBucketsSize();
		int bucketIndex = calculateIndex(hash, bucketsSize);
		CustomEntry<K, V> bucket = this.buckets[bucketIndex];
		while (bucket != null) {
			if (bucket.key.equals(key))
				return bucket.value;
			bucket = bucket.next;
		}
		return null;
	}

	// find hash
	// get bucketsize
	// calculate index
	// find the entry
	public CustomEntry<K, V> remove(K key) {
		int hash = getHash(key);
		int bucketsSize = getBucketsSize();
		int bucketIndex = calculateIndex(hash, bucketsSize);
		CustomEntry<K, V> entryToReturn = null;
		CustomEntry<K, V> bucket = this.buckets[bucketIndex];
		if (bucket != null) {
			if (bucket.key.equals(key)) {
				entryToReturn = createEntry(bucket.key,bucket.value);
				//entryToReturn.next=bucket.next;
				this.buckets[bucketIndex].key = null;
				this.buckets[bucketIndex].value = null;
				this.buckets[bucketIndex].next=null;
				this.buckets[bucketIndex] = bucket.next;
				this.size--;
			} else {
				while (bucket.next != null) {
					if (bucket.next.key.equals(key)) {
						entryToReturn = createEntry(bucket.next.key,bucket.next.value);
						//entryToReturn.next=bucket.next;
						bucket.next.key = null;
						bucket.next.value = null;	
						bucket.next = bucket.next.next;
						bucket.next.next=null;
						this.size--;
						break;
					}
					bucket = bucket.next;
				}
			}
		}
		return entryToReturn;
	}

	private int calculateIndex(int hash, int bucketsSize) {
		// hash%(bucketsSize-1) - it can be 0 to 15
		return hash & (bucketsSize - 1);
	}

	private void ensureCapacity() {
		if (this.size >= (this.capacity * this.loadFactor)) {
			int newSize = this.size * 2;
			this.capacity = newSize;
			this.buckets = Arrays.copyOf(this.buckets, newSize);
		}
	}

	private CustomEntry<K, V> createEntry(K key, V value) {
		return new CustomEntry(key, value, null);
	}

	private int getHash(K key) {
		return key == null ? 0 : key.hashCode();
	}

	private int getBucketsSize() {
		return this.buckets.length;
	}

	public void printElements() {
		for (CustomEntry<K, V> entry : this.buckets) {
			CustomEntry<K, V> bucket = entry;
			while (bucket != null) {
				System.out.println("Key==> " + bucket.key);
				System.out.println("Value==> " + bucket.value);
				bucket = bucket.next;
			}
		}
	}

}

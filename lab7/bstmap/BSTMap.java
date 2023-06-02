package bstmap;

import java.security.Key;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        private K key;
        private V val;
        private Node left;
        private Node right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

    }

    private Node root;
    private int size;

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        return containsKey(root, key);
    }

    public boolean containsKey(Node root, K key) {
        if (root == null) return false;
        int cmp = key.compareTo(root.key);
        if (cmp < 0) return containsKey(root.left, key);
        if (cmp > 0) return containsKey(root.right, key);
        return true;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    public V get(Node root, K key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp < 0) return get(root.left, key);
        if (cmp > 0) return get(root.right, key);
        return root.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
        size++;
    }

    public Node put(Node root, K key, V value) {
        if (root == null) return new Node(key, value);
        int cmp = key.compareTo(root.key);
        if (cmp < 0) root.left = put(root.left, key, value);
        else if (cmp > 0) root.right = put(root.right, key, value);
        else root.val = value;
        return root;

    }

    @Override
    public Set<K> keySet() {
        HashSet<K> set = new HashSet<>();
        addkeys(root, set);
        return set;
    }

    public void addkeys(Node root, HashSet set) {
        if (root == null) return;
        set.add(root.key);
        addkeys(root.right, set);
        addkeys(root.left, set);
    }

    public Node findMax(Node root) {
        if (root.right == null) return root;
        return findMax(root.right);
    }

    @Override
    public V remove(K key) {
        V res = get(key);
        if (res == null) return null;
        size--;
        root = remove(root, key);
        return res;
    }

    public Node remove(Node root, K key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp < 0) root.left = remove(root.left, key);
        else if (cmp > 0) root.right = remove(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                Node t = findMax(root.left);
                root.key = t.key;
                root.val = t.val;
                root.left = remove(root.left, root.key);
            }
        }
        return root;
    }

    @Override
    public V remove(K key, V value) {
        V res = get(key);
        if (res == null || res != value) return null;
        size--;
        root = remove(root, key);
        return res;
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.println(node.key.toString() + " -> " + node.val.toString());
        printInOrder(node.right);
    }


    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }

}

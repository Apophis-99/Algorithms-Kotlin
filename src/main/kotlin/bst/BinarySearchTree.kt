package bst

import java.lang.Exception

/**
 * A kotlin representation of a binary search tree.
 * Generic ([T]) to be stored within the tree, [T] must be comparable (< == >) to be a valid BST type
 * @param root the initial value to structure the rest of the tree around
 */
class BinarySearchTree<T : Comparable<T>>(root: T) {

    private val parentNode: Node<T> = Node(root)

    /**
     * The number of nodes within the tree.
     * Each time a new value is successfully inserted it is incremented.
     * Each time a value is successfully removed it is decremented.
     */
    var size: Int = 1

    /**
     * The first value passed will be the root node of the tree
     * @param values the values to insert into tree
     */
    constructor(vararg values: T) : this(values[0]) {
        values.toList().subList(1, values.size - 1).forEach { insert(it) }
    }

    /**
     * Inserts [values] into the binary search tree
     * @param values vararg of type T to add to binary search tree one by one
     */
    fun insert(vararg values: T) {
        for (value in values) {
            insert(value)
        }
    }
    private fun insert(value: T) {
        // Check if value is already present in tree
        if (contains(value))
            return
        size++

        // Locate where to store
        insert(value, parentNode)
    }
    private fun insert(value: T, root: Node<T>?) {
        if (value < root?.value!! && root.left == null) {
            root.left = Node(value)
            return
        }
        if (value > root.value && root.right == null) {
            root.right = Node(value)
            return
        }

        if (value < root.value)
            insert(value, root.left)
        if (value > root.value)
            insert(value, root.right)
    }

    /**
     * Removes a value from the binary search tree if it is present in the tree
     * @param values vararg of type T to remove from binary search tree one by one
     */
    fun remove(vararg values: T) {
        values.forEach { remove(it) }
    }
    private fun remove(value: T) {
        val node = find(value, parentNode) ?: return
        remove(node.first, node.second)
        size--
    }
    private fun remove(parent: Node<T>, child: Node<T>) {
        if (child.left == null && child.right == null) {
            if (parent.left?.value == child.value)
                parent.left = null
            else if (parent.right?.value == child.value)
                parent.right = null
            return
        }

        if (child.right == null) {
            child.value = child.left!!.value
            child.right = child.left!!.right
            child.left = child.left!!.left
            return
        }

        if (child.left == null) {
            child.value = child.right!!.value
            child.left = child.left!!.left
            child.right = child.right!!.right
            return
        }

        var newNode = child.right ?: return
        var parentNode = child
        while (newNode.left != null) {
            parentNode = newNode
            newNode = newNode.left!!
        }

        child.value = newNode.value
        remove(parentNode, newNode)
    }
    private fun find(value: T, root: Node<T>): Pair<Node<T>, Node<T>>? {
        try {
            if (root.left?.value == value)
                return Pair(root, root.left!!)
            if (root.right?.value == value)
                return Pair(root, root.right!!)

            if (value < root.value)
                return find(value, root.left!!)
            if (value > root.value)
                return find(value, root.right!!)
        } catch(e: Exception) {
            return null
        }

        return null
    }

    /**
     * Checks if a particular value is present in the binary search tree
     * @param value the value to locate within the tree
     * @return true if the value was found in the list, else false
     */
    fun contains(value: T): Boolean {
        return contains(value, parentNode) != null
    }
    private fun contains(value: T, root: Node<T>?): Node<T>? {
        if (root?.value == value)
            return root

        if (root != null) {
            if (value < root.value)
                return contains(value, root.left)
            if (value > root.value)
                return contains(value, root.right)
        }

        return null
    }
}


// Standard types for the binary search tree

/**
 * An alias for BinarySearchTree<T: Comparable<T>>
 */
typealias BST<T> = BinarySearchTree<T>
/**
 * A BST of type Int
 */
typealias IntBST = BinarySearchTree<Int>
/**
 * A BST of type Float
 */
typealias FloatBST = BinarySearchTree<Float>
/**
 * A BST of type String
 */
typealias StringBST = BinarySearchTree<String>

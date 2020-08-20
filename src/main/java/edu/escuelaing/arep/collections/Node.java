package edu.escuelaing.arep.collections;

/**
 * Nodo de lista enlazada, con valor y nodo siguiente
 * @param <E> Tipo de datos que contendrá la lista enlazada
 * @author Alejandro Vasquez
 */
public class Node<E> {
    private E value;
    private Node<E> nextNode;
    private Node<E> priorNode;

    /**
     * Constructor de un nodo con valor y nodo siguiente, que por defecto es null
     * @param value Valor que va a contener el nodo
     */
    public Node(E value){
        this.value = value;
        nextNode = null;
        priorNode = null;
    }

    /**
     * Retorna el valor que contiene el nodo
     * @return Valor que contiene el nodo
     */
    public E getValue() {
        return value;
    }

    /**
     * Retorna el valor del siguiente nodo, si no hay nodo siguiente retorna null
     * @return Valor del nodo siguiente, null si no hay nodo siguiente
     */
    public E nextValue(){
        return nextNode!=null ? nextNode.value : null;
    }

    /**
     * Retorna el siguiente nodo
     * @return Retorna el nodo siguiente, null si no hay nodo siguiente
     */
    public Node<E> getNextNode(){
        return nextNode;
    }

    /**
     * Retorna el nodo anterior
     * @return Retorna el nodo anterior, null si no hay anterior
     */
    public Node<E> getPriorNode(){
        return priorNode;
    }

    /**
     * Cambia el nodo siguiente
     * @param node Nuevo nodo siguiente
     */
    public void setNextNode(Node<E> node){
        nextNode = node;
    }

    /**
     * Cambia el nodo siguiente
     * @param node Nuevo nodo anterior
     */
    public void setPriorNode(Node<E> node){
        priorNode = node;
    }
}


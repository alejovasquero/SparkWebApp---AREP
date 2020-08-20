package edu.escuelaing.arep.collections;


import java.lang.reflect.Array;
import java.util.*;

/**
 * Implementación para una lista enlazada
 * @param <E> Tipo generico con el que vamos a llenar la lista enlazada
 * @author Alejandro Vasquez
 */
public class LinkedList<E>  implements Collection<E> {
    
    private Node<E> head;

    /**
     * Constructor de una lista elzada sencilla
     */
    public LinkedList(){
        head = null;
    }



    /**
     * Numero de elementos de la lista enlazada
     * @return Cantidad de elementos de la lista enlazada
     */
    public int size() {
        Node<E> current = head;
        int size = 0;
        while(current!= null){
            size++;
            current=current.getNextNode();
        }
        return size;
    }


    /**
     * Consulta si la lista contiene o no elementos
     * @return La lista tiene elementos
     */
    public boolean isEmpty() {
        return head==null;
    }

    public boolean contains(Object o) {
        return false;
    }

    /**
     * Retorna un iterador sobre la lista enlazada
     * @return Iterador de los elementos internos de la lista
     */
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    /**
     * Convierte la lista enlazada en un arreglo de objetos
     * @return Arreglo de objetos que contienen a los elementos de la lista en orden de almacenamiento
     */
    public Object[] toArray() {
        Object[] ans =  new Object[size()];
        Node<E> current  = head;
        for(int i=0; i<ans.length && current != null; i++){
            ans[i] = current.getValue();
            current = current.getNextNode();
        }
        return ans;
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * Inserta un elemento al final de la lista
     * @param o Elemento a insertar
     * @return Si la insercion al final de la lista fue exitosa
     */
    public boolean add(E o) {
        Node<E> last = getLast();
        if(last == null){
            head = new Node<E>(o);
        } else {
            Node<E> newnode =new Node<E>(o);
            newnode.setPriorNode(last);
            last.setNextNode(newnode);
        }
        return true;
    }

    /**
     * Remueve un nodo de la lista
     * @param o Valor del elemento a eliminar
     * @return Si la eliminación fue exitosa
     */
    public boolean remove(Object o) {
        Node<E> current = head;
        boolean done=false;
        if(head !=null && o.equals(head.getValue())) {
            head = head.getNextNode();
        }
        while(current!=null && !done){
            if(o.equals(current.getValue())){
                putNodes(current.getPriorNode(), current.getNextNode());
                done=true;
            }
            current=current.getNextNode();
        }
        return done;
    }

    /**
     * Enlzada dos nodos para que sean continuos en la lista enlazada
     * @param priorNode Nodo anterior al nodo siguiente
     * @param nextNode Nodo continuo al nodo anterior
     */
    private void putNodes(Node<E> priorNode, Node<E> nextNode){
        if(nextNode!=null){
            nextNode.setPriorNode(priorNode);
        }
        if(priorNode!=null){
            priorNode.setNextNode(nextNode);
        }
    }

    /**
     * Añade todos los objetos entregados a la lista enlzada
     * @param c Colleccion de objetos a añadir a la lista
     * @return Si la insercion fue exitosa
     */
    public boolean addAll(Collection<? extends E> c) {
        for(E e: c){
            add(e);
        }
        return true;
    }

    public void clear() {

    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public boolean containsAll(Collection c) {
        return false;
    }

    /**
     * Retorna el ultimo elemento de la lista enlzada
     * @return Ultimo elemento de la lista enzalada, null si está vacía
     */
    private  Node<E> getLast(){
        Node<E> last = head;
        while(last!= null && last.getNextNode()!=null){
            last = last.getNextNode();
        }
        return last;
    }

    /**
     * Convierte la lista a una representación en cadena
     * @return Cadena que contiene los elementos de la lista en forma de arreglo
     */
    public String toString(){
        return Arrays.toString(toArray());
    }

    /**
     * Ietarador de la lista enlazada
     */
    private class LinkedListIterator implements Iterator<E>{
        private Node<E> nextNode;

        public LinkedListIterator(){
            nextNode = head;
        }

        /**
         * Retorna si el iterador tiene aún elemento por retornar de la lista
         * @return Si existe algun elemento por iterar
         */
        @Override
        public boolean hasNext() {
            return nextNode!=null;
        }

        /**
         * Retorna el siguiente valor de la lista
         * @return Siguiente valor de la lista segun el iterador
         */
        @Override
        public E next() {
            E value;
            if(!hasNext()){
                throw new NoSuchElementException();
            } else {
                value=nextNode.getValue();
                nextNode=nextNode.getNextNode();
            }
            return value;
        }

        @Override
        public void remove() {

        }
    }

}

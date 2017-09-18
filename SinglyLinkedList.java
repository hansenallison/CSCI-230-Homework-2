package edu.cofc.csci230;

/**
 * Singly LinkedList Data Structure
 * @author CSCI 230: Data Structures and Algorithms Fall 2017
 * @param <AnyType>
 */
public class SinglyLinkedList<AnyType extends Comparable<AnyType>> implements List<AnyType> {   
    // instance variables
    private Node<AnyType> headNode = null;
    private int size = 0;
 
 
    /**
     * Appends the specified element to the end of this list.
     * @param t
     */
    public void add( AnyType t) {
    
        addNode( new Node<AnyType>(t) );
         
    } // end add() method
    
    
    /**
     * implementation for public add(AnyType t) method
     * @param t
     */
    private void addNode(Node<AnyType> t) {
        
        if ( isEmpty() ) headNode = t;
        else getNode( size-1 ).setNextNode( t );
         
        size++;
         
    } // end addNode() method
 
    
    /**
     * Inserts the specified element at the specified position in this list.
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
         
    		addNode( index, new Node<AnyType>(t) );
         
    } // end add() method
    
    
    /**
     * Implementation for public add(int index, AnyType t) method
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    private void addNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {
    	/** TODO: You fully implement this method */
    		
    		Node<AnyType> tempNode = headNode;
    	
    		if (index >= 0 && index <= size) { //if index is in possible range
    			if (index == 0) { 
    				t.setNextNode(headNode); //add new node to front of list 
    				headNode = t; //set headnode to new node 
    				size++; 
    			}
    			if (index > 0 && index < size) {
    				t.setNextNode(getNode(index)); //add new node to list 
    				getNode(index-1).setNextNode(t); //set node before to point to new node 
    				size++;
    			}
    			if (index == size) {
    				addNode(t); //add new node to the end of the list 
    			}
    		}
    		else {
    			throw new IndexOutOfBoundsException(); 
    		}
        
    	} // end addNode() method
 
    
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException {
         
        setNode( index, new Node<AnyType>(t) );
         
    } // end set() method
    
    
    /**
     * Implementation for public set( int index, AnyType t ) method
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    private void setNode( int index, Node<AnyType> t ) throws IndexOutOfBoundsException {
    	/** TODO: You fully implement this method*/
    	
    		if (index >= 0 && index < size) { //if index is in possible range 
    			if (index == 0) {
    				t.setNextNode(getNode(index + 1)); //point value of new node to list 
    				headNode = t; //set headnode to new value 
    			}
    			if (index > 0 && index < size -1) {
    				t.setNextNode(getNode(index + 1)); //point value of new node to list 
    				getNode(index - 1).setNextNode(t); //point previous node to new value 
    			}
    			if (index == size -1) {
    				t.setNextNode(null); //point new value to null to indicate end of list 
    				getNode(index - 1).setNextNode(t); //point previous node to new value 
    			}
    		}
    		else {
    			throw new IndexOutOfBoundsException();
    		} 
    		
    } // end setNode() method

   
    /**
     * Removes the element at the specified position in this list.
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType remove( int index ) throws IndexOutOfBoundsException {
    	
    		return removeNode( index ).getData(); 
    	
    } // end remove() method
    
    
    /**
     * Implementation for public remove( int index ) method
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> removeNode( int index ) throws IndexOutOfBoundsException {
        /** TODO: You fully implement this method */
        
    		Node<AnyType> tempNode = getNode(index); //node to hold value of node being removed 
    		
    		if (index >= 0 && index < size) { //if index is in possible range
    			
    			if (index == 0) {
    				headNode = headNode.getNextNode(); //if removing value at first index, set headnode to the following node
    				size--; 
    			}
    			else if (index > 0 && index < size -1) {
    				getNode(index -1).setNextNode(getNode(index +1)); //set previous node to node after the one being removed
        			size--;
    			}
    			else if (index == size -1) { 
    				getNode(index -1).setNextNode(null); //set previous node to be the end node 
    				size--;
    			}
    		}
    		else {
    			throw new IndexOutOfBoundsException();
    		}
    		return tempNode; //return node that is being removed 
           
    } // end removeNode() method
 
     
    /**
     * Returns the element at the specified position in this list.
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType get( int index ) throws IndexOutOfBoundsException {
    	
    		return getNode( index ).getData();
    	
    } // end get() method
    
    
    /**
     * Implementation for public get(int index) method
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> getNode(int index) throws IndexOutOfBoundsException { 
        /** TODO: You fully implement this method **/
    	
    	 	Node<AnyType> tempNode = headNode; 
    	
    	 	if (index >= 0 && index <= size -1) {
    	 		if (index == 0) {
    	 			return headNode;
    	 		}
    	 		else {
    	 			for (int i = 0; i < index; i++) {
    	 				tempNode = tempNode.getNextNode(); 
    	 			} //end of for loop to set through nodes 
    	 		}//close of else for index greater than zero 
    	 	}//close of if check for valid index
    	 	else {
    	 		throw new IndexOutOfBoundsException("out of bounds");
    	 	}
    	 	return tempNode;
         
    } // end get() method
 
    
    /**
     * Returns the number of elements in this list. 
     * @return
     */
    public int size() {
         
        return size;
         
    } // end size() method
 
    
    /**
     * Returns true if this list contains no elements.
     * @return
     */
    public Boolean isEmpty() {
         
        return ( size == 0 ) ? true : false;
         
    } // end isEmpty() method
     
     
    /**
     * Removes all of the elements from this list.
     */
    public void clear() { 
        /** TODO: You fully implement this method */
    	
    		headNode = null;
    		size = 0;
         
    } // end clear method
     
    
    /**
     * @param args
     */
    public static void main( String[] args ) { 
        /** TODO: You put your test cases here */ 
         
    		SinglyLinkedList<Integer> sList = new SinglyLinkedList<Integer>();
    		sList.add(0, 0); //call public methods 
    		sList.add(1, 1);
    		sList.add(2, 2);
    		sList.add(3, 3);
    		sList.add(4, 4);
    		sList.add(5, 5);
    		sList.set(0, 10);
    		sList.set(1, 11);
    		sList.set(2, 12);
    		sList.set(3, 13);
    		sList.set(5, 15);
    		sList.add(0, 100);
    		sList.remove(5);
    		//sList.clear();
    		System.out.println("size of list: " + sList.size());
    		System.out.println();
    		System.out.println("node at index 0: " + sList.getNode(0));
    		System.out.println("node at index 1: " + sList.getNode(1));
    		System.out.println("node at index 2: " + sList.getNode(2));
    		System.out.println("node at index 3: " + sList.getNode(3));
    		System.out.println("node at index 4: " + sList.getNode(4));
    		  
    } // end main() method
  
} // end SinglyLinkedList class definition

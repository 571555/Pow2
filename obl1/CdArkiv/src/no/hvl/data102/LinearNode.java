
public class LinearNode<T> {

	
	private LinearNode<T> neste;
	private T element;
	 
	 // Oppretter en tom node
	  public LinearNode()  {
	    neste   =  null;
	    element = null;
	  }
	 
	  // Oppretter node med ett element
	  public LinearNode (T elem) {
	    neste   = null;
	    element = elem;
	  }
	 
	  // returnerer neste 
	  public LinearNode<T> getNeste()  {
	    return neste;
	  }
	 
	 // Setter neste som node
	  public void setNeste (LinearNode<T> node)  {
	    neste = node;
	  }
	 
	 //Elementet blir returnert til node
	  public T getElement() {
	    return element;
	  }
	 
	  // setter nytt element i node
	  public void setElement (T elem) {
	    element = elem;
	  }
}

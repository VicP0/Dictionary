import java.util.Set;
import java.util.TreeMap;
public class Dictionary {

	private TreeMap<String , String > dictionary;
	
	public Dictionary() 
	{
		dictionary = new TreeMap<String , String>();
	}
	
	public void add (String term , String def) throws DuplicateContentException
	{
		if(dictionary.containsKey(term))
			throw new DuplicateContentException("This term already exists");
		dictionary.put(term, def);
	}
	
	public void remove(String term) throws ContentNotFoundException
	{
		if(!dictionary.containsKey(term))
			throw new ContentNotFoundException("This term doesnt exists");
		dictionary.remove(term);
	}
	
	public void update(String term , String def)throws ContentNotFoundException
	{
		if(!dictionary.containsKey(term))
			throw new ContentNotFoundException("This term doesnt exists");
		dictionary.put(term, def);
	}
	
	public String search(String term)
	{
		if(dictionary.containsKey(term))
			return "Definition of : " + term+ " is: "+dictionary.get(term);
		return "There is no such word ";
	}
	
	public TreeMap<String, String> getDictionary(){
		return dictionary;
	}
	public Set<String> getTerms(){
		return dictionary.keySet();
	}
	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary.getDictionary();
	}
}

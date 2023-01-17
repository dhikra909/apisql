import java.util.List;

public class Idd {

	private	String root;
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public List<String> getSuffixes() {
		return suffixes;
	}
	public void setSuffixes(List<String> suffixes) {
		this.suffixes = suffixes;
	}
	private List<String> suffixes;
}

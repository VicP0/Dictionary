import java.util.Map;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DictionaryController {

	@FXML
	private TextField defField;

	@FXML
	private TextArea definitionArea;

	@FXML
	private TextField newWordField;

	@FXML
	private TextField removeField;

	@FXML
	private TextField searchField;
	@FXML
	private ListView<Map.Entry<String,String>>wordListView;

	private Dictionary dictionary;

	public void initialize() {
		dictionary = new Dictionary();
		definitionArea.setEditable(false);
		definitionArea.setWrapText(true);
	}

	@FXML
	void addPressed(ActionEvent event)throws DuplicateContentException {

		dictionary.add(newWordField.getText().trim().toLowerCase(), defField.getText().trim().toLowerCase());
		newWordField.clear();
		defField.clear();
		changeView();
		definitionArea.clear();
	}

	@FXML
	void removePressed(ActionEvent event) throws ContentNotFoundException {
		
		dictionary.remove(removeField.getText().trim());
		changeView();
		removeField.clear();
		definitionArea.clear();

	}

	@FXML
	void searchPressed(ActionEvent event)throws ContentNotFoundException {
		dictionary.search(searchField.getText().trim());
		definitionArea.setText("Definition of : " + searchField.getText().trim()
				+ dictionary.search(searchField.getText().trim())) ;
		definitionArea.setText(""+dictionary.search(searchField.getText().trim())) ;
		searchField.clear();
	}

	@FXML
	void updatePressed(ActionEvent event) throws ContentNotFoundException {
		dictionary.update(newWordField.getText().trim(), defField.getText().trim());
		newWordField.clear();
		defField.clear();
		definitionArea.clear();
		changeView();
	}
	
	private void changeView() {
		wordListView.getItems().clear();
		wordListView.getItems().addAll(dictionary.getDictionary().entrySet());
	}

}

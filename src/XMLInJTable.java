import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLInJTable extends AbstractTableModel {
	Vector data;
	Vector columns;

	public XMLInJTable() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse("D:\\selenium\\UserRegi\\xmlfile.xml");

			NodeList nl = doc.getElementsByTagName("firstname");
			NodeList n2 = doc.getElementsByTagName("lastname");
			NodeList n3 = doc.getElementsByTagName("city");
			NodeList n4 = doc.getElementsByTagName("address");
			
			

			NodeList listOfPersons = doc.getElementsByTagName("employee");
			String data1 = "", data2 = "", data3 = "", data4 = "";
			data = new Vector();
			columns = new Vector();
			for (int i = 0; i < listOfPersons.getLength(); i++) {
				data1 = nl.item(i).getFirstChild().getNodeValue();
				data2 = n2.item(i).getFirstChild().getNodeValue();
				data3 = n3.item(i).getFirstChild().getNodeValue();
				data4 = n4.item(i).getFirstChild().getNodeValue();
				

				String line = data1 + " " + data2 + " " + data3 + " " + data4;
				StringTokenizer st2 = new StringTokenizer(line, " ");
				while (st2.hasMoreTokens())
					data.addElement(st2.nextToken());
			}
			columns.add("");
			columns.add("");
			columns.add("");
			columns.add("");
			
			


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getRowCount() {
		return data.size() / getColumnCount();
	}

	public int getColumnCount() {
		return columns.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return (String) data.elementAt((rowIndex * getColumnCount())
				+ columnIndex);
	}
}

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StudentXMLToHTML {
    public static void main(String[] args) {
        try {
            // Load and parse the XML file
            File xmlFile = new File("student.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Get the list of students
            NodeList nList = doc.getElementsByTagName("student");

            // Start building the HTML table
            StringBuilder html = new StringBuilder();
            html.append("<html><body>");
            html.append("<h2>Student Information</h2>");
            html.append("<table border='1'>");
            html.append("<tr><th>ID</th><th>Name</th><th>Age</th><th>Major</th></tr>");

            // Iterate over each student and add a row to the table
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String id = eElement.getElementsByTagName("id").item(0).getTextContent();
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String age = eElement.getElementsByTagName("age").item(0).getTextContent();
                    String major = eElement.getElementsByTagName("major").item(0).getTextContent();

                    html.append("<tr>");
                    html.append("<td>").append(id).append("</td>");
                    html.append("<td>").append(name).append("</td>");
                    html.append("<td>").append(age).append("</td>");
                    html.append("<td>").append(major).append("</td>");
                    html.append("</tr>");
                }
            }

            // Close the table and HTML tags
            html.append("</table>");
            html.append("</body></html>");

            // Save the HTML to a file
            FileWriter fileWriter = new FileWriter("student.html");
            fileWriter.write(html.toString());
            fileWriter.close();

            System.out.println("HTML file created: student.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

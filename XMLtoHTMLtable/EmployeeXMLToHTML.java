import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.FileWriter;

public class EmployeeXMLToHTML {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("Employee.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("student");  // Changed from "Employee" to "student"

            StringBuilder html = new StringBuilder();
            html.append("<html><body>");
            html.append("<h2>Employee Information</h2>");
            html.append("<table border='1'>");
            html.append("<tr><th>ID</th><th>Name</th><th>Age</th><th>Position</th><th>City</th></tr>");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String id = eElement.getElementsByTagName("id").item(0).getTextContent();
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String age = eElement.getElementsByTagName("age").item(0).getTextContent();
                    String position = eElement.getElementsByTagName("position").item(0).getTextContent();
                    String city = eElement.getElementsByTagName("city").item(0).getTextContent();

                    html.append("<tr>");
                    html.append("<td>").append(id).append("</td>");
                    html.append("<td>").append(name).append("</td>");
                    html.append("<td>").append(age).append("</td>");
                    html.append("<td>").append(position).append("</td>");
                    html.append("<td>").append(city).append("</td>");
                    html.append("</tr>");
                }
            }

            // Close the table and HTML tags
            html.append("</table>");
            html.append("</body></html>");

            // Save the HTML to a file
            FileWriter fileWriter = new FileWriter("Employee.html");
            fileWriter.write(html.toString());
            fileWriter.close();

            System.out.println("HTML file created: Employee.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

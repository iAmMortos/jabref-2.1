/*
 * Created on Oct 23, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package net.sf.jabref.export;

import net.sf.jabref.export.layout.format.*;
import net.sf.jabref.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.BasicEventList;

/**
 * @author Morten O. Alver.
 * Based on net.sf.jabref.MODSDatabase by Michael Wrighton
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class OpenDocumentRepresentation {
    protected Collection entries;

        /*protected final static String TYPE_COL = "BibliographyType";

        protected final static Map columns = new LinkedHashMap();
        static {

            columns.put(TYPE_COL, "dummy");
            columns.put("ISBN", "isbn");
            coulmns.put("Identifier", "\bibtexkey");
            coulmns.put("", "");
            coulmns.put("", "");

        }*/

    public OpenDocumentRepresentation() {
        //entries = new HashSet();
    }

    public OpenDocumentRepresentation(BibtexDatabase bibtex) {
        this();
        // Make a list of comparators for sorting the entries:
        List comparators = new ArrayList();
        comparators.add(new FieldComparator("author"));
        comparators.add(new FieldComparator("year"));
        comparators.add(new FieldComparator(BibtexFields.KEY_FIELD));
        // Use glazed lists to get a sorted view of the entries:
        BasicEventList entryList = new BasicEventList();
        entryList.addAll(bibtex.getEntries());
        entries = new SortedList(entryList, new FieldComparatorStack(comparators));
    }
    public Document getDOMrepresentation() {
        Document result = null;
        try {
            DocumentBuilder dbuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            result = dbuild.newDocument();
            Element collection = result.createElement("office:document-content");
            //collection.setAttribute("xmlns", "http://openoffice.org/2000/office");
            collection.setAttribute("xmlns:office", "urn:oasis:names:tc:opendocument:xmlns:office:1.0");
            collection.setAttribute("xmlns:style", "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
            collection.setAttribute("xmlns:text", "urn:oasis:names:tc:opendocument:xmlns:text:1.0");
            collection.setAttribute("xmlns:table", "urn:oasis:names:tc:opendocument:xmlns:table:1.0");
            collection.setAttribute("xmlns:meta", "urn:oasis:names:tc:opendocument:xmlns:meta:1.0");
            collection.setAttribute("office:version", "1.0");
            collection.setAttribute("xmlns:fo", "urn:oasis:names:tc:opendocument:xmlns:xsl-fo-compatible:1.0");
            collection.setAttribute("xmlns:xlink", "http://www.w3.org/1999/xlink");
            Element el = result.createElement("office:scripts");
            collection.appendChild(el);

            el = result.createElement("office:automatic-styles");
            Element el2 = result.createElement("style:style");
            el2.setAttribute("style:name", "ro1");
            el2.setAttribute("style:family", "table-row");
            Element el3 = result.createElement("style.table-row-properties");
            el3.setAttribute("style:row-height", "0.1681inch");
            el3.setAttribute("fo:break-before", "auto");
            el3.setAttribute("style:use-optimal-row-height", "true");
            el2.appendChild(el3);
            el.appendChild(el2);
            el2 = result.createElement("style:style");
            el2.setAttribute("style:name", "ta1");
            el2.setAttribute("style:family", "table");
            el2.setAttribute("style:master-page-name", "Default");
            el3 = result.createElement("style:properties");
            el3.setAttribute("table:display", "true");
            el2.appendChild(el3);
            el.appendChild(el2);
            collection.appendChild(el);

            Element body = result.createElement("office:body"),
                    spreadsheet = result.createElement("office:spreadsheet"),
                    table = result.createElement("table:table");
            table.setAttribute("table:name", "biblio");
            table.setAttribute("table.style-name", "ta1");

            Element row = result.createElement("table:table-row");
            row.setAttribute("table.style-name", "ro1");
            addTableCell(result, row, "Identifier");
            addTableCell(result, row, "Type");
            addTableCell(result, row, "Address");
            addTableCell(result, row, "Annote");
            addTableCell(result, row, "Author");
            addTableCell(result, row, "Booktitle");
            addTableCell(result, row, "Chapter");
            addTableCell(result, row, "Edition");
            addTableCell(result, row, "Editor");
            addTableCell(result, row, "Howpublish");
            addTableCell(result, row, "Institutn");
            addTableCell(result, row, "Journal");
            addTableCell(result, row, "Month");
            addTableCell(result, row, "Note");
            addTableCell(result, row, "Number");
            addTableCell(result, row, "Organizat");
            addTableCell(result, row, "Pages");
            addTableCell(result, row, "Publisher");
            addTableCell(result, row, "School");
            addTableCell(result, row, "Series");
            addTableCell(result, row, "Title");
            addTableCell(result, row, "RepType");
            addTableCell(result, row, "Volume");
            addTableCell(result, row, "Year");
            addTableCell(result, row, "URL");
            addTableCell(result, row, "Custom1");
            addTableCell(result, row, "Custom2");
            addTableCell(result, row, "Custom3");
            addTableCell(result, row, "Custom4");
            addTableCell(result, row, "Custom5");
            addTableCell(result, row, "ISBN");
            table.appendChild(row);

            for(Iterator iter = entries.iterator(); iter.hasNext(); ) {
                BibtexEntry e = (BibtexEntry)iter.next();
                row = result.createElement("table:table-row");
                addTableCell(result, row, getField(e, BibtexFields.KEY_FIELD));
                addTableCell(result, row, new GetOpenOfficeType().format(e.getType().getName()));
                addTableCell(result, row, getField(e, "address"));
                addTableCell(result, row, getField(e, "annote"));
                addTableCell(result, row, getField(e, "author"));//new AuthorLastFirst().format(getField(e, "author")));
                addTableCell(result, row, getField(e, "booktitle"));
                addTableCell(result, row, getField(e, "chapter"));
                addTableCell(result, row, getField(e, "edition"));
                addTableCell(result, row, getField(e, "editor"));//new AuthorLastFirst().format(getField(e, "editor")));
                addTableCell(result, row, getField(e, "howpublished"));
                addTableCell(result, row, getField(e, "institution"));
                addTableCell(result, row, getField(e, "journal"));
                addTableCell(result, row, getField(e, "month"));
                addTableCell(result, row, getField(e, "note"));
                addTableCell(result, row, getField(e, "number"));
                addTableCell(result, row, getField(e, "organization"));
                addTableCell(result, row, getField(e, "pages"));
                addTableCell(result, row, getField(e, "publisher"));
                addTableCell(result, row, getField(e, "school"));
                addTableCell(result, row, getField(e, "series"));
                addTableCell(result, row, new RemoveWhitespace().format(new RemoveBrackets().format(getField(e, "title"))));
                addTableCell(result, row, getField(e, "reporttype"));
                addTableCell(result, row, getField(e, "volume"));
                addTableCell(result, row, getField(e, "year"));
                addTableCell(result, row, getField(e, "url"));
                addTableCell(result, row, "");
                addTableCell(result, row, "");
                addTableCell(result, row, "");
                addTableCell(result, row, "");
                addTableCell(result, row, "");
                addTableCell(result, row, getField(e, "isbn"));
                table.appendChild(row);
            }

            spreadsheet.appendChild(table);
            body.appendChild(spreadsheet);
            collection.appendChild(body);

            result.appendChild(collection);
        } catch (Exception e) {
            System.out.println("Exception caught..." + e);
            e.printStackTrace();
        }
        return result;
    }

    protected String getField(BibtexEntry e, String field) {
        Object o = e.getField(field);
        return o == null ? "" : o.toString();
    }

    protected void addTableCell(Document doc, Element parent, String content) {
        Element cell = doc.createElement("table:table-cell"),
                text = doc.createElement("text:p");
    Text textNode = doc.createTextNode(content);
    text.appendChild(textNode);
        //text.setTextContent(content);
        cell.appendChild(text);
        parent.appendChild(cell);
    }
}

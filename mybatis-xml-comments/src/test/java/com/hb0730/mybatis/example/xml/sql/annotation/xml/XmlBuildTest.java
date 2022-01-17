package com.hb0730.mybatis.example.xml.sql.annotation.xml;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;
import org.apache.ibatis.io.Resources;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author bing_huang
 * @date 2021/7/30
 * @since 1.0.0
 */

public class XmlBuildTest {

    @Test
    public void readXml() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = new DocumentBuilderFactoryImpl();
        factory.setIgnoringComments(false);
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        factory.setIgnoringElementContentWhitespace(false);
        factory.setCoalescing(false);
        factory.setExpandEntityReferences(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(Resources.getResourceAsStream("com/hb0730/mybatis/example.xml.sql.annotation.mvc/mapper/testMapper.xml"));
        //获得xml文档中的元素根元素
        Element rootDocument = document.getDocumentElement();
        System.out.println(rootDocument.getNodeName());
        NodeList childNodes = rootDocument.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            System.out.println(node.getNodeName());
            NamedNodeMap attributes = node.getAttributes();
            if (null!=attributes){
                Node item = attributes.getNamedItem("id");
                System.out.println(item.getTextContent());
            }
            System.out.println(node.getTextContent());
        }
    }
}

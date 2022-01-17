package com.hb0730.mybatis.example.xml.sql.annotation.plugin;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.Properties;

/**
 * @author bing_huang
 * @date 2021/7/30
 * @since 1.0.0
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class ExecutorPlugin implements Interceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorPlugin.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement statement = (MappedStatement) invocation.getArgs()[0];
        BoundSql boundSql = statement.getBoundSql(invocation.getArgs()[1]);
        String sql = boundSql.getSql();
        LOGGER.info("SQL:{},params:[{}]", sql, boundSql.getParameterObject());
        getComment(statement.getId(), statement.getResource());
        Object proceed = invocation.proceed();
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    private String getComment(String id, String resource) throws ParserConfigurationException, IOException, SAXException {
        String idName = id.substring(id.lastIndexOf(".") + 1);
        DocumentBuilderFactory factory = new DocumentBuilderFactoryImpl();
        factory.setIgnoringComments(false);
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        factory.setIgnoringElementContentWhitespace(false);
        factory.setCoalescing(false);
        factory.setExpandEntityReferences(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(Resources.getResourceAsStream(resource));
        //Root节点 MAPPER
        Element rootElement = document.getDocumentElement();

        NodeList childNodes = rootElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            NamedNodeMap attributes = node.getAttributes();
            if (null == attributes) {
                continue;
            }
            //获取带有id的节点比如 Select Delete Update
            Node item = attributes.getNamedItem("id");
            if (item.getNodeValue().equals(idName)) {
                System.out.println(childNodes.item(i - 2).getTextContent());
            }
        }

        return "";
    }
}

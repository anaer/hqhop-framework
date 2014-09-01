package com.hqhop.framework.common.orm.sql;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.springframework.core.io.Resource;

import com.hqhop.framework.common.UtilsConstants;

public class SQLContextFactory {

	public static SQLContext createSQLContext(Resource springResource) throws IOException, DocumentException {
		SQLContextFileBuilder builder = SQLContextFileBuilder.getInstance();
		builder.loadFullConfigFile(springResource, UtilsConstants.CHARSET);
		return builder.loadSQLContext();
	}

}

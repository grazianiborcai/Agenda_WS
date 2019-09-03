package br.com.gda.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;

public final class DaoStmtBuilderHelper implements DaoStmtBuilder {
	private DaoStmtBuilder builder;
	private Class<?> childClass;
	
	public DaoStmtBuilderHelper(DaoOperation operation, DaoStmtBuilderOption option, Class<?> clazz) {
		checkArgument(operation);
		
		childClass = clazz;
		builder = operation.factorySqlStmtBuilder(option, clazz);
	}

		
	
	@Override public boolean checkStmtBuild() {
		return builder.checkStmtBuild();
	}

	
	
	@Override public String buildStmt() {
		return builder.buildStmt();
	}
	
	
	
	private void checkArgument(DaoOperation operation) {
		if (operation == null) {
			logException(new NullPointerException("operation" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("operation" + SystemMessage.NULL_ARGUMENT);	
		}
	}	



	private void logException(Exception e) {
		Class<?> clazz = childClass;
		
		if (clazz == null)
			clazz = this.getClass();
		
		Logger logger = LogManager.getLogger(clazz);
		logger.error(e.getMessage(), e);
	}	
}

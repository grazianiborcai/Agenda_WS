package br.com.gda.model.action;

import java.sql.Connection;

import br.com.gda.common.SystemMessage;

public abstract class ActionMultiVisitorTemplate<T> implements ActionMultiVisitor<T> {

	protected ActionMultiVisitorTemplate(Connection conn, String schemaName) {
		checkArgument(conn, schemaName);
		
	}
	
	
	
	private void checkArgument(Connection conn, String schemaName) {
		if (conn == null)
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		
		if (schemaName == null)
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
	}
}

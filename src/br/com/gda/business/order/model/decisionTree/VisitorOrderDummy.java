package br.com.gda.business.order.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorOrderDummy implements DeciActionTransVisitor<OrderInfo> {
	//TODO: Criar um Template para Dummy
	public VisitorOrderDummy(Connection conn, String schemaName) {
		checkArgument(conn, schemaName);
	}
	
	
	
	private void checkArgument(Connection conn, String schemaName) {
		if (conn == null)
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);		
		
		if (schemaName == null)
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);		
	}
	
	
		
	@Override public List<OrderInfo> executeTransformation(List<OrderInfo> recordInfos) {		
		return recordInfos;
	}	
}

package br.com.gda.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionMultiVisitor;
import br.com.gda.model.decisionTree.DeciResult;

final class MultiVisitorOrderExtra implements ActionMultiVisitor<OrderInfo>{

	
	public MultiVisitorOrderExtra(Connection conn, String schemaName) {
		checkArgument(conn, schemaName);
		
	}
	
	
	
	private void checkArgument(Connection conn, String schemaName) {
		if (conn == null)
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		
		if (schemaName == null)
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	@Override public boolean executeAction(List<List<OrderInfo>> infoRecords) {
		// TODO Auto-generated method stub
		return false;
	}


	
	@Override public DeciResult<OrderInfo> getDecisionResult() {
		// TODO Auto-generated method stub
		return null;
	}
}

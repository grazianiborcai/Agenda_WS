package br.com.gda.business.order.model.decisionTree;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.decisionTree.RootEmpSelect;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderMerger;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisitorOrderMergeEmp implements DeciActionTransVisitor<OrderInfo> {
	private DeciTreeOption<EmpInfo> selOption;
	
	
	public VisitorOrderMergeEmp(Connection conn, String schemaName) {
		checkArgument(conn, schemaName);
		makeOption(conn, schemaName);
	}
	
	
	
	private void checkArgument(Connection conn, String schemaName) {
		if (conn == null)
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);		
		
		if (schemaName == null)
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);		
	}
	
	
	
	private void makeOption(Connection conn, String schemaName) {
		selOption = new DeciTreeOption<>();
		selOption.conn = conn;
		selOption.schemaName = schemaName;
		selOption.recordInfos = null;
	}
	
	
		
	@Override public List<OrderInfo> executeTransformation(List<OrderInfo> recordInfos) {
		addRecordToOption(recordInfos);
		List<EmpInfo> stores = selectStore();
		
		return merge(recordInfos, stores);
	}	
	
	
	
	private void addRecordToOption(List<OrderInfo> recordInfos) {
		selOption.recordInfos = EmpInfo.copyFrom(recordInfos);
	}
	
	
	
	private List<EmpInfo> selectStore() {
		DeciAction<EmpInfo> mainAction = new RootEmpSelect(selOption).toAction();
		mainAction.executeAction();
		
		if (mainAction.getDecisionResult().hasResultset())		
			return mainAction.getDecisionResult().getResultset();
		
		return Collections.emptyList();
	}
	
	
	
	private List<OrderInfo> merge(List<OrderInfo> orders, List<EmpInfo> emps) {
		if (orders.isEmpty())
			return orders;
		
		return new OrderMerger().merge(emps, orders);
	}
}

package br.com.gda.business.order.model.action;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderMerger;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionVisitor;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisitorOrderInsertHdrFirst implements ActionVisitor<OrderInfo> {
	private DeciTreeOption<OrderInfo> selOption;
	
	
	public VisitorOrderInsertHdrFirst(Connection conn, String schemaName) {
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
		List<OrderInfo> hdrs = execAction();		
		return mergeHdr(hdrs, recordInfos);
	}	
	
	
	
	private void addRecordToOption(List<OrderInfo> recordInfos) {
		selOption.recordInfos = recordInfos;
	}
	
	
	
	private List<OrderInfo> execAction() {
		ActionStd<OrderInfo> action = buildAction();
		action.executeAction();
		
		if (action.getDecisionResult().hasResultset())		
			return action.getDecisionResult().getResultset();
		
		return Collections.emptyList();
	}
	
	
	
	private ActionStd<OrderInfo> buildAction() {
		ActionStd<OrderInfo> firstRow = new StdOrderFirstRow(selOption);
		ActionLazy<OrderInfo> insertHdr = new LazyOrderInsertHdr(selOption.conn, selOption.schemaName);
		
		firstRow.addPostAction(insertHdr);
		return firstRow;
	}
	
	
	
	private List<OrderInfo> mergeHdr(List<OrderInfo> hdrs, List<OrderInfo> originals) {
		if (hdrs.isEmpty())
			return Collections.emptyList();		
		
		return new OrderMerger().merge(hdrs, originals);
	}
}

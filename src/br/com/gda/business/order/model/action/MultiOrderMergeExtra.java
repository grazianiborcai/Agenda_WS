package br.com.gda.business.order.model.action;

import java.sql.Connection;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.model.action.ActionMultiTemplate;
import br.com.gda.model.action.ActionMultiVisitor;

public final class MultiOrderMergeExtra extends ActionMultiTemplate<OrderInfo> {
	static private final int TRIGGER_SIZE = 2;
	

	public MultiOrderMergeExtra(Connection conn, String schemaName) {
		super(conn, schemaName, TRIGGER_SIZE);
	}
	
	
	
	@Override protected ActionMultiVisitor<OrderInfo> getInstanceOfVisitorHook(Connection conn, String schemaName) {
		return new VisiOrderMergeExtra();
	}
}

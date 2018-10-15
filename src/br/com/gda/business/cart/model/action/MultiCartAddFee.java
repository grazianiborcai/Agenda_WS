package br.com.gda.business.cart.model.action;

import java.sql.Connection;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.action.ActionMultiTemplate;
import br.com.gda.model.action.ActionMultiVisitor;

public final class MultiCartAddFee extends ActionMultiTemplate<CartInfo> {
	static private final int TRIGGER_SIZE = 2;
	

	public MultiCartAddFee(Connection conn, String schemaName) {
		super(conn, schemaName, TRIGGER_SIZE);
	}
	
	
	
	@Override protected ActionMultiVisitor<CartInfo> getInstanceOfVisitorHook(Connection conn, String schemaName) {
		return new VisiCartAddFee();
	}
}

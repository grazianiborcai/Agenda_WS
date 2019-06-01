package br.com.gda.business.cartSnapshot_.model.action;

import java.sql.Connection;

import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.model.action.ActionMultiTemplate;
import br.com.gda.model.action.ActionMultiVisitor;

public final class MultiCartSnapJoinResult extends ActionMultiTemplate<CartSnapInfo> {
	static private final int TRIGGER_SIZE = 3;
	

	public MultiCartSnapJoinResult(Connection conn, String schemaName) {
		super(conn, schemaName, TRIGGER_SIZE);
	}
	
	
	
	@Override protected ActionMultiVisitor<CartSnapInfo> getInstanceOfVisitorHook(Connection conn, String schemaName) {
		return new VisiCartSnapJoinResult();
	}
}

package br.com.gda.business.cartItem.model.action;

import java.sql.Connection;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.model.action.ActionMultiTemplate;
import br.com.gda.model.action.ActionMultiVisitor;

public final class MultiCartemAddTotal extends ActionMultiTemplate<CartemInfo> {
	static private final int TRIGGER_SIZE = 2;
	

	public MultiCartemAddTotal(Connection conn, String schemaName) {
		super(conn, schemaName, TRIGGER_SIZE);
	}
	
	
	
	@Override protected ActionMultiVisitor<CartemInfo> getInstanceOfVisitorHook(Connection conn, String schemaName) {
		return new VisiCartemAddTotal();
	}
}

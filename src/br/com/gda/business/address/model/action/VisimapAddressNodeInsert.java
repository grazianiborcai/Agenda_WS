package br.com.gda.business.address.model.action;

import java.sql.Connection;
import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.decisionTree.NodeAddressInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class VisimapAddressNodeInsert extends ActionVisitorTemplateAction<AddressInfo, AddressInfo> {
	public VisimapAddressNodeInsert(Connection conn, String schemaName) {
		super(conn, schemaName, AddressInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected ActionStd<AddressInfo> getActionHook(DeciTreeOption<AddressInfo> option) {
		return new NodeAddressInsert(option).toAction();
	}
}

package br.com.gda.business.addressSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class VisimapAddressSnapMergeForm extends ActionVisitorTemplateAction<AddressSnapInfo, AddressSnapInfo> {
	public VisimapAddressSnapMergeForm(Connection conn, String schemaName) {
		super(conn, schemaName, AddressSnapInfo.class, AddressSnapInfo.class);
	}
	
	
	
	@Override protected ActionStd<AddressSnapInfo> getActionHook(DeciTreeOption<AddressSnapInfo> option) {
		return new StdAddressSnapMergeForm(option);
	}
}

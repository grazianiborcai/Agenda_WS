package br.com.gda.business.phoneSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class VisimapPhoneSnapMergeCountryPhone extends ActionVisitorTemplateAction<PhoneSnapInfo, PhoneSnapInfo> {
	public VisimapPhoneSnapMergeCountryPhone(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneSnapInfo.class, PhoneSnapInfo.class);
	}
	
	
	
	@Override protected ActionStd<PhoneSnapInfo> getActionHook(DeciTreeOption<PhoneSnapInfo> option) {
		return new StdPhoneSnapMergeCountryPhone(option);
	}
}

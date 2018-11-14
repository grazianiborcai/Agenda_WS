package br.com.gda.business.phone.model.action;

import java.sql.Connection;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class VisimapPhoneMergeForm extends ActionVisitorTemplateAction<PhoneInfo, PhoneInfo> {
	public VisimapPhoneMergeForm(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> getActionHook(DeciTreeOption<PhoneInfo> option) {
		return new StdPhoneMergeForm(option);
	}
}

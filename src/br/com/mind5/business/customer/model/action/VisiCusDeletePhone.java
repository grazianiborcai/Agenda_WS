package br.com.mind5.business.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.RootPhoneDelete;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusDeletePhone extends ActionVisitorTemplateAction<CusInfo, PhoneInfo> {
	
	public VisiCusDeletePhone(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<CusInfo> recordInfos) {
		return PhoneCopier.copyFromCus(recordInfos);
	}
	
	
	
	@Override protected ActionStdV1<PhoneInfo> getActionHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneDelete(option).toAction();
	}
	
	
	
	@Override protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<PhoneInfo> results) {
		return baseInfos;
	}
}

package br.com.gda.business.phone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.info.PhoneMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;

final class VisiPhoneMergeToSelect extends ActionVisitorTemplateMerge_<PhoneInfo, PhoneInfo> {
	
	public VisiPhoneMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PhoneInfo>> getActionClassHook() {
		return StdPhoneSelect.class;
	}
	
	
	
	@Override protected List<PhoneInfo> mergeHook(List<PhoneInfo> recordInfos, List<PhoneInfo> selectedInfos) {	
		return PhoneMerger.mergeToSelect(selectedInfos, recordInfos);
	}
}

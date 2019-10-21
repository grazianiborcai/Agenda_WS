package br.com.mind5.business.phone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiPhoneMergeToUpdate extends ActionVisitorTemplateMergeV2<PhoneInfo, PhoneInfo> {
	
	public VisiPhoneMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PhoneInfo>> getActionClassHook() {
		return StdPhoneSelect.class;
	}
	
	
	
	@Override protected List<PhoneInfo> mergeHook(List<PhoneInfo> recordInfos, List<PhoneInfo> selectedInfos) {	
		return PhoneMerger.mergeToUpdate(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

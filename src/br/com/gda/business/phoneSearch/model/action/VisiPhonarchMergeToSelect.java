package br.com.gda.business.phoneSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.phoneSearch.info.PhonarchInfo;
import br.com.gda.business.phoneSearch.info.PhonarchMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiPhonarchMergeToSelect extends ActionVisitorTemplateMergeV2<PhonarchInfo, PhonarchInfo> {
	
	public VisiPhonarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PhonarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PhonarchInfo>> getActionClassHook() {
		return StdPhonarchSelect.class;
	}
	
	
	
	@Override protected List<PhonarchInfo> mergeHook(List<PhonarchInfo> recordInfos, List<PhonarchInfo> selectedInfos) {	
		return PhonarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

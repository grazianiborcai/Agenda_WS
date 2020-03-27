package br.com.mind5.business.phoneSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.info.PhonarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiPhonarchMergeToSelect extends ActionVisitorTemplateMerge<PhonarchInfo, PhonarchInfo> {
	
	public VisiPhonarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PhonarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PhonarchInfo>> getActionClassHook() {
		return StdPhonarchSelect.class;
	}
	
	
	
	@Override protected List<PhonarchInfo> mergeHook(List<PhonarchInfo> baseInfos, List<PhonarchInfo> selectedInfos) {	
		return PhonarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}

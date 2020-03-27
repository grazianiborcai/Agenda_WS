package br.com.mind5.business.phone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneMerger;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.decisionTree.RootPhonarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPhoneMergePhonarch extends ActionVisitorTemplateMerge<PhoneInfo, PhonarchInfo> {
	
	public VisiPhoneMergePhonarch(Connection conn, String schemaName) {
		super(conn, schemaName, PhonarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonarchInfo>> getTreeClassHook() {
		return RootPhonarchSelect.class;
	}
	
	
	
	@Override protected List<PhoneInfo> mergeHook(List<PhoneInfo> recordInfos, List<PhonarchInfo> selectedInfos) {	
		return PhoneMerger.mergeWithPhonarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}

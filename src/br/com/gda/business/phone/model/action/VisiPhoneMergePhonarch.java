package br.com.gda.business.phone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.info.PhoneMerger;
import br.com.gda.business.phoneSearch.info.PhonarchInfo;
import br.com.gda.business.phoneSearch.model.decisionTree.RootPhonarchSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPhoneMergePhonarch extends ActionVisitorTemplateMergeV2<PhoneInfo, PhonarchInfo> {
	
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
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

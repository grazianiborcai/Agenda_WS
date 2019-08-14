package br.com.gda.business.companySnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.companySnapshot.info.CompnapInfo;
import br.com.gda.business.companySnapshot.info.CompnapMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiCompnapMergeToSelect extends ActionVisitorTemplateMergeV2<CompnapInfo, CompnapInfo> {
	
	public VisiCompnapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CompnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CompnapInfo>> getActionClassHook() {
		return StdCompnapSelect.class;
	}
	
	
	
	@Override protected List<CompnapInfo> mergeHook(List<CompnapInfo> recordInfos, List<CompnapInfo> selectedInfos) {	
		return CompnapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

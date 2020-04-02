package br.com.mind5.business.companySnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.companySnapshot.info.CompnapMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiCompnapMergeToSelect extends ActionVisitorTemplateMerge<CompnapInfo, CompnapInfo> {
	
	public VisiCompnapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CompnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<CompnapInfo>> getActionClassHook() {
		return StdCompnapSelect.class;
	}
	
	
	
	@Override protected List<CompnapInfo> mergeHook(List<CompnapInfo> recordInfos, List<CompnapInfo> selectedInfos) {	
		return CompnapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}

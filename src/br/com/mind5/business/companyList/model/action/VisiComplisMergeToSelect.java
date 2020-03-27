package br.com.mind5.business.companyList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.info.ComplisMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiComplisMergeToSelect extends ActionVisitorTemplateMerge<ComplisInfo, ComplisInfo> {
	
	public VisiComplisMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, ComplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<ComplisInfo>> getActionClassHook() {
		return StdComplisSelect.class;
	}
	
	
	
	@Override protected List<ComplisInfo> mergeHook(List<ComplisInfo> recordInfos, List<ComplisInfo> selectedInfos) {	
		return ComplisMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}

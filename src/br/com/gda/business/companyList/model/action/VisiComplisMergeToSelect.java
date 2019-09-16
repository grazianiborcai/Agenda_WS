package br.com.gda.business.companyList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.companyList.info.ComplisInfo;
import br.com.gda.business.companyList.info.ComplisMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiComplisMergeToSelect extends ActionVisitorTemplateMergeV2<ComplisInfo, ComplisInfo> {
	
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
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

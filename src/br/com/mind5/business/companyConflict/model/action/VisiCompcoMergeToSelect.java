package br.com.mind5.business.companyConflict.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.business.companyConflict.info.CompcoMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiCompcoMergeToSelect extends ActionVisitorTemplateMergeV1<CompcoInfo, CompcoInfo> {
	
	public VisiCompcoMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CompcoInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<CompcoInfo>> getActionClassHook() {
		return StdCompcoSelect.class;
	}
	
	
	
	@Override protected List<CompcoInfo> mergeHook(List<CompcoInfo> recordInfos, List<CompcoInfo> selectedInfos) {	
		return CompcoMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}

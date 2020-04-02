package br.com.mind5.business.customerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.info.CusnapMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiCusnapMergeToSelect extends ActionVisitorTemplateMerge<CusnapInfo, CusnapInfo> {
	
	public VisiCusnapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CusnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<CusnapInfo>> getActionClassHook() {
		return StdCusnapSelect.class;
	}
	
	
	
	@Override protected List<CusnapInfo> mergeHook(List<CusnapInfo> recordInfos, List<CusnapInfo> selectedInfos) {	
		return CusnapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}

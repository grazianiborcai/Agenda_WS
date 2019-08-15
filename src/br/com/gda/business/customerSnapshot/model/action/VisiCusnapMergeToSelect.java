package br.com.gda.business.customerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customerSnapshot.info.CusnapInfo;
import br.com.gda.business.customerSnapshot.info.CusnapMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiCusnapMergeToSelect extends ActionVisitorTemplateMergeV2<CusnapInfo, CusnapInfo> {
	
	public VisiCusnapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CusnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CusnapInfo>> getActionClassHook() {
		return StdCusnapSelect.class;
	}
	
	
	
	@Override protected List<CusnapInfo> mergeHook(List<CusnapInfo> recordInfos, List<CusnapInfo> selectedInfos) {	
		return CusnapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

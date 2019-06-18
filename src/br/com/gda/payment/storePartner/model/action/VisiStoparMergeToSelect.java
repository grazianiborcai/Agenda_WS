package br.com.gda.payment.storePartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.info.StoparMerger;

final class VisiStoparMergeToSelect extends ActionVisitorTemplateMergeV2<StoparInfo, StoparInfo> {
	
	public VisiStoparMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StoparInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoparInfo>> getActionClassHook() {
		return StdStoparSelect.class;
	}
	
	
	
	@Override protected List<StoparInfo> mergeHook(List<StoparInfo> recordInfos, List<StoparInfo> selectedInfos) {	
		return StoparMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

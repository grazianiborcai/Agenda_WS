package br.com.mind5.payment.storePartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.info.StoparMerger;

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

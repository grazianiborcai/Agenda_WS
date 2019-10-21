package br.com.mind5.payment.ownerPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.info.OwnparMerger;

final class VisiOwnparMergeToSelect extends ActionVisitorTemplateMergeV2<OwnparInfo, OwnparInfo> {
	
	public VisiOwnparMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OwnparInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OwnparInfo>> getActionClassHook() {
		return StdOwnparSelect.class;
	}
	
	
	
	@Override protected List<OwnparInfo> mergeHook(List<OwnparInfo> recordInfos, List<OwnparInfo> selectedInfos) {	
		return OwnparMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

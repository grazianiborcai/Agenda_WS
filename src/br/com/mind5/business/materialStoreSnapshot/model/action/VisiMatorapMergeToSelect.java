package br.com.mind5.business.materialStoreSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.business.materialStoreSnapshot.info.MatorapMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiMatorapMergeToSelect extends ActionVisitorTemplateMerge<MatorapInfo, MatorapInfo> {
	
	public VisiMatorapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<MatorapInfo>> getActionClassHook() {
		return StdMatorapSelect.class;
	}
	
	
	
	@Override protected List<MatorapInfo> mergeHook(List<MatorapInfo> recordInfos, List<MatorapInfo> selectedInfos) {	
		return MatorapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}

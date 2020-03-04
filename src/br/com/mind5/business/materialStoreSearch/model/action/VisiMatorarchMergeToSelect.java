package br.com.mind5.business.materialStoreSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSearch.info.MatorarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiMatorarchMergeToSelect extends ActionVisitorTemplateMergeV2<MatorarchInfo, MatorarchInfo> {
	
	public VisiMatorarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatorarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatorarchInfo>> getActionClassHook() {
		return StdMatorarchSelect.class;
	}
	
	
	
	@Override protected List<MatorarchInfo> mergeHook(List<MatorarchInfo> baseInfos, List<MatorarchInfo> selectedInfos) {	
		return MatorarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

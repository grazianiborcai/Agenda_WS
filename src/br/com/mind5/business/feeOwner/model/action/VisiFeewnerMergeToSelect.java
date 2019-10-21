package br.com.mind5.business.feeOwner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.info.FeewnerMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiFeewnerMergeToSelect extends ActionVisitorTemplateMergeV2<FeewnerInfo, FeewnerInfo> {

	public VisiFeewnerMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, FeewnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<FeewnerInfo>> getActionClassHook() {
		return StdFeewnerSelect.class;
	}
	
	
	
	@Override protected List<FeewnerInfo> mergeHook(List<FeewnerInfo> recordInfos, List<FeewnerInfo> selectedInfos) {	
		return FeewnerMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

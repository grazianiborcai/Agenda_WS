package br.com.mind5.business.feeOwner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.info.FeewnerMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiFeewnerMergeToSelect extends ActionVisitorTemplateMerge<FeewnerInfo, FeewnerInfo> {

	public VisiFeewnerMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, FeewnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<FeewnerInfo>> getActionClassHook() {
		return StdFeewnerSelect.class;
	}
	
	
	
	@Override protected List<FeewnerInfo> mergeHook(List<FeewnerInfo> recordInfos, List<FeewnerInfo> selectedInfos) {	
		return FeewnerMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}

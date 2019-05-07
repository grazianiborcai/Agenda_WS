package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiOwnerMergeToSelect extends ActionVisitorTemplateMergeV2<OwnerInfo, OwnerInfo> {
	
	public VisiOwnerMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OwnerInfo>> getActionClassHook() {
		return StdOwnerSelect.class;
	}
	
	
	
	@Override protected List<OwnerInfo> mergeHook(List<OwnerInfo> recordInfos, List<OwnerInfo> selectedInfos) {	
		return OwnerMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

package br.com.gda.business.storeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.info.StolevateMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiStolevateMergeToSelect extends ActionVisitorTemplateMergeV2<StolevateInfo, StolevateInfo> {
	
	public VisiStolevateMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StolevateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StolevateInfo>> getActionClassHook() {
		return StdStolevateSelect.class;
	}
	
	
	
	@Override protected List<StolevateInfo> mergeHook(List<StolevateInfo> recordInfos, List<StolevateInfo> selectedInfos) {	
		return StolevateMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

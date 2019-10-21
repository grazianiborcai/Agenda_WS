package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiSchedinapMergeToSelect extends ActionVisitorTemplateMergeV2<SchedinapInfo, SchedinapInfo> {
	
	public VisiSchedinapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, SchedinapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedinapInfo>> getActionClassHook() {
		return StdSchedinapSelect.class;
	}
	
	
	
	@Override protected List<SchedinapInfo> mergeHook(List<SchedinapInfo> recordInfos, List<SchedinapInfo> selectedInfos) {	
		return SchedinapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

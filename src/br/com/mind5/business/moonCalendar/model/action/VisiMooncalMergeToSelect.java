package br.com.mind5.business.moonCalendar.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.business.moonCalendar.info.MooncalMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiMooncalMergeToSelect extends ActionVisitorTemplateMergeV1<MooncalInfo, MooncalInfo> {
	
	public VisiMooncalMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MooncalInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<MooncalInfo>> getActionClassHook() {
		return StdMooncalSelect.class;
	}
	
	
	
	@Override protected List<MooncalInfo> mergeHook(List<MooncalInfo> baseInfos, List<MooncalInfo> selectedInfos) {	
		return MooncalMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}

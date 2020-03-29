package br.com.mind5.business.moonCalendar.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.business.moonCalendar.info.MooncalMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiMooncalMergeToSelect extends ActionVisitorTemplateMerge<MooncalInfo, MooncalInfo> {
	
	public VisiMooncalMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MooncalInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MooncalInfo>> getActionClassHook() {
		return StdMooncalSelect.class;
	}
	
	
	
	@Override protected List<MooncalInfo> mergeHook(List<MooncalInfo> baseInfos, List<MooncalInfo> selectedInfos) {	
		return MooncalMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}

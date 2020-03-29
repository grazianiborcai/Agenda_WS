package br.com.mind5.business.moonCalendar.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.business.moonCalendar.info.MooncalMerger;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.decisionTree.RootMoonaseSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMooncalMergeMoonase extends ActionVisitorTemplateMerge<MooncalInfo, MoonaseInfo> {
	
	public VisiMooncalMergeMoonase(Connection conn, String schemaName) {
		super(conn, schemaName, MoonaseInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MoonaseInfo>> getTreeClassHook() {
		return RootMoonaseSelect.class;
	}
	
	
	
	@Override protected List<MooncalInfo> mergeHook(List<MooncalInfo> baseInfos, List<MoonaseInfo> selectedInfos) {	
		return MooncalMerger.mergeWithMoonase(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.MERGE_WHEN_EMPTY;
	}
}

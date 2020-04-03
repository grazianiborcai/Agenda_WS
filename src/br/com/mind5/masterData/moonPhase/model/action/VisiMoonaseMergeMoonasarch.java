package br.com.mind5.masterData.moonPhase.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.info.MoonaseMerger;
import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.masterData.moonPhaseSearch.model.decisionTree.RootMoonasarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMoonaseMergeMoonasarch extends ActionVisitorTemplateMergeV1<MoonaseInfo, MoonasarchInfo> {
	
	public VisiMoonaseMergeMoonasarch(Connection conn, String schemaName) {
		super(conn, schemaName, MoonasarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MoonasarchInfo>> getTreeClassHook() {
		return RootMoonasarchSelect.class;
	}
	
	
	
	@Override protected List<MoonaseInfo> mergeHook(List<MoonaseInfo> baseInfos, List<MoonasarchInfo> selectedInfos) {	
		return MoonaseMerger.mergeWithMoonasarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}

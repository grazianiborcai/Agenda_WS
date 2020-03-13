package br.com.mind5.business.materialList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.info.MatlisMerger;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.decisionTree.RootMatarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatlisMergeMatarch extends ActionVisitorTemplateMergeV2<MatlisInfo, MatarchInfo> {
	
	public VisiMatlisMergeMatarch(Connection conn, String schemaName) {
		super(conn, schemaName, MatarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatarchInfo>> getTreeClassHook() {
		return RootMatarchSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> mergeHook(List<MatlisInfo> baseInfos, List<MatarchInfo> selectedInfos) {	
		return MatlisMerger.mergeWithMatarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

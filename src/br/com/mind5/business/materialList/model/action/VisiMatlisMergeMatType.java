package br.com.mind5.business.materialList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMatTypeSelect;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.info.MatlisMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatlisMergeMatType extends ActionVisitorTemplateMergeV2<MatlisInfo, MatTypeInfo> {
	
	public VisiMatlisMergeMatType(Connection conn, String schemaName) {
		super(conn, schemaName, MatTypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatTypeInfo>> getTreeClassHook() {
		return RootMatTypeSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> mergeHook(List<MatlisInfo> baseInfos, List<MatTypeInfo> selectedInfos) {	
		return MatlisMerger.mergeWithMatType(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

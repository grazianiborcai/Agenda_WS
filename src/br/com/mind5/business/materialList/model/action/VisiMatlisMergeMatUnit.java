package br.com.mind5.business.materialList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMatUnitSelect;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.info.MatlisMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatlisMergeMatUnit extends ActionVisitorTemplateMergeV1<MatlisInfo, MatUnitInfo> {
	
	public VisiMatlisMergeMatUnit(Connection conn, String schemaName) {
		super(conn, schemaName, MatUnitInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatUnitInfo>> getTreeClassHook() {
		return RootMatUnitSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> mergeHook(List<MatlisInfo> baseInfos, List<MatUnitInfo> selectedInfos) {	
		return MatlisMerger.mergeWithMatUnit(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}

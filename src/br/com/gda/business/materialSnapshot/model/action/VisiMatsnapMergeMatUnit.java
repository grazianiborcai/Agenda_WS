package br.com.gda.business.materialSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatUnitSelect;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.info.MatsnapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatsnapMergeMatUnit extends ActionVisitorTemplateMergeV2<MatsnapInfo, MatUnitInfo> {
	
	public VisiMatsnapMergeMatUnit(Connection conn, String schemaName) {
		super(conn, schemaName, MatUnitInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatUnitInfo>> getTreeClassHook() {
		return RootMatUnitSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> mergeHook(List<MatsnapInfo> recordInfos, List<MatUnitInfo> selectedInfos) {	
		return MatsnapMerger.mergeWithMatUnit(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

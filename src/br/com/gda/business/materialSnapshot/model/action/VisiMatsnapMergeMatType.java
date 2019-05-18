package br.com.gda.business.materialSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatTypeSelect;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.info.MatsnapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatsnapMergeMatType extends ActionVisitorTemplateMergeV2<MatsnapInfo, MatTypeInfo> {
	
	public VisiMatsnapMergeMatType(Connection conn, String schemaName) {
		super(conn, schemaName, MatTypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatTypeInfo>> getTreeClassHook() {
		return RootMatTypeSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> mergeHook(List<MatsnapInfo> recordInfos, List<MatTypeInfo> selectedInfos) {	
		return MatsnapMerger.mergeWithMatType(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

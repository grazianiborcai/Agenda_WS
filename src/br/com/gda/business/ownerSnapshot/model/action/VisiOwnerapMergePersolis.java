package br.com.gda.business.ownerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.business.ownerSnapshot.info.OwnerapMerger;
import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.business.personList.model.decisionTree.RootPersolisSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwnerapMergePersolis extends ActionVisitorTemplateMergeV2<OwnerapInfo, PersolisInfo> {
	
	public VisiOwnerapMergePersolis(Connection conn, String schemaName) {
		super(conn, schemaName, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersolisInfo>> getTreeClassHook() {
		return RootPersolisSelect.class;
	}
	
	
	
	@Override protected List<OwnerapInfo> mergeHook(List<OwnerapInfo> recordInfos, List<PersolisInfo> selectedInfos) {	
		return OwnerapMerger.mergeWithPersolis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

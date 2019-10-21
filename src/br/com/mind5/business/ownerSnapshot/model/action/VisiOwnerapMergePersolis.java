package br.com.mind5.business.ownerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.ownerSnapshot.info.OwnerapMerger;
import br.com.mind5.business.personList.info.PersolisCopier;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.model.decisionTree.RootPersolisSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiOwnerapMergePersolis extends ActionVisitorTemplateMergeV2<OwnerapInfo, PersolisInfo> {
	
	public VisiOwnerapMergePersolis(Connection conn, String schemaName) {
		super(conn, schemaName, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersolisInfo>> getTreeClassHook() {
		return RootPersolisSelect.class;
	}

	

	protected List<PersolisInfo> toActionClassHook(List<OwnerapInfo> recordInfos) {
		return PersolisCopier.copyFromOwnerap(recordInfos);	
	}
	
	
	
	@Override protected List<OwnerapInfo> mergeHook(List<OwnerapInfo> recordInfos, List<PersolisInfo> selectedInfos) {	
		return OwnerapMerger.mergeWithPersolis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

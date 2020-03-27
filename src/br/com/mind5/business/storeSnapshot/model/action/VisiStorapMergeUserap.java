package br.com.mind5.business.storeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.userSnapshot.info.UserapCopier;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.model.decisionTree.RootUserapSelect;

final class VisiStorapMergeUserap extends ActionVisitorTemplateMerge<StorapInfo, UserapInfo> {
	
	public VisiStorapMergeUserap(Connection conn, String schemaName) {
		super(conn, schemaName, UserapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserapInfo>> getTreeClassHook() {
		return RootUserapSelect.class;
	}
	
	
	
	@Override protected List<UserapInfo> toActionClassHook(List<StorapInfo> recordInfos) {
		return UserapCopier.copyFromStorap(recordInfos);	
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> recordInfos, List<UserapInfo> selectedInfos) {	
		return StorapMerger.mergeWithUserap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.MERGE_WHEN_EMPTY;
	}
}

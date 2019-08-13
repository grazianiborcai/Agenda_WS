package br.com.gda.business.storeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.business.storeSnapshot.info.StorapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.userSnapshot.info.UserapCopier;
import br.com.gda.security.userSnapshot.info.UserapInfo;
import br.com.gda.security.userSnapshot.model.decisionTree.RootUserapSelect;

final class VisiStorapMergeUserap extends ActionVisitorTemplateMergeV2<StorapInfo, UserapInfo> {
	
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
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

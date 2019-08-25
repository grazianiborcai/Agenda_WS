package br.com.gda.business.orderSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
import br.com.gda.business.orderSnapshot.info.OrdnapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.userList.info.UselisInfo;
import br.com.gda.security.userList.model.decisionTree.RootUselisSelect;

final class VisiOrdnapMergeUselis extends ActionVisitorTemplateMergeV2<OrdnapInfo, UselisInfo> {
	
	public VisiOrdnapMergeUselis(Connection conn, String schemaName) {
		super(conn, schemaName, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return RootUselisSelect.class;
	}
	
	
	
	@Override protected List<OrdnapInfo> mergeHook(List<OrdnapInfo> recordInfos, List<UselisInfo> selectedInfos) {	
		return OrdnapMerger.mergeWithUselis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

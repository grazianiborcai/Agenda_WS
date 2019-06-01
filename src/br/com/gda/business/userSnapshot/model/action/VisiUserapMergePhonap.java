package br.com.gda.business.userSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.phoneSnapshot.model.decisionTree.RootPhonapSelect;
import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.business.userSnapshot.info.UserapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiUserapMergePhonap extends ActionVisitorTemplateMergeV2<UserapInfo, PhonapInfo> {
	
	public VisiUserapMergePhonap(Connection conn, String schemaName) {
		super(conn, schemaName, PhonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonapInfo>> getTreeClassHook() {
		return RootPhonapSelect.class;
	}
	
	
	
	@Override protected List<UserapInfo> mergeHook(List<UserapInfo> recordInfos, List<PhonapInfo> selectedInfos) {	
		return UserapMerger.mergeWithPhonap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

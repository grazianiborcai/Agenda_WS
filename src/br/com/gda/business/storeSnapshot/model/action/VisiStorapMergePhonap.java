package br.com.gda.business.storeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhonapCopier;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.phoneSnapshot.model.decisionTree.RootPhonapSelect;
import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.business.storeSnapshot.info.StorapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStorapMergePhonap extends ActionVisitorTemplateMergeV2<StorapInfo, PhonapInfo> {
	
	public VisiStorapMergePhonap(Connection conn, String schemaName) {
		super(conn, schemaName, PhonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonapInfo>> getTreeClassHook() {
		return RootPhonapSelect.class;
	}
	
	
	
	@Override protected List<PhonapInfo> toActionClassHook(List<StorapInfo> recordInfos) {
		return PhonapCopier.copyFromStorap(recordInfos);	
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> recordInfos, List<PhonapInfo> selectedInfos) {	
		return StorapMerger.mergeWithPhonap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

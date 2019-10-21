package br.com.mind5.business.storeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapCopier;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.companySnapshot.model.decisionTree.RootCompnapSelect;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStorapMergeCompnap extends ActionVisitorTemplateMergeV2<StorapInfo, CompnapInfo> {
	
	public VisiStorapMergeCompnap(Connection conn, String schemaName) {
		super(conn, schemaName, CompnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CompnapInfo>> getTreeClassHook() {
		return RootCompnapSelect.class;
	}
	
	
	
	@Override protected List<CompnapInfo> toActionClassHook(List<StorapInfo> recordInfos) {
		return CompnapCopier.copyFromStorap(recordInfos);	
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> recordInfos, List<CompnapInfo> selectedInfos) {	
		return StorapMerger.mergeWithCompnap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

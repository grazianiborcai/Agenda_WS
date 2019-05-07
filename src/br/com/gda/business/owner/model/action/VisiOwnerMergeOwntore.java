package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.business.ownerStore.info.OwntoreCopier;
import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.business.ownerStore.model.decisionTree.RootOwntoreSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwnerMergeOwntore extends ActionVisitorTemplateMergeV2<OwnerInfo, OwntoreInfo> {
	
	public VisiOwnerMergeOwntore(Connection conn, String schemaName) {
		super(conn, schemaName, OwntoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwntoreInfo>> getTreeClassHook() {
		return RootOwntoreSelect.class;
	}
	
	
	
	@Override protected List<OwntoreInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return OwntoreCopier.copyFromOwner(recordInfos);	
	}
	
	
	
	@Override protected List<OwnerInfo> mergeHook(List<OwnerInfo> recordInfos, List<OwntoreInfo> selectedInfos) {	
		return OwnerMerger.mergeWithOwntore(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

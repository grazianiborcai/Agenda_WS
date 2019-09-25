package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.business.storeList.info.StolisCopier;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.storeList.model.decisionTree.RootStolisSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwnerMergeStolis extends ActionVisitorTemplateMergeV2<OwnerInfo, StolisInfo> {
	
	public VisiOwnerMergeStolis(Connection conn, String schemaName) {
		super(conn, schemaName, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return RootStolisSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return StolisCopier.copyFromOwner(recordInfos);	
	}
	
	
	
	@Override protected List<OwnerInfo> mergeHook(List<OwnerInfo> recordInfos, List<StolisInfo> selectedInfos) {	
		return OwnerMerger.mergeWithStolis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

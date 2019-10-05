package br.com.gda.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.info.StoreMerger;
import br.com.gda.file.fileImageList.info.FimistCopier;
import br.com.gda.file.fileImageList.info.FimistInfo;
import br.com.gda.file.fileImageList.model.decisionTree.RootFimistSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStoreMergeFimist extends ActionVisitorTemplateMergeV2<StoreInfo, FimistInfo> {
	
	public VisiStoreMergeFimist(Connection conn, String schemaName) {
		super(conn, schemaName, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimistInfo>> getTreeClassHook() {
		return RootFimistSelect.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return FimistCopier.copyFromStore(recordInfos);	
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> recordInfos, List<FimistInfo> selectedInfos) {	
		return StoreMerger.mergeWithFimist(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

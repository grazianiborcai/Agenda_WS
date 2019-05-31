package br.com.gda.business.feeOwner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.business.feeDefault.model.decisionTree.RootFeedefSelectService;
import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.business.feeOwner.info.FeewnerMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiFeewnerMergeFeedef extends ActionVisitorTemplateMergeV2<FeewnerInfo, FeedefInfo> {
	
	public VisiFeewnerMergeFeedef(Connection conn, String schemaName) {
		super(conn, schemaName, FeedefInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeedefInfo>> getTreeClassHook() {
		return RootFeedefSelectService.class;
	}
	
	
	
	@Override protected List<FeewnerInfo> mergeHook(List<FeewnerInfo> recordInfos, List<FeedefInfo> selectedInfos) {	
		return FeewnerMerger.mergeWithFeedef(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

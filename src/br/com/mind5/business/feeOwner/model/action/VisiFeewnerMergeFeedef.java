package br.com.mind5.business.feeOwner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.business.feeDefault.model.decisionTree.RootFeedefSelectService;
import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.info.FeewnerMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiFeewnerMergeFeedef extends ActionVisitorTemplateMergeV1<FeewnerInfo, FeedefInfo> {
	
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
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}

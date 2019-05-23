package br.com.gda.business.cartItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.info.CartemMerger;
import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.business.feeDefault.model.decisionTree.RootFeeDefaultSelectService;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartemMergeFeeDefault extends ActionVisitorTemplateMergeV2<CartemInfo, FeeDefaultInfo> {
	
	public VisiCartemMergeFeeDefault(Connection conn, String schemaName) {
		super(conn, schemaName, FeeDefaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeeDefaultInfo>> getTreeClassHook() {
		return RootFeeDefaultSelectService.class;
	}
	
	
	
	@Override protected List<CartemInfo> mergeHook(List<CartemInfo> recordInfos, List<FeeDefaultInfo> selectedInfos) {	
		return CartemMerger.mergeWithFeeDefault(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

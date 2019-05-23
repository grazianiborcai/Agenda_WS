package br.com.gda.business.cartItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.info.CartemMerger;
import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.business.feeStore.model.decisionTree.RootFeetoreSelectService;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartemMergeFeetore extends ActionVisitorTemplateMergeV2<CartemInfo, FeetoreInfo> {
	
	public VisiCartemMergeFeetore(Connection conn, String schemaName) {
		super(conn, schemaName, FeetoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeetoreInfo>> getTreeClassHook() {
		return RootFeetoreSelectService.class;
	}
	
	
	
	@Override protected List<CartemInfo> mergeHook(List<CartemInfo> recordInfos, List<FeetoreInfo> selectedInfos) {	
		return CartemMerger.mergeWithFeetore(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

package br.com.gda.business.cartItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.info.CartemMerger;
import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.business.totalAmount.model.decisionTree.RootTotAmountCompute;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartemMergeTotAmount extends ActionVisitorTemplateMergeV2<CartemInfo, TotAmountInfo> {
	
	public VisiCartemMergeTotAmount(Connection conn, String schemaName) {
		super(conn, schemaName, TotAmountInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TotAmountInfo>> getTreeClassHook() {
		return RootTotAmountCompute.class;
	}
	
	
	
	@Override protected List<CartemInfo> mergeHook(List<CartemInfo> recordInfos, List<TotAmountInfo> selectedInfos) {	
		return CartemMerger.mergeWithTotAmount(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

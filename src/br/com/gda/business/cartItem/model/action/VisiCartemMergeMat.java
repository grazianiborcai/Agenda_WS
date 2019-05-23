package br.com.gda.business.cartItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.info.CartemMerger;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartemMergeMat extends ActionVisitorTemplateMergeV2<CartemInfo, MatInfo> {
	
	public VisiCartemMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected List<CartemInfo> mergeHook(List<CartemInfo> recordInfos, List<MatInfo> selectedInfos) {	
		return CartemMerger.mergeWithMat(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

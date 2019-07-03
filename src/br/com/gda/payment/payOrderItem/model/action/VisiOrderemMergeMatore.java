package br.com.gda.payment.payOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.model.decisionTree.RootMatoreSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.payOrderItem.info.PayordemMerger;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

final class VisiOrderemMergeMatore extends ActionVisitorTemplateMergeV2<PayordemInfo, MatoreInfo> {
	
	public VisiOrderemMergeMatore(Connection conn, String schemaName) {
		super(conn, schemaName, MatoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoreInfo>> getTreeClassHook() {
		return RootMatoreSelect.class;
	}
	
	
	
	@Override protected List<PayordemInfo> mergeHook(List<PayordemInfo> recordInfos, List<MatoreInfo> selectedInfos) {	
		return PayordemMerger.mergeWithMatore(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

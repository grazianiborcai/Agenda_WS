package br.com.gda.payment.payOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.material.info.MatCopier;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.payOrderItem.info.PayordemMerger;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

final class VisiOrderemMergeMat extends ActionVisitorTemplateMergeV2<PayordemInfo, MatInfo> {
	
	public VisiOrderemMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> toActionClassHook(List<PayordemInfo> recordInfos) {
		return MatCopier.copyFromOrderem(recordInfos);	
	}
	
	
	
	@Override protected List<PayordemInfo> mergeHook(List<PayordemInfo> recordInfos, List<MatInfo> selectedInfos) {	
		return PayordemMerger.mergeWithMat(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}

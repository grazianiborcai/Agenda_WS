package br.com.gda.payment.refundOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.model.decisionTree.RootCusparSelect;
import br.com.gda.payment.refundOrderItem.info.RefemInfo;
import br.com.gda.payment.refundOrderItem.info.RefemMerger;

final class VisiRefemMergeCuspar extends ActionVisitorTemplateMergeV2<RefemInfo, CusparInfo> {
	
	public VisiRefemMergeCuspar(Connection conn, String schemaName) {
		super(conn, schemaName, CusparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return RootCusparSelect.class;
	}
	
	
	
	@Override protected List<RefemInfo> mergeHook(List<RefemInfo> recordInfos, List<CusparInfo> selectedInfos) {	
		return RefemMerger.mergeWithCuspar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

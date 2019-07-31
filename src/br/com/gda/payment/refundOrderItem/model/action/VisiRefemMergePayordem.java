package br.com.gda.payment.refundOrderItem.model.action;

import java.sql.Connection;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.payOrderItem.model.decisionTree.RootPayordemSelect;
import br.com.gda.payment.refundOrderItem.info.RefemInfo;

final class VisiRefemMergePayordem extends ActionVisitorTemplateMergeV2<RefemInfo, PayordemInfo> {
	
	public VisiRefemMergePayordem(Connection conn, String schemaName) {
		super(conn, schemaName, PayordemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordemInfo>> getTreeClassHook() {
		return RootPayordemSelect.class;
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}

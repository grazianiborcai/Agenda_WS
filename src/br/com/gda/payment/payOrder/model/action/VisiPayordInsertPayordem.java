package br.com.gda.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;


import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.info.PayordMerger;
import br.com.gda.payment.payOrderItem.info.PayordemCopier;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.payOrderItem.model.decisionTree.RootPayordemInsert;

final class VisiPayordInsertPayordem extends ActionVisitorTemplateAction<PayordInfo, PayordemInfo> {
	public VisiPayordInsertPayordem(Connection conn, String schemaName) {
		super(conn, schemaName, PayordInfo.class, PayordemInfo.class);
	}
	
	
	
	@Override protected ActionStd<PayordemInfo> getActionHook(DeciTreeOption<PayordemInfo> option) {
		return new RootPayordemInsert(option).toAction();
	}
	
	
	
	@Override protected List<PayordemInfo> toActionClassHook(List<PayordInfo> baseInfos) {
		return PayordemCopier.copyFromPayordToWrite(baseInfos);
	}
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<PayordemInfo> results) {
		return PayordMerger.mergeWithPayordem(results, baseInfos);
	}
}

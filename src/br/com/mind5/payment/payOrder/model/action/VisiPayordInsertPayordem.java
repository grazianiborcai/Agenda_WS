package br.com.mind5.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;
import br.com.mind5.payment.payOrderItem.info.PayordemCopier;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.decisionTree.RootPayordemInsert;

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
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		return PayordMerger.mergeWithPayordem(baseInfos, selectedInfos);
	}
}

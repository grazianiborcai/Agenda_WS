package br.com.mind5.payment.refundOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.info.RefemMerger;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.decisionTree.RootRefumoipRefund;

final class VisiRefemRefumoipRefund extends ActionVisitorTemplateAction<RefemInfo, RefumoipInfo> {
	
	public VisiRefemRefumoipRefund(Connection conn, String schemaName) {
		super(conn, schemaName, RefemInfo.class, RefumoipInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<RefumoipInfo> getActionHook(DeciTreeOption<RefumoipInfo> option) {
		return new RootRefumoipRefund(option).toAction();
	}
	
	
	
	@Override protected List<RefemInfo> toBaseClassHook(List<RefemInfo> baseInfos, List<RefumoipInfo> results) {	
		return RefemMerger.mergeWithRefumoip(baseInfos, results);
	}
}

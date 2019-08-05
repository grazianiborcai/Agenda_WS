package br.com.gda.payment.refundOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.gda.payment.partnerMoip.refundMoip.model.decisionTree.RootRefumoipRefund;
import br.com.gda.payment.refundOrderItem.info.RefemInfo;
import br.com.gda.payment.refundOrderItem.info.RefemMerger;

final class VisiRefemRefumoipRefund extends ActionVisitorTemplateAction<RefemInfo, RefumoipInfo> {
	
	public VisiRefemRefumoipRefund(Connection conn, String schemaName) {
		super(conn, schemaName, RefemInfo.class, RefumoipInfo.class);
	}
	
	
	
	@Override protected ActionStd<RefumoipInfo> getActionHook(DeciTreeOption<RefumoipInfo> option) {
		return new RootRefumoipRefund(option).toAction();
	}
	
	
	
	@Override protected List<RefemInfo> toBaseClassHook(List<RefemInfo> baseInfos, List<RefumoipInfo> results) {	
		return RefemMerger.mergeWithRefumoip(results, baseInfos);
	}
}

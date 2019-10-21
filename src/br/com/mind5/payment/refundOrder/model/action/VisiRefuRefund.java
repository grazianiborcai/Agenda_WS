package br.com.mind5.payment.refundOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrderItem.info.RefemCopier;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.decisionTree.RootRefemRefund;

final class VisiRefuRefund extends ActionVisitorTemplateAction<RefuInfo, RefemInfo> {
	
	public VisiRefuRefund(Connection conn, String schemaName) {
		super(conn, schemaName, RefuInfo.class, RefemInfo.class);
	}
	
	
	
	@Override protected ActionStd<RefemInfo> getActionHook(DeciTreeOption<RefemInfo> option) {
		return new RootRefemRefund(option).toAction();
	}
	
	
	
	protected List<RefemInfo> toActionClassHook(List<RefuInfo> recordInfos) {
		return RefemCopier.copyFromRefu(recordInfos);
	}
	
	
	
	@Override protected List<RefuInfo> toBaseClassHook(List<RefuInfo> baseInfos, List<RefemInfo> results) {	
		return baseInfos;
	}
}

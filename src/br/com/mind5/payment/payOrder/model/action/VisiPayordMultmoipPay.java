package br.com.mind5.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipCopier;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.decisionTree.RootMultmoipPay;

final class VisiPayordMultmoipPay extends ActionVisitorTemplateAction<PayordInfo, MultmoipInfo> {
	public VisiPayordMultmoipPay(Connection conn, String schemaName) {
		super(conn, schemaName, PayordInfo.class, MultmoipInfo.class);
	}
	
	
	
	@Override protected ActionStd<MultmoipInfo> getActionHook(DeciTreeOption<MultmoipInfo> option) {
		return new RootMultmoipPay(option).toAction();
	}
	
	
	
	@Override protected List<MultmoipInfo> toActionClassHook(List<PayordInfo> baseInfos) {
		return MultmoipCopier.copyFromPayord(baseInfos);
	}
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<MultmoipInfo> selectedInfos) {
		return PayordMerger.mergeWithMultmoip(baseInfos, selectedInfos);
	}
}

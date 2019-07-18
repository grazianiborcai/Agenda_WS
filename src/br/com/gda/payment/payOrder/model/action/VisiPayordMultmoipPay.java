package br.com.gda.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipCopier;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.decisionTree.RootMultmoipPay;
import br.com.gda.payment.payOrder.info.PayordInfo;

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
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<MultmoipInfo> results) {
		return baseInfos;
	}
}

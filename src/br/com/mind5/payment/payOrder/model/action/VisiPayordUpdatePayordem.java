package br.com.mind5.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;
import br.com.mind5.payment.payOrderItem.info.PayordemCopier;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.decisionTree.RootPayordemUpdate;

final class VisiPayordUpdatePayordem extends ActionVisitorTemplateAction<PayordInfo, PayordemInfo> {
	public VisiPayordUpdatePayordem(Connection conn, String schemaName) {
		super(conn, schemaName, PayordInfo.class, PayordemInfo.class);
	}
	
	
	
	@Override protected ActionStd<PayordemInfo> getActionHook(DeciTreeOption<PayordemInfo> option) {
		return new RootPayordemUpdate(option).toAction();
	}
	
	
	
	@Override protected List<PayordemInfo> toActionClassHook(List<PayordInfo> baseInfos) {
		List<OrdmoipInfo> ordmoips = new ArrayList<>();
		
		for (PayordInfo eachBase : baseInfos) {
			ordmoips.addAll(eachBase.ordmoips);
		}
		
		return PayordemCopier.copyFromOrdmoip(ordmoips);
	}
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<PayordemInfo> results) {
		return PayordMerger.mergeWithPayordem(results, baseInfos);
	}
}

package br.com.gda.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.customerPartner.info.CusparCopier;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.model.decisionTree.RootCusparInsert;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.info.PayordMerger;

final class VisiPayordInsertCuspar extends ActionVisitorTemplateAction<PayordInfo, CusparInfo> {
	public VisiPayordInsertCuspar(Connection conn, String schemaName) {
		super(conn, schemaName, PayordInfo.class, CusparInfo.class);
	}
	
	
	
	@Override protected ActionStd<CusparInfo> getActionHook(DeciTreeOption<CusparInfo> option) {
		return new RootCusparInsert(option).toAction();
	}
	
	
	
	@Override protected List<CusparInfo> toActionClassHook(List<PayordInfo> baseInfos) {
		return CusparCopier.copyFromPayord(baseInfos);
	}
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<CusparInfo> results) {
		return PayordMerger.mergeWithCuspar(results, baseInfos);
	}
}

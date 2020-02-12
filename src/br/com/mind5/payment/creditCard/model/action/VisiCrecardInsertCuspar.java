package br.com.mind5.payment.creditCard.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;
import br.com.mind5.payment.customerPartner.info.CusparCopier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.RootCusparInsertAuth;

final class VisiCrecardInsertCuspar extends ActionVisitorTemplateAction<CrecardInfo, CusparInfo> {
	public VisiCrecardInsertCuspar(Connection conn, String schemaName) {
		super(conn, schemaName, CrecardInfo.class, CusparInfo.class);
	}
	
	
	
	@Override protected ActionStd<CusparInfo> getActionHook(DeciTreeOption<CusparInfo> option) {
		return new RootCusparInsertAuth(option).toAction();
	}
	
	
	
	@Override protected List<CusparInfo> toActionClassHook(List<CrecardInfo> baseInfos) {
		return CusparCopier.copyFromCrecard(baseInfos);
	}
	
	
	
	@Override protected List<CrecardInfo> toBaseClassHook(List<CrecardInfo> baseInfos, List<CusparInfo> selectedInfos) {
		return CrecardMerger.mergeWithCuspar(baseInfos, selectedInfos);
	}
}

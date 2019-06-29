package br.com.gda.payment.creditCard.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.info.CrecardMerger;
import br.com.gda.payment.customerPartner.info.CusparCopier;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.model.decisionTree.RootCusparInsert;

final class VisiCrecardInsertCuspar extends ActionVisitorTemplateAction<CrecardInfo, CusparInfo> {
	public VisiCrecardInsertCuspar(Connection conn, String schemaName) {
		super(conn, schemaName, CrecardInfo.class, CusparInfo.class);
	}
	
	
	
	@Override protected ActionStd<CusparInfo> getActionHook(DeciTreeOption<CusparInfo> option) {
		return new RootCusparInsert(option).toAction();
	}
	
	
	
	@Override protected List<CusparInfo> toActionClassHook(List<CrecardInfo> baseInfos) {
		return CusparCopier.copyFromCrecard(baseInfos);
	}
	
	
	
	@Override protected List<CrecardInfo> toBaseClassHook(List<CrecardInfo> baseInfos, List<CusparInfo> results) {
		return CrecardMerger.mergeWithCuspar(results, baseInfos);
	}
}

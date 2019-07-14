package br.com.gda.payment.creditCard.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.info.CrecardMerger;
import br.com.gda.payment.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.decisionTree.RootCremoipAdd;


final class VisiCrecardAddCremoip extends ActionVisitorTemplateAction<CrecardInfo, CremoipInfo> {
	
	public VisiCrecardAddCremoip(Connection conn, String schemaName) {
		super(conn, schemaName, CrecardInfo.class, CremoipInfo.class);
	}
	
	
	
	@Override protected ActionStd<CremoipInfo> getActionHook(DeciTreeOption<CremoipInfo> option) {
		return new RootCremoipAdd(option).toAction();
	}
	
	
	
	@Override protected List<CrecardInfo> toBaseClassHook(List<CrecardInfo> baseInfos, List<CremoipInfo> results) {
		return CrecardMerger.mergeWithCremoip(results, baseInfos);
	}
}

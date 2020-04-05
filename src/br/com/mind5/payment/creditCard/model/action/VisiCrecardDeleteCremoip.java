package br.com.mind5.payment.creditCard.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree.RootCremoipDelete;


final class VisiCrecardDeleteCremoip extends ActionVisitorTemplateActionV1<CrecardInfo, CremoipInfo> {
	
	public VisiCrecardDeleteCremoip(Connection conn, String schemaName) {
		super(conn, schemaName, CrecardInfo.class, CremoipInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<CremoipInfo> getActionHook(DeciTreeOption<CremoipInfo> option) {
		return new RootCremoipDelete(option).toAction();
	}
	
	
	
	@Override protected List<CrecardInfo> toBaseClassHook(List<CrecardInfo> baseInfos, List<CremoipInfo> results) {
		return baseInfos;
	}
}

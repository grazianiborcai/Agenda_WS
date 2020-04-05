package br.com.mind5.payment.creditCard.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipCopier;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree.RootCremoipAdd;


final class VisiCrecardAddCremoip extends ActionVisitorTemplateActionV1<CrecardInfo, CremoipInfo> {
	
	public VisiCrecardAddCremoip(Connection conn, String schemaName) {
		super(conn, schemaName, CrecardInfo.class, CremoipInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<CremoipInfo> getActionHook(DeciTreeOption<CremoipInfo> option) {
		return new RootCremoipAdd(option).toAction();
	}
	
	
	
	@Override protected List<CremoipInfo> toActionClassHook(List<CrecardInfo> baseInfos) {
		return CremoipCopier.copyFromCrecard(baseInfos);
	}
	
	
	
	@Override protected List<CrecardInfo> toBaseClassHook(List<CrecardInfo> baseInfos, List<CremoipInfo> selectedInfos) {
		return CrecardMerger.mergeWithCremoip(baseInfos, selectedInfos);
	}
}

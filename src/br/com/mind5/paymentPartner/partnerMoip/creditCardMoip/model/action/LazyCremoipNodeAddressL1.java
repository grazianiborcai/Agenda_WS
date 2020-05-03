package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree.NodeCremoipAddressL1;

public final class LazyCremoipNodeAddressL1 extends ActionLazyTemplateV2<CremoipInfo, CremoipInfo> {

	public LazyCremoipNodeAddressL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CremoipInfo> translateRecordInfosHook(List<CremoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CremoipInfo> getInstanceOfActionHook(DeciTreeOption<CremoipInfo> option) {
		return new NodeCremoipAddressL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CremoipInfo> translateResultHook(DeciResult<CremoipInfo> result) {
		return result;
	}
}

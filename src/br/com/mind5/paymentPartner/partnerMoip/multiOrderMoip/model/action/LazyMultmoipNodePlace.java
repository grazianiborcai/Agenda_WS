package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.decisionTree.NodeMultmoipPlace;

public final class LazyMultmoipNodePlace extends ActionLazyTemplate<MultmoipInfo, MultmoipInfo> {

	public LazyMultmoipNodePlace(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MultmoipInfo> translateRecordInfosHook(List<MultmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MultmoipInfo> getInstanceOfActionHook(DeciTreeOption<MultmoipInfo> option) {
		return new NodeMultmoipPlace(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MultmoipInfo> translateResultHook(DeciResult<MultmoipInfo> result) {
		return result;
	}
}

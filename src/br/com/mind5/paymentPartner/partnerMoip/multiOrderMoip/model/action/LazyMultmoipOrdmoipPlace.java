package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class LazyMultmoipOrdmoipPlace extends ActionLazyTemplate<MultmoipInfo, MultmoipInfo> {

	public LazyMultmoipOrdmoipPlace(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MultmoipInfo> translateRecordInfosHook(List<MultmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<MultmoipInfo> getInstanceOfActionHook(DeciTreeOption<MultmoipInfo> option) {
		return new StdMultmoipOrdmoipPlace(option);
	}
	
	
	
	@Override protected DeciResult<MultmoipInfo> translateResultHook(DeciResult<MultmoipInfo> result) {
		return result;
	}
}

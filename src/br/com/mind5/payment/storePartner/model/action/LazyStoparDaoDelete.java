package br.com.mind5.payment.storePartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class LazyStoparDaoDelete extends ActionLazyTemplateV2<StoparInfo, StoparInfo> {
	
	public LazyStoparDaoDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoparInfo> translateRecordInfosHook(List<StoparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StoparInfo> getInstanceOfActionHook(DeciTreeOption<StoparInfo> option) {
		return new StdStoparDaoDelete(option);
	}
	
	
	
	@Override protected DeciResult<StoparInfo> translateResultHook(DeciResult<StoparInfo> result) {
		return result;
	}
}
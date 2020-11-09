package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class LazyPeresmoipDaoDelete extends ActionLazyTemplateV2<PeresmoipInfo, PeresmoipInfo> {
	
	public LazyPeresmoipDaoDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PeresmoipInfo> translateRecordInfosHook(List<PeresmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PeresmoipInfo> getInstanceOfActionHook(DeciTreeOption<PeresmoipInfo> option) {
		return new StdPeresmoipDaoDelete(option);
	}
	
	
	
	@Override protected DeciResult<PeresmoipInfo> translateResultHook(DeciResult<PeresmoipInfo> result) {
		return result;
	}
}

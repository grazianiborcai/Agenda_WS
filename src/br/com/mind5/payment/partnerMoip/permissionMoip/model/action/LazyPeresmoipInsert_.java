package br.com.mind5.payment.partnerMoip.permissionMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class LazyPeresmoipInsert_ extends ActionLazyTemplate<PeresmoipInfo, PeresmoipInfo> {
	
	public LazyPeresmoipInsert_(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PeresmoipInfo> translateRecordInfosHook(List<PeresmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PeresmoipInfo> getInstanceOfActionHook(DeciTreeOption<PeresmoipInfo> option) {
		return new StdPeresmoipInsert(option);
	}
	
	
	
	@Override protected DeciResult<PeresmoipInfo> translateResultHook(DeciResult<PeresmoipInfo> result) {
		return result;
	}
}

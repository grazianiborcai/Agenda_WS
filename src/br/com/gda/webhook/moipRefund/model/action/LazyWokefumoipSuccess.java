package br.com.gda.webhook.moipRefund.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.webhook.moipRefund.info.WokefumoipInfo;

public final class LazyWokefumoipSuccess extends ActionLazyTemplate<WokefumoipInfo, WokefumoipInfo> {
	
	public LazyWokefumoipSuccess(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<WokefumoipInfo> translateRecordInfosHook(List<WokefumoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<WokefumoipInfo> getInstanceOfActionHook(DeciTreeOption<WokefumoipInfo> option) {
		return new StdWokefumoipSuccess(option);
	}
	
	
	
	@Override protected DeciResult<WokefumoipInfo> translateResultHook(DeciResult<WokefumoipInfo> result) {
		return result;
	}
}

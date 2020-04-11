package br.com.mind5.webhook.moipRefund.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class LazyWokefumoipPaytusRefresh extends ActionLazyTemplateV1<WokefumoipInfo, WokefumoipInfo> {

	public LazyWokefumoipPaytusRefresh(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<WokefumoipInfo> translateRecordInfosHook(List<WokefumoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<WokefumoipInfo> getInstanceOfActionHook(DeciTreeOption<WokefumoipInfo> option) {
		return new StdWokefumoipPaytusRefresh(option);
	}
	
	
	
	@Override protected DeciResult<WokefumoipInfo> translateResultHook(DeciResult<WokefumoipInfo> result) {
		return result;
	}
}

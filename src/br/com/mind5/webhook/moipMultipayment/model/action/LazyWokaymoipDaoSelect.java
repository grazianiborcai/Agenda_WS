package br.com.mind5.webhook.moipMultipayment.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class LazyWokaymoipDaoSelect extends ActionLazyTemplate<WokaymoipInfo, WokaymoipInfo> {
	
	public LazyWokaymoipDaoSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<WokaymoipInfo> translateRecordInfosHook(List<WokaymoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<WokaymoipInfo> getInstanceOfActionHook(DeciTreeOption<WokaymoipInfo> option) {
		return new StdWokaymoipDaoSelect(option);
	}
	
	
	
	@Override protected DeciResult<WokaymoipInfo> translateResultHook(DeciResult<WokaymoipInfo> result) {
		return result;
	}
}

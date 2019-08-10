package br.com.gda.webhook.moipMultipayment.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.webhook.moipMultipayment.info.WokaymoipInfo;

public final class LazyWokaymoipSelect extends ActionLazyTemplate<WokaymoipInfo, WokaymoipInfo> {
	
	public LazyWokaymoipSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<WokaymoipInfo> translateRecordInfosHook(List<WokaymoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<WokaymoipInfo> getInstanceOfActionHook(DeciTreeOption<WokaymoipInfo> option) {
		return new StdWokaymoipSelect(option);
	}
	
	
	
	@Override protected DeciResult<WokaymoipInfo> translateResultHook(DeciResult<WokaymoipInfo> result) {
		return result;
	}
}

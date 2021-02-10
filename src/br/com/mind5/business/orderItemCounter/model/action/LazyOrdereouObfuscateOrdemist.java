package br.com.mind5.business.orderItemCounter.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderItemCounter.info.OrdereouInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrdereouObfuscateOrdemist extends ActionLazyTemplate<OrdereouInfo, OrdereouInfo> {

	public LazyOrdereouObfuscateOrdemist(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdereouInfo> translateRecordInfosHook(List<OrdereouInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrdereouInfo> getInstanceOfActionHook(DeciTreeOption<OrdereouInfo> option) {
		return new StdOrdereouObfuscateOrdemist(option);
	}
	
	
	
	@Override protected DeciResult<OrdereouInfo> translateResultHook(DeciResult<OrdereouInfo> result) {
		return result;
	}
}

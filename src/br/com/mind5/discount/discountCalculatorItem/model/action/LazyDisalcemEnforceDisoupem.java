package br.com.mind5.discount.discountCalculatorItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.discount.discountCalculatorItem.info.DisalcemInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyDisalcemEnforceDisoupem extends ActionLazyTemplate<DisalcemInfo, DisalcemInfo> {
	
	public LazyDisalcemEnforceDisoupem(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<DisalcemInfo> translateRecordInfosHook(List<DisalcemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<DisalcemInfo> getInstanceOfActionHook(DeciTreeOption<DisalcemInfo> option) {
		return new StdDisalcemEnforceDisoupem(option);
	}
	
	
	
	@Override protected DeciResult<DisalcemInfo> translateResultHook(DeciResult<DisalcemInfo> result) {
		return result;
	}
}

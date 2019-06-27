package br.com.gda.payment.creditCard.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyCrecardInsert extends ActionLazyTemplate<CrecardInfo, CrecardInfo> {
	
	public LazyCrecardInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CrecardInfo> translateRecordInfosHook(List<CrecardInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<CrecardInfo> getInstanceOfActionHook(DeciTreeOption<CrecardInfo> option) {
		return new StdCrecardInsert(option);
	}
	
	
	
	@Override protected DeciResult<CrecardInfo> translateResultHook(DeciResult<CrecardInfo> result) {
		return result;
	}
}

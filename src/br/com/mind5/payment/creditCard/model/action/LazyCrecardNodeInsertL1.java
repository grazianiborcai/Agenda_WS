package br.com.mind5.payment.creditCard.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.decisionTree.NodeCrecardInsertL1;

public final class LazyCrecardNodeInsertL1 extends ActionLazyTemplate<CrecardInfo, CrecardInfo> {
	
	public LazyCrecardNodeInsertL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CrecardInfo> translateRecordInfosHook(List<CrecardInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<CrecardInfo> getInstanceOfActionHook(DeciTreeOption<CrecardInfo> option) {
		return new NodeCrecardInsertL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CrecardInfo> translateResultHook(DeciResult<CrecardInfo> result) {
		return result;
	}
}

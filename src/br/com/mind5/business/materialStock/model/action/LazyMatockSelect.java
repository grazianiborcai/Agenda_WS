package br.com.mind5.business.materialStock.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatockSelect extends ActionLazyTemplate<MatockInfo, MatockInfo> {

	public LazyMatockSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatockInfo> translateRecordInfosHook(List<MatockInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<MatockInfo> getInstanceOfActionHook(DeciTreeOption<MatockInfo> option) {
		return new StdMatockSelect(option);
	}
	
	
	
	@Override protected DeciResult<MatockInfo> translateResultHook(DeciResult<MatockInfo> result) {
		return result;
	}
}

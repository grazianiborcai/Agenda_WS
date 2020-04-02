package br.com.mind5.business.materialTextSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatextsnapInsert extends ActionLazyTemplate<MatextsnapInfo, MatextsnapInfo> {
	
	public LazyMatextsnapInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatextsnapInfo> translateRecordInfosHook(List<MatextsnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<MatextsnapInfo> getInstanceOfActionHook(DeciTreeOption<MatextsnapInfo> option) {
		return new StdMatextsnapInsert(option);
	}
	
	
	
	@Override protected DeciResult<MatextsnapInfo> translateResultHook(DeciResult<MatextsnapInfo> result) {
		return result;
	}
}

package br.com.mind5.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatMergeToDelete extends ActionLazyTemplate<MatInfo, MatInfo> {
	
	public LazyMatMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatInfo> translateRecordInfosHook(List<MatInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatInfo> getInstanceOfActionHook(DeciTreeOption<MatInfo> option) {
		return new StdMatMergeToDelete(option);
	}
	
	
	
	@Override protected DeciResult<MatInfo> translateResultHook(DeciResult<MatInfo> result) {
		return result;
	}
}

package br.com.mind5.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatMergeMatoup extends ActionLazyTemplateV1<MatInfo, MatInfo> {
	
	public LazyMatMergeMatoup(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatInfo> translateRecordInfosHook(List<MatInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<MatInfo> getInstanceOfActionHook(DeciTreeOption<MatInfo> option) {
		return new StdMatMergeMatoup(option);
	}
	
	
	
	@Override protected DeciResult<MatInfo> translateResultHook(DeciResult<MatInfo> result) {
		return result;
	}
}
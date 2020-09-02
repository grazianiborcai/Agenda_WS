package br.com.mind5.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatDaoDelete extends ActionLazyTemplateV2<MatInfo, MatInfo> {

	public LazyMatDaoDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatInfo> translateRecordInfosHook(List<MatInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<MatInfo> getInstanceOfActionHook(DeciTreeOption<MatInfo> option) {
		return new StdMatDaoDelete(option);
	}
	
	
	
	@Override protected DeciResult<MatInfo> translateResultHook(DeciResult<MatInfo> result) {
		return result;
	}
}
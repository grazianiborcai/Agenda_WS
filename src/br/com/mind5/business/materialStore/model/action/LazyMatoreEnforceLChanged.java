package br.com.mind5.business.materialStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatoreEnforceLChanged extends ActionLazyTemplate<MatoreInfo, MatoreInfo> {
	
	public LazyMatoreEnforceLChanged(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatoreInfo> translateRecordInfosHook(List<MatoreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatoreInfo> getInstanceOfActionHook(DeciTreeOption<MatoreInfo> option) {
		return new StdMatoreEnforceLChanged(option);
	}
	
	
	
	@Override protected DeciResult<MatoreInfo> translateResultHook(DeciResult<MatoreInfo> result) {
		return result;
	}
}

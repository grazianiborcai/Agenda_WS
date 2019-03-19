package br.com.gda.business.materialStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyMatoreMergeUsername extends ActionLazyTemplate<MatoreInfo, MatoreInfo> {
	
	public LazyMatoreMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatoreInfo> translateRecordInfosHook(List<MatoreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatoreInfo> getInstanceOfActionHook(DeciTreeOption<MatoreInfo> option) {
		return new StdMatoreMergeUsername(option);
	}
	
	
	
	@Override protected DeciResult<MatoreInfo> translateResultHook(DeciResult<MatoreInfo> result) {
		return result;
	}
}

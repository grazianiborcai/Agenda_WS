package br.com.gda.business.materialSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyMatSnapInsertText extends ActionLazyTemplate<MatSnapInfo, MatSnapInfo> {
	
	public LazyMatSnapInsertText(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatSnapInfo> translateRecordInfosHook(List<MatSnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<MatSnapInfo> getInstanceOfActionHook(DeciTreeOption<MatSnapInfo> option) {
		return new StdMatSnapInsertText(option);
	}
	
	
	
	@Override protected DeciResult<MatSnapInfo> translateResultHook(DeciResult<MatSnapInfo> result) {
		return result;
	}
}

package br.com.mind5.masterData.materialGroup.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatoupMergeFimgys extends ActionLazyTemplate<MatoupInfo, MatoupInfo> {

	public LazyMatoupMergeFimgys(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatoupInfo> translateRecordInfosHook(List<MatoupInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatoupInfo> getInstanceOfActionHook(DeciTreeOption<MatoupInfo> option) {
		return new StdMatoupMergeFimgys(option);
	}
	
	
	
	@Override protected DeciResult<MatoupInfo> translateResultHook(DeciResult<MatoupInfo> result) {
		return result;
	}
}

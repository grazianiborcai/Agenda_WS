package br.com.mind5.masterData.materialGroup.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatoupMergeBusarea extends ActionLazyTemplateV2<MatoupInfo, MatoupInfo> {

	public LazyMatoupMergeBusarea(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatoupInfo> translateRecordInfosHook(List<MatoupInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<MatoupInfo> getInstanceOfActionHook(DeciTreeOption<MatoupInfo> option) {
		return new StdMatoupMergeBusarea(option);
	}
	
	
	
	@Override protected DeciResult<MatoupInfo> translateResultHook(DeciResult<MatoupInfo> result) {
		return result;
	}
}

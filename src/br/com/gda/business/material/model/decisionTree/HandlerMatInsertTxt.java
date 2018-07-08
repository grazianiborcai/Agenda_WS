package br.com.gda.business.material.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerMatInsertTxt extends DeciActionHandlerTemplate<MatInfo, MatInfo> {
	
	public HandlerMatInsertTxt(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatInfo> translateRecordInfosHook(List<MatInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  DeciAction<MatInfo> getInstanceOfActionHook(DeciTreeOption<MatInfo> option) {
		return new ActionMatInsertText(option);
	}
	
	
	
	@Override protected DeciResult<MatInfo> translateResultHook(DeciResult<MatInfo> result) {
		return result;
	}
}

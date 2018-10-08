package br.com.gda.business.materialEmployee.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class HandlerMatEmpSelect extends ActionLazyTemplate<MatEmpInfo, MatEmpInfo> {
	
	public HandlerMatEmpSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatEmpInfo> translateRecordInfosHook(List<MatEmpInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<MatEmpInfo> getInstanceOfActionHook(DeciTreeOption<MatEmpInfo> option) {
		return new ActionMatEmpSelect(option);
	}
	
	
	
	@Override protected DeciResult<MatEmpInfo> translateResultHook(DeciResult<MatEmpInfo> result) {
		return result;
	}
}

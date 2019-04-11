package br.com.gda.business.employeeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.decisionTree.RootEmpwotmSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyEmpwotmRootSelect extends ActionLazyTemplate<EmpwotmInfo, EmpwotmInfo> {
	
	public LazyEmpwotmRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpwotmInfo> translateRecordInfosHook(List<EmpwotmInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmpwotmInfo> getInstanceOfActionHook(DeciTreeOption<EmpwotmInfo> option) {
		return new RootEmpwotmSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmpwotmInfo> translateResultHook(DeciResult<EmpwotmInfo> result) {
		return result;
	}
}

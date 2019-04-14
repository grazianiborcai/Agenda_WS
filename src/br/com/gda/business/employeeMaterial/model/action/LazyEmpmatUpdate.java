package br.com.gda.business.employeeMaterial.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyEmpmatUpdate extends ActionLazyTemplate<EmpmatInfo, EmpmatInfo> {
	
	public LazyEmpmatUpdate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpmatInfo> translateRecordInfosHook(List<EmpmatInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<EmpmatInfo> getInstanceOfActionHook(DeciTreeOption<EmpmatInfo> option) {
		return new StdEmpmatUpdate(option);
	}
	
	
	
	@Override protected DeciResult<EmpmatInfo> translateResultHook(DeciResult<EmpmatInfo> result) {
		return result;
	}
}

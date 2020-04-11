package br.com.mind5.business.employeeMaterial.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmpmatMergeEmpmarch extends ActionLazyTemplateV1<EmpmatInfo, EmpmatInfo> {
	
	public LazyEmpmatMergeEmpmarch(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpmatInfo> translateRecordInfosHook(List<EmpmatInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmpmatInfo> getInstanceOfActionHook(DeciTreeOption<EmpmatInfo> option) {
		return new StdEmpmatMergeEmpmarch(option);
	}
	
	
	
	@Override protected DeciResult<EmpmatInfo> translateResultHook(DeciResult<EmpmatInfo> result) {
		return result;
	}
}

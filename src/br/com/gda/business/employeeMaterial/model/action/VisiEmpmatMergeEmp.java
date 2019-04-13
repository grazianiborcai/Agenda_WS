package br.com.gda.business.employeeMaterial.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.decisionTree.RootEmpSelect;
import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.info.EmpmatMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class VisiEmpmatMergeEmp extends ActionLazyTemplate<EmpmatInfo, EmpInfo> {
	private List<EmpmatInfo> originalInfos;
	
	
	public VisiEmpmatMergeEmp(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpInfo> translateRecordInfosHook(List<EmpmatInfo> recordInfos) {
		originalInfos = recordInfos;
		List<EmpInfo> result = EmpInfo.copyFrom(recordInfos);
		return compact(result);
	}
	
	
	
	private List<EmpInfo> compact(List<EmpInfo> recordInfos) {
		HashSet<EmpInfo> recordSet = new HashSet<>(recordInfos);
		return new ArrayList<>(recordSet);
	}
	
	
	
	@Override protected ActionStd<EmpInfo> getInstanceOfActionHook(DeciTreeOption<EmpInfo> option) {
		return new RootEmpSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmpmatInfo> translateResultHook(DeciResult<EmpInfo> result) {
		DeciResultHelper<EmpmatInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		resultHelper.resultset = Collections.emptyList();
		
		if (result.hasResultset())
			resultHelper.resultset = new EmpmatMerger().merge(result.getResultset(), originalInfos);
		
		return resultHelper;
	}
}

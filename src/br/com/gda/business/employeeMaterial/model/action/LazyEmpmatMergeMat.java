package br.com.gda.business.employeeMaterial.model.action;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.info.EmpmatMerger;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class LazyEmpmatMergeMat extends ActionLazyTemplate<EmpmatInfo, MatInfo> {
	private List<EmpmatInfo> originalInfos;
	
	
	public LazyEmpmatMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatInfo> translateRecordInfosHook(List<EmpmatInfo> recordInfos) {
		originalInfos = recordInfos;
		return MatInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected  ActionStd<MatInfo> getInstanceOfActionHook(DeciTreeOption<MatInfo> option) {
		return new RootMatSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmpmatInfo> translateResultHook(DeciResult<MatInfo> result) {		
		DeciResultHelper<EmpmatInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		resultHelper.resultset = Collections.emptyList();
		
		if (result.hasResultset())
			resultHelper.resultset = new EmpmatMerger().merge(result.getResultset(), originalInfos);
		
		return resultHelper;
	}
}

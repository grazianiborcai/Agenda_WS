package br.com.gda.business.materialEmployee.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.business.materialEmployee.info.MatEmpMerger;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultDataNotFound;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerMatEmpMergeMat extends DeciActionHandlerTemplate<MatEmpInfo, MatInfo> {
	private List<MatEmpInfo> originalInfos;
	
	
	public HandlerMatEmpMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatInfo> translateRecordInfosHook(List<MatEmpInfo> recordInfos) {
		originalInfos = recordInfos;
		return MatInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected  DeciAction<MatInfo> getInstanceOfActionHook(DeciTreeOption<MatInfo> option) {
		return new RootMatSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatEmpInfo> translateResultHook(DeciResult<MatInfo> result) {
		if (result.hasResultset() == EMPTY)
			return new DeciResultDataNotFound<>();		
		//TODO: Rever - não utilizar a classe acima
		
		DeciResultHelper<MatEmpInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		resultHelper.resultset = new MatEmpMerger().merge(result.getResultset(), originalInfos);
		
		return resultHelper;
	}
}

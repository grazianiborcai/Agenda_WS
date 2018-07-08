package br.com.gda.business.materialStore.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.business.materialStore.info.MatStoreMerger;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerMatStoreMergeMat extends DeciActionHandlerTemplate<MatStoreInfo, MatInfo> {
	private List<MatStoreInfo> originalInfos;
	
	
	public HandlerMatStoreMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatInfo> translateRecordInfosHook(List<MatStoreInfo> recordInfos) {
		originalInfos = recordInfos;
		return MatInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected  DeciAction<MatInfo> getInstanceOfActionHook(DeciTreeOption<MatInfo> option) {
		return new RootMatSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatStoreInfo> translateResultHook(DeciResult<MatInfo> result) {
		DeciResultHelper<MatStoreInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		
		if (result.hasResultset()) {
			resultHelper.resultset = MatStoreMerger.merge(result.getResultset(), originalInfos);
		
		} else {		
			List<MatStoreInfo> dummyResultset = new ArrayList<>();
			dummyResultset.add(new MatStoreInfo());		
			resultHelper.resultset = dummyResultset;
		}
		
		return resultHelper;
	}
}

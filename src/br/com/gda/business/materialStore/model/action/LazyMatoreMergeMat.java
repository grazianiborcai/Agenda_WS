package br.com.gda.business.materialStore.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.info.MatoreMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyMatoreMergeMat extends ActionLazyTemplate<MatoreInfo, MatInfo> {
	private List<MatoreInfo> originalInfos;
	
	
	public LazyMatoreMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatInfo> translateRecordInfosHook(List<MatoreInfo> recordInfos) {
		originalInfos = recordInfos;
		return MatInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected ActionStd<MatInfo> getInstanceOfActionHook(DeciTreeOption<MatInfo> option) {
		return new RootMatSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatoreInfo> translateResultHook(DeciResult<MatInfo> result) {
		DeciResultHelper<MatoreInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		
		if (result.hasResultset()) {
			resultHelper.resultset = new MatoreMerger().merge(result.getResultset(), originalInfos);
		
		} else {		
			List<MatoreInfo> dummy = new ArrayList<>();
			dummy.add(new MatoreInfo());		
			resultHelper.resultset = dummy;
		}
		
		return resultHelper;
	}
}

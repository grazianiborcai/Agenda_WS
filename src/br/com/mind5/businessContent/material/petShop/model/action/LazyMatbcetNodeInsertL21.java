package br.com.mind5.businessContent.material.petShop.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.businessContent.material.petShop.model.decisionTree.NodeMatbcetInsertL21;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatbcetNodeInsertL21 extends ActionLazyTemplate<MatbcetInfo, MatbcetInfo> {
	
	public LazyMatbcetNodeInsertL21(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatbcetInfo> translateRecordInfosHook(List<MatbcetInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatbcetInfo> getInstanceOfActionHook(DeciTreeOption<MatbcetInfo> option) {
		return new NodeMatbcetInsertL21(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatbcetInfo> translateResultHook(DeciResult<MatbcetInfo> result) {
		return result;
	}
}

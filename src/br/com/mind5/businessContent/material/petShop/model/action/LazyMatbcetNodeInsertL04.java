package br.com.mind5.businessContent.material.petShop.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.businessContent.material.petShop.model.decisionTree.NodeMatbcetInsertL04;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatbcetNodeInsertL04 extends ActionLazyTemplate<MatbcetInfo, MatbcetInfo> {
	
	public LazyMatbcetNodeInsertL04(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatbcetInfo> translateRecordInfosHook(List<MatbcetInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<MatbcetInfo> getInstanceOfActionHook(DeciTreeOption<MatbcetInfo> option) {
		return new NodeMatbcetInsertL04(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatbcetInfo> translateResultHook(DeciResult<MatbcetInfo> result) {
		return result;
	}
}

package br.com.mind5.businessContent.material.petShop.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.businessContent.material.petShop.model.decisionTree.NodeMatbcetInsertL09;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatbcetNodeInsertL09 extends ActionLazyTemplate<MatbcetInfo, MatbcetInfo> {
	
	public LazyMatbcetNodeInsertL09(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatbcetInfo> translateRecordInfosHook(List<MatbcetInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<MatbcetInfo> getInstanceOfActionHook(DeciTreeOption<MatbcetInfo> option) {
		return new NodeMatbcetInsertL09(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatbcetInfo> translateResultHook(DeciResult<MatbcetInfo> result) {
		return result;
	}
}

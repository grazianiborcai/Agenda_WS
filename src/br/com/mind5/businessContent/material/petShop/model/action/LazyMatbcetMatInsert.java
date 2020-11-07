package br.com.mind5.businessContent.material.petShop.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatbcetMatInsert extends ActionLazyTemplateV2<MatbcetInfo, MatbcetInfo> {
	
	public LazyMatbcetMatInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatbcetInfo> translateRecordInfosHook(List<MatbcetInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<MatbcetInfo> getInstanceOfActionHook(DeciTreeOption<MatbcetInfo> option) {
		return new StdMatbcetMatInsert(option);
	}
	
	
	
	@Override protected DeciResult<MatbcetInfo> translateResultHook(DeciResult<MatbcetInfo> result) {
		return result;
	}
}
package br.com.mind5.business.materialMovement.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.decisionTree.NodeMatmovInsert;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatmovNodeInsert extends ActionLazyTemplate<MatmovInfo, MatmovInfo> {

	public LazyMatmovNodeInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatmovInfo> translateRecordInfosHook(List<MatmovInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<MatmovInfo> getInstanceOfActionHook(DeciTreeOption<MatmovInfo> option) {
		return new NodeMatmovInsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatmovInfo> translateResultHook(DeciResult<MatmovInfo> result) {
		return result;
	}
}

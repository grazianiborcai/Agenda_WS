package br.com.gda.business.materialMovement.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyMatmovDelete extends ActionLazyTemplate<MatmovInfo, MatmovInfo> {

	public LazyMatmovDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatmovInfo> translateRecordInfosHook(List<MatmovInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<MatmovInfo> getInstanceOfActionHook(DeciTreeOption<MatmovInfo> option) {
		return new StdMatmovDelete(option);
	}
	
	
	
	@Override protected DeciResult<MatmovInfo> translateResultHook(DeciResult<MatmovInfo> result) {
		return result;
	}
}

package br.com.mind5.business.materialMovement.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatmovEnforcePostingDate extends ActionLazyTemplate<MatmovInfo, MatmovInfo> {
	
	public LazyMatmovEnforcePostingDate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatmovInfo> translateRecordInfosHook(List<MatmovInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<MatmovInfo> getInstanceOfActionHook(DeciTreeOption<MatmovInfo> option) {
		return new StdMatmovEnforcePostingDate(option);
	}
	
	
	
	@Override protected DeciResult<MatmovInfo> translateResultHook(DeciResult<MatmovInfo> result) {
		return result;
	}
}

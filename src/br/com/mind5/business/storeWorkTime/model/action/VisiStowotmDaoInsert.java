package br.com.mind5.business.storeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTime.dao.DaoStowotmInsert;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStowotmDaoInsert extends ActionVisitorTemplateStmtV2<StowotmInfo> {

	public VisiStowotmDaoInsert(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StowotmInfo> buildStmtExecHook(List<DaoStmtExecOption<StowotmInfo>> stmtOptions) {
		return new DaoStowotmInsert(stmtOptions);
	}
}

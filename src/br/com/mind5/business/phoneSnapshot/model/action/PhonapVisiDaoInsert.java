package br.com.mind5.business.phoneSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshot.dao.PhonapDaoInsert;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonapVisiDaoInsert extends ActionVisitorTemplateStmt<PhonapInfo> {

	public PhonapVisiDaoInsert(DeciTreeOption<PhonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PhonapInfo> buildStmtExecHook(List<DaoStmtExecOption<PhonapInfo>> stmtOptions) {
		return new PhonapDaoInsert(stmtOptions);
	}
}

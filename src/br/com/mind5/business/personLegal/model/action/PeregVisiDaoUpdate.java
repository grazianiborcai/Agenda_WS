package br.com.mind5.business.personLegal.model.action;

import java.util.List;

import br.com.mind5.business.personLegal.dao.PeregDaoUpdate;
import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiDaoUpdate extends ActionVisitorTemplateStmt<PeregInfo> {

	public PeregVisiDaoUpdate(DeciTreeOption<PeregInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PeregInfo> buildStmtExecHook(List<DaoStmtExecOption<PeregInfo>> stmtOptions) {
		return new PeregDaoUpdate(stmtOptions);
	}
}

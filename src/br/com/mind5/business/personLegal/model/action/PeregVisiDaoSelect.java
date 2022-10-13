package br.com.mind5.business.personLegal.model.action;

import java.util.List;

import br.com.mind5.business.personLegal.dao.PeregDaoSelect;
import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiDaoSelect extends ActionVisitorTemplateStmt<PeregInfo> {

	public PeregVisiDaoSelect(DeciTreeOption<PeregInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PeregInfo> buildStmtExecHook(List<DaoStmtExecOption<PeregInfo>> stmtOptions) {
		return new PeregDaoSelect(stmtOptions);
	}
}

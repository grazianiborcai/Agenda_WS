package br.com.mind5.business.person.model.action;

import java.util.List;

import br.com.mind5.business.person.dao.DaoPersonInsert;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersonDaoInsert extends ActionVisitorTemplateStmt<PersonInfo> {

	public VisiPersonDaoInsert(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PersonInfo> buildStmtExecHook(List<DaoStmtExecOption<PersonInfo>> stmtOptions) {
		return new DaoPersonInsert(stmtOptions);
	}
}

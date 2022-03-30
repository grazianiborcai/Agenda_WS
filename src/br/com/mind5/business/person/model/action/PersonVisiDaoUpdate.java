package br.com.mind5.business.person.model.action;

import java.util.List;

import br.com.mind5.business.person.dao.PersonDaoUpdate;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonVisiDaoUpdate extends ActionVisitorTemplateStmt<PersonInfo> {

	public PersonVisiDaoUpdate(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PersonInfo> buildStmtExecHook(List<DaoStmtExecOption<PersonInfo>> stmtOptions) {
		return new PersonDaoUpdate(stmtOptions);
	}
}

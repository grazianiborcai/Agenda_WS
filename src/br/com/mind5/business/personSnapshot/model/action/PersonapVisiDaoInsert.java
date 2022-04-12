package br.com.mind5.business.personSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personSnapshot.dao.PersonapDaoInsert;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonapVisiDaoInsert extends ActionVisitorTemplateStmt<PersonapInfo> {

	public PersonapVisiDaoInsert(DeciTreeOption<PersonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PersonapInfo> buildStmtExecHook(List<DaoStmtExecOption<PersonapInfo>> stmtOptions) {
		return new PersonapDaoInsert(stmtOptions);
	}
}

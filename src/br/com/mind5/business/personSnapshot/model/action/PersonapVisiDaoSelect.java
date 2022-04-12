package br.com.mind5.business.personSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personSnapshot.dao.PersonapDaoSelect;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonapVisiDaoSelect extends ActionVisitorTemplateStmt<PersonapInfo> {

	public PersonapVisiDaoSelect(DeciTreeOption<PersonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PersonapInfo> buildStmtExecHook(List<DaoStmtExecOption<PersonapInfo>> stmtOptions) {
		return new PersonapDaoSelect(stmtOptions);
	}
}

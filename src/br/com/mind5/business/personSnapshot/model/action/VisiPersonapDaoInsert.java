package br.com.mind5.business.personSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personSnapshot.dao.DaoPersonapInsert;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersonapDaoInsert extends ActionVisitorTemplateStmt<PersonapInfo> {

	public VisiPersonapDaoInsert(DeciTreeOption<PersonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PersonapInfo> buildStmtExecHook(List<DaoStmtExecOption<PersonapInfo>> stmtOptions) {
		return new DaoPersonapInsert(stmtOptions);
	}
}

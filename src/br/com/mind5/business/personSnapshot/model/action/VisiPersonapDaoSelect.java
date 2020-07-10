package br.com.mind5.business.personSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personSnapshot.dao.DaoPersonapSelect;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersonapDaoSelect extends ActionVisitorTemplateStmtV2<PersonapInfo> {

	public VisiPersonapDaoSelect(DeciTreeOption<PersonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PersonapInfo> buildStmtExecHook(List<DaoStmtExecOption<PersonapInfo>> stmtOptions) {
		return new DaoPersonapSelect(stmtOptions);
	}
}

package br.com.mind5.business.person.model.action;

import java.util.List;

import br.com.mind5.business.person.dao.DaoPersonInsert;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersonDaoInsert extends ActionVisitorTemplateStmtV2<PersonInfo> {

	public VisiPersonDaoInsert(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PersonInfo> buildStmtExecHook(List<DaoStmtExecOption<PersonInfo>> stmtOptions) {
		return new DaoPersonInsert(stmtOptions);
	}
}
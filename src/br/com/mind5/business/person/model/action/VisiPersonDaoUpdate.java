package br.com.mind5.business.person.model.action;

import java.util.List;

import br.com.mind5.business.person.dao.DaoPersonUpdate;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersonDaoUpdate extends ActionVisitorTemplateStmtV2<PersonInfo> {

	public VisiPersonDaoUpdate(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PersonInfo> buildStmtExecHook(List<DaoStmtExecOption<PersonInfo>> stmtOptions) {
		return new DaoPersonUpdate(stmtOptions);
	}
}
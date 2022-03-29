package br.com.mind5.business.personList.model.action;

import java.util.List;

import br.com.mind5.business.personList.dao.PersolisDaoSelect;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersolisVisiDaoSelect extends ActionVisitorTemplateStmt<PersolisInfo> {

	public PersolisVisiDaoSelect(DeciTreeOption<PersolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PersolisInfo> buildStmtExecHook(List<DaoStmtExecOption<PersolisInfo>> stmtOptions) {
		return new PersolisDaoSelect(stmtOptions);
	}
}

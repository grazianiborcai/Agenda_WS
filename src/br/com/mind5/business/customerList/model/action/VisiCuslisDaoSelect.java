package br.com.mind5.business.customerList.model.action;

import java.util.List;

import br.com.mind5.business.customerList.dao.DaoCuslisSelect;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCuslisDaoSelect extends ActionVisitorTemplateStmt<CuslisInfo> {

	public VisiCuslisDaoSelect(DeciTreeOption<CuslisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CuslisInfo> buildStmtExecHook(List<DaoStmtExecOption<CuslisInfo>> stmtOptions) {
		return new DaoCuslisSelect(stmtOptions);
	}
}

package br.com.mind5.business.customerSearch.model.action;

import java.util.List;

import br.com.mind5.business.customerSearch.dao.CusarchDaoSelect;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusarchVisiDaoSelect extends ActionVisitorTemplateStmt<CusarchInfo> {

	public CusarchVisiDaoSelect(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CusarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CusarchInfo>> stmtOptions) {
		return new CusarchDaoSelect(stmtOptions);
	}
}

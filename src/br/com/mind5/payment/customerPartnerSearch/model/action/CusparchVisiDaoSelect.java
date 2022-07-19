package br.com.mind5.payment.customerPartnerSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.dao.CusparchDaoSelect;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

public final class CusparchVisiDaoSelect extends ActionVisitorTemplateStmt<CusparchInfo> {

	public CusparchVisiDaoSelect(DeciTreeOption<CusparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CusparchInfo> buildStmtExecHook(List<DaoStmtExecOption<CusparchInfo>> stmtOptions) {
		return new CusparchDaoSelect(stmtOptions);
	}
}

package br.com.mind5.payment.systemPartnerSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.systemPartnerSearch.dao.SysparchDaoSelect;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;

public final class SysparchVisiDaoSelect extends ActionVisitorTemplateStmt<SysparchInfo> {

	public SysparchVisiDaoSelect(DeciTreeOption<SysparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SysparchInfo> buildStmtExecHook(List<DaoStmtExecOption<SysparchInfo>> stmtOptions) {
		return new SysparchDaoSelect(stmtOptions);
	}
}

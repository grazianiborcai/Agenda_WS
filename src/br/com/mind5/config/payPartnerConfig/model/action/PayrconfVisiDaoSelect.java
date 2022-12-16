package br.com.mind5.config.payPartnerConfig.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.config.payPartnerConfig.dao.PayrconfDaoSelect;
import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayrconfVisiDaoSelect extends ActionVisitorTemplateStmt<PayrconfInfo> {

	public PayrconfVisiDaoSelect(DeciTreeOption<PayrconfInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PayrconfInfo> buildStmtExecHook(List<DaoStmtExecOption<PayrconfInfo>> stmtOptions) {
		return new PayrconfDaoSelect(stmtOptions);
	}
}

package br.com.mind5.discount.discountStore.model.action;

import java.util.List;

import br.com.mind5.discount.discountStore.dao.DisoreDaoSelect;
import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisoreVisiDaoSelect extends ActionVisitorTemplateStmt<DisoreInfo> {

	public DisoreVisiDaoSelect(DeciTreeOption<DisoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<DisoreInfo> buildStmtExecHook(List<DaoStmtExecOption<DisoreInfo>> stmtOptions) {
		return new DisoreDaoSelect(stmtOptions);
	}
}

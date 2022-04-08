package br.com.mind5.business.materialStoreSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialStoreSearch.dao.MatorarchDaoSelect;
import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatorarchVisiDaoSelect extends ActionVisitorTemplateStmt<MatorarchInfo> {

	public MatorarchVisiDaoSelect(DeciTreeOption<MatorarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatorarchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatorarchInfo>> stmtOptions) {
		return new MatorarchDaoSelect(stmtOptions);
	}
}

package br.com.mind5.business.addressSearch.model.action;

import java.util.List;

import br.com.mind5.business.addressSearch.dao.DaoAddarchSelect;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddarchDaoSelect extends ActionVisitorTemplateStmt<AddarchInfo> {

	public VisiAddarchDaoSelect(DeciTreeOption<AddarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<AddarchInfo> buildStmtExecHook(List<DaoStmtExecOption<AddarchInfo>> stmtOptions) {
		return new DaoAddarchSelect(stmtOptions);
	}
}

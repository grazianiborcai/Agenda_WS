package br.com.mind5.config.sysStoreBusinessContent.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.config.sysStoreBusinessContent.dao.DaoSytorbcSelect;
import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSytorbcDaoSelect extends ActionVisitorTemplateStmt<SytorbcInfo> {

	public VisiSytorbcDaoSelect(DeciTreeOption<SytorbcInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SytorbcInfo> buildStmtExecHook(List<DaoStmtExecOption<SytorbcInfo>> stmtOptions) {
		return new DaoSytorbcSelect(stmtOptions);
	}
}

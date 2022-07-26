package br.com.mind5.config.sysStoreBusinessContent.model.action;

import java.util.List;

import br.com.mind5.config.sysStoreBusinessContent.dao.SytorbcDaoSelect;
import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SytorbcVisiDaoSelect extends ActionVisitorTemplateStmt<SytorbcInfo> {

	public SytorbcVisiDaoSelect(DeciTreeOption<SytorbcInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SytorbcInfo> buildStmtExecHook(List<DaoStmtExecOption<SytorbcInfo>> stmtOptions) {
		return new SytorbcDaoSelect(stmtOptions);
	}
}

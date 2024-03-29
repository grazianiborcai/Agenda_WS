package br.com.mind5.masterData.feeCategory.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.feeCategory.dao.FeecatDaoSelect;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FeecatVisiDaoSelect extends ActionVisitorTemplateStmt<FeecatInfo> {

	public FeecatVisiDaoSelect(DeciTreeOption<FeecatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FeecatInfo> buildStmtExecHook(List<DaoStmtExecOption<FeecatInfo>> stmtOptions) {
		return new FeecatDaoSelect(stmtOptions);
	}
}

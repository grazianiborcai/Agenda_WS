package br.com.mind5.masterData.movimentType.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.movimentType.dao.MamovypeDaoSelect;
import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MamovypeVisiDaoSelect extends ActionVisitorTemplateStmt<MamovypeInfo> {

	public MamovypeVisiDaoSelect(DeciTreeOption<MamovypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MamovypeInfo> buildStmtExecHook(List<DaoStmtExecOption<MamovypeInfo>> stmtOptions) {
		return new MamovypeDaoSelect(stmtOptions);
	}
}

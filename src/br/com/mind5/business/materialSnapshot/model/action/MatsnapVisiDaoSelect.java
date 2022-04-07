package br.com.mind5.business.materialSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialSnapshot.dao.MatsnapDaoSelect;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatsnapVisiDaoSelect extends ActionVisitorTemplateStmt<MatsnapInfo> {

	public MatsnapVisiDaoSelect(DeciTreeOption<MatsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatsnapInfo> buildStmtExecHook(List<DaoStmtExecOption<MatsnapInfo>> stmtOptions) {
		return new MatsnapDaoSelect(stmtOptions);
	}
}

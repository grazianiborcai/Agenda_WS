package br.com.mind5.business.petSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.petSnapshot.dao.PetsnapDaoSelect;
import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetsnapVisiDaoSelect extends ActionVisitorTemplateStmt<PetsnapInfo> {

	public PetsnapVisiDaoSelect(DeciTreeOption<PetsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PetsnapInfo> buildStmtExecHook(List<DaoStmtExecOption<PetsnapInfo>> stmtOptions) {
		return new PetsnapDaoSelect(stmtOptions);
	}
}

package br.com.mind5.business.petSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.petSnapshot.dao.DaoPetsnapSelect;
import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetsnapDaoSelect extends ActionVisitorTemplateStmt<PetsnapInfo> {

	public VisiPetsnapDaoSelect(DeciTreeOption<PetsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PetsnapInfo> buildStmtExecHook(List<DaoStmtExecOption<PetsnapInfo>> stmtOptions) {
		return new DaoPetsnapSelect(stmtOptions);
	}
}

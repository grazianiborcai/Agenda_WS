package br.com.mind5.masterData.petTypeSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.petTypeSearch.dao.DaoPetyparchSelect;
import br.com.mind5.masterData.petTypeSearch.info.PetyparchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetyparchDaoSelect extends ActionVisitorTemplateStmt<PetyparchInfo> {

	public VisiPetyparchDaoSelect(DeciTreeOption<PetyparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PetyparchInfo> buildStmtExecHook(List<DaoStmtExecOption<PetyparchInfo>> stmtOptions) {
		return new DaoPetyparchSelect(stmtOptions);
	}
}

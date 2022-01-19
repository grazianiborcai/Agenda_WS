package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.pet.dao.DaoPetSelect;
import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetDaoSelect extends ActionVisitorTemplateStmt<PetInfo> {

	public VisiPetDaoSelect(DeciTreeOption<PetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PetInfo> buildStmtExecHook(List<DaoStmtExecOption<PetInfo>> stmtOptions) {
		return new DaoPetSelect(stmtOptions);
	}
}

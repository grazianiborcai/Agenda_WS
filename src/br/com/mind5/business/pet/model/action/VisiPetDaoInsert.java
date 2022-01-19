package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.pet.dao.DaoPetInsert;
import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetDaoInsert extends ActionVisitorTemplateStmt<PetInfo> {

	public VisiPetDaoInsert(DeciTreeOption<PetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PetInfo> buildStmtExecHook(List<DaoStmtExecOption<PetInfo>> stmtOptions) {
		return new DaoPetInsert(stmtOptions);
	}
}

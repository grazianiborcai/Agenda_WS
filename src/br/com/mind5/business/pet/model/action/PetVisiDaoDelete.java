package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.pet.dao.PetDaoDelete;
import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetVisiDaoDelete extends ActionVisitorTemplateStmt<PetInfo> {

	public PetVisiDaoDelete(DeciTreeOption<PetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PetInfo> buildStmtExecHook(List<DaoStmtExecOption<PetInfo>> stmtOptions) {
		return new PetDaoDelete(stmtOptions);
	}
}

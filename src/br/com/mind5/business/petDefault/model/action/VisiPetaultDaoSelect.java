package br.com.mind5.business.petDefault.model.action;

import java.util.List;

import br.com.mind5.business.petDefault.dao.PetaultDaoSelect;
import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class VisiPetaultDaoSelect extends ActionVisitorTemplateStmt<PetaultInfo> {

	public VisiPetaultDaoSelect(DeciTreeOption<PetaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PetaultInfo> buildStmtExecHook(List<DaoStmtExecOption<PetaultInfo>> stmtOptions) {
		return new PetaultDaoSelect(stmtOptions);
	}
}

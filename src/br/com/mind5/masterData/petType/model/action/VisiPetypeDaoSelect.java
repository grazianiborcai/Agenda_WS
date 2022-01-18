package br.com.mind5.masterData.petType.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.petType.dao.DaoPetypeSelect;
import br.com.mind5.masterData.petType.info.PetypeInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetypeDaoSelect extends ActionVisitorTemplateStmt<PetypeInfo> {

	public VisiPetypeDaoSelect(DeciTreeOption<PetypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PetypeInfo> buildStmtExecHook(List<DaoStmtExecOption<PetypeInfo>> stmtOptions) {
		return new DaoPetypeSelect(stmtOptions);
	}
}

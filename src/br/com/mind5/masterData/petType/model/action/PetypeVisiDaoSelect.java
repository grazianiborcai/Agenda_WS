package br.com.mind5.masterData.petType.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.petType.dao.PetypeDaoSelect;
import br.com.mind5.masterData.petType.info.PetypeInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetypeVisiDaoSelect extends ActionVisitorTemplateStmt<PetypeInfo> {

	public PetypeVisiDaoSelect(DeciTreeOption<PetypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PetypeInfo> buildStmtExecHook(List<DaoStmtExecOption<PetypeInfo>> stmtOptions) {
		return new PetypeDaoSelect(stmtOptions);
	}
}

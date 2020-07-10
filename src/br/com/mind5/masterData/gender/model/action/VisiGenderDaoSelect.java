package br.com.mind5.masterData.gender.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.gender.dao.DaoGenderSelect;
import br.com.mind5.masterData.gender.info.GenderInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiGenderDaoSelect extends ActionVisitorTemplateStmtV2<GenderInfo> {

	public VisiGenderDaoSelect(DeciTreeOption<GenderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<GenderInfo> buildStmtExecHook(List<DaoStmtExecOption<GenderInfo>> stmtOptions) {
		return new DaoGenderSelect(stmtOptions);
	}
}

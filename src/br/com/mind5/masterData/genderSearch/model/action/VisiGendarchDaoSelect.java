package br.com.mind5.masterData.genderSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.genderSearch.dao.DaoGendarchSelect;
import br.com.mind5.masterData.genderSearch.info.GendarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiGendarchDaoSelect extends ActionVisitorTemplateStmtV2<GendarchInfo> {

	public VisiGendarchDaoSelect(DeciTreeOption<GendarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<GendarchInfo> buildStmtExecHook(List<DaoStmtExecOption<GendarchInfo>> stmtOptions) {
		return new DaoGendarchSelect(stmtOptions);
	}
}

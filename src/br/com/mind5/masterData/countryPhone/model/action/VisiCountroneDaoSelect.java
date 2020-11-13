package br.com.mind5.masterData.countryPhone.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.countryPhone.dao.DaoCountroneSelect;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCountroneDaoSelect extends ActionVisitorTemplateStmt<CountroneInfo> {

	public VisiCountroneDaoSelect(DeciTreeOption<CountroneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CountroneInfo> buildStmtExecHook(List<DaoStmtExecOption<CountroneInfo>> stmtOptions) {
		return new DaoCountroneSelect(stmtOptions);
	}
}

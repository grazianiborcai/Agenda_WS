package br.com.mind5.masterData.prospectStatus.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.prospectStatus.dao.DaoProstusSelect;
import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiProstusDaoSelect extends ActionVisitorTemplateStmtV2<ProstusInfo> {

	public VisiProstusDaoSelect(DeciTreeOption<ProstusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<ProstusInfo> buildStmtExecHook(List<DaoStmtExecOption<ProstusInfo>> stmtOptions) {
		return new DaoProstusSelect(stmtOptions);
	}
}

package br.com.mind5.business.ownerList.model.action;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdOwnelisMergeComplis extends ActionStdTemplate<OwnelisInfo> {

	public StdOwnelisMergeComplis(DeciTreeOption<OwnelisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OwnelisInfo> buildVisitorHook(DeciTreeOption<OwnelisInfo> option) {
		return new VisiOwnelisMergeComplis(option);
	}
}

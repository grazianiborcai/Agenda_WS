package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.decisionTree.CrecardNodeUser;

public final class CrecardVisiNodeUser extends ActionVisitorTemplateAction<CrecardInfo, CrecardInfo> {

	public CrecardVisiNodeUser(DeciTreeOption<CrecardInfo> option) {
		super(option, CrecardInfo.class, CrecardInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecardInfo>> getTreeClassHook() {
		return CrecardNodeUser.class;
	}
	
	
	
	@Override protected List<CrecardInfo> toBaseClassHook(List<CrecardInfo> baseInfos, List<CrecardInfo> results) {
		return results;
	}
}

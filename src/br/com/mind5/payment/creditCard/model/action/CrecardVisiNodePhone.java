package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.decisionTree.CrecardNodePhone;

public final class CrecardVisiNodePhone extends ActionVisitorTemplateAction<CrecardInfo, CrecardInfo> {

	public CrecardVisiNodePhone(DeciTreeOption<CrecardInfo> option) {
		super(option, CrecardInfo.class, CrecardInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecardInfo>> getTreeClassHook() {
		return CrecardNodePhone.class;
	}
	
	
	
	@Override protected List<CrecardInfo> toBaseClassHook(List<CrecardInfo> baseInfos, List<CrecardInfo> results) {
		return results;
	}
}

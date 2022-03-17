package br.com.mind5.payment.storePartnerSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSearch.model.decisionTree.StoparchRootSelect;

public final class StoparchVisiRootSelect extends ActionVisitorTemplateAction<StoparchInfo, StoparchInfo> {

	public StoparchVisiRootSelect(DeciTreeOption<StoparchInfo> option) {
		super(option, StoparchInfo.class, StoparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparchInfo>> getTreeClassHook() {
		return StoparchRootSelect.class;
	}
	
	
	
	@Override protected List<StoparchInfo> toBaseClassHook(List<StoparchInfo> baseInfos, List<StoparchInfo> results) {
		return results;
	}
}

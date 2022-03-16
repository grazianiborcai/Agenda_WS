package br.com.mind5.payment.storePartnerList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.model.decisionTree.StoplisRootSelect;

public final class StoplisVisiRootSelect extends ActionVisitorTemplateAction<StoplisInfo, StoplisInfo> {

	public StoplisVisiRootSelect(DeciTreeOption<StoplisInfo> option) {
		super(option, StoplisInfo.class, StoplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoplisInfo>> getTreeClassHook() {
		return StoplisRootSelect.class;
	}
	
	
	
	@Override protected List<StoplisInfo> toBaseClassHook(List<StoplisInfo> baseInfos, List<StoplisInfo> results) {
		return results;
	}
}

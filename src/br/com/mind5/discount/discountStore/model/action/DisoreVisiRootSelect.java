package br.com.mind5.discount.discountStore.model.action;

import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.model.decisionTree.DisoreRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisoreVisiRootSelect extends ActionVisitorTemplateAction<DisoreInfo, DisoreInfo> {

	public DisoreVisiRootSelect(DeciTreeOption<DisoreInfo> option) {
		super(option, DisoreInfo.class, DisoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DisoreInfo>> getTreeClassHook() {
		return DisoreRootSelect.class;
	}
	
	
	
	@Override protected List<DisoreInfo> toBaseClassHook(List<DisoreInfo> baseInfos, List<DisoreInfo> results) {
		return results;
	}
}

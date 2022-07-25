package br.com.mind5.discount.discountCouponItem.model.action;

import java.util.List;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountCouponItem.model.decisionTree.DisoupemRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisoupemVisiRootSelect extends ActionVisitorTemplateAction<DisoupemInfo, DisoupemInfo> {

	public DisoupemVisiRootSelect(DeciTreeOption<DisoupemInfo> option) {
		super(option, DisoupemInfo.class, DisoupemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DisoupemInfo>> getTreeClassHook() {
		return DisoupemRootSelect.class;
	}
	
	
	
	@Override protected List<DisoupemInfo> toBaseClassHook(List<DisoupemInfo> baseInfos, List<DisoupemInfo> results) {
		return results;
	}
}

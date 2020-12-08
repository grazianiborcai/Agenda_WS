package br.com.mind5.discount.discountCalculatorItem.model.action;

import java.util.List;

import br.com.mind5.discount.discountCalculatorItem.info.DisalcemInfo;
import br.com.mind5.discount.discountCalculatorItem.info.DisalcemMerger;
import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountCouponItem.model.decisionTree.RootDisoupemInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisalcemDisoupemInsert extends ActionVisitorTemplateAction<DisalcemInfo, DisoupemInfo> {

	public VisiDisalcemDisoupemInsert(DeciTreeOption<DisalcemInfo> option) {
		super(option, DisalcemInfo.class, DisoupemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DisoupemInfo>> getTreeClassHook() {
		return RootDisoupemInsert.class;
	}
	
	
	
	@Override protected List<DisalcemInfo> toBaseClassHook(List<DisalcemInfo> baseInfos, List<DisoupemInfo> results) {
		return DisalcemMerger.mergeWithDisoupem(baseInfos, results);
	}
}

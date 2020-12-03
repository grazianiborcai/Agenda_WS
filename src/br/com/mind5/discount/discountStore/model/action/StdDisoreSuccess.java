package br.com.mind5.discount.discountStore.model.action;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdDisoreSuccess extends ActionStdSuccessTemplate<DisoreInfo> {
	
	public StdDisoreSuccess(DeciTreeOption<DisoreInfo> option) {
		super(option);
	}
}

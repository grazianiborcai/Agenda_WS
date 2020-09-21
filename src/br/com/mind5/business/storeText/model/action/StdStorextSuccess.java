package br.com.mind5.business.storeText.model.action;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorextSuccess extends ActionStdSuccessTemplate<StorextInfo> {
	public StdStorextSuccess(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
}

package br.com.mind5.business.personBio.model.action;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerbioSuccess extends ActionStdSuccessTemplate<PerbioInfo> {
	public StdPerbioSuccess(DeciTreeOption<PerbioInfo> option) {
		super(option);
	}
}

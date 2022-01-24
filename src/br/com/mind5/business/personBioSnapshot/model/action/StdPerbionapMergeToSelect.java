package br.com.mind5.business.personBioSnapshot.model.action;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerbionapMergeToSelect extends ActionStdTemplate<PerbionapInfo> {

	public StdPerbionapMergeToSelect(DeciTreeOption<PerbionapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PerbionapInfo> buildVisitorHook(DeciTreeOption<PerbionapInfo> option) {
		return new VisiPerbionapMergeToSelect(option);
	}
}

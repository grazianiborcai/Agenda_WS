package br.com.mind5.business.personBioSearch.model.action;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerbiorchMergeToSelect extends ActionStdTemplate<PerbiorchInfo> {

	public StdPerbiorchMergeToSelect(DeciTreeOption<PerbiorchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PerbiorchInfo> buildVisitorHook(DeciTreeOption<PerbiorchInfo> option) {
		return new VisiPerbiorchMergeToSelect(option);
	}
}

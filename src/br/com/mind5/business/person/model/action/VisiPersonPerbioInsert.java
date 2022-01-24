package br.com.mind5.business.person.model.action;

import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonMerger;
import br.com.mind5.business.personBio.info.PerbioCopier;
import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.model.decisionTree.RootPerbioInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersonPerbioInsert extends ActionVisitorTemplateAction<PersonInfo, PerbioInfo> {
	
	public VisiPersonPerbioInsert(DeciTreeOption<PersonInfo> option) {
		super(option, PersonInfo.class, PerbioInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerbioInfo>> getTreeClassHook() {
		return RootPerbioInsert.class;
	}
	
	
	
	@Override protected List<PerbioInfo> toActionClassHook(List<PersonInfo> recordInfos) {
		return PerbioCopier.copyFromPerson(recordInfos);
	}
	
	
	
	@Override protected List<PersonInfo> toBaseClassHook(List<PersonInfo> baseInfos, List<PerbioInfo> results) {
		return PersonMerger.mergeWithPerbio(baseInfos, results);
	}
}

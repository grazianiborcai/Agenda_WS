package br.com.mind5.business.person.model.action;

import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonMerger;
import br.com.mind5.business.personBio.info.PerbioCopier;
import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.model.decisionTree.RootPerbioUpsertdel;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonVisiPerbioUpsertdel extends ActionVisitorTemplateAction<PersonInfo, PerbioInfo> {
	
	public PersonVisiPerbioUpsertdel(DeciTreeOption<PersonInfo> option) {
		super(option, PersonInfo.class, PerbioInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerbioInfo>> getTreeClassHook() {
		return RootPerbioUpsertdel.class;
	}
	
	
	
	@Override protected List<PerbioInfo> toActionClassHook(List<PersonInfo> recordInfos) {
		return PerbioCopier.copyFromPerson(recordInfos);
	}
	
	
	
	@Override protected List<PersonInfo> toBaseClassHook(List<PersonInfo> baseInfos, List<PerbioInfo> results) {
		return PersonMerger.mergeWithPerbio(baseInfos, results);
	}
}

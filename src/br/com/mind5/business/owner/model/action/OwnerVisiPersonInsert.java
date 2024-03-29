package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.business.person.info.PersonCopier;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.PersonRootInsertOwner;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnerVisiPersonInsert extends ActionVisitorTemplateAction<OwnerInfo, PersonInfo> {
	
	public OwnerVisiPersonInsert(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return PersonRootInsertOwner.class;
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return PersonCopier.copyFromOwner(recordInfos);
	}
	
	
	
	@Override protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<PersonInfo> results) {
		return OwnerMerger.mergeWithPerson(baseInfos, results);
	}
}

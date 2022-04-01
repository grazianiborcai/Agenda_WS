package br.com.mind5.business.customerSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.info.CusnapMerger;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.PersonRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusnapVisiMergePerson extends ActionVisitorTemplateMerge<CusnapInfo, PersonInfo> {
	
	public CusnapVisiMergePerson(DeciTreeOption<CusnapInfo> option) {
		super(option, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return PersonRootSelect.class;
	}
	
	
	
	@Override protected List<CusnapInfo> mergeHook(List<CusnapInfo> baseInfos, List<PersonInfo> selectedInfos) {	
		return CusnapMerger.mergeWithPerson(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}

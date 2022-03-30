package br.com.mind5.business.store.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonCopier;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.PersonRootUpdate;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiPersonUpdate extends ActionVisitorTemplateAction<StoreInfo, PersonInfo> {
	
	public StoreVisiPersonUpdate(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return PersonRootUpdate.class;
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		List<PersonInfo> results = new ArrayList<>();	//TODO: move to copier
		
		for (StoreInfo eachRecord : recordInfos) {
			results.add(PersonCopier.copyFromStore(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<PersonInfo> results) {
		return StoreMerger.mergeWithPerson(baseInfos, results);
	}
}

package br.com.mind5.business.owner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.business.person.info.PersonCopier;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.RootPersonUpdate;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerPersonUpdate extends ActionVisitorTemplateActionV2<OwnerInfo, PersonInfo> {
	
	public VisiOwnerPersonUpdate(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return RootPersonUpdate.class;
	}
	
	
	
	@Override protected List<PersonInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		List<PersonInfo> results = new ArrayList<>();
		
		for (OwnerInfo eachRecord : recordInfos) {
			results.add(PersonCopier.copyFromOwner(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<PersonInfo> results) {
		return OwnerMerger.mergeWithPerson(baseInfos, results);
	}
}

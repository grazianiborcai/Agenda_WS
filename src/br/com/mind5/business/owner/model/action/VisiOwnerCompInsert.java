package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.company.info.CompCopier;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.decisionTree.RootCompInsertOwner;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerCompInsert extends ActionVisitorTemplateActionV2<OwnerInfo, CompInfo> {
	
	public VisiOwnerCompInsert(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class, CompInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CompInfo>> getTreeClassHook() {
		return RootCompInsertOwner.class;
	}
	
	
	
	@Override protected List<CompInfo> toActionClassHook(List<OwnerInfo> recordInfos) {		
		return CompCopier.copyFromOwner(recordInfos);
	}
	
	
	
	@Override protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<CompInfo> results) {
		return OwnerMerger.mergeWithComp(baseInfos, results);
	}
}

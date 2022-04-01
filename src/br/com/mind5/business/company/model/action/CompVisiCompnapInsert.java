package br.com.mind5.business.company.model.action;

import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.info.CompMerger;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.companySnapshot.model.decisionTree.CompnapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompVisiCompnapInsert extends ActionVisitorTemplateAction<CompInfo, CompnapInfo> {

	public CompVisiCompnapInsert(DeciTreeOption<CompInfo> option) {
		super(option, CompInfo.class, CompnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CompnapInfo>> getTreeClassHook() {
		return CompnapRootInsert.class;
	}
	
	
	
	protected List<CompInfo> toBaseClassHook(List<CompInfo> baseInfos, List<CompnapInfo> results) {
		return CompMerger.mergeWithCompnap(baseInfos, results);
	}
}

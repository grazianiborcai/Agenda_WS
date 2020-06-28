package br.com.mind5.business.company.model.action;

import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.info.CompMerger;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.companySnapshot.model.decisionTree.RootCompnapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCompInsertCompnap extends ActionVisitorTemplateActionV2<CompInfo, CompnapInfo> {

	public VisiCompInsertCompnap(DeciTreeOption<CompInfo> option) {
		super(option, CompInfo.class, CompnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CompnapInfo>> getTreeClassHook() {
		return RootCompnapInsert.class;
	}
	
	
	
	protected List<CompInfo> toBaseClassHook(List<CompInfo> baseInfos, List<CompnapInfo> results) {
		return CompMerger.mergeWithCompnap(baseInfos, results);
	}
}

package br.com.mind5.masterData.countryLegal.model.action;

import java.util.List;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.masterData.countryLegal.model.decisionTree.CountralRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountralVisiRootSelect extends ActionVisitorTemplateAction<CountralInfo, CountralInfo> {

	public CountralVisiRootSelect(DeciTreeOption<CountralInfo> option) {
		super(option, CountralInfo.class, CountralInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountralInfo>> getTreeClassHook() {
		return CountralRootSelect.class;
	}
	
	
	
	@Override protected List<CountralInfo> toBaseClassHook(List<CountralInfo> baseInfos, List<CountralInfo> results) {
		return results;
	}
}

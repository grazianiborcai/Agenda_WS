package br.com.mind5.masterData.currencySearch.model;

import br.com.mind5.masterData.currencySearch.info.CurrarshInfo;
import br.com.mind5.masterData.currencySearch.model.decisionTree.CurrarshRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CurrarshModelSelect extends ModelTemplate<CurrarshInfo> {

	public CurrarshModelSelect(CurrarshInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CurrarshInfo> getDecisionTreeHook(DeciTreeOption<CurrarshInfo> option) {
		return new CurrarshRootSelect(option);
	}
}

package br.com.mind5.masterData.fileDocTypeSearch.model;

import br.com.mind5.masterData.fileDocTypeSearch.info.FidocarchInfo;
import br.com.mind5.masterData.fileDocTypeSearch.model.decisionTree.FidocarchRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FidocarchModelSelect extends ModelTemplate<FidocarchInfo> {

	public FidocarchModelSelect(FidocarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<FidocarchInfo> getDecisionTreeHook(DeciTreeOption<FidocarchInfo> option) {
		return new FidocarchRootSelect(option);
	}
}

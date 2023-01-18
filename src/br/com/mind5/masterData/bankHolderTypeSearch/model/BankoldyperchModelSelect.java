package br.com.mind5.masterData.bankHolderTypeSearch.model;

import br.com.mind5.masterData.bankHolderTypeSearch.info.BankoldyperchInfo;
import br.com.mind5.masterData.bankHolderTypeSearch.model.decisionTree.BankoldyperchRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankoldyperchModelSelect extends ModelTemplate<BankoldyperchInfo> {

	public BankoldyperchModelSelect(BankoldyperchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<BankoldyperchInfo> getDecisionTreeHook(DeciTreeOption<BankoldyperchInfo> option) {
		return new BankoldyperchRootSelect(option);
	}
}

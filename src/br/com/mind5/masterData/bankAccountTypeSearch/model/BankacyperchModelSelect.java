package br.com.mind5.masterData.bankAccountTypeSearch.model;

import br.com.mind5.masterData.bankAccountTypeSearch.info.BankacyperchInfo;
import br.com.mind5.masterData.bankAccountTypeSearch.model.decisionTree.BankacyperchRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankacyperchModelSelect extends ModelTemplate<BankacyperchInfo> {

	public BankacyperchModelSelect(BankacyperchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<BankacyperchInfo> getDecisionTreeHook(DeciTreeOption<BankacyperchInfo> option) {
		return new BankacyperchRootSelect(option);
	}
}

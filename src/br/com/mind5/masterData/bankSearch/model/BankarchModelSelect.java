package br.com.mind5.masterData.bankSearch.model;

import br.com.mind5.masterData.bankSearch.info.BankarchInfo;
import br.com.mind5.masterData.bankSearch.model.decisionTree.BankarchRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankarchModelSelect extends ModelTemplate<BankarchInfo> {

	public BankarchModelSelect(BankarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<BankarchInfo> getDecisionTreeHook(DeciTreeOption<BankarchInfo> option) {
		return new BankarchRootSelect(option);
	}
}

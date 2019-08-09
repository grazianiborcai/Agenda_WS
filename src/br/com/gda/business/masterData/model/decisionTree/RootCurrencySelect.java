package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.model.action.StdCurrencySelect;
import br.com.gda.business.masterData.model.checker.CurrencyCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootCurrencySelect extends DeciTreeReadTemplate<CurrencyInfo> {
	
	public RootCurrencySelect(DeciTreeOption<CurrencyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CurrencyInfo> buildDecisionCheckerHook(DeciTreeOption<CurrencyInfo> option) {
		List<ModelChecker<CurrencyInfo>> queue = new ArrayList<>();		
		ModelChecker<CurrencyInfo> checker;
		
		checker = new CurrencyCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CurrencyInfo>> buildActionsOnPassedHook(DeciTreeOption<CurrencyInfo> option) {
		List<ActionStd<CurrencyInfo>> actions = new ArrayList<>();
		
		actions.add(new StdCurrencySelect(option));
		return actions;
	}
}

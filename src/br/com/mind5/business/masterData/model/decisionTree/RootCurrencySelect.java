package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.masterData.model.action.StdCurrencySelect;
import br.com.mind5.business.masterData.model.checker.CurrencyCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootCurrencySelect extends DeciTreeReadTemplate<CurrencyInfo> {
	
	public RootCurrencySelect(DeciTreeOption<CurrencyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CurrencyInfo> buildDecisionCheckerHook(DeciTreeOption<CurrencyInfo> option) {
		List<ModelChecker<CurrencyInfo>> queue = new ArrayList<>();		
		ModelChecker<CurrencyInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CurrencyCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CurrencyInfo>> buildActionsOnPassedHook(DeciTreeOption<CurrencyInfo> option) {
		List<ActionStd<CurrencyInfo>> actions = new ArrayList<>();
		
		ActionStd<CurrencyInfo> select = new StdCurrencySelect(option);
		
		actions.add(select);
		return actions;
	}
}

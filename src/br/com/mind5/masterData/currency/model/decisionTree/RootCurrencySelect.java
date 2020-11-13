package br.com.mind5.masterData.currency.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.currency.model.action.StdCurrencyDaoSelect;
import br.com.mind5.masterData.currency.model.checker.CurrencyCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCurrencySelect extends DeciTreeTemplateRead<CurrencyInfo> {
	
	public RootCurrencySelect(DeciTreeOption<CurrencyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CurrencyInfo> buildCheckerHook(DeciTreeOption<CurrencyInfo> option) {
		List<ModelChecker<CurrencyInfo>> queue = new ArrayList<>();		
		ModelChecker<CurrencyInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CurrencyCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CurrencyInfo>> buildActionsOnPassedHook(DeciTreeOption<CurrencyInfo> option) {
		List<ActionStd<CurrencyInfo>> actions = new ArrayList<>();
		
		ActionStd<CurrencyInfo> select = new StdCurrencyDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}

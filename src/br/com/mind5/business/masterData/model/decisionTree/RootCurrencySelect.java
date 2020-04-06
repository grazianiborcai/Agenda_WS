package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.masterData.model.action.StdCurrencySelect;
import br.com.mind5.business.masterData.model.checker.CurrencyCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCurrencySelect extends DeciTreeTemplateRead<CurrencyInfo> {
	
	public RootCurrencySelect(DeciTreeOption<CurrencyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CurrencyInfo> buildCheckerHook(DeciTreeOption<CurrencyInfo> option) {
		List<ModelCheckerV1<CurrencyInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CurrencyInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CurrencyCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CurrencyInfo>> buildActionsOnPassedHook(DeciTreeOption<CurrencyInfo> option) {
		List<ActionStdV1<CurrencyInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CurrencyInfo> select = new StdCurrencySelect(option);
		
		actions.add(select);
		return actions;
	}
}

package br.com.mind5.payment.creditCardSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.model.action.StdCrecarchMergeToSelect;
import br.com.mind5.payment.creditCardSearch.model.checker.CrecarchCheckRead;

public final class RootCrecarchSelect extends DeciTreeReadTemplate<CrecarchInfo> {
	
	public RootCrecarchSelect(DeciTreeOption<CrecarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecarchInfo> buildDecisionCheckerHook(DeciTreeOption<CrecarchInfo> option) {
		List<ModelChecker<CrecarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecarchInfo> checker;
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecarchInfo> option) {
		List<ActionStd<CrecarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CrecarchInfo> mergeToSelect = new StdCrecarchMergeToSelect(option);
		
		actions.add(mergeToSelect);
		return actions;
	}
}

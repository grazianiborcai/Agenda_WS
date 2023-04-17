package br.com.mind5.webhook.pagarmeHook.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;
import br.com.mind5.webhook.pagarmeHook.model.checker.PagookCheckExist;

public final class PagookNodeInsertL1 extends DeciTreeTemplateWrite<PagookInfo> {
	
	public PagookNodeInsertL1(DeciTreeOption<PagookInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PagookInfo> buildCheckerHook(DeciTreeOption<PagookInfo> option) {	
		List<ModelChecker<PagookInfo>> queue = new ArrayList<>();		
		ModelChecker<PagookInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new PagookCheckExist(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PagookInfo>> buildActionsOnPassedHook(DeciTreeOption<PagookInfo> option) {
		List<ActionStd<PagookInfo>> actions = new ArrayList<>();	
		
		ActionStd<PagookInfo> nodeL2 = new PagookNodeInsertL2(option).toAction();
		
		actions.add(nodeL2);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PagookInfo>> buildActionsOnFailedHook(DeciTreeOption<PagookInfo> option) {
		List<ActionStd<PagookInfo>> actions = new ArrayList<>();

		ActionStd<PagookInfo> success = new ActionStdSuccessCommom<PagookInfo>(option);		
		actions.add(success);
		
		return actions;
	}
}

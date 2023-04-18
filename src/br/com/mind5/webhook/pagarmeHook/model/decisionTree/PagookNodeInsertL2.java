package br.com.mind5.webhook.pagarmeHook.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;
import br.com.mind5.webhook.pagarmeHook.model.action.PagookVisiDaoInsert;
import br.com.mind5.webhook.pagarmeHook.model.action.PagookVisiPayordWebhook;
import br.com.mind5.webhook.pagarmeHook.model.checker.PagookCheckPayord;
import br.com.mind5.webhook.pagarmeHook.model.checker.PagookCheckPayordem;

public final class PagookNodeInsertL2 extends DeciTreeTemplateWrite<PagookInfo> {
	
	public PagookNodeInsertL2(DeciTreeOption<PagookInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PagookInfo> buildCheckerHook(DeciTreeOption<PagookInfo> option) {	
		List<ModelChecker<PagookInfo>> queue = new ArrayList<>();		
		ModelChecker<PagookInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PagookCheckPayord(checkerOption);
		queue.add(checker);
		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PagookCheckPayordem(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PagookInfo>> buildActionsOnPassedHook(DeciTreeOption<PagookInfo> option) {
		List<ActionStd<PagookInfo>> actions = new ArrayList<>();	
		
		ActionStd <PagookInfo> insert        = new ActionStdCommom <PagookInfo> (option, PagookVisiDaoInsert.class);
		ActionLazy<PagookInfo> payordWebhook = new ActionLazyCommom<PagookInfo> (option, PagookVisiPayordWebhook.class);
		
		insert.addPostAction(payordWebhook);
		
		actions.add(insert);		
		return actions;
	}
}

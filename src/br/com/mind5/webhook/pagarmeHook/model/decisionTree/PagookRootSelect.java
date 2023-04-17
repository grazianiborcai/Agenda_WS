package br.com.mind5.webhook.pagarmeHook.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;
import br.com.mind5.webhook.pagarmeHook.model.action.PagookVisiDaoSelect;
import br.com.mind5.webhook.pagarmeHook.model.checker.PagookCheckRead;

public final class PagookRootSelect extends DeciTreeTemplateRead<PagookInfo> {
	
	public PagookRootSelect(DeciTreeOption<PagookInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PagookInfo> buildCheckerHook(DeciTreeOption<PagookInfo> option) {	
		List<ModelChecker<PagookInfo>> queue = new ArrayList<>();		
		ModelChecker<PagookInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PagookCheckRead(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PagookInfo>> buildActionsOnPassedHook(DeciTreeOption<PagookInfo> option) {
		List<ActionStd<PagookInfo>> actions = new ArrayList<>();	
		
		ActionStd<PagookInfo> select = new ActionStdCommom<PagookInfo> (option, PagookVisiDaoSelect.class);
		
		actions.add(select);		
		return actions;
	}
}

package br.com.mind5.business.orderItemSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.model.action.LazyOrdemrapMergeMatsnap;
import br.com.mind5.business.orderItemSnapshot.model.action.StdOrdemrapMergeToSelect;
import br.com.mind5.business.orderItemSnapshot.model.checker.OrdemrapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootOrdemrapSelect extends DeciTreeTemplateWrite<OrdemrapInfo> {
	
	public RootOrdemrapSelect(DeciTreeOption<OrdemrapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdemrapInfo> buildCheckerHook(DeciTreeOption<OrdemrapInfo> option) {
		List<ModelChecker<OrdemrapInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdemrapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdemrapCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdemrapInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdemrapInfo> option) {
		List<ActionStd<OrdemrapInfo>> actions = new ArrayList<>();
		
		ActionStd<OrdemrapInfo> select = new StdOrdemrapMergeToSelect(option);
		ActionLazy<OrdemrapInfo> mergeMatsnap = new LazyOrdemrapMergeMatsnap(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatsnap);
		
		actions.add(select);
		return actions;
	}
}

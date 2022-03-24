package br.com.mind5.business.orderItemSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.model.action.OrdemrapVisiMergeMatsnap;
import br.com.mind5.business.orderItemSnapshot.model.action.OrdemrapVisiMergeToSelect;
import br.com.mind5.business.orderItemSnapshot.model.checker.OrdemrapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrdemrapRootSelect extends DeciTreeTemplateWrite<OrdemrapInfo> {
	
	public OrdemrapRootSelect(DeciTreeOption<OrdemrapInfo> option) {
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
		
		ActionStd<OrdemrapInfo> select = new ActionStdCommom<OrdemrapInfo>(option, OrdemrapVisiMergeToSelect.class);
		ActionLazy<OrdemrapInfo> mergeMatsnap = new ActionLazyCommom<OrdemrapInfo>(option, OrdemrapVisiMergeMatsnap.class);
		
		select.addPostAction(mergeMatsnap);
		
		actions.add(select);
		return actions;
	}
}

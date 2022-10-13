package br.com.mind5.business.addressSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.action.AddarchVisiEnforcePeregKey;
import br.com.mind5.business.addressSearch.model.action.AddarchVisiRootSelect;
import br.com.mind5.business.addressSearch.model.checker.AddarchCheckLangu;
import br.com.mind5.business.addressSearch.model.checker.AddarchCheckReadPereg;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class AddarchRootSelectPereg extends DeciTreeTemplateWrite<AddarchInfo> {
	
	public AddarchRootSelectPereg(DeciTreeOption<AddarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddarchInfo> buildCheckerHook(DeciTreeOption<AddarchInfo> option) {
		List<ModelChecker<AddarchInfo>> queue = new ArrayList<>();		
		ModelChecker<AddarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddarchCheckReadPereg(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AddarchCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddarchInfo>> buildActionsOnPassedHook(DeciTreeOption<AddarchInfo> option) {
		List<ActionStd<AddarchInfo>> actions = new ArrayList<>();
		
		ActionStd<AddarchInfo> enforcePeregKey = new ActionStdCommom<AddarchInfo>(option, AddarchVisiEnforcePeregKey.class);
		ActionLazy<AddarchInfo> select = new ActionLazyCommom<AddarchInfo>(option, AddarchVisiRootSelect.class);
		
		enforcePeregKey.addPostAction(select);
		
		actions.add(enforcePeregKey);
		return actions;
	}
}

package br.com.mind5.business.storeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.model.action.SotarchVisiRootSelectUser;
import br.com.mind5.business.storeSearch.model.action.SotarchVisiMergeUsername;
import br.com.mind5.business.storeSearch.model.checker.SotarchCheckReadUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class SotarchRootSelectUsename extends DeciTreeTemplateRead<SotarchInfo> {
	
	public SotarchRootSelectUsename(DeciTreeOption<SotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SotarchInfo> buildCheckerHook(DeciTreeOption<SotarchInfo> option) {
		List<ModelChecker<SotarchInfo>> queue = new ArrayList<>();		
		ModelChecker<SotarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SotarchCheckReadUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SotarchInfo>> buildActionsOnPassedHook(DeciTreeOption<SotarchInfo> option) {
		List<ActionStd<SotarchInfo>> actions = new ArrayList<>();

		ActionStd<SotarchInfo> mergeUsername = new ActionStdCommom<SotarchInfo>(option, SotarchVisiMergeUsername.class);
		ActionLazy<SotarchInfo> select = new ActionLazyCommom<SotarchInfo>(option, SotarchVisiRootSelectUser.class);
		
		mergeUsername.addPostAction(select);
		
		actions.add(mergeUsername);
		return actions;
	}
}

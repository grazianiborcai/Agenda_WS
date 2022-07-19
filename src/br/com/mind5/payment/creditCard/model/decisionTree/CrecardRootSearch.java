package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiRootSelect;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiEnforceUserKey;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiMergeCrecarch;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckSearch;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUsername;

public final class CrecardRootSearch extends DeciTreeTemplateRead<CrecardInfo> {
	
	public CrecardRootSearch(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecardCheckSearch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CrecardCheckUsername(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStd<CrecardInfo> nodeUser = new CrecardNodeUser(option).toAction();
		ActionLazy<CrecardInfo> enforceUserKey = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiEnforceUserKey.class);
		ActionLazy<CrecardInfo> mergeCrecarch = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiMergeCrecarch.class);
		ActionLazy<CrecardInfo> user = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiRootSelect.class);
		
		nodeUser.addPostAction(enforceUserKey);
		enforceUserKey.addPostAction(mergeCrecarch);
		mergeCrecarch.addPostAction(user);
		
		actions.add(nodeUser);
		return actions;
	}
}

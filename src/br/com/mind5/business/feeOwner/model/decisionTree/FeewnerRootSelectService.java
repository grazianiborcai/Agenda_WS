package br.com.mind5.business.feeOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.model.action.FeewnerVisiRootSelect;
import br.com.mind5.business.feeOwner.model.action.FeewnerVisiEnforceCategServ;
import br.com.mind5.business.feeOwner.model.checker.FeewnerCheckReadService;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class FeewnerRootSelectService extends DeciTreeTemplateRead<FeewnerInfo> {
	
	public FeewnerRootSelectService(DeciTreeOption<FeewnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FeewnerInfo> buildCheckerHook(DeciTreeOption<FeewnerInfo> option) {		
		List<ModelChecker<FeewnerInfo>> queue = new ArrayList<>();		
		ModelChecker<FeewnerInfo> checker;
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FeewnerCheckReadService(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FeewnerInfo>> buildActionsOnPassedHook(DeciTreeOption<FeewnerInfo> option) {
		List<ActionStd<FeewnerInfo>> actions = new ArrayList<>();
		
		ActionStd<FeewnerInfo> enforceCateg = new ActionStdCommom<FeewnerInfo>(option, FeewnerVisiEnforceCategServ.class);
		ActionLazy<FeewnerInfo> select = new ActionLazyCommom<FeewnerInfo>(option, FeewnerVisiRootSelect.class);
		
		enforceCateg.addPostAction(select);		
		
		actions.add(enforceCateg);
		return actions;
	}
}

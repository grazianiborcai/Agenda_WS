package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerCompUpdate;
import br.com.mind5.business.owner.model.action.StdOwnerEnforceCompKey;
import br.com.mind5.business.owner.model.checker.OwnerCheckHasComp;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeOwnerUpdateComp extends DeciTreeTemplateWrite<OwnerInfo> {

	public NodeOwnerUpdateComp(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildCheckerHook(DeciTreeOption<OwnerInfo> option) {
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new OwnerCheckHasComp(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> enforceCompKey = new StdOwnerEnforceCompKey(option);
		ActionLazy<OwnerInfo> updateCompany = new LazyOwnerCompUpdate(option.conn, option.schemaName);
		
		enforceCompKey.addPostAction(updateCompany);
		
		actions.add(enforceCompKey);
		return actions;
	}
}

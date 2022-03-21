package br.com.mind5.business.pet.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.action.PetVisiNodeUpdateAuthL2;
import br.com.mind5.business.pet.model.action.PetVisiNodeUpdateAuthL3;
import br.com.mind5.business.pet.model.action.PetVisiEnforceUserKey;
import br.com.mind5.business.pet.model.action.PetVisiMergeToSelectAuth;
import br.com.mind5.business.pet.model.action.PetVisiMergeUsername;
import br.com.mind5.business.pet.model.checker.PetCheckAuthCustomer;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PetNodeUpdateAuthL1 extends DeciTreeTemplateWrite<PetInfo> {
	
	public PetNodeUpdateAuthL1(DeciTreeOption<PetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PetInfo> buildCheckerHook(DeciTreeOption<PetInfo> option) {
		List<ModelChecker<PetInfo>> queue = new ArrayList<>();		
		ModelChecker<PetInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PetCheckAuthCustomer(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetInfo>> buildActionsOnPassedHook(DeciTreeOption<PetInfo> option) {
		List<ActionStd<PetInfo>> actions = new ArrayList<>();
		
		ActionStd<PetInfo> mergeUsername = new ActionStdCommom<PetInfo>(option, PetVisiMergeUsername.class);
		ActionLazy<PetInfo> enforceUserKey = new ActionLazyCommom<PetInfo>(option, PetVisiEnforceUserKey.class);	
		ActionLazy<PetInfo> nodeL2 = new ActionLazyCommom<PetInfo>(option, PetVisiNodeUpdateAuthL2.class);	
		
		mergeUsername.addPostAction(enforceUserKey);	
		enforceUserKey.addPostAction(nodeL2);
		
		actions.add(mergeUsername);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PetInfo>> buildActionsOnFailedHook(DeciTreeOption<PetInfo> option) {
		List<ActionStd<PetInfo>> actions = new ArrayList<>();
		
		ActionStd<PetInfo> select = new ActionStdCommom<PetInfo>(option, PetVisiMergeToSelectAuth.class);
		ActionLazy<PetInfo> nodeL3 = new ActionLazyCommom<PetInfo>(option, PetVisiNodeUpdateAuthL3.class);
		
		select.addPostAction(nodeL3);
		
		actions.add(select);
		return actions;
	}
}

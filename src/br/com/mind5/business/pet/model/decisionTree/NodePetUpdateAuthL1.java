package br.com.mind5.business.pet.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.action.LazyPetEnforceUserKey;
import br.com.mind5.business.pet.model.action.LazyPetNodeUpdateAuthL2;
import br.com.mind5.business.pet.model.action.LazyPetNodeUpdateAuthL3;
import br.com.mind5.business.pet.model.action.StdPetMergeToSelectAuth;
import br.com.mind5.business.pet.model.action.StdPetMergeUsername;
import br.com.mind5.business.pet.model.checker.PetCheckAuthCustomer;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodePetUpdateAuthL1 extends DeciTreeTemplateWrite<PetInfo> {
	
	public NodePetUpdateAuthL1(DeciTreeOption<PetInfo> option) {
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
		
		ActionStd<PetInfo> mergeUsername = new StdPetMergeUsername(option);
		ActionLazy<PetInfo> enforceUserKey = new LazyPetEnforceUserKey(option.conn, option.schemaName);	
		ActionLazy<PetInfo> nodeL2 = new LazyPetNodeUpdateAuthL2(option.conn, option.schemaName);	
		
		mergeUsername.addPostAction(enforceUserKey);	
		enforceUserKey.addPostAction(nodeL2);
		
		actions.add(mergeUsername);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PetInfo>> buildActionsOnFailedHook(DeciTreeOption<PetInfo> option) {
		List<ActionStd<PetInfo>> actions = new ArrayList<>();
		
		ActionStd<PetInfo> select = new StdPetMergeToSelectAuth(option);
		ActionLazy<PetInfo> nodeL3 = new LazyPetNodeUpdateAuthL3(option.conn, option.schemaName);
		
		select.addPostAction(nodeL3);
		
		actions.add(select);
		return actions;
	}
}

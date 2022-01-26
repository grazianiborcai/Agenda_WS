package br.com.mind5.business.pet.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.action.LazyPetEnforceDefaultOn;
import br.com.mind5.business.pet.model.action.LazyPetMergeToSelect;
import br.com.mind5.business.pet.model.action.LazyPetRootUpdate;
import br.com.mind5.business.pet.model.action.StdPetMergePetarchUser;
import br.com.mind5.business.pet.model.action.StdPetSuccess;
import br.com.mind5.business.pet.model.checker.PetCheckHasUser;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodePetDefaultAfterL2 extends DeciTreeTemplateWrite<PetInfo> {
	
	public NodePetDefaultAfterL2(DeciTreeOption<PetInfo> option) {
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
		checker = new PetCheckHasUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetInfo>> buildActionsOnPassedHook(DeciTreeOption<PetInfo> option) {
		List<ActionStd<PetInfo>> actions = new ArrayList<>();
		
		ActionStd<PetInfo> mergePetarchUser = new StdPetMergePetarchUser(option);
		ActionLazy<PetInfo> mergeToSelect = new LazyPetMergeToSelect(option.conn, option.schemaName);
		ActionLazy<PetInfo> enforceDefaultOn = new LazyPetEnforceDefaultOn(option.conn, option.schemaName);
		ActionLazy<PetInfo> update = new LazyPetRootUpdate(option.conn, option.schemaName);
		ActionStd<PetInfo> success = new StdPetSuccess(option);	
		
		mergePetarchUser.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(enforceDefaultOn);
		enforceDefaultOn.addPostAction(update);
		
		actions.add(mergePetarchUser);
		actions.add(success);
		
		return actions;
	}
}

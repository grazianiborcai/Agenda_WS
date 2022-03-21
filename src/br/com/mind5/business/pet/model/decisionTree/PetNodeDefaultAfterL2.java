package br.com.mind5.business.pet.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.action.PetVisiRootUpdate;
import br.com.mind5.business.pet.model.action.PetVisiEnforceDefaultOn;
import br.com.mind5.business.pet.model.action.PetVisiMergePetarchUser;
import br.com.mind5.business.pet.model.action.PetVisiMergeToSelect;
import br.com.mind5.business.pet.model.checker.PetCheckHasUser;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PetNodeDefaultAfterL2 extends DeciTreeTemplateWrite<PetInfo> {
	
	public PetNodeDefaultAfterL2(DeciTreeOption<PetInfo> option) {
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
		
		ActionStd<PetInfo> mergePetarchUser = new ActionStdCommom<PetInfo>(option, PetVisiMergePetarchUser.class);
		ActionLazy<PetInfo> mergeToSelect = new ActionLazyCommom<PetInfo>(option, PetVisiMergeToSelect.class);
		ActionLazy<PetInfo> enforceDefaultOn = new ActionLazyCommom<PetInfo>(option, PetVisiEnforceDefaultOn.class);
		ActionLazy<PetInfo> update = new ActionLazyCommom<PetInfo>(option, PetVisiRootUpdate.class);
		ActionStd<PetInfo> success = new ActionStdSuccessCommom<PetInfo>(option);	
		
		mergePetarchUser.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(enforceDefaultOn);
		enforceDefaultOn.addPostAction(update);
		
		actions.add(mergePetarchUser);
		actions.add(success);
		
		return actions;
	}
}

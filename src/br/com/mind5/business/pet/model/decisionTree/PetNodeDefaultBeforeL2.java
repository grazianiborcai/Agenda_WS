package br.com.mind5.business.pet.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.action.PetVisiDaoUpdate;
import br.com.mind5.business.pet.model.action.PetVisiEnforceDefaultOff;
import br.com.mind5.business.pet.model.action.PetVisiMergePetault;
import br.com.mind5.business.pet.model.action.PetVisiMergeToSelect;
import br.com.mind5.business.pet.model.checker.PetCheckPetault;
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

public final class PetNodeDefaultBeforeL2 extends DeciTreeTemplateWrite<PetInfo> {
	
	public PetNodeDefaultBeforeL2(DeciTreeOption<PetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PetInfo> buildCheckerHook(DeciTreeOption<PetInfo> option) {
		List<ModelChecker<PetInfo>> queue = new ArrayList<>();		
		ModelChecker<PetInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PetCheckPetault(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetInfo>> buildActionsOnPassedHook(DeciTreeOption<PetInfo> option) {
		List<ActionStd<PetInfo>> actions = new ArrayList<>();
		
		ActionStd<PetInfo> mergePetault = new ActionStdCommom<PetInfo>(option, PetVisiMergePetault.class);
		ActionLazy<PetInfo> mergeToSelect = new ActionLazyCommom<PetInfo>(option, PetVisiMergeToSelect.class);
		ActionLazy<PetInfo> enforceDefaultOff = new ActionLazyCommom<PetInfo>(option, PetVisiEnforceDefaultOff.class);
		ActionLazy<PetInfo> update = new ActionLazyCommom<PetInfo>(option, PetVisiDaoUpdate.class);
		ActionStd<PetInfo> success = new ActionStdSuccessCommom<PetInfo>(option);	
		
		mergePetault.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(enforceDefaultOff);
		enforceDefaultOff.addPostAction(update);
		
		actions.add(mergePetault);
		actions.add(success);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PetInfo>> buildActionsOnFailedHook(DeciTreeOption<PetInfo> option) {
		List<ActionStd<PetInfo>> actions = new ArrayList<>();
		
		ActionStd<PetInfo> success = new ActionStdSuccessCommom<PetInfo>(option);
		
		actions.add(success);		
		return actions;
	}
}

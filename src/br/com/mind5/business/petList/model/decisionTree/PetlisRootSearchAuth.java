package br.com.mind5.business.petList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petList.info.PetlisInfo;
import br.com.mind5.business.petList.model.action.PetlisVisiMergePetSearchAuth;
import br.com.mind5.business.petList.model.checker.PetlisCheckSearch;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PetlisRootSearchAuth extends DeciTreeTemplateWrite<PetlisInfo> {
	
	public PetlisRootSearchAuth(DeciTreeOption<PetlisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PetlisInfo> buildCheckerHook(DeciTreeOption<PetlisInfo> option) {
		List<ModelChecker<PetlisInfo>> queue = new ArrayList<>();		
		ModelChecker<PetlisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PetlisCheckSearch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetlisInfo>> buildActionsOnPassedHook(DeciTreeOption<PetlisInfo> option) {
		List<ActionStd<PetlisInfo>> actions = new ArrayList<>();
		
		ActionStd<PetlisInfo> mergePet = new ActionStdCommom<PetlisInfo>(option, PetlisVisiMergePetSearchAuth.class);
		
		actions.add(mergePet);
		return actions;
	}
}

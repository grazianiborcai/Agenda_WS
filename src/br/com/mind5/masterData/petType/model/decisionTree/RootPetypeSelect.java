package br.com.mind5.masterData.petType.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.petType.info.PetypeInfo;
import br.com.mind5.masterData.petType.model.action.StdPetypeDaoSelect;
import br.com.mind5.masterData.petType.model.checker.PetypeCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPetypeSelect extends DeciTreeTemplateRead<PetypeInfo> {
	
	public RootPetypeSelect(DeciTreeOption<PetypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PetypeInfo> buildCheckerHook(DeciTreeOption<PetypeInfo> option) {
		List<ModelChecker<PetypeInfo>> queue = new ArrayList<>();		
		ModelChecker<PetypeInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PetypeCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetypeInfo>> buildActionsOnPassedHook(DeciTreeOption<PetypeInfo> option) {
		List<ActionStd<PetypeInfo>> actions = new ArrayList<>();
		
		ActionStd<PetypeInfo> select = new StdPetypeDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}

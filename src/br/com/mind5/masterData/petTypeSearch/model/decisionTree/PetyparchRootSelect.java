package br.com.mind5.masterData.petTypeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.petTypeSearch.info.PetyparchInfo;
import br.com.mind5.masterData.petTypeSearch.model.action.PetyparchVisiDaoSelect;
import br.com.mind5.masterData.petTypeSearch.model.checker.PetyparchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PetyparchRootSelect extends DeciTreeTemplateRead<PetyparchInfo> {
	
	public PetyparchRootSelect(DeciTreeOption<PetyparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PetyparchInfo> buildCheckerHook(DeciTreeOption<PetyparchInfo> option) {
		List<ModelChecker<PetyparchInfo>> queue = new ArrayList<>();		
		ModelChecker<PetyparchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PetyparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetyparchInfo>> buildActionsOnPassedHook(DeciTreeOption<PetyparchInfo> option) {
		List<ActionStd<PetyparchInfo>> actions = new ArrayList<>();
		
		ActionStd<PetyparchInfo> select = new ActionStdCommom<PetyparchInfo>(option, PetyparchVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}

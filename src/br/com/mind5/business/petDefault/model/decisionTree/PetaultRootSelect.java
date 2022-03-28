package br.com.mind5.business.petDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.business.petDefault.model.action.VisiPetaultMergeToSelect;
import br.com.mind5.business.petDefault.model.checker.PetaultCheckLangu;
import br.com.mind5.business.petDefault.model.checker.PetaultCheckOwner;
import br.com.mind5.business.petDefault.model.checker.PetaultCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PetaultRootSelect extends DeciTreeTemplateWrite<PetaultInfo> {
	
	public PetaultRootSelect(DeciTreeOption<PetaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PetaultInfo> buildCheckerHook(DeciTreeOption<PetaultInfo> option) {
		List<ModelChecker<PetaultInfo>> queue = new ArrayList<>();		
		ModelChecker<PetaultInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PetaultCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PetaultCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PetaultCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetaultInfo>> buildActionsOnPassedHook(DeciTreeOption<PetaultInfo> option) {
		List<ActionStd<PetaultInfo>> actions = new ArrayList<>();		
		
		ActionStd<PetaultInfo> select = new ActionStdCommom<PetaultInfo>(option, VisiPetaultMergeToSelect.class);
		
		actions.add(select);			
		return actions;
	}
}

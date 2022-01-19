package br.com.mind5.business.petSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.action.StdPerarchSuccess;
import br.com.mind5.business.petSearch.model.checker.PerarchCheckHasStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class NodePerarchSytotinL2 extends DeciTreeTemplateRead<PetarchInfo> {
	
	public NodePerarchSytotinL2(DeciTreeOption<PetarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PetarchInfo> buildCheckerHook(DeciTreeOption<PetarchInfo> option) {
		List<ModelChecker<PetarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PetarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PerarchCheckHasStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PetarchInfo> option) {
		List<ActionStd<PetarchInfo>> actions = new ArrayList<>();
		
		ActionStd<PetarchInfo> success = new StdPerarchSuccess(option);	

		actions.add(success);		
		return actions;
	}
}

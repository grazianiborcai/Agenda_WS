package br.com.mind5.business.petSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.action.LazyPerarchEnforcePerson;
import br.com.mind5.business.petSearch.model.action.LazyPetarchRootSelect;
import br.com.mind5.business.petSearch.model.action.StdPerarchEnforceCategEmp;
import br.com.mind5.business.petSearch.model.checker.PetarchCheckReadCus;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPerarchSelectPersonEmp extends DeciTreeTemplateRead<PetarchInfo> {
	
	public RootPerarchSelectPersonEmp(DeciTreeOption<PetarchInfo> option) {
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
		checker = new PetarchCheckReadCus(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PetarchInfo> option) {
		List<ActionStd<PetarchInfo>> actions = new ArrayList<>();
		
		ActionStd<PetarchInfo> enforceCateg = new StdPerarchEnforceCategEmp(option);	
		ActionLazy<PetarchInfo> enforcePerson = new LazyPerarchEnforcePerson(option.conn, option.schemaName);
		ActionLazy<PetarchInfo> select = new LazyPetarchRootSelect(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(enforcePerson);
		enforcePerson.addPostAction(select);

		actions.add(enforceCateg);		
		return actions;
	}
}

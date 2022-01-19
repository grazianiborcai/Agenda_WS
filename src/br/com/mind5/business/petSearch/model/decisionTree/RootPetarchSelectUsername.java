package br.com.mind5.business.petSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.action.LazyPetarchMergeCusarch;
import br.com.mind5.business.petSearch.model.action.LazyPetarchRootSelectCus;
import br.com.mind5.business.petSearch.model.action.StdPetarchEnforceUsername;
import br.com.mind5.business.petSearch.model.checker.PetarchCheckReadUsername;
import br.com.mind5.business.petSearch.model.checker.PetarchCheckUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPetarchSelectUsername extends DeciTreeTemplateRead<PetarchInfo> {
	
	public RootPetarchSelectUsername(DeciTreeOption<PetarchInfo> option) {
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
		checker = new PetarchCheckReadUsername(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PetarchCheckUsername(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PetarchInfo> option) {
		List<ActionStd<PetarchInfo>> actions = new ArrayList<>();
		
		ActionStd<PetarchInfo> enforceUsername = new StdPetarchEnforceUsername(option);
		ActionLazy<PetarchInfo> mergeCusarch = new LazyPetarchMergeCusarch(option.conn, option.schemaName);
		ActionLazy<PetarchInfo> select = new LazyPetarchRootSelectCus(option.conn, option.schemaName);
		
		enforceUsername.addPostAction(mergeCusarch);
		mergeCusarch.addPostAction(select);

		actions.add(enforceUsername);		
		return actions;
	}
}

package br.com.mind5.business.petSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.action.PetarchVisiMergeToSelect;
import br.com.mind5.business.petSearch.model.checker.PetarchCheckLangu;
import br.com.mind5.business.petSearch.model.checker.PetarchCheckOwner;
import br.com.mind5.business.petSearch.model.checker.PetarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PetarchRootSelect extends DeciTreeTemplateRead<PetarchInfo> {
	
	public PetarchRootSelect(DeciTreeOption<PetarchInfo> option) {
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
		checker = new PetarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PetarchCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PetarchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PetarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PetarchInfo> option) {
		List<ActionStd<PetarchInfo>> actions = new ArrayList<>();
		
		ActionStd<PetarchInfo> select = new ActionStdCommom<PetarchInfo>(option, PetarchVisiMergeToSelect.class);

		actions.add(select);		
		return actions;
	}
}

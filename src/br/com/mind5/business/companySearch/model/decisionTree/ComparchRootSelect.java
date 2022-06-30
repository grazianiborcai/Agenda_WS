package br.com.mind5.business.companySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.business.companySearch.model.action.ComparchVisiMergeToSelect;
import br.com.mind5.business.companySearch.model.checker.ComparchCheckLangu;
import br.com.mind5.business.companySearch.model.checker.ComparchCheckOwner;
import br.com.mind5.business.companySearch.model.checker.ComparchCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class ComparchRootSelect extends DeciTreeTemplateRead<ComparchInfo> {
	
	public ComparchRootSelect(DeciTreeOption<ComparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ComparchInfo> buildCheckerHook(DeciTreeOption<ComparchInfo> option) {
		List<ModelChecker<ComparchInfo>> queue = new ArrayList<>();		
		ModelChecker<ComparchInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new ComparchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new ComparchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new ComparchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<ComparchInfo>> buildActionsOnPassedHook(DeciTreeOption<ComparchInfo> option) {
		List<ActionStd<ComparchInfo>> actions = new ArrayList<>();
		
		ActionStd<ComparchInfo> nodeNameSearch = new ComparchNodeNameSearch(option).toAction();	
		ActionLazy<ComparchInfo> select = new ActionLazyCommom<ComparchInfo>(option, ComparchVisiMergeToSelect.class);
		
		nodeNameSearch.addPostAction(select);
		
		actions.add(nodeNameSearch);		
		return actions;
	}
}

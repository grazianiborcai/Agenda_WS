package br.com.gda.business.companySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.companySearch.info.ComparchInfo;
import br.com.gda.business.companySearch.model.action.StdComparchMergeToSelect;
import br.com.gda.business.companySearch.model.checker.ComparchCheckLangu;
import br.com.gda.business.companySearch.model.checker.ComparchCheckOwner;
import br.com.gda.business.companySearch.model.checker.ComparchCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootComparchSelect extends DeciTreeReadTemplate<ComparchInfo> {
	
	public RootComparchSelect(DeciTreeOption<ComparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ComparchInfo> buildDecisionCheckerHook(DeciTreeOption<ComparchInfo> option) {
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<ComparchInfo>> buildActionsOnPassedHook(DeciTreeOption<ComparchInfo> option) {
		List<ActionStd<ComparchInfo>> actions = new ArrayList<>();
		
		ActionStd<ComparchInfo> select = new StdComparchMergeToSelect(option);	
		actions.add(select);
		
		return actions;
	}
}

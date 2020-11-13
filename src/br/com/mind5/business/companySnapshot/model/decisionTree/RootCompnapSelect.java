package br.com.mind5.business.companySnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.companySnapshot.model.action.StdCompnapMergeToSelect;
import br.com.mind5.business.companySnapshot.model.checker.CompnapCheckOwner;
import br.com.mind5.business.companySnapshot.model.checker.CompnapCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCompnapSelect extends DeciTreeTemplateRead<CompnapInfo> {
	
	public RootCompnapSelect(DeciTreeOption<CompnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompnapInfo> buildCheckerHook(DeciTreeOption<CompnapInfo> option) {
		List<ModelChecker<CompnapInfo>> queue = new ArrayList<>();		
		ModelChecker<CompnapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CompnapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CompnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CompnapInfo>> buildActionsOnPassedHook(DeciTreeOption<CompnapInfo> option) {
		List<ActionStd<CompnapInfo>> actions = new ArrayList<>();
		
		ActionStd<CompnapInfo> select = new StdCompnapMergeToSelect(option);	
		actions.add(select);
		
		return actions;
	}
}

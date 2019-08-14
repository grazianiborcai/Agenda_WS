package br.com.gda.business.companySnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.companySnapshot.info.CompnapInfo;
import br.com.gda.business.companySnapshot.model.action.StdCompnapInsert;
import br.com.gda.business.companySnapshot.model.checker.CompnapCheckComp;
import br.com.gda.business.companySnapshot.model.checker.CompnapCheckOwner;
import br.com.gda.business.companySnapshot.model.checker.CompnapCheckWrite;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootCompnapInsert extends DeciTreeWriteTemplate<CompnapInfo> {
	
	public RootCompnapInsert(DeciTreeOption<CompnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompnapInfo> buildDecisionCheckerHook(DeciTreeOption<CompnapInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<CompnapInfo>> queue = new ArrayList<>();		
		ModelChecker<CompnapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CompnapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CompnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CompnapCheckComp(checkerOption);
		queue.add(checker);	
			
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CompnapInfo>> buildActionsOnPassedHook(DeciTreeOption<CompnapInfo> option) {
		List<ActionStd<CompnapInfo>> actions = new ArrayList<>();
		
		ActionStd<CompnapInfo> insert = new StdCompnapInsert(option);
		
		actions.add(insert);
		return actions;
	}
}

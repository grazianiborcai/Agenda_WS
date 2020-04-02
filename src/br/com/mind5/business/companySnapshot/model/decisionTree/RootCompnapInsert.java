package br.com.mind5.business.companySnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.companySnapshot.model.action.StdCompnapInsert;
import br.com.mind5.business.companySnapshot.model.checker.CompnapCheckComp;
import br.com.mind5.business.companySnapshot.model.checker.CompnapCheckOwner;
import br.com.mind5.business.companySnapshot.model.checker.CompnapCheckWrite;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCompnapInsert extends DeciTreeWriteTemplate<CompnapInfo> {
	
	public RootCompnapInsert(DeciTreeOption<CompnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompnapInfo> buildDecisionCheckerHook(DeciTreeOption<CompnapInfo> option) {
		List<ModelChecker<CompnapInfo>> queue = new ArrayList<>();		
		ModelChecker<CompnapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CompnapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CompnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CompnapCheckComp(checkerOption);
		queue.add(checker);	
			
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CompnapInfo>> buildActionsOnPassedHook(DeciTreeOption<CompnapInfo> option) {
		List<ActionStdV1<CompnapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CompnapInfo> insert = new StdCompnapInsert(option);
		
		actions.add(insert);
		return actions;
	}
}

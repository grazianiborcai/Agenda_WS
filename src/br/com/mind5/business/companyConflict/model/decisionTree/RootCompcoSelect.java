package br.com.mind5.business.companyConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.business.companyConflict.model.action.StdCompcoMergeToSelect;
import br.com.mind5.business.companyConflict.model.checker.CompcoCheckLangu;
import br.com.mind5.business.companyConflict.model.checker.CompcoCheckOwner;
import br.com.mind5.business.companyConflict.model.checker.CompcoCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootCompcoSelect extends DeciTreeReadTemplate<CompcoInfo> {
	
	public RootCompcoSelect(DeciTreeOption<CompcoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompcoInfo> buildDecisionCheckerHook(DeciTreeOption<CompcoInfo> option) {
		List<ModelChecker<CompcoInfo>> queue = new ArrayList<>();		
		ModelChecker<CompcoInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CompcoCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CompcoCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CompcoCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CompcoInfo>> buildActionsOnPassedHook(DeciTreeOption<CompcoInfo> option) {
		List<ActionStdV1<CompcoInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CompcoInfo> select = new StdCompcoMergeToSelect(option);	
		actions.add(select);
		
		return actions;
	}
}

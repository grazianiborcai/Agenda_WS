package br.com.mind5.business.customerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.model.action.StdCusnapMergeToSelect;
import br.com.mind5.business.customerSnapshot.model.checker.CusnapCheckLangu;
import br.com.mind5.business.customerSnapshot.model.checker.CusnapCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootCusnapSelect extends DeciTreeReadTemplate<CusnapInfo> {
	
	public RootCusnapSelect(DeciTreeOption<CusnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusnapInfo> buildDecisionCheckerHook(DeciTreeOption<CusnapInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CusnapInfo>> queue = new ArrayList<>();		
		ModelChecker<CusnapInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checker = new CusnapCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CusnapCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusnapInfo>> buildActionsOnPassedHook(DeciTreeOption<CusnapInfo> option) {
		List<ActionStd<CusnapInfo>> actions = new ArrayList<>();
		
		ActionStd<CusnapInfo> select = new StdCusnapMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}

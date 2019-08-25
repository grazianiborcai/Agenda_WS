package br.com.gda.business.orderSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
import br.com.gda.business.orderSnapshot.model.action.StdOrdnapMergeToSelect;
import br.com.gda.business.orderSnapshot.model.checker.OrdnapCheckLangu;
import br.com.gda.business.orderSnapshot.model.checker.OrdnapCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootOrdnapSelect extends DeciTreeReadTemplate<OrdnapInfo> {
	
	public RootOrdnapSelect(DeciTreeOption<OrdnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdnapInfo> buildDecisionCheckerHook(DeciTreeOption<OrdnapInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrdnapInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrdnapCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdnapCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdnapInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdnapInfo> option) {
		List<ActionStd<OrdnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdnapInfo> select = new StdOrdnapMergeToSelect(option);
		
		actions.add(select);			
		return actions;
	}
}

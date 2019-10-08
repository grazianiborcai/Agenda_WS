package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckExist;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckOwner;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckStorauth;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckStore;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckTimeRange;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckWrite;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootStolevateInsert extends DeciTreeWriteTemplate<StolevateInfo> {
	
	public RootStolevateInsert(DeciTreeOption<StolevateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StolevateInfo> buildDecisionCheckerHook(DeciTreeOption<StolevateInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<StolevateInfo>> queue = new ArrayList<>();		
		ModelChecker<StolevateInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new StolevateCheckWrite();
		queue.add(checker);
		
		checker = new StolevateCheckTimeRange();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StolevateCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StolevateCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new StolevateCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StolevateCheckStorauth(checkerOption);
		queue.add(checker);
		//TODO: Verificar conflitos antes de inserir
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolevateInfo>> buildActionsOnPassedHook(DeciTreeOption<StolevateInfo> option) {
		List<ActionStd<StolevateInfo>> actions = new ArrayList<>();	
		
		actions.add(new NodeStolevateInsert(option).toAction());
		return actions;
	}
}

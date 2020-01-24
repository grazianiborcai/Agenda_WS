package br.com.mind5.business.scheduleLineSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.model.action.LazySchedinapInsert;
import br.com.mind5.business.scheduleLineSnapshot.model.action.LazySchedinapMergapStolis;
import br.com.mind5.business.scheduleLineSnapshot.model.action.LazySchedinapMergapUselis;
import br.com.mind5.business.scheduleLineSnapshot.model.action.LazySchedinapMergeCuslis;
import br.com.mind5.business.scheduleLineSnapshot.model.action.LazySchedinapMergeEmplis;
import br.com.mind5.business.scheduleLineSnapshot.model.action.LazySchedinapMergeMatlis;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckLangu;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckOwner;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckSchedine;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedinapInsert extends DeciTreeWriteTemplate<SchedinapInfo> {
	
	public RootSchedinapInsert(DeciTreeOption<SchedinapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedinapInfo> buildDecisionCheckerHook(DeciTreeOption<SchedinapInfo> option) {
		List<ModelChecker<SchedinapInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedinapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedinapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedinapCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedinapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedinapCheckSchedine(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedinapInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedinapInfo> option) {
		List<ActionStd<SchedinapInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedinapInfo> nodeOrder = new NodeSchedinapOrder(option).toAction();
		ActionLazy<SchedinapInfo> mergeMatlis = new LazySchedinapMergeMatlis(option.conn, option.schemaName);
		ActionLazy<SchedinapInfo> mergeStolis = new LazySchedinapMergapStolis(option.conn, option.schemaName);
		ActionLazy<SchedinapInfo> mergCuslis = new LazySchedinapMergeCuslis(option.conn, option.schemaName);
		ActionLazy<SchedinapInfo> mergUselis = new LazySchedinapMergapUselis(option.conn, option.schemaName);
		ActionLazy<SchedinapInfo> mergeEmplis = new LazySchedinapMergeEmplis(option.conn, option.schemaName);
		ActionLazy<SchedinapInfo> insert = new LazySchedinapInsert(option.conn, option.schemaName);
		
		nodeOrder.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergCuslis);		
		mergCuslis.addPostAction(mergUselis);		
		mergUselis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(insert);
		
		actions.add(nodeOrder);
		return actions;
	}
}

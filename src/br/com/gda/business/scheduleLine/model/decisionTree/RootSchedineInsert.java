package br.com.gda.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.action.LazySchedineEnforceLChanged;
import br.com.gda.business.scheduleLine.model.action.LazySchedineInsert;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeMat;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeStolis;
import br.com.gda.business.scheduleLine.model.action.LazySchedineNodeMat;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckCus;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckLangu;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckMat;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckOwner;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckStore;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckWrite;
import br.com.gda.business.scheduleLine.model.checker.ShedineCheckEmp;
import br.com.gda.business.scheduleLine.model.checker.ShedineCheckEmpmat;
import br.com.gda.business.scheduleLine.model.checker.ShedineCheckEmpos;
import br.com.gda.business.scheduleLine.model.checker.ShedineCheckMatore;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedineInsert extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public RootSchedineInsert(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new SchedineCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new SchedineCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new SchedineCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new SchedineCheckMat(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new SchedineCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new SchedineCheckCus(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new ShedineCheckMatore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new ShedineCheckEmp(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new ShedineCheckEmpos(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new ShedineCheckEmpmat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> nodeOrder = new NodeSchedineOrderL1(option).toAction();
		ActionLazy<SchedineInfo> enforceLChanged = new LazySchedineEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeMat = new LazySchedineMergeMat(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodeMat = new LazySchedineNodeMat(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeStolis = new LazySchedineMergeStolis(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> insert = new LazySchedineInsert(option.conn, option.schemaName);
		
		nodeOrder.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeMat);
		mergeMat.addPostAction(nodeMat);
		nodeMat.addPostAction(mergeStolis);
		mergeStolis.addPostAction(insert);
		
		actions.add(nodeOrder);
		return actions;
	}
}

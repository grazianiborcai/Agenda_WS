package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineInsertSchedovm;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineNodeSnapshot;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckCus;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckEmp;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckEmpmat;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckEmpos;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckExist;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckLangu;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckMat;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckMatore;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckOwner;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckStore;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedineUpdate extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public RootSchedineUpdate(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new SchedineCheckUpdate();
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
		checker = new SchedineCheckMatore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new SchedineCheckEmp(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new SchedineCheckEmpos(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new SchedineCheckEmpmat(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new SchedineCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> nodeUpdate = new NodeSchedineUpdate(option).toAction();
		ActionLazy<SchedineInfo> nodeSnapshot = new LazySchedineNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> insertSchedovm = new LazySchedineInsertSchedovm(option.conn, option.schemaName);
		
		nodeUpdate.addPostAction(nodeSnapshot);
		nodeSnapshot.addPostAction(insertSchedovm);
		
		actions.add(nodeUpdate);
		return actions;
	}
}

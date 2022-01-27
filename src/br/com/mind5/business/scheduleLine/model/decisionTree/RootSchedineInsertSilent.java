package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineDaoInsert;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceCreatedBy;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceCreatedOn;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceStatus;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineInsertSchedovm;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeCalate;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeCuslis;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeUsername;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineNodePetWriteL1;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineNodeSnapshot;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineEnforceLChanged;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckCus;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckEmp;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckEmpmat;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckInsert;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckLangu;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckMat;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckMatarchService;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckMatore;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckOwner;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootSchedineInsertSilent extends DeciTreeTemplateWrite<SchedineInfo> {
	
	public RootSchedineInsertSilent(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedineCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckMat(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckMatarchService(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckCus(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckMatore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckEmp(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckEmpmat(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> enforceLChanged = new StdSchedineEnforceLChanged(option);
		ActionLazy<SchedineInfo> mergeCuslis = new LazySchedineMergeCuslis(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeUsername = new LazySchedineMergeUsername(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeCalate = new LazySchedineMergeCalate(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceCreatedOn = new LazySchedineEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceCreatedBy = new LazySchedineEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceStatus = new LazySchedineEnforceStatus(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodePet = new LazySchedineNodePetWriteL1(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> insert = new LazySchedineDaoInsert(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodeSnapshot = new LazySchedineNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> insertSchedovm = new LazySchedineInsertSchedovm(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(mergeCuslis);		
		mergeCuslis.addPostAction(mergeUsername);
		mergeUsername.addPostAction(mergeCalate);
		mergeCalate.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceStatus);
		enforceStatus.addPostAction(nodePet);
		nodePet.addPostAction(insert);
		insert.addPostAction(nodeSnapshot);
		nodeSnapshot.addPostAction(insertSchedovm);
		
		actions.add(enforceLChanged);
		return actions;
	}
}

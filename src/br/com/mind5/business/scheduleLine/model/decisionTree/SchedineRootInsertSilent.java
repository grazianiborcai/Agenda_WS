package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiNodePetWriteL1;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiNodeSnapshot;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiDaoInsert;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiEnforceCreatedBy;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiEnforceCreatedOn;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiEnforceLChanged;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiEnforceStatus;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiInsertSchedovm;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiMergeCalate;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiMergeCuslis;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiMergeUsername;
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
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedineRootInsertSilent extends DeciTreeTemplateWrite<SchedineInfo> {
	
	public SchedineRootInsertSilent(DeciTreeOption<SchedineInfo> option) {
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
		
		ActionStd<SchedineInfo> enforceLChanged = new ActionStdCommom<SchedineInfo>(option, SchedineVisiEnforceLChanged.class);
		ActionLazy<SchedineInfo> mergeCuslis = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiMergeCuslis.class);
		ActionLazy<SchedineInfo> mergeUsername = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiMergeUsername.class);
		ActionLazy<SchedineInfo> mergeCalate = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiMergeCalate.class);
		ActionLazy<SchedineInfo> enforceCreatedOn = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiEnforceCreatedOn.class);
		ActionLazy<SchedineInfo> enforceCreatedBy = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiEnforceCreatedBy.class);
		ActionLazy<SchedineInfo> enforceStatus = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiEnforceStatus.class);
		ActionLazy<SchedineInfo> nodePet = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiNodePetWriteL1.class);
		ActionLazy<SchedineInfo> insert = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiDaoInsert.class);
		ActionLazy<SchedineInfo> nodeSnapshot = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiNodeSnapshot.class);
		ActionLazy<SchedineInfo> insertSchedovm = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiInsertSchedovm.class);
		
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

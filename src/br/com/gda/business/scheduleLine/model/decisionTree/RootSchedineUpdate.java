package br.com.gda.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.action.LazySchedineEnforceLChanged;
import br.com.gda.business.scheduleLine.model.action.LazySchedineNodeTime;
import br.com.gda.business.scheduleLine.model.action.StdSchedineMergeToUpdate;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeCuslis;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeMat;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeUsername;
import br.com.gda.business.scheduleLine.model.action.LazySchedineNodeMat;
import br.com.gda.business.scheduleLine.model.action.LazySchedineNodeSnapshot;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckCus;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckLangu;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckMat;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckOwner;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckStore;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckWrite;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckEmp;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckEmpmat;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckEmpos;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckExist;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckMatore;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedineUpdate extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public RootSchedineUpdate(DeciTreeOption<SchedineInfo> option) {
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
		
		ActionStd<SchedineInfo> mergeToUpdate = new StdSchedineMergeToUpdate(option);
		ActionLazy<SchedineInfo> enforceLChanged = new LazySchedineEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeMat = new LazySchedineMergeMat(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodeMat = new LazySchedineNodeMat(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeCuslis = new LazySchedineMergeCuslis(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeUsername = new LazySchedineMergeUsername(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodeTime = new LazySchedineNodeTime(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> snapshot = new LazySchedineNodeSnapshot(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeMat);
		mergeMat.addPostAction(nodeMat);
		nodeMat.addPostAction(mergeCuslis);		
		mergeCuslis.addPostAction(mergeUsername);
		mergeUsername.addPostAction(nodeTime);
		nodeTime.addPostAction(snapshot);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}

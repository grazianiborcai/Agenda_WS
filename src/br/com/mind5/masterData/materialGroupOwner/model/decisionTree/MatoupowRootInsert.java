package br.com.mind5.masterData.materialGroupOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiEnforceCreatedBy;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiEnforceCreatedOn;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiEnforceLChanged;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiEnforceLockedOff;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiEnforceRgbWrite;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiMergeMatoup;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiMergeUsername;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiNodeInsert;
import br.com.mind5.masterData.materialGroupOwner.model.checker.MatoupowCheckExist;
import br.com.mind5.masterData.materialGroupOwner.model.checker.MatoupowCheckLangu;
import br.com.mind5.masterData.materialGroupOwner.model.checker.MatoupowCheckMatoup;
import br.com.mind5.masterData.materialGroupOwner.model.checker.MatoupowCheckOwner;
import br.com.mind5.masterData.materialGroupOwner.model.checker.MatoupowCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatoupowRootInsert extends DeciTreeTemplateWrite<MatoupowInfo> {
	
	public MatoupowRootInsert(DeciTreeOption<MatoupowInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoupowInfo> buildCheckerHook(DeciTreeOption<MatoupowInfo> option) {
		List<ModelChecker<MatoupowInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoupowInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatoupowCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatoupowCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatoupowCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatoupowCheckMatoup(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new MatoupowCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoupowInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoupowInfo> option) {
		List<ActionStd<MatoupowInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatoupowInfo> mergeMatoup 		= new ActionStdCommom<MatoupowInfo>(option, MatoupowVisiMergeMatoup.class);
		ActionLazy<MatoupowInfo> enforceLChanged 	= new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiEnforceLChanged.class);
		ActionLazy<MatoupowInfo> enforceLChangedBy 	= new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiMergeUsername.class);
		ActionLazy<MatoupowInfo> enforceCreatedOn 	= new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiEnforceCreatedOn.class);
		ActionLazy<MatoupowInfo> enforceCreatedBy 	= new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiEnforceCreatedBy.class);
		ActionLazy<MatoupowInfo> enforceLockedOff 	= new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiEnforceLockedOff.class);
		ActionLazy<MatoupowInfo> enforceRgbWrite 	= new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiEnforceRgbWrite.class);
		ActionLazy<MatoupowInfo> nodeL1 			= new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiNodeInsert.class);
		
		mergeMatoup.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);	
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceLockedOff);
		enforceLockedOff.addPostAction(enforceRgbWrite);
		enforceRgbWrite.addPostAction(nodeL1);
		
		actions.add(mergeMatoup);		
		return actions;
	}
}
